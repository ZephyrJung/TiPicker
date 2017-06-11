package org.b3log.zephyr.model.welcome;

import java.util.Date;

/**
 * Created by yaya on 17-2-27.
 */
public class WelcomeListModel {
    private String tag;
    private String message;
    private String creator;
    private Date createTime;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
