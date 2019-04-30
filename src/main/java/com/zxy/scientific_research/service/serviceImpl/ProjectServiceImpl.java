package com.zxy.scientific_research.service.serviceImpl;

import com.zxy.scientific_research.bean.Project;
import com.zxy.scientific_research.bean.Pt;
import com.zxy.scientific_research.bean.Teacher;
import com.zxy.scientific_research.common.ServerResponse;
import com.zxy.scientific_research.mapper.ProjectMapper;
import com.zxy.scientific_research.mapper.PtMapper;
import com.zxy.scientific_research.mapper.TeacherMapper;
import com.zxy.scientific_research.service.IProjectService;
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
 * @create: 2019/04/10 19:58
 */
@Service(value = "IProjectService")
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private PtMapper ptMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public ServerResponse<Project> addProject(Map<String,Object> map) {
        Project project;
        Pt pt;
        try {
            project = JsonXMLUtils.map2obj((Map<String, Object>)map.get("project"),Project.class);
            pt = JsonXMLUtils.map2obj((Map<String, Object>)map.get("pt"), Pt.class);
            boolean flag = judgeExistPt(project.getPno(), pt.getTno());
            if (!flag)
                return ServerResponse.createByErrorMessage("项目已存在");
        }catch (Exception e) {
            return ServerResponse.createByErrorMessage("参数存在空值");
        }
        if(project.getPno() == null) {
            return ServerResponse.createByErrorMessage("项目编码不能为空");
        } else if (project.getPname() == null) {
            return ServerResponse.createByErrorMessage("项目名称不能为空");
        } else if (project.getPgrade()== null) {
            return ServerResponse.createByErrorMessage("项目等级不能为空");
        } else if (project.getPleader() == null) {
            return ServerResponse.createByErrorMessage("项目负责人不能为空");
        } else if (pt.getTno() == null) {
            return ServerResponse.createByErrorMessage("老师编号不能为空");
        } else {
            boolean flag = judgeExistTeacher(pt.getTno());
            if (flag) {
                int i = projectMapper.insertSelective(project);
                if (i > 0) {
                    pt.setPno(project.getPno());
                    int j = ptMapper.insertSelective(pt);
                    if (j > 0) {
                        return ServerResponse.createBySuccessMessage("添加成功");
                    } else {
                        projectMapper.deleteByPrimaryKey(project.getPno());
                        return ServerResponse.createByErrorMessage("添加失败,主键不唯一");
                    }
                }
                return ServerResponse.createByErrorMessage("添加失败,项目编号已存在");
            }
            return ServerResponse.createByErrorMessage("添加失败,教师不存在");
        }
    }

    @Override
    public ServerResponse<Integer> updateStatusByPno(String pno, Integer pstatus) {
        Project project = projectMapper.selectByPrimaryKey(pno);
        if (project != null && pstatus != null) {
            int i = projectMapper.updateStatusByPno(pno, pstatus+"");
            if (i > 0) {
                return ServerResponse.createBySuccess("更新状态成功",pstatus);
            }
            return ServerResponse.createBySuccessMessage("更新状态失败");
        }
        return ServerResponse.createBySuccessMessage("更新的项目不存在");
    }

    @Override
    public ServerResponse<List<Project>> findAll() {
        List<Project> list = projectMapper.findAll();
        if (list.size() > 0) {
            return ServerResponse.createBySuccess(list);
        }
        return ServerResponse.createByErrorMessage("暂时项目没有数据");
    }

    @Override
    public ServerResponse<Project> findByPno(String pno) {
        Project project = projectMapper.selectByPrimaryKey(pno);
        if (project != null) {
            return ServerResponse.createBySuccess(project);
        }
        return ServerResponse.createByErrorMessage("编号不存在");
    }

    @Override
    public ServerResponse<String> deleteByPno(String pno) {
        int i = projectMapper.deleteByPrimaryKey(pno);
        int j = ptMapper.deleteByPno(pno);
        if(i > 0) {
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("编号不存在");
    }

    @Override
    public ServerResponse<Project> updateByPno(Project project) {
        if (project.getPno() == null) {
            return ServerResponse.createBySuccessMessage("项目编码不能为空");
        }
        Project oldProject = projectMapper.selectByPrimaryKey(project.getPno());
        if (oldProject != null) {
            project.setPstatus(oldProject.getPstatus());
            project.setPendtime(oldProject.getPendtime());
            int i = projectMapper.updateByPrimaryKeySelective(project);
            if (i > 0) {
                return ServerResponse.createBySuccessMessage("修改成功");
            }
            return ServerResponse.createByErrorMessage("修改失败");
        }
        return ServerResponse.createByErrorMessage("修改的项目不存在");
    }

    @Override
    public ServerResponse<List<Project>> findListByTno(String tno) {
        List<Pt> list= ptMapper.findListByTno(tno);
        if (list.size() > 0) {
            List pnoList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                pnoList.add(list.get(i).getPno());
            }
            List<Project> projectList = projectMapper.findsByPnos(pnoList);
            if (projectList.size() > 0) {
                return ServerResponse.createBySuccess(projectList);
            }
            return ServerResponse.createByErrorMessage("没有查到数据");
        }
        return ServerResponse.createByErrorMessage("教师编号不存在");
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
     * @description:  判断Pt是否存在
     * @author: kw
     * @date: 2019/4/14
     * @param: [pno, tno]
     * @return: boolean
     */
    public boolean judgeExistPt(String pno, String tno) {
        Project project = projectMapper.selectByPrimaryKey(pno);
        Pt pt = ptMapper.selectByPnoAndTno(pno, tno);
        if (pt != null || project != null)
            return false;
        return true;
    }
}
