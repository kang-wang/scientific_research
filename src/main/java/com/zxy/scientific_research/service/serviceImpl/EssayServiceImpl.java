package com.zxy.scientific_research.service.serviceImpl;

import com.zxy.scientific_research.bean.Essay;
import com.zxy.scientific_research.bean.Et;
import com.zxy.scientific_research.bean.Teacher;
import com.zxy.scientific_research.common.ServerResponse;
import com.zxy.scientific_research.mapper.EssayMapper;
import com.zxy.scientific_research.mapper.EtMapper;
import com.zxy.scientific_research.mapper.TeacherMapper;
import com.zxy.scientific_research.service.IEssayService;
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
 * @create: 2019/04/10 21:02
 */
@Service
public class EssayServiceImpl implements IEssayService {
    @Autowired
    private EssayMapper essayMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private EtMapper etMapper;


    @Override
    public ServerResponse<Essay> findByEno(String eno) {
        Essay essay = essayMapper.selectByPrimaryKey(eno);
        if (essay != null) {
            return ServerResponse.createBySuccess(essay);
        }
        return ServerResponse.createByErrorMessage("编号不存在");
    }

    @Override
    public ServerResponse<List<Essay>> findAll() {

        List<Essay> list = essayMapper.findAll();
        if (list.size() > 0) {
            return ServerResponse.createBySuccess(list);
        }
        return ServerResponse.createByErrorMessage("暂时论文没有数据");
    }

    @Override
    public ServerResponse<Essay> addEssay(Map<String, Object> map) {
        Essay essay;
        Et et;
        try {
            essay = JsonXMLUtils.map2obj((Map<String, Object>)map.get("essay"),Essay.class);
            et = JsonXMLUtils.map2obj((Map<String, Object>)map.get("et"), Et.class);
            boolean flag = judgeExistEt(essay.getEno(), et.getTno());
            if (!flag)
                return ServerResponse.createByErrorMessage("论文已存在");
        }catch (Exception e) {
            return ServerResponse.createByErrorMessage("参数存在空值");
        }
        if(essay.getEno() == null) {
            return ServerResponse.createByErrorMessage("论文编码不能为空");
        } else if (essay.getEname() == null) {
            return ServerResponse.createByErrorMessage("论文名称不能为空");
        } else if (essay.getEgrade() == null) {
            return ServerResponse.createByErrorMessage("论文等级不能为空");
        } else if (essay.getEleader() == null) {
            return ServerResponse.createByErrorMessage("论文负责人不能为空");
        }  else if (et.getTno() == null) {
            return ServerResponse.createByErrorMessage("老师编号不能为空");
        } else {
            boolean flag = judgeExistTeacher(et.getTno());
            if (flag) {
                //essay.setEstatus("0");
                int i = essayMapper.insertSelective(essay);
                if (i > 0) {
                    et.setEno(essay.getEno());
                    int j = etMapper.insertSelective(et);
                    if (j > 0) {
                        return ServerResponse.createBySuccessMessage("添加成功");
                    } else {
                        essayMapper.deleteByPrimaryKey(essay.getEno());
                        return ServerResponse.createByErrorMessage("添加失败,主键不唯一");
                    }
                }
                return ServerResponse.createByErrorMessage("添加失败,论文编号已存在");
            }
            return ServerResponse.createByErrorMessage("添加失败，教师不存在");
        }
    }

    @Override
    public ServerResponse<String> deleteByEno(String eno) {
        int i = essayMapper.deleteByPrimaryKey(eno);
        int j = etMapper.deleteByEno(eno);
        if(i > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("编号不存在");
    }

    @Override
    public ServerResponse<Essay> updateByEno(Essay essay) {
        if (essay.getEno() == null) {
            return ServerResponse.createBySuccessMessage("论文编码不能为空");
        }
        Essay oldEssay = essayMapper.selectByPrimaryKey(essay.getEno());
        if (oldEssay != null) {
            essay.setEstatus(oldEssay.getEstatus());
            essay.setEendtime(oldEssay.getEendtime());
            int i = essayMapper.updateByPrimaryKeySelective(essay);
            if (i > 0) {
                return ServerResponse.createBySuccessMessage("修改成功");
            }
            return ServerResponse.createByErrorMessage("修改失败");
        }
        return ServerResponse.createByErrorMessage("修改的论文不存在");
    }

    @Override
    public ServerResponse<List<Essay>> findListByTno(String tno) {
        List<Et> list= etMapper.findsListByTno(tno);
        if (list.size() > 0) {
            List enoList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                enoList.add(list.get(i).getEno());
            }
            List<Essay> essaytList = essayMapper.findsByEnos(enoList);
            if (essaytList.size() > 0) {
                return ServerResponse.createBySuccess(essaytList);
            }
            return ServerResponse.createByErrorMessage("没有查到数据");
        }
        return ServerResponse.createByErrorMessage("教师编号不存在");
    }

    @Override
    public ServerResponse<Integer> updateStatusByPno(String eno, Integer estatus) {
        Essay essay = essayMapper.selectByPrimaryKey(eno);
        if (essay != null && estatus != null) {
            int i = essayMapper.updateStatusByEno(eno, estatus+"");
            if (i > 0) {
                return ServerResponse.createBySuccess("更新状态成功",estatus);
            }
            return ServerResponse.createBySuccessMessage("更新状态失败");
        }
        return ServerResponse.createBySuccessMessage("更新的论文不存在");
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

    /**
     * @description:  判断Et是否存在
     * @author: kw
     * @date: 2019/4/14
     * @param: [eno, tno]
     * @return: boolean
     */
    public boolean judgeExistEt(String eno, String tno) {
        Essay essay = essayMapper.selectByPrimaryKey(eno);
        Et et = etMapper.selectByEnoAndTno(eno, tno);
        if (et != null || essay != null)
            return false;
        return true;
    }
}
