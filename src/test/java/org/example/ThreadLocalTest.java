package org.example;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    @Test
    public void testThreadLocalSetAndGet(){
        ThreadLocal tl = new ThreadLocal();

        new Thread(()->{
            tl.set("小燕");
            System.out.println(Thread.currentThread().getName() + "的线程局部变量是：" + tl.get());
        }, "线程1").start();

        new Thread(()->{
            tl.set("小王");
            System.out.println(Thread.currentThread().getName() + "的线程局部变量是：" + tl.get());
        }, "线程2").start();
    }

}
