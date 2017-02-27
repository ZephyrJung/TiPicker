package org.b3log.zephyr.element.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.b3log.zephyr.element.entity.MessageLib;
import org.b3log.zephyr.element.entity.UserLib;

import java.util.Date;
import java.util.List;

/**
 * Created by Zephyr on 2017/2/14.
 */
@Mapper
public interface MessageMapper {
    @Select("SELECT * FROM messagelib order by create_time desc")
    @Results({
            @Result(property = "content",column = "content"),
            @Result(property = "creator",column = "creator"),
            @Result(property = "createTime",column="create_time")
    })
    List<MessageLib> findAllMessages();

    @Select("SELECT * FROM messagelib WHERE message_id=#{mid}")
    UserLib findByMessageId(@Param("mid") String mid);

    @Insert("INSERT INTO messagelib VALUES(#{messageId},#{tagId},#{content},#{creator},#{updateTime},#{createTime})")
    int saveMessage(@Param("messageId") String messageId, @Param("tagId") String tagId,
                    @Param("content") String content,@Param("creator") String creator,
                    @Param("updateTime") Date updateTime,@Param("createTime") Date createTime);

    @Delete("DELETE FROM userlib WHERE user_name=#{uname}")
    int deleteUser(@Param("uname") String uname);

    @Update("UPDATE userlib SET user_name=#{uname} WHERE user_id=#{uid}")
    int updateUser(@Param("uid") String uid, @Param("uname") String uname);
}
