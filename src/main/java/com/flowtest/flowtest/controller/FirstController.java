package com.flowtest.flowtest.controller;

import com.flowtest.flowtest.service.FirstService;
import com.flowtest.flowtest.vo.extension;
import com.flowtest.flowtest.vo.set_extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FirstController {

    @Autowired
    FirstService firstService;

    @RequestMapping(value = "/home")
    public String home(Model model){
        System.out.println(firstService.selectAllSetExt());
        model.addAttribute("setext", firstService.selectAllSetExt());
        model.addAttribute("ext", firstService.selectExt());
        return "/test";
    }

    // 고정 확장자
    @PostMapping(value = "/saveset")
    public String saveset(@RequestParam("result") int checked){
       // false 일시
        if(!firstService.selectSetExt(checked)){
            firstService.updateSetExt_1(checked);
        } else{
            firstService.updateSetExt_0(checked);
        }
        return "test";
    }

    // 커스텀 확장자
    @PostMapping(value = "/save")
    public String save(@RequestParam("result") String input){
        //Map<String, String> update = new HashMap<>();

        // false 일시
        extension extension = new extension();
        extension.setExtension_name(input);
        firstService.insertExt(extension);
        return "test";
    }

    //커스텀 확정자 삭제
    @GetMapping(value = "/del")
    public String del(@RequestParam("num") int num){

        firstService.delExt(num);
        return "test";
    }

}
