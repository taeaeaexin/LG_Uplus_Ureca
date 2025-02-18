package basic.Ch20_Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//로봇청소기와 방 주어졌을 때, 청소 영역의 개수
//방 NxM (r,c)
//로봇청소기 (동서남북)
//현재 칸 청소
//동서남북 청소 됨 -> 후진 (뒤에 벽있으면 작동 중지)
//안됨 -> 반시계 90도 회전 후 청소

public class G5_14503_로봇청소기 {
    static int N, M, result;
    static Robot robot;
    static int[][] arr;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static class Robot {
        int r, c, d;
        Robot(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        robot = new Robot(r, c, d);

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0;
        cleanRoom();
        System.out.println(result);
    }

    public static void cleanRoom() {
        while (true) {
            if (arr[robot.r][robot.c] == 0) {
                arr[robot.r][robot.c] = 2;
                result++;
            }

            boolean cleaned = false;
            for (int i = 0; i < 4; i++) {
                robot.d = (robot.d + 3) % 4;
                int ny = robot.r + dy[robot.d];
                int nx = robot.c + dx[robot.d];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && arr[ny][nx] == 0) {
                    robot.r = ny;
                    robot.c = nx;
                    cleaned = true;
                    break;
                }
            }

            if (!cleaned) {
                int backY = robot.r - dy[robot.d];
                int backX = robot.c - dx[robot.d];

                if (backY >= 0 && backY < N && backX >= 0 && backX < M && arr[backY][backX] != 1) {
                    robot.r = backY;
                    robot.c = backX;
                } else {
                    break;
                }
            }
        }
    }
}