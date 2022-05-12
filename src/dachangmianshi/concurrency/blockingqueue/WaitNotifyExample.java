package dachangmianshi.concurrency.blockingqueue;

class ThreadB extends Thread {
    int total;

    @Override
    public void run() {
        synchronized (this) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                total += i;

            }
            notify();
            System.out.println(Thread.currentThread().getName());
        }
    }
}

public class WaitNotifyExample {
    public static void main(String[] args){
        ThreadB b = new ThreadB();
        b.start();
        synchronized(b){
            try{
                System.out.println("Waiting for b to complete...");
                b.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("Total is: " + b.total);
        }
    }
}


