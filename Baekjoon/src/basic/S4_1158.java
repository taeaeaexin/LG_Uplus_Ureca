package basic;

import java.util.Scanner;

public class S4_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] result = new int[N];
        int live = N;
        int die = 0;

        int point = K;
        int cnt = 0;
        while(live > 0){
            result[cnt] = point;

            int count = 0;
            while(count < 3){
                boolean flag = true;
                for (int i = 0; i < N; i++) {
                    if(result[i] == point){
                        flag = false;
                    }
                }
                if(flag){
                    count++;
                    point++;
                }
            }

            live--;
            die++;
        }

        //출력
        System.out.print("<");
        for (int i = 0; i < N; i++) {
            System.out.print(result[i]);
            if (i != N - 1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}