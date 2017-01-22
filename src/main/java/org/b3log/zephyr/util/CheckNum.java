package org.b3log.zephyr.util;

/**
 * Created by Zephyr on 2017/1/22.
 */
public class CheckNum {
    public static boolean ifNatureNum(Object obj){
        try{
            int num=Integer.parseInt(obj.toString());
            if(num >= 0){
                return true;
            }else{
                return false;
            }
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean ifNatureNum(Object obj,int max){
        try{
            int num=Integer.parseInt(obj.toString());
            if(num >= 0 && num <= max){
                return true;
            }else{
                return false;
            }
        }catch (NumberFormatException e){
            return false;
        }
    }
}
