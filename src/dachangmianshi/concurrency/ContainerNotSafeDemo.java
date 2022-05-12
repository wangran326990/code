package dachangmianshi.concurrency;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        //List<String> list = new ArrayList<>();
        /**
         * thread safe version
         */

        //List<String> list = Collections.synchronizedList(new ArrayList<>());
       //list.forEach(System.out::println);
        //Exception in thread "Thread-203" Exception in thread "Thread-277" java.util.ConcurrentModificationException

        List<String> list =new CopyOnWriteArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }).start();
        }

        while(Thread.activeCount() > 2) {

        }
    }
}
