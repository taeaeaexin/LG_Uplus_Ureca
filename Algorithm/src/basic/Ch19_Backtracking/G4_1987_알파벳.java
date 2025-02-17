package basic.Ch19_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1987_알파벳 {
    static int R, C;
    static int result;
    static char[][] arr;
    static boolean[] alpha = new boolean[26];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];

        for (int i = 0; i < R; i++) arr[i] = bf.readLine().toCharArray();

        backtrack(0, 0, 1);
        System.out.println(result);
    }

    public static void backtrack(int y, int x, int cnt){
        result = Math.max(result, cnt);
        alpha[arr[y][x] - 'A'] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && ny < R && nx >= 0 && nx <  C && !alpha[arr[ny][nx]-'A']){
                backtrack(ny, nx, cnt+1);
            }
        }
        alpha[arr[y][x] - 'A'] = false;
    }
}