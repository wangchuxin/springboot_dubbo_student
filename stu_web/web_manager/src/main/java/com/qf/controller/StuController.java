package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Student;
import com.qf.service.IClsService;
import com.qf.service.IStuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/stu")
public class StuController {

    @Reference
    private IStuService stuService;

    @Reference
    private IClsService clsService;

    @RequestMapping("/getindex")
    public  String getIndex(){
        return "index";
    }

    @RequestMapping("/list")
    public String list(Model model){
        List<Student> list =stuService.list();
        model.addAttribute("stus",list);
        return "stulist";
    }
    @RequestMapping("/toadd")
    public String toadd(){
        return "addstu";
    }

    @RequestMapping("/add")
    public String addstu(Student student){
        System.out.println(student);
        stuService.addStu(student);
        clsService.updateNum(student.getCid());
        return "redirect:/stu/list";
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        Student student = stuService.queryById(id);
        stuService.deleteStu(id);
        clsService.delnum(student.getCid());
        return "redirect:/stu/list";
    }

    @RequestMapping("/toupdate")
    public String toupdate(Integer id,Model model){
        Student student=stuService.queryById(id);
        model.addAttribute("stu",student);
        return "updatestu";
    }

    @RequestMapping("/update")
    public String update(Student student){
        stuService.updateStu(student);
        return "redirect:/stu/list";
    }
}
