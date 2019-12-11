package com.springboot.controller.adminController.reply;

import com.springboot.domain.*;
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
public class AdminReplyController {

    @Autowired
    ReplyGetService replyGetServiceImpl;
    @GetMapping("/getAllReply")
    public String getAllReply(Model model){
        List<Map<String, Object>> reply = replyGetServiceImpl.getAllReply();
        model.addAttribute("reply",reply);
        return "admin/reply/getAllReply";
    }

    @GetMapping("/updateReply/{REPLY_ID}")
    public String updateReply(@PathVariable("REPLY_ID") String REPLY_ID, Model model){
        List<Map<String, Object>> reply = replyGetServiceImpl.getReplyByREPLYID(REPLY_ID);
        System.out.println(reply);
        model.addAttribute("reply",reply);
        return "admin/reply/updateReply";
    }

    @Autowired
    ReplyUpdateService replyUpdateServiceImpl;
    @PostMapping("/updateReply")
    @ResponseBody
    public String updateReply(@RequestParam("REPLY_ID") String REPLY_ID,@RequestParam("REPLY_REPOTFORMID") String REPLY_REPOTFORMID,
                              @RequestParam("REPLY_DOCTORID") String REPLY_DOCTORID, @RequestParam("REPLY_CONTENT") String REPLY_CONTENT,
                              @RequestParam("REPLY_TIME") String REPLY_TIME, @RequestParam("REPLY_IMG") String REPLY_IMG,
                              @RequestParam("REPLY_STATE") String REPLY_STATE){
        Reply reply = new Reply();
        reply.setREPLY_ID(Integer.valueOf(REPLY_ID));
        reply.setREPLY_IMG(REPLY_IMG);
        reply.setREPLY_TIME(REPLY_TIME);
        reply.setREPLY_DOCTORID(Integer.valueOf(REPLY_DOCTORID));
        reply.setREPLY_CONTENT(REPLY_IMG);
        reply.setREPLY_REPOTFORMID(Integer.valueOf(REPLY_REPOTFORMID));
        reply.setREPLY_STATE(REPLY_STATE);
        return String.valueOf(replyUpdateServiceImpl.updateReply(reply));
    }

    @GetMapping("/addReply")
    public String addReplyPage(){
        return "admin/reply/addReply";
    }

    @Autowired
    ReplyInsertService replyInsertServiceImpl;
    @PostMapping("/addReply")
    @ResponseBody
    public String addReportForm(@RequestParam("REPLY_REPOTFORMID") String REPLY_REPOTFORMID,
                                @RequestParam("REPLY_DOCTORID") String REPLY_DOCTORID, @RequestParam("REPLY_CONTENT") String REPLY_CONTENT,
                                @RequestParam("REPLY_TIME") String REPLY_TIME, @RequestParam("REPLY_IMG") String REPLY_IMG,
                                @RequestParam("REPLY_STATE") String REPLY_STATE){
        Reply reply = new Reply();
        reply.setREPLY_IMG(REPLY_IMG);
        reply.setREPLY_TIME(REPLY_TIME);
        reply.setREPLY_DOCTORID(Integer.valueOf(REPLY_DOCTORID));
        reply.setREPLY_CONTENT(REPLY_IMG);
        reply.setREPLY_REPOTFORMID(Integer.valueOf(REPLY_REPOTFORMID));
        reply.setREPLY_STATE(REPLY_STATE);
        return String.valueOf(replyInsertServiceImpl.insertReply(reply));
    }

    @Autowired
    ReplyDeleteService replyDeleteServiceImpl;
    @GetMapping("/deleteReply/{REPLY_ID}")
    @ResponseBody
    public String deleteReply(@PathVariable("REPLY_ID") String REPLY_ID){
        if(replyDeleteServiceImpl.replyDelete(Integer.valueOf(REPLY_ID)) == 1){
            return "删除成功";
        }
        return "删除失败";
    }

}
