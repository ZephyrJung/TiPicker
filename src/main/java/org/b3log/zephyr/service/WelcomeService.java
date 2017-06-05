package org.b3log.zephyr.service;

import org.b3log.zephyr.model.welcome.WelcomeListModel;
import org.b3log.zephyr.model.welcome.WelcomeTagModel;

import java.util.List;

/**
 * Created by yaya on 17-2-27.
 */
public interface WelcomeService {
    List<WelcomeListModel> getWelcomeList();
    List<WelcomeTagModel> getWelcomeTag(String userid);
    void saveWelcomeListModel(WelcomeListModel wm);
}
