package org.b3log.zephyr.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wenchao.ren on 2014/4/26.
 */
@Controller
public class SimpleController {

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

}