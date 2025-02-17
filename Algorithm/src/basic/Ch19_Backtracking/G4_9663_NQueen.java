package basic.Ch19_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class G4_9663_NQueen {
    static int N;
    static int result;
    static boolean[][] queen;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        queen = new boolean[N][N];
        result = 0;

        backtrack(0);
        System.out.println(result);
    }

    public static void backtrack(int y){
        if(y == N){
            result++;
            return;
        }

        for (int i = 0; i < N; i++) {
                if (test(y, i)) {
                    queen[y][i] = true;
                    backtrack(y+1);
                    queen[y][i] = false;
                }
        }
    }

    public static boolean test(int y, int x) {
        //위 확인
        for (int i = 0; i < y; i++) {
            if (queen[i][x]) return false;
        }

        //왼쪽 위 대각선 확인
        for (int i = 1; y - i >= 0 && x - i >= 0; i++) {
            if (queen[y - i][x - i]) return false;
        }

        //오른쪽 위 대각선 확인
        for (int i = 1; y - i >= 0 && x + i < N; i++) {
            if (queen[y - i][x + i]) return false;
        }

        return true;
    }
}
