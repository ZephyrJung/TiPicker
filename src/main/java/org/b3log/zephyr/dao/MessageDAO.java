package org.b3log.zephyr.dao;

import org.b3log.zephyr.element.entity.MessageLib;
import org.b3log.zephyr.model.welcome.WelcomeListModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yaya on 17-5-20.
 */
@Repository("messageDAO")
public interface MessageDAO {
    //    List<MessageLib> findAllMessages();
//
//    MessageLib findByMessageId(@Param("mid") String mid);
//
    int saveMessage(MessageLib messageLib);
//
//    int deleteUser(@Param("uname") String uname);
//
//    int updateUser(@Param("uid") String uid, @Param("uname") String uname);
//
}
