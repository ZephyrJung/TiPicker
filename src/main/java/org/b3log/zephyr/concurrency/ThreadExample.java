package org.b3log.zephyr.concurrency;

/**
 * Created by yaya on 17-2-26.
 */
public class ThreadExample {
    private static int count=0;
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName());
        for(int i=0;i<10;i++){
            new Thread("" +i){
                public void run(){
                    //多个线程访问了相同的资源时会导致问题的发生
                    count++;
                    System.out.println("Thread: "+getName()+" running");
                }
            }.start();
        }
        System.out.println(count);
    }
}
