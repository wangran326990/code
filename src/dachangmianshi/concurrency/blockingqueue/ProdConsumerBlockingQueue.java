package dachangmianshi.concurrency.blockingqueue;

import javax.management.MBeanAttributeInfo;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile/CAS/atomicInteger/BlockQueue/Thread Communication/
 */

class MyResource {
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue<String> blockingQueue = null;
    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception {
        String data = null;
        boolean retValue;
        while(FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            //Thread.sleep(1000);
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if(retValue) {
                System.out.println(Thread.currentThread().getName() +" insert success");
            }else {
                System.out.println(Thread.currentThread().getName() +" insert failed");
            }
        }
        Thread.sleep(1000);
        System.out.println("prod finished");
    }

    public void myConsumer() throws Exception {
        String data = null;
        boolean retValue;
        String result = null;
        while(FLAG) {
            //Thread.sleep(1000);
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null || result.equalsIgnoreCase("")) {
                System.out.println(Thread.currentThread().getName() +" get "+result+" failed");
            }else {
                System.out.println(Thread.currentThread().getName() +" get "+result+" success");
            }
        }
        Thread.sleep(1000);
        System.out.println("prod finished");

    }

    public void stop() throws  Exception {
        this.FLAG = false;
    }
}
public class ProdConsumerBlockingQueue {
    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(100));
        new Thread(()-> {
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(()-> {
            try {
                myResource.myConsumer();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
        Thread.sleep(5000);
        myResource.stop();
    }

}
