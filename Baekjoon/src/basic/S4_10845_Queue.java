package basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S4_10845_Queue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            switch (str) {
                case "push":
                    int X = sc.nextInt();
                    q.add(X);
                    break;
                case "pop": q.poll(); break;
                case "size" : q.size(); break;
                case "empty" : q.isEmpty(); break;
                case "front" : q.peek(); break;
                case "back" : q.poll(); break;
            }
        }
    }
}
