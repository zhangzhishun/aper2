package com.springboot.controller.adminController.admin;

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
public class AdminAdminController {

    @Autowired
    AdminGetService adminGetServiceImpl;
    @GetMapping("/getAllAdmin")
    public String getAllAdmin(Model model){
        List<Map<String, Object>> admin = adminGetServiceImpl.getAllAdmin();
        model.addAttribute("admin",admin);
        return "admin/admin/getAllAdmin";
    }

    @GetMapping("/updateAdmin/{ADMIN_ID}")
    public String updateAdmin(@PathVariable("ADMIN_ID") String ADMIN_ID, Model model){
        System.out.println("adminController UPdate");
        Admin admin = adminGetServiceImpl.getAdminByADMINID(Integer.valueOf(ADMIN_ID));
        model.addAttribute("admin",admin);
        System.out.println(admin);
        return "admin/admin/updateAdmin";
    }

    @GetMapping("/addAdminPage")
    public String addAdminPage(){
        return "admin/admin/addAdmin";
    }

    @PostMapping("/checkAdminName")
    @ResponseBody
    public int checkAdminName(@RequestParam("ADMIN_NAME")String ADMIN_NAME){
        System.out.println("check"+ADMIN_NAME);
        int result = adminRegisterServiceImpl.checkName(ADMIN_NAME);
        return result;
    }

    @Autowired
    AdminRegisterService adminRegisterServiceImpl;
    @PostMapping("/addAdminPost")
    @ResponseBody
    public String addAdminPost(@RequestParam("ADMIN_NAME") String ADMIN_NAME,@RequestParam("ADMIN_PASSWORD") String ADMIN_PASSWORD,Model model){
        Admin admin = new Admin();
        admin.setADMIN_PASSWORD(ADMIN_PASSWORD);
        admin.setADMIN_NAME(ADMIN_NAME);
        return String.valueOf(adminRegisterServiceImpl.adminRegister(admin));
    }

    @Autowired
    AdminDeleteService adminDeleteServiceImpl;
    @GetMapping("/deleteAdmin/{ADMIN_ID}")
    @ResponseBody
    public String deleteADMIN(@PathVariable("ADMIN_ID") String ADMIN_ID){
        if(adminDeleteServiceImpl.adminDelete(Integer.valueOf(ADMIN_ID)) == 1){
            return "删除成功";
        }
        return "删除失败";
    }

    @Autowired
    AdminUpdateService adminUpdateServiceImpl;
    @PostMapping("/updateAdmin")
    @ResponseBody
    public String updateAdminPost(@RequestParam("ADMIN_PASSWORD") String ADMIN_PASSWORD,@RequestParam("ADMIN_NAME") String ADMIN_NAME){
        Admin admin = new Admin();
        admin.setADMIN_PASSWORD(ADMIN_PASSWORD);
        admin.setADMIN_NAME(ADMIN_NAME);
        return String.valueOf(adminUpdateServiceImpl.adminUpdate(admin));
    }

}
