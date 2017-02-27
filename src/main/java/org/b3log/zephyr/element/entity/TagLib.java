package org.b3log.zephyr.element.entity;

import java.util.Date;

/**
 * Created by yaya on 17-2-27.
 */
public class TagLib {
    private String tagId;
    private String tagName;
    private String tagLogo;
    private String description;
    private String creator;
    private Date createTime;

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTagLogo() {
        return tagLogo;
    }

    public void setTagLogo(String tagLogo) {
        this.tagLogo = tagLogo;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
