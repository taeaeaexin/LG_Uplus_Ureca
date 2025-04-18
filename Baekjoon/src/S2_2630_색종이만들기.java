import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_2630_색종이만들기 {
    public static int[] color = {0,0};
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st  = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutPaper(0,0, N);
        System.out.println(color[0]);
        System.out.println(color[1]);
    }

    public static void cutPaper(int y, int x, int n){
        if(n == 1) {
            color[arr[y][x]]++;
            return;
        }

        int c = arr[y][x];
        boolean flag = true;

        for (int i = y; i < y+n; i++) {
            for (int j = x; j < x+n; j++) {
                if(arr[i][j] != c){
                    flag = false;
                    break;
                }
            }
        }

        if(flag) {
            color[c]++;
            return;
        }

        cutPaper(y,x,n/2);
        cutPaper(y,x+n/2,n/2);
        cutPaper(y+n/2,x,n/2);
        cutPaper(y+n/2,x+n/2,n/2);
    }
}