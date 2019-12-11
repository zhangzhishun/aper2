package com.springboot.controller.adminController;

import com.springboot.domain.*;
import com.springboot.service.admin.*;
import com.springboot.service.doctor.DoctorDeleteService;
import com.springboot.service.doctor.DoctorGetService;
import com.springboot.service.doctor.DoctorRegisterService;
import com.springboot.service.doctor.DoctorUpdateService;
import com.springboot.service.reply.ReplyDeleteService;
import com.springboot.service.reply.ReplyGetService;
import com.springboot.service.reply.ReplyInsertService;
import com.springboot.service.reply.ReplyUpdateService;
import com.springboot.service.reportform.ReportFormDeleteService;
import com.springboot.service.reportform.ReportFormGetService;
import com.springboot.service.reportform.ReportFormInsertService;
import com.springboot.service.reportform.ReportFormUpdateService;
import com.springboot.service.user.UserDeleteService;
import com.springboot.service.user.UserGetService;
import com.springboot.service.user.UserRegisterService;
import com.springboot.service.user.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("")
    public String login(){
        return "admin/login";
    }

    @GetMapping("/main")
    public String adminMain(){
        return "admin/main";
    }

    @Autowired
    AdminLoginAuthService adminLoginAuthServiceImpl;

    @PostMapping("/login")
    public String loginPost(@RequestParam("username") String username, @RequestParam("password") String password,
                            Map<String, Object> map,HttpSession session, Model model){
        Admin login = new Admin();
        login.setADMIN_NAME(username);
        login.setADMIN_PASSWORD(password);
        boolean flag = adminLoginAuthServiceImpl.adminLoginAuth(login);
        if(flag){
            System.out.println("success login");
            session.setAttribute("loginUser",username);
            return "redirect:main";
        }else{
            //登陆失败
            map.put("msg", "用户名密码错误");
            return "admin/login";
        }

    }

}
