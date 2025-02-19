package basic.Ch21_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        System.out.println(dp(N));
    }

    static int dp(int n){
        if(n == 1) return 2;
        if(n == 2) return 5;

        arr[1] = 2;
        arr[2] = 5;

        for (int i = 3; i <= n ; i++) {
            arr[i] = arr[i-2] + arr[i-1] * 2;
        }

        return arr[n];
    }
}
