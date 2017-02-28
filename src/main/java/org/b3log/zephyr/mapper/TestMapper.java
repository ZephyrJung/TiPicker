package org.b3log.zephyr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.b3log.zephyr.element.Test;

/**
 * Created by yaya on 17-2-12.
 */

@Mapper
public interface TestMapper {

    @Select("SELECT * FROM SYMPHONY_USER_TAG WHERE OID=#{oId}")
    Test findByOId(@Param("oId") String oId);

}
