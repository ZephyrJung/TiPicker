package org.b3log.zephyr.element;

import org.b3log.zephyr.util.CheckNum;

import java.util.List;
import java.util.Stack;

/**
 * Created by Zephyr on 2017/1/22.
 */
public class TagStack {
    Stack<Tag> stack=null;
    public TagStack(){
        stack=new Stack<Tag>();
    }
    public TagStack(List<Tag> tag){
        stack=new Stack<Tag>();
        stack.addAll(tag);
    }
    public void init(int num){
        if(!CheckNum.ifNatureNum(num)){
            return;
        }
        for(int i=0;i<num;i++){
            stack.add(new Tag());
        }
    }
    public void destory(){
        stack=null;
    }

    public boolean push(Tag tag){
        stack.push(tag);
        return true;
    }
}
