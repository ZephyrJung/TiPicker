package org.b3log.zephyr.controller;

import org.b3log.zephyr.element.Test;
import org.b3log.zephyr.element.mapper.TestMapper;
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

    @RequestMapping(value ="/data", method = RequestMethod.GET)
    @ResponseBody
    public String getData(){
        Test test=testMapper.findByOId("1486278412296");
        return test.toString();
    }
}
