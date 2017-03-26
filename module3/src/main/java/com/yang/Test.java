package com.yang;

/**
 * Created by Dev_yang on 2017/3/23.
 */
public class Test {

   public synchronized void test1(){
        System.out.println("test1");
    }

    public synchronized void test2(){
       //1.进入该方法就获取到了this对象的锁
       test1();//这里调用test1()需要再次获得this锁，假如没有重入锁机制的话，步骤1中获取
        //的this锁还没有释放，就无法再次获取this锁，导致一直等待 也就发生了死锁

    }

}
