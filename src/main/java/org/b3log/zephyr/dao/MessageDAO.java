package org.b3log.zephyr.dao;

import org.b3log.zephyr.model.WelcomeListModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yaya on 17-5-20.
 */
@Repository("messageDAO")
public interface MessageDAO{
//    List<MessageLib> findAllMessages();
//
//    MessageLib findByMessageId(@Param("mid") String mid);
//
//    int saveMessagessage(@Param("messageId") String messageId, @Param("tagId") String tagId,
//                    @Param("content") String content, @Param("creator") String creator,
//                    @Param("updateTime") Date updateTime, @Param("createTime") Date createTime);
//
//    int deleteUser(@Param("uname") String uname);
//
//    int updateUser(@Param("uid") String uid, @Param("uname") String uname);
//
    List<WelcomeListModel> findWelcomeList();
}
