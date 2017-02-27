package org.b3log.zephyr.element.mapper;

import org.apache.ibatis.annotations.*;
import org.b3log.zephyr.element.entity.MessageLib;
import org.b3log.zephyr.element.entity.TagLib;
import org.b3log.zephyr.element.entity.UserLib;

import java.util.Date;
import java.util.List;

/**
 * Created by Zephyr on 2017/2/14.
 */
@Mapper
public interface TagMapper {
    @Select("SELECT * FROM messagelib order by create_time desc")
    @Results({
            @Result(property = "content",column = "content"),
            @Result(property = "creator",column = "creator"),
            @Result(property = "createTime",column="create_time")
    })
    List<TagLib> findAllMessages();

    @Select("SELECT * FROM taglib WHERE tag_id=#{tid}")
    TagLib findByTagId(@Param("tid") String tid);

    @Select("SELECT * FROM taglib WHERE tag_name=#{tagName}")
    TagLib findByTagName(@Param("tagName") String tagName);

    @Insert("INSERT INTO taglib VALUES(#{tagId},#{tagName},#{tagLogo},#{description},#{creator},#{createTime})")
    int saveTag(@Param("tagId") String tagId, @Param("tagName") String tagName,
                    @Param("tagLogo") String tagLogo, @Param("description") String description,
                    @Param("creator") String creator, @Param("createTime") Date createTime);

    @Delete("DELETE FROM userlib WHERE user_name=#{uname}")
    int deleteUser(@Param("uname") String uname);

    @Update("UPDATE userlib SET user_name=#{uname} WHERE user_id=#{uid}")
    int updateUser(@Param("uid") String uid, @Param("uname") String uname);
}
