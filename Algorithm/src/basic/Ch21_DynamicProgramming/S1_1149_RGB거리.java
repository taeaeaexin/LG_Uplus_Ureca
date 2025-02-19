package basic.Ch21_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] rgb = new int[N][3];
        int[][] result = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }

        result[0][0] = rgb[0][0];
        result[0][1] = rgb[0][1];
        result[0][2] = rgb[0][2];

        for (int i = 1; i < N; i++) {
            result[i][0] = rgb[i][0] + Math.min(result[i-1][1], result[i-1][2]);
            result[i][1] = rgb[i][1] + Math.min(result[i-1][0], result[i-1][2]);
            result[i][2] = rgb[i][2] + Math.min(result[i-1][0], result[i-1][1]);
        }

        System.out.println(Math.min(result[N-1][0], Math.min(result[N-1][1], result[N-1][2])));
    }
}
