package org.b3log.demo.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Zephyr on 2017/3/10.
 */
public class TaskThread implements Runnable {
    private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>();
    private CountDownLatch countDownLatch;

    @Override
    public void run() {
        String test=queue.poll();
        if(test!=null){
            System.out.println(Thread.currentThread().getId()+" : "+test);
        }

    }

    public void setQueue(LinkedBlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
}
