package com.by.wzs.util;

import java.util.Random;

/**
 * @Author wangzhs
 * @create 2021/5/29 22:48
 */
public class ArrUtil {

    public static Integer[] mark(Integer n) {
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Random(10000000).nextInt();
        }
        return a;
    }
}
