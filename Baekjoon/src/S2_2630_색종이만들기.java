import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2630_색종이만들기 {
    public static int N;
    public static int white;
    public static int black;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st  = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        white = 0;
        black = 0;
        cutPaper(0,0, N);
        System.out.println(white);
        System.out.println(black);
    }

    public static void cutPaper(int y, int x, int n){
        int color = arr[y][x];
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] != color){
                    flag = false;
                    break;
                }
            }
        }

        if(flag){
            if(color == 0) white++;
            else black++;
        }

        cutPaper(0,0,n/2);
        cutPaper(0,n/2, n/2);
        cutPaper(n/2,0,n/2);
        cutPaper(n/2,n/2,0);
    }
}