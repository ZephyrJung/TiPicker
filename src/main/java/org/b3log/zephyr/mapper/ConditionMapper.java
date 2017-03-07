package org.b3log.zephyr.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.b3log.zephyr.element.entity.ConditionLib;

import java.util.List;

/**
 * Created by yaya on 17-3-5.
 */
@Mapper
public interface ConditionMapper {
    @Select("select * from conditionLib where parent_id=#{parentId}")
    List<ConditionLib> getConditions(@Param("parentId") String parentId);
}
