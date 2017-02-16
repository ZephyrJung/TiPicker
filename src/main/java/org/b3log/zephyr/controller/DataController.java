package org.b3log.zephyr.controller;

import org.b3log.zephyr.element.Test;
import org.b3log.zephyr.element.entity.UserLib;
import org.b3log.zephyr.element.mapper.TestMapper;
import org.b3log.zephyr.element.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    //这样写要求匹配路径中应当包含参数uanme，否则返回400
    @RequestMapping(value ="/add", method = RequestMethod.GET,params = "uname")
    @ResponseBody
    public String addData(String uname){
        if(null==uname||uname.equals("")){
            return null;
        }
        int count=userMapper.saveUser(System.currentTimeMillis()+"",uname);
        return "成功记录："+count+" 条";
    }

//    @Transactional
    @RequestMapping(value ="/addall", method = RequestMethod.GET)
    @ResponseBody
    public String addAllData(){
        userMapper.saveUser(System.currentTimeMillis()+"","test1");
        userMapper.saveUser(System.currentTimeMillis()+"","test2");
        userMapper.saveUser(System.currentTimeMillis()+"","test3");
        userMapper.saveUser(System.currentTimeMillis()+"","test4");
        userMapper.saveUser(System.currentTimeMillis()+"","test5");
        userMapper.saveUser(System.currentTimeMillis()+"","test6");
        userMapper.saveUser(System.currentTimeMillis()+"","test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7test7");
        userMapper.saveUser(System.currentTimeMillis()+"","test8");
        userMapper.saveUser(System.currentTimeMillis()+"","test9");
        userMapper.saveUser(System.currentTimeMillis()+"","test10");
        return "成功";
    }


    @RequestMapping(value ="/delete", method = RequestMethod.GET)
    @ResponseBody
    public String deleteData(String uname){
        int count=userMapper.deleteUser(uname);
        return "成功记录："+count+" 条";
    }
//    @RequestMapping(value ="/update", method = RequestMethod.GET)
//    @ResponseBody
//    public String updateData(){
//        Test test=testMapper.findByOId("1486278412296");
//        return test.toString();
//    }
    @RequestMapping(value ="/select", method = RequestMethod.GET)
    @ResponseBody
    public String selectData(){
        List<UserLib> userLibList=userMapper.findAllUsers();
        StringBuilder result=new StringBuilder("获得记录个数：");
        for(UserLib userLib:userLibList){
            result.append(userLib.getUserId()+":"+userLib.getUserName()+"\n");
        }
        return result.toString();
    }
}
