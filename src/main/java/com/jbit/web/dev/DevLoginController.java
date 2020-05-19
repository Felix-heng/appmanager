package com.jbit.web.dev;

import com.jbit.pojo.DevUser;
import com.jbit.service.DevUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/dev")
public class DevLoginController {
    @Resource
    private DevUserService devUserService;

    @GetMapping("/devlogin")
    public String devPage(){
        return "devlogin";
    }

    @PostMapping("/dologin")
    public String adminLogin(String devCode, String devPassword, HttpSession session, Model model){
        DevUser user = devUserService.queryByDevUser(devCode,devPassword);
        if (user != null){
            session.setAttribute("devUserSession",user);
            return "developer/main";
        }
        model.addAttribute("error","用户名或密码错误");
        return "devlogin";
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("devUserSession");
        return "/devlogin";
    }


    @GetMapping("main")
    public String main(){
        return "developer/main";
    }
}
