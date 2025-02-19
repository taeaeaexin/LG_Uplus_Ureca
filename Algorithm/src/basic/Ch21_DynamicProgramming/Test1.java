package basic.Ch21_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {
    static Color[] color;

    static class Color{
        int y, b;
        Color (int y, int b){
        this.y = y;
        this.b = b;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        color = new Color[N+1];
        for (int i = 0; i <= N; i++) {
            color[i] = new Color(0, 0);
        }

        System.out.println(dp(N));
    }

    public static int dp(int n){
        if(n == 1) return 2;
        if(n == 2) return 3;

        color[1].y = 1;
        color[1].b = 1;

        color[2].y = 2;
        color[2].b = 1;

        for (int i = 3; i <= n ; i++) {
            color[i].y = color[i-1].y + color[i-1].b;
            color[i].b = color[i-1].y;
        }

        return color[n].y + color[n].b;
    }
}
