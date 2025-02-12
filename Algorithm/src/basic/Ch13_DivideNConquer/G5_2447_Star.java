package basic.Ch13_DivideNConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G5_2447_Star {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        //전부 별
        for (char[] star : arr) Arrays.fill(star, '*');

        //빈칸 뚫기
        star(N,0,0);

        //결과 출력
        for (char[] star : arr) {
            sb.append(star).append("\n");
        }
        System.out.println(sb);
    }

    public static void star(int N, int y, int x) {
        if(N == 1) return;

        //공백 삽입
        for (int i = y+(N/3); i < y+(N/3*2); i++) {
            for (int j = x+(N/3); j < x+(N/3*2); j++) {
                arr[i][j] = ' ';
            }
        }

        //분할 정복
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3 ; j++) {
                star(N/3, y+(i*N/3), x+(j*N/3));
            }
        }
    }
}