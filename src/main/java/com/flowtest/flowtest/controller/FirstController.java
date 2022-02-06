package com.flowtest.flowtest.controller;

import com.flowtest.flowtest.service.FirstService;
import com.flowtest.flowtest.vo.extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;

@Controller
public class FirstController {

    @Autowired
    FirstService firstService;

    String[] setExtList = new String[] {"bat", "cmd", "com", "cpl", "exe", "scr", "js"};

    @RequestMapping(value = "/home")
    public String home(Model model){
        model.addAttribute("setext", firstService.selectAllSetExt());
        model.addAttribute("ext", firstService.selectAllExt());
        return "home";
    }

    // 고정 확장자
    @RequestMapping(value = "/savecheck", method=RequestMethod.POST)
    public String saveset(@RequestParam("checked") int checked){
       // checkBox false 일시
        if(!firstService.selectSetExt(checked)){
            firstService.updateSetExt_1(checked);
        } else{
            firstService.updateSetExt_0(checked);
        }
        return "home";
    }

    // 커스텀 확장자 저장
    @RequestMapping(value = "/save", method=RequestMethod.POST)
    public @ResponseBody int save(@RequestParam("result") String input){
        //고정 확장자 check
        if(Arrays.asList(setExtList).contains(input)){
            return -3;
        }
        // 길이 check
        if(input.length()>20){
            return -2;
        }
        //DB에 이미 존재하는 커스텀 확장자
        if(firstService.selectExt(input) > 0){
            HashMap<String, Object> map = firstService.selectDelExt(input);
            if((Boolean)map.get("extension_del")){
                firstService.updateExt_0((Integer)map.get("extension_num"));
            }else{
                return -1; // 중복된 확장자
            }
        }else {
            //DB에 존재하지 않는 커스텀 확장자
            extension extension = new extension();
            extension.setExtension_name(input);
            firstService.insertExt(extension);
        }
        // 커스텀 확장자 추가 완료
        return firstService.selectExtNum(input);
    }

    //커스텀 확정자 삭제
    @RequestMapping(value = "/delext", method=RequestMethod.POST)
    public String delExt(@RequestParam("num") int num){
        firstService.updateExt_1(num);
        return "home";
    }

    //커스텀 확정자 삭제
    @RequestMapping(value = "/delallext", method=RequestMethod.POST)
    public String delAllExt(){
        firstService.updateAllExt_1();
        return "home";
    }

}
