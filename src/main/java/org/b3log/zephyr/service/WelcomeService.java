package org.b3log.zephyr.service;

import org.b3log.zephyr.element.entity.MessageLib;
import org.b3log.zephyr.element.entity.TagLib;
import org.b3log.zephyr.element.model.WelcomeModel;

import java.util.List;

/**
 * Created by yaya on 17-2-27.
 */
public interface WelcomeService {
    public List<WelcomeModel> getWelcomeList();
    public void saveWelcomeModel(WelcomeModel wm);
}
