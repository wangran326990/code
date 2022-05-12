package dachangmianshi.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatchDemo = new CountDownLatch(6);

        for (int i = 1; i <=6; i++) {
            new Thread(()-> {
                System.out.println(Thread.currentThread().getName() + "\t finished");
                countDownLatchDemo.countDown();
            }, "test" +i).start();
        }
        countDownLatchDemo.await();
        System.out.println(Thread.currentThread().getName()+ "\t leave");
    }

    public void closeDoorDemo() throws InterruptedException {
        CountDownLatch countDownLatchDemo = new CountDownLatch(6);

        for (int i = 1; i <=6; i++) {
            new Thread(()-> {
                System.out.println(Thread.currentThread().getName() + "\t finished");
                countDownLatchDemo.countDown();
            }, "test" +i).start();
        }
        countDownLatchDemo.await();
        System.out.println(Thread.currentThread().getName()+ "\t leave");
    }
}
