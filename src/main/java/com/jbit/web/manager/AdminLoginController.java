package com.jbit.web.manager;

import com.jbit.pojo.BackendUser;
import com.jbit.service.BackendUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    @Resource
    private BackendUserService backendUserService;

    @GetMapping("/adminlogin")
    public String adminPage(){
        return "backendlogin";
    }

    @PostMapping("/dologin")
    public String adminLogin(String userCode, String userPassword, HttpSession session, Model model){
        BackendUser backendUser = new BackendUser();
        backendUser.setUsercode(userCode);
        backendUser.setUserpassword(userPassword);
        BackendUser user = backendUserService.queryByBackendUser(backendUser);
        if (user != null){
            session.setAttribute("userSession",user);
            return "backend/main";
        }
        model.addAttribute("error","用户名或密码错误");
        return "backendlogin";
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("userSession");
        return "/backendlogin";
    }


    @GetMapping("main")
    public String main(){
        return "backend/main";
    }

}
