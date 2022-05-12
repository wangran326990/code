package dachangmianshi.streams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class JavaStream {
    public static void main(String[] args) throws FileNotFoundException {
       new BufferedInputStream( new FileInputStream("test"));
        //Collections.synchronizedList();
        Thread t = Thread.currentThread();
    }
}
