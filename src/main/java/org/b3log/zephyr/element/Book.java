package org.b3log.zephyr.element;

import org.b3log.demo.structure.DoubleList;

/**
 * Created by Zephyr on 2017/2/7.
 */
public class Book {
    private String title;
    private Tag tag;
    //是否使用双链表有待商榷
    private DoubleList<Article> book;
}
