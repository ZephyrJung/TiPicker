package org.b3log.zephyr.service;

import org.b3log.zephyr.element.entity.MessageLib;
import org.b3log.zephyr.element.entity.TagLib;
import org.b3log.zephyr.element.model.WelcomeListModel;
import org.b3log.zephyr.element.model.WelcomeTagModel;

import java.util.List;

/**
 * Created by yaya on 17-2-27.
 */
public interface WelcomeService {
    public List<WelcomeListModel> getWelcomeList();
    public List<WelcomeTagModel> getWelcomeTag(String userid);
    public void saveWelcomeListModel(WelcomeListModel wm);
}
