package com.jpa.demo.controller;

import com.jpa.demo.pojo.People;
import com.jpa.demo.services.PeopleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;



/**
 * @Topic
 * @Date 2021/07/22 13:41
 */

@Controller
public class PeopleController {


    @Resource
    PeopleService peopleService;

    @GetMapping("/all")
    public String queryAll(Model model){
        List<People> peopleList = peopleService.selectAll();
        model.addAttribute("list",peopleList);
        return "all";
    }

    @RequestMapping(value = "/query/{id}")
    @ResponseBody
    public People queryById(@PathVariable Integer id){
        People people = peopleService.selectById(id);
        return people;
    }

    @RequestMapping(value = "/addPage")
    public String add(){
        return "addPage";
    }

    @RequestMapping(value = "/add")
    public String AddPeople(People people){
        peopleService.addNew(people);
        return "redirect:/all";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable Integer id){
        peopleService.deleteById(id);
        return "redirect:/all";
    }

    @GetMapping("/updatePage/{id}")
    public String updatePage(Model model ,@PathVariable Integer id){
        model.addAttribute("people",peopleService.selectById(id));
        return "updatePage";
    }

    @RequestMapping(value = "/update")
    public String updateMsg(People people) {
        peopleService.update(people);
        return "redirect:/all";
    }
}
