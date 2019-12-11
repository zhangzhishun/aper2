package com.springboot.controller.adminController.report_form;

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
public class AdminReportFormController {

    @Autowired
    ReportFormGetService reportFormGetServiceImpl;
    @GetMapping("/getAllReportForm")
    public String getAllReportForm(Model model){
        List<Map<String, Object>> reportForm = reportFormGetServiceImpl.getReportForm();
        model.addAttribute("reportForm",reportForm);
        return "admin/reportForm/getAllReportForm";
    }

    @GetMapping("/updateReportForm/{REPORTFORM_ID}")
    public String updateReportForm(@PathVariable("REPORTFORM_ID") String REPORTFORM_ID, Model model){
        List<Map<String, Object>> reportForm = reportFormGetServiceImpl.getReportFormByREPORTFORM_ID(Integer.valueOf(REPORTFORM_ID));
        model.addAttribute("reportForm",reportForm);
        System.out.println(reportForm);
        return "admin/reportForm/updateReportForm";
    }

    @Autowired
    ReportFormUpdateService reportFormUpdateServiceImpl;
    @PostMapping("/updateReportForm")
    @ResponseBody
    public String updateReportFormPost(@RequestParam("REPORTFORM_ID") String REPORTFORM_ID,@RequestParam("REPORTFORM_USERID") String REPORTFORM_USERID,
                                       @RequestParam("REPORTFORM_TITLE") String REPORTFORM_TITLE,@RequestParam("REPORTFORM_CONTENT") String REPORTFORM_CONTENT,
                                       @RequestParam("REPORTFORM_TIME") String REPORTFORM_TIME,@RequestParam("REPORTFORM_OFFICEID") String REPORTFORM_OFFICEID,
                                       @RequestParam("REPORTFORM_STATE") String REPORTFORM_STATE,@RequestParam("REPORTFORM_IMG") String REPORTFORM_IMG){
        ReportForm reportForm = new ReportForm();
        reportForm.setREPORTFORM_OFFICEID(Integer.valueOf(REPORTFORM_OFFICEID));
        reportForm.setREPORTFORM_USERID(Integer.valueOf(REPORTFORM_USERID));
        reportForm.setREPORTFORM_TITLE(REPORTFORM_TITLE);
        reportForm.setREPORTFORM_TIME(REPORTFORM_TIME);
        reportForm.setREPORTFORM_STATE(REPORTFORM_STATE);
        reportForm.setREPORTFORM_ID(Integer.valueOf(REPORTFORM_ID));
        reportForm.setREPORTFORM_CONTENT(REPORTFORM_CONTENT);
        reportForm.setREPORTFORM_IMG(REPORTFORM_IMG);
        return String.valueOf(reportFormUpdateServiceImpl.updateReportForm(reportForm));
    }

    @GetMapping("/addReportFormPage")
    public String addReportFormPage(){
        return "adminController/ReportForm/addReportForm";
    }

    @Autowired
    ReportFormInsertService reportFormInsertServiceImpl;
    @PostMapping("/addReportForm")
    @ResponseBody
    public String addReportForm(@RequestParam("REPORTFORM_USERID") String REPORTFORM_USERID,
                                @RequestParam("REPORTFORM_TITLE") String REPORTFORM_TITLE, @RequestParam("REPORTFORM_CONTENT") String REPORTFORM_CONTENT,
                                @RequestParam("REPORTFORM_TIME") String REPORTFORM_TIME, @RequestParam("REPORTFORM_OFFICEID") String REPORTFORM_OFFICEID,
                                @RequestParam("REPORTFORM_STATE") String REPORTFORM_STATE, @RequestParam("REPORTFORM_IMG") String REPORTFORM_IMG, Model model, String post){
        ReportForm reportForm = new ReportForm();
        reportForm.setREPORTFORM_OFFICEID(Integer.valueOf(REPORTFORM_OFFICEID));
        reportForm.setREPORTFORM_USERID(Integer.valueOf(REPORTFORM_USERID));
        reportForm.setREPORTFORM_TITLE(REPORTFORM_TITLE);
        reportForm.setREPORTFORM_TIME(REPORTFORM_TIME);
        reportForm.setREPORTFORM_STATE(REPORTFORM_STATE);
        reportForm.setREPORTFORM_CONTENT(REPORTFORM_CONTENT);
        reportForm.setREPORTFORM_IMG(REPORTFORM_IMG);
        boolean result = reportFormInsertServiceImpl.insertReportForm(reportForm);
        if(result){
            return "1";
        }
        return String.valueOf(result);
    }

    @Autowired
    ReportFormDeleteService reportFormDeleteServiceImpl;
    @GetMapping("/deleteReportForm/{REPORTFORM_ID}")
    @ResponseBody
    public String deleteReportForm(@PathVariable("REPORTFORM_ID") String REPORTFORM_ID){
        if(reportFormDeleteServiceImpl.reportFormDelete(Integer.valueOf(REPORTFORM_ID)) == 1){
            return "删除成功";
        }
        return "删除失败";
    }


}
