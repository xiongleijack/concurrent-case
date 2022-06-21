package org.example;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;


/**
 * 偏向锁的测试
 * 偏向锁的参数： -XX:BiasedLockingStartupDelay 默认延迟 4 秒开启
 * -XX:BiasedLockingStartupDelay=0 立即开启偏向锁
 **/
public class BiasedLockExample {
    public static void main(String[] args) throws InterruptedException {
        BiasedLockExample example = new BiasedLockExample();
        System.out.println("加锁之前");
        System.out.println(ClassLayout.parseInstance(example).toPrintable());
        synchronized (example) {
            System.out.println("加锁之后");
            System.out.println(ClassLayout.parseInstance(example).toPrintable());
        }

        TimeUnit.SECONDS.sleep(10);
        System.out.println(ClassLayout.parseInstance(example).toPrintable());

        synchronized (example) {
            System.out.println("加锁之后");
            System.out.println(ClassLayout.parseInstance(example).toPrintable());
        }
    }
}
