package com.springboot.controller.doctorController;

import com.springboot.domain.*;
import com.springboot.service.doctor.DoctorGetService;
import com.springboot.service.doctor.DoctorHandleReportFormService;
import com.springboot.service.doctor.DoctorUpdateService;
import com.springboot.service.office.OfficeGetService;
import com.springboot.service.reply.ReplyDeleteService;
import com.springboot.service.reply.ReplyGetService;
import com.springboot.service.reply.ReplyInsertService;
import com.springboot.service.reportform.ReportFormGetService;
import com.springboot.service.reportform.ReportFormInsertService;
import com.springboot.service.reportform.ReportFormUpdateService;
import com.springboot.service.user.UserReadMsgService;
import com.springboot.service.user.UserSubmitAdviceService;
import com.springboot.service.user.UserUpdateService;
import com.springboot.service.user.impl.UserGetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Controller
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    ReplyGetService replyGetServiceImpl;
    @Autowired
    ReportFormInsertService reportFormInsertServiceImpl;
    @Autowired
    OfficeGetService officeGetServiceImpl;
    @Autowired
    DoctorHandleReportFormService doctorHandleReportFormServiceImpl;

    @GetMapping("/toAskVisit")
    public String toAskVisit(Model model){
        model.addAttribute("officeList",officeGetServiceImpl.getAllOffice());
        return "doctor/askVisit";
    }

    /**
     * 返回具体的某一个医生的回复
     * */
    @GetMapping("/getREPLYByID/{REPLY_ID}")
    public String getREPLYByID(@PathVariable("REPLY_ID") String REPLY_ID, Model model){
        List<Map<String,Object>> reply = replyGetServiceImpl.getReplyByREPLYID(REPLY_ID);
        model.addAttribute("reply",reply);
        return "doctor/scanReply";
    }

    @Autowired
    ReplyDeleteService replyDeleteServiceImpl;
    /**
     * 删除具体的某一个医生的回复
     * */
    @PostMapping("/deleteREPLYByID")
    @ResponseBody
    public String deleteREPLYByID(@RequestParam("REPLY_ID") String REPLY_ID){
        if(replyDeleteServiceImpl.replyDelete(Integer.valueOf(REPLY_ID)) == 1){
            return "1";
        }
        return "0";
    }


    @Autowired
    ReportFormGetService reportFormGetServiceImpl;

    /**
     * 返回具体的某一个医生的回复
     * */
    @GetMapping("/getREPORTFORM/{REPORTFORM_ID}")
    public String getREPORTFORM(@PathVariable("REPORTFORM_ID") String REPORTFORM_ID, Model model){
        //System.out.println(REPLY_ID);
        List<Map<String,Object>> reportform = reportFormGetServiceImpl.getReportFormByREPORTFORM_ID(Integer.valueOf(REPORTFORM_ID));
        List<String> imgs = new ArrayList<>();
        for (Map<String,Object>map:reportform
             ) {
            String[] getImgs = map.get("REPORTFORM_IMG").toString().split(";");
            for (String s:getImgs
                 ) {
                imgs.add(s);
            }
        }
        model.addAttribute("reportFormImgs",imgs);
        model.addAttribute("reportForm",reportform);
        return "doctor/scanReportForm";
    }

    @Autowired
    ReplyInsertService replyInsertServiceImpl;
    @Autowired
    ReportFormUpdateService reportFormUpdateServiceImpl;
    @PostMapping("/addReply")
    @ResponseBody
    public String addReportForm(@RequestParam("REPLY_CONTENT") String REPLY_CONTENT, @RequestParam("REPLY_REPOTFORMID") String REPLY_REPOTFORMID,
                                HttpSession httpSession){
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        Reply reply = new Reply();
        reply.setREPLY_TIME(ft.format(new Date()));
        reply.setREPLY_DOCTORID(Integer.valueOf(httpSession.getAttribute("doctorId").toString()));
        reply.setREPLY_CONTENT(REPLY_CONTENT);
        reply.setREPLY_REPOTFORMID(Integer.valueOf(REPLY_REPOTFORMID));
        reply.setREPLY_STATE("0");
        reportFormUpdateServiceImpl.updateReportFormState(Integer.valueOf(REPLY_REPOTFORMID),1);
        return String.valueOf(replyInsertServiceImpl.insertReply(reply));
    }


    @Autowired
    UserSubmitAdviceService userSubmitAdviceServiceImpl;
    @Autowired
    UserGetServiceImpl userGetServiceImpl;
    /** 反馈GET处理 */
    @RequestMapping("/advice")
    public String ADVICE(){
        return "doctor/advice";
    }

    /** 反馈POST处理 */
    @PostMapping("/adviceSubmit")
    @ResponseBody
    public String ADVICESubmit(@RequestParam("ADVICE_TITLE")String ADVICE_TITLE,@RequestParam("ADVICE_CONTENT")String ADVICE_CONTENT,HttpSession session){
        Advice advice = new Advice();
        advice.setADVICE_CONTENT(ADVICE_CONTENT);
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        advice.setADVICE_TIME(ft.format(new Date()));
        advice.setADVICE_TITLE("Doctor:" + ADVICE_TITLE);
        advice.setUSER_ID(doctorGetServiceImpl.getDoctorByDOCTORNAME(session.getAttribute("doctorName").toString()).getDOCTOR_ID());
        int result = userSubmitAdviceServiceImpl.insertADVICE(advice);
        return String.valueOf(result);
    }

    @Autowired
    DoctorGetService doctorGetServiceImpl;

    /** 更改用户信息 */
    @RequestMapping("/updateDoctor")
    public String updateDoctor(Model model,HttpSession httpSession){
        Doctor doctor = doctorGetServiceImpl.getDoctorByDOCTORNAME(httpSession.getAttribute("doctorName").toString());
        System.out.println(doctor.toString());
        model.addAttribute("officeList",officeGetServiceImpl.getAllOffice());
        model.addAttribute("doctor",doctor);
        return "doctor/updateDoctor";
    }

    @Autowired
    DoctorUpdateService doctorUpdateServiceImpl;
    @PostMapping("/updateDoctorPost")
    @ResponseBody
    public String updateDoctorPost(@RequestParam("DOCTOR_NAME")String DOCTOR_NAME, @RequestParam("DOCTOR_PASSWORD")String DOCTOR_PASSWORD,
                                   @RequestParam("DOCTOR_SEX")String DOCTOR_SEX, @RequestParam("DOCTOR_PHONE")String DOCTOR_PHONE,
                                   @RequestParam("DOCTOR_WECHAT")String DOCTOR_WECHAT,@RequestParam("DOCTOR_OFFICEID")String DOCTOR_OFFICEID,
                                   @RequestParam("DOCTOR_REALNAME")String DOCTOR_REALNAME){
        Doctor doctor = new Doctor();
        doctor.setDOCTOR_NAME(DOCTOR_NAME);
        doctor.setDOCTOR_REALNAME(DOCTOR_REALNAME);
        doctor.setDOCTOR_SEX(DOCTOR_SEX);
        doctor.setDOCTOR_PHONE(DOCTOR_PHONE);
        doctor.setDOCTOR_WECHAT(DOCTOR_WECHAT);
        doctor.setDOCTOR_OFFICEID(Integer.valueOf(DOCTOR_OFFICEID));
        doctor.setDOCTOR_PASSWORD(DOCTOR_PASSWORD);
        int result = doctorUpdateServiceImpl.doctorUpdate(doctor);
        return String.valueOf(result);
    }

}
