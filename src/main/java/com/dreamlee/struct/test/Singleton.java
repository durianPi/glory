package com.dreamlee.struct.test;

/**
 * @author: DreamLee
 * @date: Created on 20:30 2018/11/14
 * @description:
 * @modified:
 */
public class Singleton {

    private static Singleton INSTANCE = null;

//    private static class LazyHolder {
//        private static final Singleton INSTANCE = new Singleton();
//    }

    static {
        INSTANCE = new Singleton();
    }

    private Singleton() {

    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    public static void test() {
        System.out.println("test");
    }

}
