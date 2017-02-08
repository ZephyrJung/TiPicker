package org.b3log.zephyr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wenchao.ren on 2014/4/26.
 */
@Controller
public class SimpleController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value ="/", method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "hello index";
    }

    @RequestMapping(value ="/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "hello world";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testLogLevel() {
        logger.debug("Logger Level ：DEBUG");
        logger.info("Logger Level ：INFO");
        logger.error("Logger Level ：ERROR");
        return "";
    }
}