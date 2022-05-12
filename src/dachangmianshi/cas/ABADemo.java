package dachangmianshi.cas;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;


class User {
    String userName;
    int age;
    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

}

public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> integerAtomicStampedReference = new AtomicStampedReference<>(100, 1);
    /*
    public static void main(String[] args) {
        User z3 = new User("z3", 22);
        User li4 = new User("li4", 23);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);
        System.out.println(atomicReference.compareAndSet(z3, li4) + "\t"+ atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3, li4) + "\t"+ atomicReference.get().toString());
    }*/

    public static void main(String[] args) {
        /*
        new Thread(() -> {
           atomicReference.compareAndSet(100, 101);
           atomicReference.compareAndSet(101, 100);
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(atomicReference.compareAndSet(100, 2019) + "\t"+ atomicReference.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        */
        System.out.println("ABA problem solution");
        new Thread(() -> {
            int stamp = integerAtomicStampedReference.getStamp();
            System.out.println("stamp :" +stamp);
            try {
                Thread.sleep(1000);
                integerAtomicStampedReference.compareAndSet(100,101, stamp, ++stamp);
                integerAtomicStampedReference.compareAndSet(101,100, stamp, stamp + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            int stamp = integerAtomicStampedReference.getStamp();
            System.out.println("stamp :" +stamp);
            try {
                Thread.sleep(3000);
                System.out.println(integerAtomicStampedReference.compareAndSet(100,101, stamp, stamp + 1) +"\t"+ integerAtomicStampedReference.getReference() + " version number: " + integerAtomicStampedReference.getStamp());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
