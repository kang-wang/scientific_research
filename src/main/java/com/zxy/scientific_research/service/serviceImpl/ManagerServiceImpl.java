package com.zxy.scientific_research.service.serviceImpl;

import com.zxy.scientific_research.bean.Manager;
import com.zxy.scientific_research.common.ServerResponse;
import com.zxy.scientific_research.mapper.ManagerMapper;
import com.zxy.scientific_research.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: scientific_research
 * @description:
 * @author: kw
 * @create: 2019/04/01 20:15
 */
@Service(value = "IManagerService")
public class ManagerServiceImpl implements IManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public ServerResponse<Manager> register(Manager manager) {
        if (manager.getMno() == null) {
            return ServerResponse.createByErrorMessage("管理员编码不能为空");
        } else if (manager.getMname() == null) {
            return ServerResponse.createByErrorMessage("管理员姓名不能为空");
        } else if (manager.getMpass() == null) {
            return ServerResponse.createByErrorMessage("管理员密码不能为空");
        } else {
            Manager managerIsExist = managerMapper.selectByPrimaryKey(manager.getMno());
            if(managerIsExist!=null) {
                return ServerResponse.createByErrorMessage("管理员已存在");
            }
            int i = managerMapper.insertSelective(manager);
            if (i > 0) {
                return ServerResponse.createBySuccess("注册成功",manager);
            } else {
                return ServerResponse.createByErrorMessage("注册失败");
            }
        }
    }

    @Override
    public ServerResponse<List<Manager>> findAll() {
        List<Manager> list = managerMapper.findAll();
        if (list.size() > 0) {
            return ServerResponse.createBySuccess(list);
        }
        return ServerResponse.createByErrorMessage("没有查到数据");
    }

    @Override
    public ServerResponse<Manager> login(Manager manager) {

        if (manager.getMno() == null || manager.getMpass() == null) {
            return ServerResponse.createByErrorMessage("管理员编号或密码不能为空");
        }
        Manager oldmanager = managerMapper.selectByPrimaryKey(manager.getMno());
        if (oldmanager == null) {
            return ServerResponse.createByErrorMessage("账号错误");
        }
        if (manager.getMpass().equals(oldmanager.getMpass())) {
            oldmanager.setMpass("");
            return ServerResponse.createBySuccess("登录成功",oldmanager);
        }
        return ServerResponse.createByErrorMessage("密码错误");
    }

    @Override
    public ServerResponse<String> updatePass(Manager manager) {
        int i = managerMapper.updatePassByPrimaryKey(manager);
        if(i > 0) {
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createBySuccessMessage("修改失败");

    }

    @Override
    public ServerResponse<Manager> findByMno(String mno) {
        Manager manager = managerMapper.selectByPrimaryKey(mno);
        if (manager != null) {
            return ServerResponse.createBySuccess(manager);
        }
        return ServerResponse.createBySuccessMessage("没有查到数据");
    }

    @Override
    public ServerResponse<String> deleteByMno(String mno) {
        int count = managerMapper.selectCount();
        if (count > 1) {
            int i = managerMapper.deleteByPrimaryKey(mno);
            if (i > 0) {
                return ServerResponse.createBySuccessMessage("删除成功");
            }
            return ServerResponse.createByErrorMessage("删除失败,编号不存在");
        }
        return ServerResponse.createByErrorMessage("删除失败,至少得存在一个管理员");
    }

}
