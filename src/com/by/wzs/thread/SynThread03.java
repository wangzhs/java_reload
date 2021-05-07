package com.by.wzs.thread;

/**
 * @Author wangzhs
 * @create 2021/5/7 8:57
 * 对象锁和类锁
 */
public class SynThread03 {

    private static int count = 0;

    private static class SynClass {

    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            synchronized (this) {   // synchronized (SynClass.class)
                for (int i = 0; i < 10; i++) {
                    count = count + 1;
                    System.out.println(Thread.currentThread().getName() + "==========================" + count);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        myThread1.start();

        MyThread myThread2 = new MyThread();
        myThread2.start();

        MyThread myThread3 = new MyThread();
        myThread3.start();

    }
}
