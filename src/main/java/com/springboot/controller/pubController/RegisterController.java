package com.springboot.controller.pubController;

import com.springboot.domain.User;
import com.springboot.service.user.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Controller
public class RegisterController {

    @Autowired
    UserRegisterService userRegisterServiceImpl;

    @GetMapping("/register")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/registerPost")
    @ResponseBody
    public String registerPost(@RequestParam("USER_NAME")String USER_NAME,@RequestParam("USER_PASSWORD")String USER_PASSWORD,
                               @RequestParam("USER_PHONE")String USER_PHONE, @RequestParam("USER_SEX")String USER_SEX,
                               @RequestParam("USER_REALNAME")String USER_REALNAME,@RequestParam("USER_WECHAT")String USER_WECHAT,
                               Model model){
        User user = new User();
        user.setUSER_PASSWORD(USER_PASSWORD);
        user.setUSER_NAME(USER_NAME);
        user.setUSER_WECHAT(USER_WECHAT);
        user.setUSER_REALNAME(USER_REALNAME);
        user.setUSER_SEX(USER_SEX);
        user.setUSER_PHONE(USER_PHONE);
        int result = userRegisterServiceImpl.userRegister(user);
        return String.valueOf(result);
    }

    @PostMapping("/checkName")
    @ResponseBody
    public int checkName(@RequestParam("USER_NAME")String USER_NAME){
        int result = userRegisterServiceImpl.checkName(USER_NAME);
        return result;
    }
}
