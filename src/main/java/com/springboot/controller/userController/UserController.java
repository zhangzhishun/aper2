package com.springboot.controller.userController;

import com.springboot.domain.*;
import com.springboot.service.doctor.DoctorGetService;
import com.springboot.service.doctor.DoctorLoginAuthService;
import com.springboot.service.doctor.DoctorUpdateService;
import com.springboot.service.office.OfficeGetService;
import com.springboot.service.reply.ReplyGetService;
import com.springboot.service.reportform.ReportFormGetService;
import com.springboot.service.reportform.ReportFormInsertService;
import com.springboot.service.user.UserLoginAuthService;
import com.springboot.service.user.UserReadMsgService;
import com.springboot.service.user.UserSubmitAdviceService;
import com.springboot.service.user.UserUpdateService;
import com.springboot.service.user.impl.UserGetServiceImpl;
import org.omg.CORBA.ObjectHelper;
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
import java.util.*;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserLoginAuthService userLoginAuthServiceImpl;
    @Autowired
    ReplyGetService replyGetServiceImpl;
    @Autowired
    ReportFormInsertService reportFormInsertServiceImpl;
    @Autowired
    OfficeGetService officeGetServiceImpl;


    @GetMapping("/toAskVisit")
    public String toAskVisit(Model model){
        model.addAttribute("officeList",officeGetServiceImpl.getAllOffice());
        return "user/askVisit";
    }

    /**
     * 返回具体的某一个医生的回复
     * */
    @GetMapping("/getREPLYID/{REPLY_ID}")
    public String getREPLYID(@PathVariable("REPLY_ID") String REPLY_ID, Model model){
        //System.out.println(REPLY_ID);
        List<Map<String,Object>> result = replyGetServiceImpl.getReplyByREPLYID(REPLY_ID);
        List<String> imgs = new ArrayList<>();
        model.addAttribute("userMsg",result);
        return "user/scanMsg";
    }

    @Autowired
    ReportFormGetService reportFormGetServiceImpl;

    /**
     * 返回具体的某一个咨询
     * */
    @GetMapping("/getREPORTFORM/{REPORTFORM_ID}")
    public String getREPORTFORM(@PathVariable("REPORTFORM_ID") String REPORTFORM_ID, Model model){
        //System.out.println(REPLY_ID);
        List<Map<String,Object>> result = reportFormGetServiceImpl.getReportFormByREPORTFORM_ID(Integer.valueOf(REPORTFORM_ID));
        List<String> imgs = new ArrayList<>();
        for (Map<String,Object>map:result
             ) {
            String[] getImgs = map.get("REPORTFORM_IMG").toString().split(";");
            for (String s:getImgs
                 ) {
                imgs.add(s);
            }
        }
        model.addAttribute("reportFormImgs",imgs);
        model.addAttribute("reportForm",result);
        return "user/scanReportForm";
    }

    @PostMapping("/uploadAsk")
    @ResponseBody
    public String uploadAsk(@RequestParam("title") String title, @RequestParam("content") String content,@RequestParam("office") String office, HttpServletRequest request,HttpSession session){
        System.out.println(title + " " + content);
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        List<String> fileNames = new ArrayList<>();
        SimpleDateFormat ftName = new SimpleDateFormat ("YYYYMMddHHmmss");
        int random = (int)((Math.random() * 9 + 1) * 10);
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            /** 文件格式：年月日时分秒+毫秒+两位随机数+序号+后缀名 */
            String fileNameTemp = ftName.format(new Date())+ random +i+suffixName;
            fileNames.add(fileNameTemp);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File("E:\\file\\study\\Java\\aperReconsitution\\src\\main\\resources\\static\\img\\reportForm\\" +fileNameTemp)));
                    //stream = new BufferedOutputStream(new FileOutputStream(new File("F:\\file\\study\\idea\\JavaWeb\\APER2019\\src\\main\\resources\\static\\img\\reportForm\\" +fileNameTemp)));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return e.getMessage();
                }
            } else {
                return "You failed to upload " + i + " because the file was empty.";
            }
        }
        String REPORTFORM_IMG = fileNames.get(0);
        for (int i = 1; i < files.size(); ++i) {
            REPORTFORM_IMG = REPORTFORM_IMG + ";" + fileNames.get(i);
        }
        System.out.println(REPORTFORM_IMG);

        /** 组装成ReportForm对象 */
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        ReportForm reportForm = new ReportForm();
        reportForm.setREPORTFORM_OFFICEID(officeGetServiceImpl.getOfficeIdByName(office));
        reportForm.setREPORTFORM_IMG(REPORTFORM_IMG);
        reportForm.setREPORTFORM_CONTENT(content);
        reportForm.setREPORTFORM_STATE("0");
        reportForm.setREPORTFORM_TIME(ft.format(new Date()));
        reportForm.setREPORTFORM_TITLE(title);
        reportForm.setREPORTFORM_USERID(userGetServiceImpl.getIdByName(session.getAttribute("username").toString()));
        reportFormInsertServiceImpl.insertReportForm(reportForm);
        return "上传成功！请返回";
    }


    @Autowired
    UserSubmitAdviceService userSubmitAdviceServiceImpl;
    @Autowired
    UserGetServiceImpl userGetServiceImpl;
    /** 反馈GET处理 */
    @RequestMapping("/advice")
    public String ADVICE(){
        return "user/advice";
    }

    /** 反馈POST处理 */
    @PostMapping("/adviceSubmit")
    @ResponseBody
    public String ADVICESubmit(@RequestParam("ADVICE_TITLE")String ADVICE_TITLE,@RequestParam("ADVICE_CONTENT")String ADVICE_CONTENT,HttpSession session){
        Advice advice = new Advice();
        advice.setADVICE_CONTENT(ADVICE_CONTENT);
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        advice.setADVICE_TIME(ft.format(new Date()));
        advice.setADVICE_TITLE("User:" + ADVICE_TITLE);
        advice.setUSER_ID(userGetServiceImpl.getIdByName(session.getAttribute("username").toString()));
        int result = userSubmitAdviceServiceImpl.insertADVICE(advice);
        return String.valueOf(result);
    }


    @Autowired
    UserUpdateService userUpdateServiceImpl;

    /** 更改用户信息 */
    @RequestMapping("/updateUser")
    public String updateUser(Model model,HttpSession httpSession){
        User user = userGetServiceImpl.getUserByName(httpSession.getAttribute("username").toString());
        System.out.println(user.toString());
        model.addAttribute("user",user);
        return "user/updateUser";
    }

    @PostMapping("/updateUserPost")
    @ResponseBody
    public String updateUserPost(@RequestParam("USER_NAME")String USER_NAME,@RequestParam("USER_PASSWORD")String USER_PASSWORD,
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
        int result = userUpdateServiceImpl.userUpdate(user);
        return String.valueOf(result);
    }

    @Autowired
    UserReadMsgService userReadMsgServiceImpl;
    /**
     *  用户点击“我已知晓”
     *  更改咨询单状态为已阅读[1] */
    @PostMapping("/updateReplyState")
    @ResponseBody
    public String updateReplyState(@RequestParam("REPLY_ID") String REPLY_ID){
        System.out.println(REPLY_ID);
        return String.valueOf(userReadMsgServiceImpl.userReadMsg(REPLY_ID));
    }

}
