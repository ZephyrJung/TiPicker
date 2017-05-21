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
import java.util.concurrent.TimeUnit;

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
        findCityById();
        return result;
    }

    public String findCityById() {
        // 从缓存中获取城市信息
        String key = "city_1";
        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            String city = operations.get(key);
            System.out.println(city);
            return city;
        }

        // 从 DB 中获取城市信息
//        City city = cityDao.findById(id);
        String city="Beijing";
        // 插入缓存
        operations.set(key, city);
        System.out.println("insert a new key:>"+key);
        return null;
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
