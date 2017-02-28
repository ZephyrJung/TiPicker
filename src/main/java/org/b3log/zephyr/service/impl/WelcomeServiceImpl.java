package org.b3log.zephyr.service.impl;

import org.b3log.zephyr.element.entity.MessageLib;
import org.b3log.zephyr.element.entity.TagLib;
import org.b3log.zephyr.element.model.WelcomeTagModel;
import org.b3log.zephyr.mapper.MessageMapper;
import org.b3log.zephyr.mapper.TagMapper;
import org.b3log.zephyr.element.model.WelcomeListModel;
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
    public List<WelcomeListModel> getWelcomeList() {
        List<WelcomeListModel> welcomeList=new ArrayList<WelcomeListModel>();
        //目前为findAll，但之后可能会改成findRecent
        List<MessageLib> messageLibs=messageMapper.findAllMessages();
        for(MessageLib ml:messageLibs){
            WelcomeListModel wm=new WelcomeListModel();
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
    public List<WelcomeTagModel> getWelcomeTag(String userid) {
        List<WelcomeTagModel> welcomeTagModels=new ArrayList<WelcomeTagModel>();
        List<TagLib> tagLibs=tagMapper.findTagsByUser(userid);
        for(TagLib tagLib:tagLibs){
            WelcomeTagModel welcomeTagModel=new WelcomeTagModel();
            welcomeTagModel.setTagName(tagLib.getTag_name());
            welcomeTagModel.setTagCount(tagMapper.countTagsById(tagLib.getTag_id(),userid));
            welcomeTagModels.add(welcomeTagModel);
        }
        return welcomeTagModels;
    }

    @Override
    @Transactional
    public void saveWelcomeListModel(WelcomeListModel wm) {
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
