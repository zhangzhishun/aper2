package com.springboot.controller.adminController.property;

import com.springboot.service.advice.AdviceDeleteService;
import com.springboot.service.advice.AdviceGetService;
import com.springboot.service.property.PropertyGetService;
import com.springboot.service.property.PropertyUpdateService;
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
public class AdminPropertyController {

    @Autowired
    PropertyGetService propertyGetServiceImpl;
    @GetMapping("/getFee")
    public String getAllAdvice(Model model){
        String fee = propertyGetServiceImpl.getPropertyByPROPERTYNAME("fee");
        model.addAttribute("fee",fee);
        return "admin/property/getFee";
    }

    @Autowired
    PropertyUpdateService propertyUpdateServiceImpl;
    @PostMapping("/updateFee")
    @ResponseBody
    public String updateAdvice(@RequestParam("newFee") String newFee, Model model){
        int result = propertyUpdateServiceImpl.updateKey("fee",newFee);
        return String.valueOf(result);
    }

}
