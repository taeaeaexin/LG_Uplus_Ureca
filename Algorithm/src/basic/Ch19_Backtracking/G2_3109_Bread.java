package basic.Ch19_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2_3109_Bread {
    static int R, C, cnt;
    static char[][] arr;
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][];

        for (int i = 0; i < R; i++) {
           arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            if(backtrack(i, 0)) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean backtrack(int y, int x){
        int nx = x+1;
        if(nx == C - 1) return true;

        for (int i = 0; i < 3; i++) {
            int ny = y + dy[i];

            if(ny < 0 || ny >= R || arr[ny][nx] == 'x') continue;
            arr[ny][nx] = 'x';
            if(backtrack(ny, nx)) return true;
        }

        return false;
    }
}
