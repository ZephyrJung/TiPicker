package org.b3log.zephyr.service.impl;

import org.b3log.zephyr.dao.MessageDAO;
import org.b3log.zephyr.dao.TagDAO;
import org.b3log.zephyr.dao.biz.WelcomeDAO;
import org.b3log.zephyr.element.entity.MessageLib;
import org.b3log.zephyr.element.entity.TagLib;
import org.b3log.zephyr.model.welcome.WelcomeTagModel;
import org.b3log.zephyr.model.welcome.WelcomeListModel;
import org.b3log.zephyr.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;
/**
 * Created by yaya on 17-2-27.
 */
@Service
public class WelcomeServiceImpl implements WelcomeService{
    @Autowired
    private WelcomeDAO welcomeDAO;
    @Autowired
    private MessageDAO messageDAO;
    @Autowired
    private TagDAO tagDAO;

    @Override
    public List<WelcomeListModel> getWelcomeList() {
        List<WelcomeListModel> result= welcomeDAO.findWelcomeList();
        return result;
    }

    @Override
    public List<WelcomeTagModel> getWelcomeTag(String userid) {
        List<WelcomeTagModel> result=tagDAO.findTagsByUserId("test");
        return result;
    }

    @Override
    @Transactional
    public void saveWelcomeListModel(WelcomeListModel wm) {
        String tid;
        TagLib tagLib=tagDAO.findByTagName(wm.getTag());

        if(null==tagLib || tagLib.equals("")){
            tagLib = new TagLib();
            tagLib.setTag_id(System.currentTimeMillis()+"");
            tagLib.setTag_name(wm.getTag());
            tagLib.setTag_logo("test");
            tagLib.setDescription("test");
            tagLib.setCreator(wm.getCreator());
            tagLib.setCreate_time(Calendar.getInstance().getTime());
            tagDAO.saveTag(tagLib);
            tid=tagLib.getTag_id();
        }else{
            tid=tagLib.getTag_id();
        }
        MessageLib messageLib = new MessageLib();
        messageLib.setMessage_id(System.currentTimeMillis()+"");
        messageLib.setTag_id(tid);
        messageLib.setContent(wm.getMessage());
        messageLib.setCreator(wm.getCreator());
        messageLib.setUpdate_time(Calendar.getInstance().getTime());
        messageLib.setCreate_time(Calendar.getInstance().getTime());
        messageDAO.saveMessage(messageLib);
    }
}
