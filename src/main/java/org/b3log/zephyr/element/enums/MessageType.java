package org.b3log.zephyr.element.enums;

/**
 * Created by yaya on 17-3-5.
 */
enum MessageType {
    TIEBA("贴吧"),
    BBS("论坛"),
    RECORD("记录"),
    CHAT("聊天"),
    ACTIVITY("活动"),
    MAIN_CLASS("主要类型"),
    SUB_CLASS("二级类型"),

    ;
    MessageType(String mt){
    }
}
