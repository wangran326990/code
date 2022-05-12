package dachangmianshi.concurrency.blockingqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 */
class ShareData1 {
    private int number = 0;
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();
    public void increment() throws Exception {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " call increment");
            condition.await();
//

            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();

        }catch (Exception ex) {

        }finally {
            lock.unlock();
        }

    }

    public void decrement() throws  Exception {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() +" call decrement");
            condition.signalAll();

        }catch (Exception ex) {

        }finally {
            lock.unlock();
        }

    }
}

/**
 * 1 线程 操作（方法） 资源类
 * 2 判断 干活 通知
 * 3 防止虚假唤醒机制
 */
public class AwakeTest {

    public static void main(String[] args) {
        ShareData1 shareData = new ShareData1();

            new Thread(()-> {
                for(int i = 0; i < 1; i++) {
                    try {
                        shareData.increment();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        new Thread(()-> {
            for(int i = 0; i < 1; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()-> {
            for(int i = 0; i < 1; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(()-> {
            for(int i = 0; i < 1; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(()-> {
            for(int i = 0; i < 1; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

            new Thread(()-> {
                for(int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                        shareData.decrement();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            while(Thread.activeCount() > 2) {

            }
            System.out.println("finished");
    }
}
