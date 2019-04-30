package com.zxy.scientific_research.service.serviceImpl;

import com.zxy.scientific_research.bean.Book;
import com.zxy.scientific_research.bean.Bt;
import com.zxy.scientific_research.bean.Teacher;
import com.zxy.scientific_research.common.ServerResponse;
import com.zxy.scientific_research.mapper.BookMapper;
import com.zxy.scientific_research.mapper.BtMapper;
import com.zxy.scientific_research.mapper.TeacherMapper;
import com.zxy.scientific_research.service.IBookService;
import com.zxy.scientific_research.util.JsonXMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: scientific_research
 * @description:
 * @author: kw
 * @create: 2019/04/10 22:04
 */
@Service(value = "IBookService")
public class BookServiceImpl implements IBookService{
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private BtMapper btMapper;

    @Override
    public ServerResponse<Book> addBook(Map<String, Object> map) {
        Book book;
        Bt bt;
        try {
            book = JsonXMLUtils.map2obj((Map<String, Object>)map.get("book"),Book.class);
            bt = JsonXMLUtils.map2obj((Map<String, Object>)map.get("bt"), Bt.class);
            boolean flag = judgeExistBt(book.getBno(), bt.getTno());
            if (!flag)
                return ServerResponse.createByErrorMessage("著作已存在");
        }catch (Exception e) {
            return ServerResponse.createByErrorMessage("参数存在空值");
        }
        if(book.getBno() == null) {
            return ServerResponse.createByErrorMessage("著作编码不能为空");
        } else if (book.getBname() == null) {
            return ServerResponse.createByErrorMessage("著作名称不能为空");
        } else if (book.getBgrade() == null) {
            return ServerResponse.createByErrorMessage("著作等级不能为空");
        } else if (book.getBleader() == null) {
            return ServerResponse.createByErrorMessage("著作负责人不能为空");
        }  else if (bt.getTno() == null) {
            return ServerResponse.createByErrorMessage("老师编号不能为空");
        } else {
            boolean flag = judgeExistTeacher(bt.getTno());
            if (flag) {
                int i = bookMapper.insertSelective(book);
                if (i > 0) {
                    bt.setBno(book.getBno());
                    int j = btMapper.insertSelective(bt);
                    if (j > 0) {
                        return ServerResponse.createBySuccessMessage("添加成功");
                    }
                    else {
                        bookMapper.deleteByPrimaryKey(book.getBno());
                        return ServerResponse.createByErrorMessage("添加失败,主键不唯一");
                    }
                }
                return ServerResponse.createByErrorMessage("添加失败,著作编号已存在");
            }
            return ServerResponse.createByErrorMessage("教师不存在，添加失败");
        }
    }

    @Override
    public ServerResponse<List<Book>> findAll() {
        List<Book> list = bookMapper.findAll();
        if (list.size() > 0) {
            return ServerResponse.createBySuccess(list);
        }
        return ServerResponse.createByErrorMessage("暂时著作没有数据");
    }

    @Override
    public ServerResponse<Book> findByBno(String bno) {
        Book book = bookMapper.selectByPrimaryKey(bno);
        if (book != null) {
            return ServerResponse.createBySuccess(book);
        }
        return ServerResponse.createByErrorMessage("编号不存在");
    }

    @Override
    public ServerResponse<String> deleteByBno(String bno) {
        int i = bookMapper.deleteByPrimaryKey(bno);
        int j = btMapper.deleteByBno(bno);
        if(i > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("编号不存在");
    }

    @Override
    public ServerResponse<Book> updateByBno(Book book) {
        if (book.getBno() == null) {
            return ServerResponse.createBySuccessMessage("著作编码不能为空");
        }
        Book oldBook = bookMapper.selectByPrimaryKey(book.getBno());
        if (oldBook != null) {
            book.setBstatus(oldBook.getBstatus());
            book.setBendtime(oldBook.getBendtime());
            int i = bookMapper.updateByPrimaryKeySelective(book);
            if (i > 0) {
                return ServerResponse.createBySuccessMessage("修改成功");
            }
            return ServerResponse.createByErrorMessage("修改失败");
        }
        return ServerResponse.createByErrorMessage("修改的著作不存在");
    }

    @Override
    public ServerResponse<List<Book>> findListByTno(String tno) {
        List<Bt> list= btMapper.findListByTno(tno);
        if (list.size() > 0) {
            List bnoList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                bnoList.add(list.get(i).getBno());
            }
            List<Book> bookList = bookMapper.findsByBnos(bnoList);
            if (bookList.size() > 0) {
                return ServerResponse.createBySuccess(bookList);
            }
            return ServerResponse.createByErrorMessage("没有查到数据");
        }
        return ServerResponse.createByErrorMessage("教师编号不存在");
    }

    @Override
    public ServerResponse<Integer> updateStatusByBno(String bno, Integer bstatus) {
        Book book = bookMapper.selectByPrimaryKey(bno);
        if (book != null && bstatus != null) {
            int i = bookMapper.updateStatusByBno(bno, bstatus+"");
            if (i > 0) {
                return ServerResponse.createBySuccess("更新状态成功",bstatus);
            }
            return ServerResponse.createBySuccessMessage("更新状态失败");
        }
        return ServerResponse.createBySuccessMessage("更新的著作不存在");
    }

    /**
     * @description:  判断教师是否存在
     * @author: kw
     * @date: 2019/4/10
     * @param: [tno]
     * @return: boolean
     */
    public boolean judgeExistTeacher(String tno) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(tno);
        if(teacher != null) {
            return true;
        }
        return false;
    }

    public boolean judgeExistBt(String bno, String tno) {
        Book book = bookMapper.selectByPrimaryKey(bno);
        Bt bt = btMapper.selectByBnoAndTno(bno, tno);
        if (bt != null || book != null)
            return false;
        return true;
    }
}
