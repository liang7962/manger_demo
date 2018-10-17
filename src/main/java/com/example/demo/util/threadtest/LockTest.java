package com.example.demo.util.threadtest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        //创建资源对象
        sells s=new sells();
        //创建线程对象
        Thread t1=new Thread(s,"窗口1");
        Thread t2=new Thread(s,"窗口2");
        Thread t3=new Thread(s,"窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

}
class sells implements Runnable {
    //定义票
    private int tickets=100;
    //定义锁对象
    private Lock lock=new ReentrantLock();
    @Override
    public void run() {
        // TODO Auto-generated method stub
        //加锁
        lock.lock();
        while(tickets>0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"正在出售第"+(tickets--)+"张票");
        }
        //释放锁
        lock.unlock();
    }

}
