package dachangmianshi.concurrency.readwritelock;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    //private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    public void put(String key, Object obj) {
        rwlock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " input data :" + key );
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, obj);
            System.out.println(Thread.currentThread().getName() + " input data :" + key + " finished");
        }catch (Exception exception) {
            exception.printStackTrace();
        } finally{
            rwlock.writeLock().unlock();
        }

    }

    public Object get(String key) {
        Object result = null;
        rwlock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " read data :" + key );
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + " read data :" + key + " finished");

        }catch (Exception exception) {
            exception.printStackTrace();
        }finally {
            rwlock.readLock().unlock();
        }
        return result;

    }
}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for(int i = 1; i <=5; i++ ) {
            final int tempInt = i;
            new Thread(() -> {
                myCache.put(tempInt + "", tempInt +"");
            }, String.valueOf(i)).start();
        }

        for(int i = 1; i <=5; i++ ) {
            final int tempInt = i;
            new Thread(() -> {
                 myCache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }
    }
}
