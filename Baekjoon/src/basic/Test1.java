package basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Test1 {

    static int T, N, M, ans;
    static int[][] memoi;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            memoi = new int[M + 1][M + 1]; // 0 dummy, 주의 가로, 세로 모두 M + 1

            memoi[0][0] = 1;

            // 파스칼의 삼각형
            //   /\ 구조를 L\ 의 구조로 표현
            for (int i = 1; i <= M; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) { // 맨 앞이거나 맨 뒤이면
                        memoi[i][j] = 1;
                        continue;
                    }

                    memoi[i][j] = memoi[i - 1][j - 1] + memoi[i - 1][j]; // 이전 행의 왼쪽(j-1) + 오른쪽 (j<=같은)
                }
            }
            System.out.println(memoi[M][N]);
        }
    }
}
