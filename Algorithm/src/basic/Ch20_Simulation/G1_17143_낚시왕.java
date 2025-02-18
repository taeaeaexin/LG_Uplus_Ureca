package basic.Ch20_Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1_17143_낚시왕 {
    static int R, C, M, result;
    static Shark[][] shark;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static class Shark {
        int r, c, s, d, z;
        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        shark = new Shark[R][C];

        if (M == 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            shark[r][c] = new Shark(r, c, s, d, z);
        }

        for (int col = 0; col < C; col++) {
            fishing(col);
            shark_move();
        }

        System.out.println(result);
    }

    public static void fishing(int col) {
        for (int i = 0; i < R; i++) {
            if (shark[i][col] != null) {
                result += shark[i][col].z;
                shark[i][col] = null;
                return;
            }
        }
    }

    public static void shark_move() {
        Shark[][] newShark = new Shark[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (shark[i][j] == null) continue;

                Shark s = shark[i][j];
                int ny = s.r, nx = s.c, speed = s.s, dir = s.d, size = s.z;

                if (dir < 2) speed %= (2 * (R - 1));  // 최적화
                else speed %= (2 * (C - 1));

                for (int k = 0; k < speed; k++) {
                    int ty = ny + dy[dir];
                    int tx = nx + dx[dir];

                    if (ty < 0 || ty >= R || tx < 0 || tx >= C) {
                        dir = (dir % 2 == 0) ? dir + 1 : dir - 1;  // 방향 변경
                        ty = ny + dy[dir];
                        tx = nx + dx[dir];
                    }
                    ny = ty;
                    nx = tx;
                }

                if (newShark[ny][nx] == null || newShark[ny][nx].z < size) {
                    newShark[ny][nx] = new Shark(ny, nx, s.s, dir, size);
                }
            }
        }
        shark = newShark;
    }
}
