package basic.Ch22_문제풀기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 고대문명유적탐사_풀이 {
    static int K,M;
    static int[][] map = new int[5][5];
    static Queue<Integer> q = new LinkedList<>();    // 새로운 유물 조각
    static boolean[][] visited = new boolean[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 5; i++) {       // 유물 지도 받기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) { // 새로운 유물 조각 입력 받기
            int a = Integer.parseInt(st.nextToken());
            q.offer(a); // 큐에 새로운 유물배열을 입력해서 애니팡되면 끄집어 쓰기
        }
        int ans = 0;   // 정답

        for (int i = 0; i < K; i++) {   // K번 탐사한다 했으니 탐사하는 코드
            int val = 0;
            int xx = 0; // 이번 턴 최종 x 좌표
            int yy = 0; // 이번 턴 최종 y 좌표
            int angle = 0;  // 이번 턴 최종 각도
            boolean flag = false;   // 유물 확인

            // 회전 하는 코드 : 90 도 만큼 3번 회전함
            for (int a = 0; a < 3; a++) {   // 각도가 가장 작은 방법 (0 = 90, 1 = 180, 2 = 270)
                for (int y = 1; y <= 3; y++) {    // 열이 가장 작은 구간 (?) 무슨말임
                    for (int x = 1; x <= 3; x++) {    // 중심 좌표 기준 (행이 가장 작은 구간)
                        int[][] nowMap = makeMap(x, y, a);
                        visited = new boolean[5][5];

                        // 2. 유물 획득
                        int tmp = 0;
                        for (int j = 0; j < 5; j++) {
                            for (int k = 0; k < 5; k++) {
                                if (!visited[j][k]) {
                                    tmp += bfs(j, k, nowMap);
                                }
                            }
                        }
                        if (val < tmp) {
                            val = tmp;
                            xx = x;
                            yy = y;
                            angle = a;
                        }
                    }
                }
            }

            if (xx == 0 && yy == 0) break;
            map = makeMap(xx, yy, angle);
            val = 0;

            while (true) {
                int tmp = 0;

                visited = new boolean[5][5];
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (!visited[j][k]) {
                            tmp += bfs(j, k, map);
                        }
                    }
                }
                if (tmp <= 0) break;
                val += tmp;
                refreshMap();
            }
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }
    static int[][] copyMap(int[][] target ) {
        int[][] tmp = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tmp[i][j] = target[i][j];
            }
        }
        return tmp;
    }
    static int[][] makeMap(int x, int y, int angle) {
        int[][] tmp = copyMap(map);

        switch (angle) {
            case 0: //90도
                tmp = rotation (x, y, tmp);
                break;
            case 1: // 180도
                for (int i = 0; i < 2; i++) {
                    tmp = rotation(x, y, tmp);
                }
                break;
            case 2: // 270도
                for (int i = 0; i < 3; i++) {
                    tmp = rotation (x, y, tmp);
                }
                break;
        }
        return tmp;
    }
    static int[][] rotation(int x, int y, int[][] arr) {
        int[][] tmp3 = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tmp3[j][2-i] = arr[i+x-1][j+y-1];
            }
        }
        int[][] tmp5 = copyMap(arr);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tmp5[x+i-1][y+j-1] = tmp3[i][j];
            }
        }
        return tmp5;
    }

    static int bfs(int x, int y, int[][] nowMap) {  // 연결된 유물 조각 개수 (3개 이상일 때 리턴, 3개 미만일때 0 리턴))
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1; // 유물 조각 개수
        List<int[]> list = new ArrayList<>();

        while (!q.isEmpty()) {
            int[] now = q.poll();
            list.add(new int[]{now[0], now[1]});

            for (int[] dir : dirs) {
                int nx = now[0] + dir[0];
                int ny = now[1] + dir[1];
                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                    if (!visited[nx][ny] && (nowMap[nx][ny] == nowMap[now[0]][now[1]])) {
                        cnt += 1;
                        list.add(new int[]{nx, ny});
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        if (cnt >= 3) {
            for (int[] cur : list) {
                nowMap[cur[0]][cur[1]] = 0;
            }
            return cnt;
        }
        return 0;
    }
    static void refreshMap() {
        for (int i = 0; i < 5; i++) {
            for (int j = 4; j >= 0; j--) {
                if (map[j][i] == 0 && !q.isEmpty()) {
                    map[j][i] = q.poll();
                }
            }
        }
    }

    static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            System.out.println();
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
        }
        System.out.println();
    }

}