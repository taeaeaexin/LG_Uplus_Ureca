package basic.Ch15_Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4_2839_greedy {
    static int count = 0;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        greedy();
        if(N != 0){
            count = -1;
        }
        System.out.println(count);
    }

    private static void greedy() {
        if (N <= 2) return;

        if(N % 5 == 0){
            count += N/5;
            N = 0;
        }else{
            count++;
            N -= 3;
            greedy();
        }
    }

}
