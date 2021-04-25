package com.by.wzs.thread;

/**
 * @Author wangzhs
 * @create 2021/4/25 16:31
 * <p>
 * isInterrupted
 * interrupt
 * <p>
 * 方法使用
 */
public class SafeThread02 {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    System.out.println("thread i am alive");
                }
            } finally {
                System.out.println("thread i am finally");
            }
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            try {
                while (!thread.isInterrupted()) {
                    System.out.println("runnable i am alive");
                }
            } finally {
                System.out.println("runnable i am finally");
            }
        }
    }

    public static class InterruptedExceptionThread extends Thread {
        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    Thread.sleep(100);
                    System.out.println("interrupted i am alive");
                } catch (InterruptedException e) {
                    System.out.println("interrupted i am error " + isInterrupted());
                    // 如果在线程异常时候，将异常拦截下来，则不会中断线程。
                    // 必须在线程里面再次中断线程
                    interrupt();
                    e.printStackTrace();
                } finally {
                    System.out.println("interrupted i am finally");
                }
            }
        }
    }

    /**
     *
     */
    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
//        myThread.start();
//        Thread.sleep(10);
//
//
//        Thread myRunnable = new Thread(new MyRunnable());
//        myRunnable.start();
//        Thread.sleep(10);
//
//        myThread.interrupt();
//        myRunnable.interrupt();
//
//        System.out.println("=========" + Thread.interrupted());

        InterruptedExceptionThread interruptedExceptionThread = new InterruptedExceptionThread();
        interruptedExceptionThread.start();
        Thread.sleep(500);
        interruptedExceptionThread.interrupt();
    }

}
