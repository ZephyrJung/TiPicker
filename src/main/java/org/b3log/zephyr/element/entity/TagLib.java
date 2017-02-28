package org.b3log.zephyr.element.entity;

import java.util.Date;

/**
 * Created by yaya on 17-2-27.
 */
public class TagLib {
    private String tag_id;
    private String tag_name;
    private String tag_logo;
    private String description;
    private String creator;
    private Date create_time;

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public String getTag_logo() {
        return tag_logo;
    }

    public void setTag_logo(String tag_logo) {
        this.tag_logo = tag_logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
