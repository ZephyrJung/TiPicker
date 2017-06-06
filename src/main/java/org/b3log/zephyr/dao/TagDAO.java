package org.b3log.zephyr.dao;

import org.apache.ibatis.annotations.*;
import org.b3log.zephyr.element.entity.TagLib;
import org.b3log.zephyr.model.welcome.WelcomeTagModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Zephyr on 2017/2/14.
 */
@Repository("tagDAO")
public interface TagDAO{
    TagLib findByTagName(@Param("tagName") String tagName);
    void saveTag(TagLib tagLib);

}
