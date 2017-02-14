package org.b3log.zephyr.controller;

import org.b3log.zephyr.element.Test;
import org.b3log.zephyr.element.mapper.TestMapper;
import org.b3log.zephyr.element.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yaya on 17-2-12.
 */
@Controller
public class DataController {
    @Autowired
    private TestMapper testMapper;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value ="/data", method = RequestMethod.GET)
    @ResponseBody
    public String getData(){
        Test test=testMapper.findByOId("1486278412296");
        return test.toString();
    }

    @RequestMapping(value ="/add",Strin, method = RequestMethod.GET)
    @ResponseBody
    public String addData(){
       int count=userMapper.saveUser(System.currentTimeMillis()+"","Test");
        return "成功记录："+count+" 条";
    }
    @RequestMapping(value ="/delete", method = RequestMethod.GET)
    @ResponseBody
    public String deleteData(){
        Test test=testMapper.findByOId("1486278412296");
        return test.toString();
    }
    @RequestMapping(value ="/update", method = RequestMethod.GET)
    @ResponseBody
    public String updateData(){
        Test test=testMapper.findByOId("1486278412296");
        return test.toString();
    }
    @RequestMapping(value ="/select", method = RequestMethod.GET)
    @ResponseBody
    public String selectData(){
        Test test=testMapper.findByOId("1486278412296");
        return test.toString();
    }
}
