package org.b3log.zephyr.element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaya on 17-1-21.
 */
public class TagList {
    List<Tag> tagList=null;
    public TagList(){
        tagList=new ArrayList<Tag>();
    }
    public TagList(List<Tag> list){
        tagList=new ArrayList<Tag>();
        for(Tag t:list){
            tagList.add(t);
        }
    }
    public void init(int num){
        for(int i=0;i<num;i++){
            tagList.add(new Tag());
        }
    }
    public void destory(){
        tagList.removeAll(tagList);
    }
    public boolean insert(int pos,Tag tag){
        try {
            tagList.add(pos, tag);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public Tag remove(int pos){
        return tagList.remove(pos);
    }
    public String getValue(int pos){
        return tagList.get(pos).getValue();
    }
}
