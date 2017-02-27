package org.b3log.zephyr.controller;

/**
 * Created by Zephyr on 2017/2/11.
 */

import org.b3log.zephyr.element.entity.MessageLib;
import org.b3log.zephyr.element.entity.TagLib;
import org.b3log.zephyr.element.mapper.MessageMapper;
import org.b3log.zephyr.element.mapper.TagMapper;
import org.b3log.zephyr.element.model.WelcomeModel;
import org.b3log.zephyr.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class WelcomeController {

    @Autowired
    WelcomeService welcomeService;


    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @GetMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        List<WelcomeModel> welcomeList=welcomeService.getWelcomeList();
        model.put("welcomeList", welcomeList);
        return "welcome";
    }

    @PostMapping("/addMessage")
    public ModelAndView addText(WelcomeModel wm){
        //使用github或QQ连接登录
        wm.setCreator("test");
        welcomeService.saveWelcomeModel(wm);
        //使用观察者模式在其他地方通知更新
        List<WelcomeModel> welcomeList=welcomeService.getWelcomeList();
        ModelAndView mv=new ModelAndView();
        mv.setViewName("welcome");
        mv.addObject("welcomeList",welcomeList);
        return mv;
    }

    @GetMapping("/github")
    public void githubLogin(HttpServletRequest request){

    }
}