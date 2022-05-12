package dachangmianshi.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1 CAS
 * 比较交换
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger.compareAndSet(0, 1) + " " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(0, 2) + " " + atomicInteger.get());
    }
}
