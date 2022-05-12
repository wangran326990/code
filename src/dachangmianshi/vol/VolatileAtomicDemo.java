package dachangmianshi.vol;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileAtomicDemo {
    /**
     * atomic cannot guarantee
     *
     */
    static class AddNumber {
        int num = 0;
        int total = 0;

        public void add60() {
            num = 60;
        }
        AtomicInteger integer = new AtomicInteger();

        public void addPlusPlus() {
            /**
             *
             */
            integer.getAndIncrement();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddNumber addNumber = new AddNumber();

        for(int i = 0; i < 20; i++) {
            new Thread(()-> {
                for(int j =0; j < 1000; j++)
                    addNumber.addPlusPlus();
            }).start();
        }
        while(Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(addNumber.integer);
    }
}
