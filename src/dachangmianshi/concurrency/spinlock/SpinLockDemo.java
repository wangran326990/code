package dachangmianshi.concurrency.spinlock;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo
{
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() +" new Thread coming" );
        while(!atomicReference.compareAndSet(null, thread)) {
            System.out.println(Thread.currentThread().getName() +"waiting" );
        }

    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() +" unlock" );
    }

    public static void main(String[] args) throws InterruptedException {
        //原子引用线程
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            try {
                spinLockDemo.myLock();
                Thread.sleep(5000);
                spinLockDemo.myUnLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AA").start();

        Thread.sleep(1000);

        new Thread(()->{
            try {
                spinLockDemo.myLock();
                Thread.sleep(1000);
                spinLockDemo.myUnLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BB").start();
    }
}
