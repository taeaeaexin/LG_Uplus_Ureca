package ch15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        // LinkedList vs ArrayList
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
        // Test ArrayList vs LinkedList
        long startTime;
        long endTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 300000; i++) {
            arrayList.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        // LinkedList (빠르다)
        startTime = System.nanoTime();
        for (int i = 0; i < 300000; i++) {
            linkedList.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 500000; i++) {
            arrayList.add(String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);

        // LinkedList
        startTime = System.nanoTime();
        for (int i = 0; i < 500000; i++) {
            linkedList.add(String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
