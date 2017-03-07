package org.b3log.zephyr.element.entity;

import java.util.Date;

/**
 * Created by yaya on 17-3-5.
 */
public class ConditionLib {
    private String condition_id;
    private String tag_id;
    private String next_tag_id;
    private String parent_tag_id;
    private String creator;
    private Date create_time;

    public String getCondition_id() {
        return condition_id;
    }

    public void setCondition_id(String condition_id) {
        this.condition_id = condition_id;
    }

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public String getNext_tag_id() {
        return next_tag_id;
    }

    public void setNext_tag_id(String next_tag_id) {
        this.next_tag_id = next_tag_id;
    }

    public String getParent_tag_id() {
        return parent_tag_id;
    }

    public void setParent_tag_id(String parent_tag_id) {
        this.parent_tag_id = parent_tag_id;
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
