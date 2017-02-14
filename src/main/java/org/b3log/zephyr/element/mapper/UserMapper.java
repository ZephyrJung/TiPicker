package org.b3log.zephyr.element.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.b3log.zephyr.element.entity.UserLib;

/**
 * Created by Zephyr on 2017/2/14.
 */
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM userlib WHERE user_id=#{uid}")
    UserLib findByUserId(@Param("uid") String uid);

    @Insert("INSERT INTO userlib VALUES(#{uid},#{uname}")
    int saveUser(@Param("uid") String uid,@Param("uname") String uname);

    @Delete("DELETE FROM userlib WHERE user_id=#{uid}")
    int deleteUser(@Param("uid") String uid);

    @Update("UPDATE userlib SET user_name=#{uname} WHERE user_id=#{uid}")
    int updateUser(@Param("uid") String uid,@Param("uname") String uname);
}
