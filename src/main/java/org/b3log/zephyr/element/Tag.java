package org.b3log.zephyr.element;

/**
 * Created by yaya on 17-1-21.
 *
 */
public class Tag {
    //Tag统一编号
    private String id;

    //Tag名称（用于存储）
    private String name;

    //Tag值（用于显示）
    private String value;

    //Tag领域，即适用范围
    private String area;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
