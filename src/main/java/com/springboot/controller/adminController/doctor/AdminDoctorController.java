package com.springboot.controller.adminController.doctor;

import com.springboot.domain.*;
import com.springboot.service.admin.AdminDeleteService;
import com.springboot.service.admin.AdminGetService;
import com.springboot.service.admin.AdminRegisterService;
import com.springboot.service.admin.AdminUpdateService;
import com.springboot.service.doctor.DoctorDeleteService;
import com.springboot.service.doctor.DoctorGetService;
import com.springboot.service.doctor.DoctorRegisterService;
import com.springboot.service.doctor.DoctorUpdateService;
import com.springboot.service.office.OfficeGetService;
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
public class AdminDoctorController {

    @Autowired
    DoctorGetService doctorGetServiceImpl;
    @Autowired
    OfficeGetService officeGetServiceImpl;
    @GetMapping("/getAllDoctor")
    public String getAllDoctor(Model model){
        List<Map<String, Object>> doctor = doctorGetServiceImpl.getAllDoctor();
        model.addAttribute("doctor",doctor);
        return "admin/doctor/getAllDoctor";
    }

    @Autowired
    DoctorUpdateService doctorUpdateServiceImpl;
    @GetMapping("/updateDoctor/{DOCTOR_ID}")
    public String updateDoctor(@PathVariable("DOCTOR_ID") String DOCTOR_ID, Model model){
        List<Map<String,Object>> doctor = doctorGetServiceImpl.getDoctorById(Integer.valueOf(DOCTOR_ID));
        List<Map<String,Object>> office = officeGetServiceImpl.getAllOffice();
        model.addAttribute("doctor",doctor);
        model.addAttribute("officeList",office);
        System.out.println(doctor);
        return "admin/doctor/updateDoctor";
    }

    @GetMapping("/addDoctorPage")
    public String addDoctorPage(){
        return "admin/doctor/addDoctor";
    }

    @Autowired
    DoctorRegisterService doctorRegisterServiceImpl;
    @PostMapping("/checkDoctorName")
    @ResponseBody
    public int checkDoctorName(@RequestParam("DOCTOR_NAME")String DOCTOR_NAME){
        int result = doctorRegisterServiceImpl.checkName(DOCTOR_NAME);
        return result;
    }

    @PostMapping("/addDoctorPost")
    @ResponseBody
    public String addDoctorPost(@RequestParam("DOCTOR_NAME") String DOCTOR_NAME,@RequestParam("DOCTOR_PASSWORD") String DOCTOR_PASSWORD,
                                @RequestParam("DOCTOR_REALNAME") String DOCTOR_REALNAME,@RequestParam("DOCTOR_SEX") String DOCTOR_SEX,
                                @RequestParam("DOCTOR_PHONE") String DOCTOR_PHONE, @RequestParam("DOCTOR_WECHAT") String DOCTOR_WECHAT,
                                @RequestParam("DOCTOR_OFFICEID") String DOCTOR_OFFICEID, Model model){
        Doctor doctor = new Doctor();
        doctor.setDOCTOR_PASSWORD(DOCTOR_PASSWORD);
        doctor.setDOCTOR_NAME(DOCTOR_NAME);
        doctor.setDOCTOR_OFFICEID(Integer.valueOf(DOCTOR_OFFICEID));
        doctor.setDOCTOR_WECHAT(DOCTOR_WECHAT);
        doctor.setDOCTOR_PHONE(DOCTOR_PHONE);
        doctor.setDOCTOR_SEX(DOCTOR_SEX);
        doctor.setDOCTOR_REALNAME(DOCTOR_REALNAME);
        return String.valueOf(doctorRegisterServiceImpl.doctorRegister(doctor));
    }

    @Autowired
    DoctorDeleteService doctorDeleteServiceImpl;
    @GetMapping("/deleteDoctor/{DOCTOR_ID}")
    @ResponseBody
    public String deleteDoctor(@PathVariable("DOCTOR_ID") String USER_ID){
        if(doctorDeleteServiceImpl.doctorDelete(Integer.valueOf(USER_ID)) == 1){
            return "删除成功";
        }
        return "删除失败";
    }


    @PostMapping("/updateDoctor")
    @ResponseBody
    public String updateDoctor(@RequestParam("DOCTOR_NAME") String DOCTOR_NAME,@RequestParam("DOCTOR_PASSWORD") String DOCTOR_PASSWORD,
                               @RequestParam("DOCTOR_REALNAME") String DOCTOR_REALNAME,@RequestParam("DOCTOR_SEX") String DOCTOR_SEX,
                               @RequestParam("DOCTOR_PHONE") String DOCTOR_PHONE,@RequestParam("DOCTOR_OFFICEID") String DOCTOR_OFFICEID,
                               @RequestParam("DOCTOR_WECHAT") String DOCTOR_WECHAT,Model model){
        Doctor doctor = new Doctor();
        doctor.setDOCTOR_PASSWORD(DOCTOR_PASSWORD);
        doctor.setDOCTOR_NAME(DOCTOR_NAME);
        doctor.setDOCTOR_OFFICEID(Integer.valueOf(DOCTOR_OFFICEID));
        doctor.setDOCTOR_WECHAT(DOCTOR_WECHAT);
        doctor.setDOCTOR_PHONE(DOCTOR_PHONE);
        doctor.setDOCTOR_SEX(DOCTOR_SEX);
        doctor.setDOCTOR_REALNAME(DOCTOR_REALNAME);
        return String.valueOf(doctorUpdateServiceImpl.doctorUpdate(doctor));
    }

}
