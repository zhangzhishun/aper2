package com.springboot.controller.pubController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Controller
public class publicController {

    @GetMapping("/about")
    public String about(){
        return "public/about";
    }

    @GetMapping("/exit")
    public String exit(){
        return "login";
    }

}
