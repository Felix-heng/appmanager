package com.jbit.service;

import com.jbit.pojo.BackendUser;
import com.jbit.mapper.BackendUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BackendUserService {
    @Resource
    private BackendUserMapper backendUserMapper;

    /**
     * 管理员登录验证
     * @param backendUser
     * @return
     */
    public BackendUser queryByBackendUser(BackendUser backendUser){
       return backendUserMapper.selectOne(backendUser);
    }
}
