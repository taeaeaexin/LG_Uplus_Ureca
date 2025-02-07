package basic;

import java.util.Arrays;
import java.util.Scanner;

public class S2_2961_subset {
    static int[][] Food;
    static boolean[] Select;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Food = new int[N][2];

        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            int B = sc.nextInt();
            Food[i][0] = S;
            Food[i][1] = B;
        }

        subset(0);
    }

    static void subset(int srcIdx) {
        if(srcIdx == Food.length) {
            printSubset();
            return;
        }

        Select[srcIdx] = true;
        subset(srcIdx + 1);

        Select[srcIdx] = false;
        subset(srcIdx + 1);
    }

    static void printSubset() {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < Select.length; i++) {
//            if(Select[i]) sb.append(Food[i][1]).append(" ");
//        }
//        System.out.println(sb);
    }
}