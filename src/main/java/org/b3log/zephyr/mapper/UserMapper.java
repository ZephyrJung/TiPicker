package org.b3log.zephyr.mapper;

import org.apache.ibatis.annotations.*;
import org.b3log.zephyr.element.entity.UserLib;

import java.util.List;

/**
 * Created by Zephyr on 2017/2/14.
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM userlib")
    @Results({
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userId",column = "user_id")
    })
    List<UserLib> findAllUsers();

    @Select("SELECT * FROM userlib WHERE user_id=#{uid}")
    UserLib findByUserId(@Param("uid") String uid);

    @Insert("INSERT INTO userlib VALUES(#{uid},#{uname})")
    int saveUser(@Param("uid") String uid,@Param("uname") String uname);

    @Delete("DELETE FROM userlib WHERE user_name=#{uname}")
    int deleteUser(@Param("uname") String uname);

    @Update("UPDATE userlib SET user_name=#{uname} WHERE user_id=#{uid}")
    int updateUser(@Param("uid") String uid,@Param("uname") String uname);
}
