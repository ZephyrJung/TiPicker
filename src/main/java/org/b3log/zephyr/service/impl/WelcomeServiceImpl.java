package org.b3log.zephyr.service.impl;

import org.b3log.zephyr.dao.MessageDAO;
import org.b3log.zephyr.dao.TagDAO;
import org.b3log.zephyr.model.WelcomeTagModel;
import org.b3log.zephyr.model.WelcomeListModel;
import org.b3log.zephyr.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by yaya on 17-2-27.
 */
@Service
public class WelcomeServiceImpl implements WelcomeService{
    @Autowired
    private MessageDAO messageDAO;

    @Autowired
    private TagDAO tagDAO;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<WelcomeListModel> getWelcomeList() {
        List<WelcomeListModel> result= messageDAO.findWelcomeList();
        return result;
    }

    @Override
    public List<WelcomeTagModel> getWelcomeTag(String userid) {
        List<WelcomeTagModel> result=tagDAO.findTagsByUserId("test");
        return result;
    }



    /*@Override
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
    }*/
}
