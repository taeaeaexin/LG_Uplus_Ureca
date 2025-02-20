package basic.Ch22_문제풀기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// 가중치가 없는 최소값, 최단경로 <= bfs()
// 말처럼 움직이는 횟수 K 제한 
// 어느 특정 좌표에서 상하좌우 똔 말 처럼 움직이는 2가지를 고려
// bfs() 처리 visit 를 K 고려한 고민
public class G3_1600_말이되고픈원숭이_풀이 {
    static int K, W, H;
    static int[][] map;
    // visit 처리는 동일 좌표 방문 시, 이후 동일한 상황 반복되기 때문, 이 문제는 같은 좌표라 하더라도 K 값이 얼마나에 딸라 이후 상황 달라질 수 있다.
    // 3차원 배열 <= 좌표[][] + K
    static boolean[][][] visit;

    // 상,하,좌,우
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = {  0, 0,-1, 1 };

    // 말 움직임 8방
    static int[] hdy = { -2, -2, -1, -1,  2,  2,  1,  1 };
    static int[] hdx = { -1,  1, -2,  2, -1,  1, -2,  2 };

    // bfs queue
    static Queue<Node> queue = new ArrayDeque<>();

    static class Node{
        int y, x, k, d;
        Node(int y, int x, int k, int d){
            this.y = y; this.x = x; this.k = k; this.d = d;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visit = new boolean[H][W][K + 1];  // K 표현 : 0 ~ K

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }
    static void bfs() {
        // 시작점 좌표, K 이용 큐에 담는다. visit 도 함께
        visit[0][0][K] = true;
        queue.offer(new Node(0, 0, K, 0));

        while( ! queue.isEmpty() ) {
            Node node = queue.poll();

            // 목표 도달?
            if( node.y == H - 1 && node.x == W - 1) {
                System.out.println(node.d); // 도달
                return; // 종료
            }

            // 탐색 1 - 상하좌우
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if( ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k] ) continue;
                visit[ny][nx][node.k] = true;
                queue.offer(new Node(ny, nx, node.k, node.d + 1)); // K 사용 X
            }


            // 탐색 2 - 말처럼 8방 ( 단 K 를 사용할 수 있으면 )
            if( node.k == 0 ) continue;

            for (int i = 0; i < 8; i++) {
                int ny = node.y + hdy[i];
                int nx = node.x + hdx[i];
                if( ny < 0 || nx < 0 || ny >= H || nx >= W || map[ny][nx] == 1 || visit[ny][nx][node.k - 1] ) continue; // K 사용 O
                visit[ny][nx][node.k - 1] = true; // K 사용 O
                queue.offer(new Node(ny, nx, node.k - 1, node.d + 1)); // K 사용 O
            }

        }
        System.out.println(-1);
    }
}
