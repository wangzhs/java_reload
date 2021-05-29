package com.by.wzs.threah_util;

import com.by.wzs.util.ArrUtil;

import java.util.concurrent.RecursiveTask;

/**
 * @Author wangzhs
 * @create 2021/5/29 22:40
 * 分而治之
 */
public class MyRecursiveTask extends RecursiveTask<Integer> {

    public static final Integer a = 10;

    private Integer[] arr;

    private Integer formIndex;

    private Integer toIndex;

    public MyRecursiveTask(Integer[] arr, Integer formIndex, Integer toIndex) {
        this.arr = arr;
        this.formIndex = formIndex;
        this.toIndex = toIndex;
    }

    @Override
    protected Integer compute() {
        if (toIndex - formIndex <= a) {
            int count = 0;
            for (int i = formIndex; i <= toIndex; i++) {
                count += arr[i];
            }
            return count;
        } else {
            int mid = (formIndex + toIndex) / 2;
            MyRecursiveTask a = new MyRecursiveTask(arr, formIndex, mid);
            MyRecursiveTask b = new MyRecursiveTask(arr, mid + 1, toIndex);
            invokeAll(a, b);
            return a.join() + b.join();
        }
    }

    public static void main(String[] args) {
        Integer[] mark = ArrUtil.mark(100);

        long s = System.currentTimeMillis();
        MyRecursiveTask t = new MyRecursiveTask(mark, 0, mark.length - 1);
        long e = System.currentTimeMillis();
        System.out.println(t.compute() + "============" + (e - s) + "ms");

        long s1 = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < mark.length; i++) {
            count += mark[i];
        }
        long e1 = System.currentTimeMillis();
        System.out.println(count + "============" + (e1 - s1) + "ms");

    }

}
