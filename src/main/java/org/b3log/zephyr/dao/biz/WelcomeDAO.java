package org.b3log.zephyr.dao.biz;

import org.apache.ibatis.annotations.Param;
import org.b3log.zephyr.model.welcome.WelcomeListModel;
import org.b3log.zephyr.model.welcome.WelcomeTagModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yaya on 17-5-20.
 */
@Repository("welcomeDAO")
public interface WelcomeDAO {
    List<WelcomeListModel> findWelcomeList();
    List<WelcomeTagModel> findTagsByUserId(@Param("uid") String uid);
}
