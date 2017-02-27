package org.b3log.zephyr.controller;

/**
 * Created by Zephyr on 2017/2/11.
 */

import org.b3log.zephyr.element.entity.MessageLib;
import org.b3log.zephyr.element.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
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
    MessageMapper messageMapper;

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @GetMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        List<MessageLib> messageLibList=messageMapper.findAllMessages();
        model.put("messageLibList", messageLibList);
        return "welcome";
    }

    @PostMapping("/addMessage")
    public ModelAndView addText(String message){
        Long mid=System.currentTimeMillis();
        Long tid =System.currentTimeMillis();
        //使用github或QQ连接登录
        String creator="test";
        Date createTime=Calendar.getInstance().getTime();
        Date updateTime=Calendar.getInstance().getTime();
        messageMapper.saveMessage(mid.toString(),tid.toString(),message,creator,updateTime,createTime);
        //使用观察者模式在其他地方通知更新
        List<MessageLib> messageLibList=messageMapper.findAllMessages();
        ModelAndView mv=new ModelAndView();
        mv.setViewName("welcome");
        mv.addObject("messageLibList",messageLibList);
        return mv;
    }

    @GetMapping("/github")
    public void githubLogin(HttpServletRequest request){

    }
}