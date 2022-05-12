package dachangmianshi.concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for(int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("get parting lot");
                    Thread.sleep(3000);
                    System.out.println("leave parting lot");

                }catch (Exception exception) {

                }finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
