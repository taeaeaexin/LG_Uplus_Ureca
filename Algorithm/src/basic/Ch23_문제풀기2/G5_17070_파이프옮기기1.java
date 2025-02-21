package basic.Ch23_문제풀기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_17070_파이프옮기기1 {
    static int N, result;
    static int[][] arr;

    static int[] w_dy = {0,1, 0,0};
    static int[] w_dx = {1,1, 1,1};
    static int[] h_dy = {1,1, 1,1};
    static int[] h_dx = {0,1, 0,0};
    static int[] d_dy = {0,1,1, 1,1,1};
    static int[] d_dx = {1,0,1, 1,1,1};

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move(0,1, 0, 0);
        System.out.println(result);
    }

    public static void move(int hy, int hx, int ty, int tx){
        if(hy == N-1 && hx == N-1) {
            result++;
            return;
        }

        //가로
        if(ty == hy && tx+1 == hx){
            int hdy, hdx, tdy, tdx;
            for (int i = 0; i < 2; i++) {
                hdy = hy + w_dy[i];
                hdx = hx + w_dx[i];
                tdy = ty + w_dy[i+2];
                tdx = tx + w_dx[i+2];

                if(hdy>=0 && hdy<N && hdx>=0 && hdx<N && tdy>=0 && tdy<N && tdx>=0 && tdx<N){
                    if(i == 1) {
                        if(arr[hdy][hdx] != 1 && arr[tdy][tdx] != 1 && arr[hdy-1][hdx] != 1 && arr[hdy][hdx-1] != 1){
                            move(hdy, hdx, tdy, tdx);
                        }
                    }else if(arr[hdy][hdx] != 1 && arr[tdy][tdx] != 1){
                        move(hdy, hdx, tdy, tdx);
                    }
                }
            }
        }

        //세로
        if(ty+1 == hy && tx == hx){
            int hdy, hdx, tdy, tdx;
            for (int i = 0; i < 2; i++) {
                hdy = hy + h_dy[i];
                hdx = hx + h_dx[i];
                tdy = ty + h_dy[i+2];
                tdx = tx + h_dx[i+2];

                if(hdy>=0 && hdy<N && hdx>=0 && hdx<N && tdy>=0 && tdy<N && tdx>=0 && tdx<N){
                    if(i == 1) {
                        if(arr[hdy][hdx] != 1 && arr[tdy][tdx] != 1 && arr[hdy-1][hdx] != 1 && arr[hdy][hdx-1] != 1){
                            move(hdy, hdx, tdy, tdx);
                        }
                    }else if(arr[hdy][hdx] != 1 && arr[tdy][tdx] != 1){
                        move(hdy, hdx, tdy, tdx);
                    }
                }
            }
        }

        //대각
        if(ty+1 == hy && tx+1 == hx){
            int hdy, hdx, tdy, tdx;
            for (int i = 0; i < 3; i++) {
                hdy = hy + d_dy[i];
                hdx = hx + d_dx[i];
                tdy = ty + d_dy[i+3];
                tdx = tx + d_dx[i+3];

                if(hdy>=0 && hdy<N && hdx>=0 && hdx<N && tdy>=0 && tdy<N && tdx>=0 && tdx<N){
                    if(i == 2) {
                        if(arr[hdy][hdx] != 1 && arr[tdy][tdx] != 1 && arr[hdy-1][hdx] != 1 && arr[hdy][hdx-1] != 1){
                            move(hdy, hdx, tdy, tdx);
                        }
                    }else if(arr[hdy][hdx] != 1 && arr[tdy][tdx] != 1){
                        move(hdy, hdx, tdy, tdx);
                    }
                }
            }
        }
    }
}
