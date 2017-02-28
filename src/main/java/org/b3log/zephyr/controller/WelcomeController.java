package org.b3log.zephyr.controller;

/**
 * Created by Zephyr on 2017/2/11.
 */

import org.b3log.zephyr.element.model.WelcomeListModel;
import org.b3log.zephyr.element.model.WelcomeTagModel;
import org.b3log.zephyr.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class WelcomeController {

    @Autowired
    WelcomeService welcomeService;


//    @Value("${application.message:Hello World}")
//    private String message = "Hello World";

    @GetMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        List<WelcomeListModel> welcomeList=welcomeService.getWelcomeList();
        List<WelcomeTagModel> welcomeTag=welcomeService.getWelcomeTag("test");
        model.put("welcomeList", welcomeList);
        model.put("welcomeTag",welcomeTag);
        return "welcome";
    }

    @PostMapping("/addMessage")
    public ModelAndView addText(WelcomeListModel wm){
        //使用github或QQ连接登录
        wm.setCreator("test");
        welcomeService.saveWelcomeListModel(wm);
        //使用观察者模式在其他地方通知更新
        List<WelcomeListModel> welcomeList=welcomeService.getWelcomeList();
        List<WelcomeTagModel> welcomeTag=welcomeService.getWelcomeTag(wm.getCreator());
        ModelAndView mv=new ModelAndView();
        mv.setViewName("welcome");
        mv.addObject("welcomeList",welcomeList);
        mv.addObject("welcomeTag",welcomeTag);
        return mv;
    }

    @GetMapping("/github")
    public void githubLogin(HttpServletRequest request){

    }
}