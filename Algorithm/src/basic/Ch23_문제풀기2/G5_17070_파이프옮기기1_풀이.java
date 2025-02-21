package bj;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 완탐 - dfs
public class G5_17070_파이프옮기기1_풀이 {
    static int N, cnt;
    static int[][] map;
    // delta
    // 현재 방향에 따라 다음 이동 방향이 제한 <= 현재 방향에 따른 y, x 의 변화량
    // 현재 -> 다음
    static int[][][] delta = {
            { {1, 1}, {0, 1}, {1, 0} }, // 대각선 0 => 대각선, 가로, 세로
            { {1, 1}, {0, 1}, {0, 0} }, // 가로 1  => 대각선, 가로, 세로 (dummy)
            { {1, 1}, {0, 0}, {1, 0} }  // 세로 2  => 대각선, 가로(dummy), 세로
    };

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1]; // 0 dummy

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 풀이 dfs
        dfs(1, 2, 1); // 1,2 좌표에서 가로 로 시작

        System.out.println(cnt);
    }
    static void dfs(int y, int x, int d) { // d: 현재 y,x 좌표에 놓여진 방향

        // 현재 좌표가 N, N 확인
        if( y == N && x == N ) {
            cnt++;
            return;
        }

        // delta 를 이용한 탐색 이어나간다. for 문이 기저조건 역할
        for (int i = 0; i < 3; i++) { // i 는 대각선, 가로, 세로

            int ny = y + delta[d][i][0];
            int nx = x + delta[d][i][1];

            // dummy ( 가면 안되는 방향 ) 처리
            if( y == ny && x == nx ) continue;

            // 범위
            if( ny > N || nx > N || map[ny][nx] == 1 ) continue; // 참고로 visit 필요 X

            // 대각선 이동의 측면
            if( i == 0 && ( map[ny][nx-1] == 1 || map[ny-1][nx] == 1) ) continue;

            dfs(ny, nx, i);
        }
    }
}