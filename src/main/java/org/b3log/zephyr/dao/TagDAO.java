package org.b3log.zephyr.dao;

import org.apache.ibatis.annotations.*;
import org.b3log.zephyr.model.WelcomeTagModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Zephyr on 2017/2/14.
 */
@Repository("tagDAO")
public interface TagDAO{
    List<WelcomeTagModel> findTagsByUserId(@Param("uid") String uid);

    /*@Select("SELECT COUNT(1) FROM messagelib where tag_id=#{tid} and creator=#{uid}")
    int countTagsById(@Param("tid") String tid, @Param("uid") String uid);

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
    int updateUser(@Param("uid") String uid, @Param("uname") String uname);*/
}
