package com.zxy.scientific_research.service.serviceImpl;

import com.zxy.scientific_research.bean.Bt;
import com.zxy.scientific_research.bean.Et;
import com.zxy.scientific_research.bean.Pt;
import com.zxy.scientific_research.bean.Teacher;
import com.zxy.scientific_research.common.ServerResponse;
import com.zxy.scientific_research.mapper.BtMapper;
import com.zxy.scientific_research.mapper.EtMapper;
import com.zxy.scientific_research.mapper.PtMapper;
import com.zxy.scientific_research.mapper.TeacherMapper;
import com.zxy.scientific_research.service.ITeacherService;
import com.zxy.scientific_research.util.JsonXMLUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program: scientific_research
 * @description:
 * @author: kw
 * @create: 2019/04/08 20:47
 */
@Service(value = "ITeacherService")
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private PtMapper ptMapper;

    @Autowired
    private EtMapper etMapper;

    @Autowired
    private BtMapper btMapper;

    @Override
    public ServerResponse<Teacher> register(Teacher teacher) {
        if (teacher.getTno()==null) {
            return ServerResponse.createByErrorMessage("教师编码不能为空");
        } else if (teacher.getTname()==null) {
            return ServerResponse.createByErrorMessage("教师姓名不能为空");
        } else if (teacher.getTpass()==null) {
            return ServerResponse.createByErrorMessage("教师密码不能为空");
        } else if (teacher.getTsex()==null) {
            return ServerResponse.createByErrorMessage("教师性别不能为空");
        } else if (teacher.getTdept()==null) {
            return ServerResponse.createByErrorMessage("教师部门不能为空");
        } else if (teacher.getTduty()==null) {
            return ServerResponse.createByErrorMessage("教师职称不能为空");
        } else if (teacher.getTemail()==null) {
            return ServerResponse.createByErrorMessage("教师邮箱不能为空");
        } else if (teacher.getTtel()==null) {
            return ServerResponse.createByErrorMessage("教师电话不能为空");
        } else if (teacher.getTsex() != 0 || teacher.getTsex() != 1) {
            return ServerResponse.createByErrorMessage("教师性别填写错误");
        } else {
            Teacher teacherIsExist = teacherMapper.selectByPrimaryKey(teacher.getTno());
            if(teacherIsExist != null) {
                return ServerResponse.createByErrorMessage("教师已存在");
            }
            int i = teacherMapper.insertSelective(teacher);
            if (i > 0) {
                return ServerResponse.createBySuccess("注册成功",teacher);
            }
            return ServerResponse.createByErrorMessage("注册失败");
        }
    }

    @Override
    public ServerResponse<Teacher> findByTno(String tno) {
        Teacher teacher = teacherMapper.selectByPrimaryKey(tno);
        if (teacher != null) {
            return ServerResponse.createBySuccess(teacher);
        }
        return ServerResponse.createByErrorMessage("没有查到数据");
    }

    @Override
    public ServerResponse<Teacher> deleteByTno(String tno) {
        int i = ptMapper.deleteByTno(tno);
        int j = btMapper.deleteByTno(tno);
        int k = btMapper.deleteByTno(tno);
        int n = teacherMapper.deleteByPrimaryKey(tno);
        if (n > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败,编号不存在");
    }

    @Override
    public ServerResponse<List<Teacher>> findAll() {
        List<Teacher> list = teacherMapper.findAll();
        if (list.size() > 0) {
            return ServerResponse.createBySuccess(list);
        }
        return ServerResponse.createByErrorMessage("没有查到数据");
    }

    @Override
    public ServerResponse<List<Teacher>> findByTname(String tname) {
        List<Teacher> list = teacherMapper.findListByTname(tname);
        if(list.size() > 0) {
            return ServerResponse.createBySuccess(list);
        }
        return ServerResponse.createByErrorMessage("没有查到数据");
    }

    @Override
    public ServerResponse<String> updatePass(Teacher teacher) {
        int i = teacherMapper.updatePassByPrimaryKey(teacher);
        if(i > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createBySuccessMessage("修改失败");
    }

    @Override
    public ServerResponse<String> updateTeacher(Teacher teacher) {
        int i = teacherMapper.updateByPrimaryKeySelective(teacher);
        if(i > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }

    @Override
    public ServerResponse<Teacher> login(Teacher teacher) {
        if (teacher.getTno() == null || teacher.getTpass() == null) {
            return ServerResponse.createByErrorMessage("教师编号或密码不能为空");
        }
        Teacher oldTeacher = teacherMapper.selectByPrimaryKey(teacher.getTno());
        if (oldTeacher != null) {
            if (teacher.getTpass().equals(oldTeacher.getTpass())) {
                oldTeacher.setTpass("");
                return ServerResponse.createBySuccess("登录成功",oldTeacher);
            }
            return ServerResponse.createByErrorMessage("密码错误");
        }
        return ServerResponse.createByErrorMessage("账号错误");
    }

    @Override
    public ServerResponse<List<Teacher>> findByConditions(Map<String, Object> map) {
            Set<String> set = new HashSet();
            if (map.containsKey("pno")) {
                String pno = (String) map.get("pno");
                if (pno != null) {
                    List<Pt> p_tno = ptMapper.findListByPno(pno);
                    for (int i = 0; i < p_tno.size(); i++) {
                        set.add(p_tno.get(i).getTno());
                    }
                }
            }
            if (map.containsKey("eno")) {
                String eno = (String) map.get("eno");
                if (eno != null) {
                    List<Et> e_tno = etMapper.findsListByEno(eno);
                    for (int i = 0; i < e_tno.size(); i++) {
                        set.add(e_tno.get(i).getTno());
                    }
                }
            }
            if (map.containsKey("bno")) {
                String bno = (String) map.get("bno");
                if (bno != null) {
                    List<Bt> b_tno = btMapper.findListByBno(bno);
                    for (int i = 0; i < b_tno.size(); i++) {
                        set.add(b_tno.get(i).getTno());
                    }
                }
            }
            if (set == null || set.size() == 0) {
                return ServerResponse.createByErrorMessage("没有查到数据");
            }
            List<Teacher> list = teacherMapper.findByTnos(set);
            if (list != null) {
                return ServerResponse.createBySuccess(list);
            }
            return ServerResponse.createByErrorMessage("没有查到数据");
    }
}
