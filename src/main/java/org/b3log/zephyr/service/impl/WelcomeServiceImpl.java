package org.b3log.zephyr.service.impl;

import org.b3log.zephyr.element.entity.MessageLib;
import org.b3log.zephyr.element.entity.TagLib;
import org.b3log.zephyr.mapper.MessageMapper;
import org.b3log.zephyr.mapper.TagMapper;
import org.b3log.zephyr.element.model.WelcomeModel;
import org.b3log.zephyr.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by yaya on 17-2-27.
 */
@Service
public class WelcomeServiceImpl implements WelcomeService{
    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<WelcomeModel> getWelcomeList() {
        List<WelcomeModel> welcomeList=new ArrayList<WelcomeModel>();
        List<MessageLib> messageLibs=messageMapper.findAllMessages();
        for(MessageLib ml:messageLibs){
            WelcomeModel wm=new WelcomeModel();
            TagLib tagLib=tagMapper.findByTagId(ml.getTag_id());
            wm.setMessage(ml.getContent());
            wm.setCreateTime(ml.getCreate_time());
            wm.setCreator(ml.getCreator());
            wm.setTag(tagLib.getTag_name());
            welcomeList.add(wm);
        }
        return welcomeList;
    }

    @Override
    @Transactional
    public void saveWelcomeModel(WelcomeModel wm) {
        Long mid=System.currentTimeMillis();
        String tid;
        TagLib tagLib=tagMapper.findByTagName(wm.getTag());
        Date createTime= Calendar.getInstance().getTime();
        Date updateTime=Calendar.getInstance().getTime();

        if(null==tagLib || tagLib.equals("")){
            tid =System.currentTimeMillis()+"";
            tagMapper.saveTag(tid.toString(),wm.getTag(),"test","test",wm.getCreator(),createTime);
        }else{
            tid=tagLib.getTag_id();
        }

        messageMapper.saveMessage(mid.toString(),tid.toString(),wm.getMessage(),wm.getCreator(),updateTime,createTime);
    }
}
