package basic.Ch22_문제풀기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G3_1600_말이되고픈원숭이 {
    static int K, W, H;

    static int[][] map;
    static boolean[][][] visited;

    static int[] h_dy = {-2,-1,1,2,2,1,-1,-2};
    static int[] h_dx = {1,2,2,1,-1,-2,-2,-1};
    static int[] m_dy = {-1,1,0,0};
    static int[] m_dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][K+1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }            
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1], moveCount = cur[2], horseUsed = cur[3];

            if (y == H - 1 && x == W - 1) return moveCount;

            for (int i = 0; i < 4; i++) {
                int ny = y + m_dy[i], nx = x + m_dx[i];

                if (isValid(ny, nx) && !visited[ny][nx][horseUsed] && map[ny][nx] == 0) {
                    visited[ny][nx][horseUsed] = true;
                    q.add(new int[]{ny, nx, moveCount + 1, horseUsed});
                }
            }

            if (horseUsed < K) {
                for (int i = 0; i < 8; i++) {
                    int ny = y + h_dy[i], nx = x + h_dx[i];

                    if (isValid(ny, nx) && !visited[ny][nx][horseUsed + 1] && map[ny][nx] == 0) {
                        visited[ny][nx][horseUsed + 1] = true;
                        q.add(new int[]{ny, nx, moveCount + 1, horseUsed + 1});
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isValid(int y, int x) {
        return (y >= 0 && y < H && x >= 0 && x < W);
    }
}