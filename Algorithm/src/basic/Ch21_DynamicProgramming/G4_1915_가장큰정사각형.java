package basic.Ch21_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1915_가장큰정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][M+1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = str.charAt(j-1) - '0';

                if(arr[i][j] == 1){
                    //왼쪽 위 방향의 값들 중 최솟값+1이 정사각형 변 길이
                    arr[i][j] = Math.min(Math.min(arr[i-1][j-1], arr[i-1][j]), arr[i][j-1]) + 1;
                    max = Math.max(arr[i][j], max);
                }
            }
        }

        System.out.println(max*max);
    }
}
