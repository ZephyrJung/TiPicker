package org.b3log.zephyr.dao;

import org.apache.ibatis.annotations.Param;
import org.b3log.zephyr.element.entity.MessageLib;
import org.b3log.zephyr.model.welcome.WelcomeListModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yaya on 17-5-20.
 */
@Repository("messageDAO")
public interface MessageDAO {
    int saveMessage(MessageLib messageLib);
    int countTagsById(@Param("tid") String tid, @Param("uid") String uid);
}
