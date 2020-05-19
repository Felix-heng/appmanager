package com.jbit.service;

import com.jbit.mapper.DevUserMapper;
import com.jbit.pojo.DevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DevUserService {

    @Resource
    private DevUserMapper devUserMapper;

    /**
     * 开发者登录验证
     * @param
     * @return
     */
    public DevUser queryByDevUser(String devcode,String devpassword){
        DevUser devUser = new DevUser();
        devUser.setDevcode(devcode);
        devUser.setDevpassword(devpassword);
        return devUserMapper.selectOne(devUser);
    }
}
