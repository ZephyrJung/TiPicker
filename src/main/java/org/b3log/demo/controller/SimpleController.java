package org.b3log.demo.controller;

import org.b3log.zephyr.element.model.WelcomeListModel;
import org.b3log.zephyr.element.model.WelcomeTagModel;
import org.b3log.zephyr.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by wenchao.ren on 2014/4/26.
 */
@Controller
public class SimpleController {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    MailService mailService;

//    @RequestMapping(value ="/", method = RequestMethod.GET)
//    @ResponseBody
//    public String index(){
//        return "hello index";
//    }
//
//    @RequestMapping(value ="/hello", method = RequestMethod.GET)
//    @ResponseBody
//    public String hello(){
//        return "hello world";
//    }

//    @RequestMapping(value ="/mail", method = RequestMethod.GET)
//    @ResponseBody
//    public String sendMail(){
//        try {
//            mailService.sendSimpleMail();
//            return "send mail success";
//        } catch (Exception e) {
//            return "send mail error";
//        }
//    }

//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public String testLogLevel() {
//        logger.debug("Logger Level ：DEBUG");
//        logger.info("Logger Level ：INFO");
//        logger.error("Logger Level ：ERROR");
//        return "";
//    }

//    @GetMapping("/websocket")
//    public String websocket() {
//        return "ws";
//    }
}