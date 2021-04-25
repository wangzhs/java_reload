package com.by.wzs.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Callable;

/**
 * @Author wangzhs
 * @create 2021/4/25 16:15
 */
public class SafeThread01 {

    /**
     * 创建线程三种方式
     */
    public static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
        }
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {

        }
    }

    public static class MyCallable implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            return true;
        }
    }


    public static void main(String[] args) {
        //1. main方法启动的线程数
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = mxBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            // 线程ID 线程名称 是否是守护进程
            System.out.printf("%s:%s:%s%n", threadInfo.getThreadId(), threadInfo.getThreadName(), threadInfo.isDaemon());
        }
    }

}


