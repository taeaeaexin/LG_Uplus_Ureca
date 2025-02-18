package basic.Ch20_Simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 시물레이션
// 현재 아기상어 자리에서 반복적으로 최단경로의 물고기를 잡으러 가는 행위 반복 <= bfs
// 몇 초동안 계속 물고기를 먹을 수 있는 지 <= 계속 물고기를 먹는 동안 이동한 거리 <= bfs() 수행마다 걸린 시간(거리)
public class G3_16236_아기상어 {
    static int N, sy, sx, sSize, sEatCnt, ans;
    static int[][] map;

    // bfs
    static Queue<Node> queue = new ArrayDeque<>();
    static boolean[][] visit;
    // delta
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = {  0, 0,-1, 1 };

    public static void main(String[] args) throws Exception {
        // 입력, 자료구조
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if( n == 9 ) { // 아기 상어
                    sy = i;
                    sx = j;
                }

                map[i][j] = n;
            }
        }

        // 시물레이션
        sSize = 2;

        // 반복횟수 미정 <= while
        while(true) {
            // 최단거리의 물고기를 먹었으면 먹는 과정에서 이동한 거리를 return, 못 먹으면 0 리턴
            int cnt = bfs();
            if( cnt == 0 ) break;
            ans += cnt;
        }

        System.out.println(ans);
    }
    // 최단거리의 물고기를 먹으려고 시도
    // 성공 : 이동한 거리(시간) 리턴
    // 실패 : 0 리턴
    static int bfs() {
        // 먹이 후보
        int minDis = Integer.MAX_VALUE; // bfs() 과정에서 먹을 수 있는 물고기를 찾으면 갱신
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;

        // visit 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visit[i][j] = false;
            }
        }

        // 현재 아기상어의 위치에서부터 시작
        visit[sy][sx] = true;
        queue.offer(new Node(sy, sx, 0));

        while( ! queue.isEmpty() ) {
            Node node = queue.poll();
            int y = node.y;
            int x = node.x;
            int d = node.d; // 상어위치부터 탐색해 온 거리

            // 먹을 수 있는 물고기를 만나면
            if( map[y][x] < sSize && map[y][x] != 0 ) {

                if( d < minDis ) { //  거리가 더 작은
                    minDis = d;
                    minY = y;
                    minX = x;
                }else if( d == minDis ) { // 거리가 같으면
                    if( y < minY ) {
                        minDis = d;
                        minY = y;
                        minX = x;
                    }else if( y == minY ) {
                        if( x < minX ) {
                            minDis = d;
                            minY = y;
                            minX = x;
                        }
                    }
                }
            } // if

            // 가지치기
            if( d + 1 >= minDis ) continue;

            // 4방탐색
            for (int i = 0; i < dx.length; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                // range, visit, size 체크
                if( ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] > sSize ) continue;

                visit[ny][nx] = true;
                queue.offer(new Node(ny, nx, node.d + 1));
            } // for
        } // while

        // 물고기를 먹는 작업 성공/실패
        if( minDis == Integer.MAX_VALUE ) return 0; // 먹이를 찾지 못한 경우
        else { // 물고기를 찾아 먹은 경우 후처리
            sEatCnt++;
            if( sEatCnt == sSize ) {
                sSize++;
                sEatCnt = 0;
            }
            map[minY][minX] = 0; // 먹은 물고기 자리
            map[sy][sx] = 0; // 상어가 출발한 자리

            sy = minY;
            sx = minX;
        }

        return minDis;
    }

    static class Node{
        int y, x, d; // d: 거리
        Node(int y, int x, int d){
            this.y = y; this.x = x; this.d = d;
        }
    }
}