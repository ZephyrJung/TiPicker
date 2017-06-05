package org.b3log.zephyr.model.welcome;

/**
 * Created by yaya on 17-2-28.
 */
public class WelcomeTagModel {
    private String tagName;
    private int tagCount;
    private String tagCreator;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getTagCount() {
        return tagCount;
    }

    public void setTagCount(int tagCount) {
        this.tagCount = tagCount;
    }

    public String getTagCreator() {
        return tagCreator;
    }

    public void setTagCreator(String tagCreator) {
        this.tagCreator = tagCreator;
    }
}
