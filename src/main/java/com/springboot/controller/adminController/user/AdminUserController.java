package com.springboot.controller.adminController.user;

import com.springboot.domain.*;
import com.springboot.service.admin.AdminDeleteService;
import com.springboot.service.admin.AdminGetService;
import com.springboot.service.admin.AdminRegisterService;
import com.springboot.service.admin.AdminUpdateService;
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

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Controller
@RequestMapping("admin")
public class AdminUserController {

    @Autowired
    UserGetService userGetServiceImpl;

    @GetMapping("/getAllUser")
    public String getAllUser(Model model){
        List<Map<String, Object>> user = userGetServiceImpl.getUser();
        model.addAttribute("user",user);
        return "admin/user/getAllUser";
    }

    @GetMapping("/updateUser/{USER_ID}")
    public String updateUserGet(@PathVariable("USER_ID") String USER_ID, Model model){
        Map<String,Object> user = userGetServiceImpl.getUserByUSERID(USER_ID);
        model.addAttribute("user",user);
        System.out.println(user);
        return "admin/user/updateUser";
    }

    @GetMapping("/addUserPage")
    public String addUserPage(){
        return "admin/user/addUser";
    }

    @Autowired
    UserRegisterService userRegisterServiceImpl;
    @PostMapping("/addUserPost")
    @ResponseBody
    public String addUserPost(@RequestParam("USER_NAME") String USER_NAME,@RequestParam("USER_PASSWORD") String USER_PASSWORD,
                              @RequestParam("USER_PHONE") String USER_PHONE,@RequestParam("USER_SEX") String USER_SEX,@RequestParam("USER_REALNAME") String USER_REALNAME,
                              @RequestParam("USER_WECHAT") String USER_WECHAT,Model model){
        User addUser = new User();
        addUser.setUSER_NAME(USER_NAME);
        addUser.setUSER_PHONE(USER_PHONE);
        addUser.setUSER_SEX(USER_SEX);
        addUser.setUSER_REALNAME(USER_REALNAME);
        addUser.setUSER_WECHAT(USER_WECHAT);
        addUser.setUSER_PASSWORD(USER_PASSWORD);
        return String.valueOf(userRegisterServiceImpl.userRegister(addUser));
    }

    @PostMapping("/checkUserName")
    @ResponseBody
    public int checkUserName(@RequestParam("USER_NAME")String USER_NAME){
        int result = userRegisterServiceImpl.checkName(USER_NAME);
        return result;
    }


    @Autowired
    UserDeleteService userDeleteServiceImpl;
    @GetMapping("/deleteUser/{USER_ID}")
    @ResponseBody
    public String deleteUser(@PathVariable("USER_ID") String USER_ID){
        if(userDeleteServiceImpl.userDelete(Integer.valueOf(USER_ID)) == 1){
            return "删除成功";
        }
        return "删除失败";
    }


    @Autowired
    UserUpdateService userUpdateServiceImpl;
    @PostMapping("/updateUser")
    @ResponseBody
    public String updateUserPost(@RequestParam("USER_ID") String USER_ID,@RequestParam("USER_NAME") String USER_NAME,@RequestParam("USER_PASSWORD") String USER_PASSWORD,
                                 @RequestParam("USER_PHONE") String USER_PHONE,@RequestParam("USER_SEX") String USER_SEX,@RequestParam("USER_REALNAME") String USER_REALNAME,@RequestParam("USER_WECHAT") String USER_WECHAT){
        User newUser = new User();
        newUser.setUSER_NAME(USER_NAME);
        newUser.setUSER_PHONE(USER_PHONE);
        newUser.setUSER_SEX(USER_SEX);
        newUser.setUSER_REALNAME(USER_REALNAME);
        newUser.setUSER_WECHAT(USER_WECHAT);
        newUser.setUSER_PASSWORD(USER_PASSWORD);
        newUser.setUSER_ID(Integer.valueOf(USER_ID));
        return String.valueOf(userUpdateServiceImpl.userUpdate(newUser));
    }

}
