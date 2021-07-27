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

    /**
     * 向controller中注入Service
     */
    @Resource
    PeopleService peopleService;

    /**
     * 返回相关表中所有数据并跳转到主页
     */
    @GetMapping("/all")
    public String queryAll(Model model){
        List<People> peopleList = peopleService.selectAll();
        model.addAttribute("list",peopleList);
        return "all";
    }

    /**
     * 根据传入id进行查询，返回json数据
     */
    @RequestMapping(value = "/query/{id}")
    @ResponseBody
    public People queryById(@PathVariable Integer id){
        People people = peopleService.selectById(id);
        return people;
    }

    /**
     * 跳转到addPage页面
     */
    @RequestMapping(value = "/addPage")
    public String add(){
        return "addPage";
    }

    /**
     * 添加信息并重定向到all页面
     */
    @RequestMapping(value = "/add")
    public String AddPeople(People people){
        peopleService.addNew(people);
        return "redirect:/all";
    }
    /**
     * 根据id删除信息并重定向到all页面
     */
    @GetMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable Integer id){
        peopleService.deleteById(id);
        return "redirect:/all";
    }
    /**
     * 根据id更新信息并到updatePage页面
     */
    @GetMapping("/updatePage/{id}")
    public String updatePage(Model model ,@PathVariable Integer id){
        model.addAttribute("people",peopleService.selectById(id));
        return "updatePage";
    }
    /**
     * 更新信息并重定向到all页面
     */
    @RequestMapping(value = "/update")
    public String updateMsg(People people) {
        peopleService.update(people);
        return "redirect:/all";
    }
}
