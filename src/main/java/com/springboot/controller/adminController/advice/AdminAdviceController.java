package com.springboot.controller.adminController.advice;

import com.springboot.domain.Advice;
import com.springboot.domain.Reply;
import com.springboot.service.admin.AdminGetService;
import com.springboot.service.advice.AdviceDeleteService;
import com.springboot.service.advice.AdviceGetService;
import com.springboot.service.advice.impl.AdviceDeleteServiceImpl;
import com.springboot.service.reply.ReplyDeleteService;
import com.springboot.service.reply.ReplyGetService;
import com.springboot.service.reply.ReplyInsertService;
import com.springboot.service.reply.ReplyUpdateService;
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
public class AdminAdviceController {

    @Autowired
    AdviceGetService adviceGetServiceImpl;
    @GetMapping("/getAllAdvice")
    public String getAllAdvice(Model model){
        List<Map<String, Object>> advice = adviceGetServiceImpl.getAllAdvice();
        model.addAttribute("advice",advice);
        return "admin/advice/getAllAdvice";
    }

    @GetMapping("/updateAdvice/{ADVICE_ID}")
    public String updateAdvice(@PathVariable("ADVICE_ID") String ADVICE_ID, Model model){
        List<Map<String, Object>> advice = adviceGetServiceImpl.getAdviceByADVICEID(ADVICE_ID);
        System.out.println(advice);
        model.addAttribute("advice",advice);
        return "admin/advice/updateAdvice";
    }


    @Autowired
    AdviceDeleteService adviceDeleteServiceImpl;
    @GetMapping("/deleteAdvice/{ADVICE_ID}")
    @ResponseBody
    public String deleteAdvice(@PathVariable("ADVICE_ID") String ADVICE_ID){
        if(adviceDeleteServiceImpl.deleteAdvice(Integer.valueOf(ADVICE_ID)) == 1){
            return "删除成功";
        }
        return "删除失败";
    }

}
