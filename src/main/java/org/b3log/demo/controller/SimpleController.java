package org.b3log.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

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