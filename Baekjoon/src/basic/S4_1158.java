package basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S4_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        Queue<Integer> people = new LinkedList<>();

        System.out.print("<");
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }

        while(!people.isEmpty()) {
            for (int i = 0; i < K-1; i++) {
                people.add(people.poll());
            }
            System.out.print(people.poll());
            if (!people.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}