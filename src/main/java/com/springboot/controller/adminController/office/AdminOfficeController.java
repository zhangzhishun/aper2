package com.springboot.controller.adminController.office;

import com.springboot.domain.Doctor;
import com.springboot.domain.Office;
import com.springboot.service.doctor.DoctorDeleteService;
import com.springboot.service.doctor.DoctorGetService;
import com.springboot.service.doctor.DoctorRegisterService;
import com.springboot.service.doctor.DoctorUpdateService;
import com.springboot.service.office.OfficeDeleteService;
import com.springboot.service.office.OfficeUpdateService;
import com.springboot.service.office.impl.OfficeGetServiceImpl;
import com.springboot.service.office.impl.OfficeInsertServiceImpl;
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
public class AdminOfficeController {

    @Autowired
    OfficeGetServiceImpl officeGetServiceImpl;
    @GetMapping("/getAllOffice")
    public String getAllDoctor(Model model){
        List<Map<String, Object>> office = officeGetServiceImpl.getAllOffice();
        model.addAttribute("office",office);
        return "admin/office/getAllOffice";
    }

    @Autowired
    OfficeUpdateService officeUpdateServiceImpl;
    @GetMapping("/updateOffice/{OFFICE_ID}")
    public String updateOffice(@PathVariable("OFFICE_ID") String OFFICE_ID, Model model){
        List<Map<String,Object>> office = officeGetServiceImpl.getOfficeById(Integer.valueOf(OFFICE_ID));
        model.addAttribute("office",office);
        System.out.println(office);
        return "admin/office/updateOffice";
    }

    @GetMapping("/addOfficePage")
    public String addOfficePage(){
        return "admin/office/addOffice";
    }

    @Autowired
    OfficeInsertServiceImpl officeInsertServiceImpl;
    @PostMapping("/addOfficePost")
    @ResponseBody
    public String addOfficePost(@RequestParam("OFFICE_NAME") String OFFICE_NAME, Model model){
        Office office = new Office();
        office.setOFFICE_NAME(OFFICE_NAME);
        return String.valueOf(officeInsertServiceImpl.officeInsert(office));
    }

    @Autowired
    OfficeDeleteService officeDeleteServiceImpl;
    @GetMapping("/deleteOffice/{OFFICE_ID}")
    @ResponseBody
    public String deleteOffice(@PathVariable("OFFICE_ID") String OFFICE_ID){
        if(officeDeleteServiceImpl.officeDelete(Integer.valueOf(OFFICE_ID)) == 1){
            return "删除成功";
        }
        return "删除失败";
    }

    @PostMapping("/updateOffice")
    @ResponseBody
    public String updateOffice(@RequestParam("OFFICE_ID") String OFFICE_ID,@RequestParam("OFFICE_NAME") String OFFICE_NAME,Model model){
        Office office = new Office();
        office.setOFFICE_ID(Integer.valueOf(OFFICE_ID));
        office.setOFFICE_NAME(OFFICE_NAME);
        return String.valueOf(officeUpdateServiceImpl.updateOffice(office));
    }

}
