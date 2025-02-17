package basic.Ch17_DFS_BFS;

import java.util.ArrayDeque;
import java.util.Queue;

// 그래프 자료구조 중 인접 행렬
// 재방문 X <= visit
// 가중치 X, 유향 => 자료구조 활용, 방문 순서 집중!!
/*
debugger 를 통한 matrix
[false, false, false, false, false]
[false, false, true, false, true]
[false, false, false, true, true]
[false, false, true, false, false]
[false, false, false, true, false]
 */
public class DFS_BFS_Graph_Test1 {

    static boolean[][] matrix;
    static boolean[] visit; // 정점에 대해서 관리

    public static void main(String[] args) {
        // 정점 1, 2, 3, 4 와 연결 간선을 직접 처리
        matrix = new boolean[5][5]; // 0 dummy
        // 간선
        // 1 -> 2, 4
        // 2 -> 3, 4
        // 3 -> 2
        // 4 -> 3
        matrix[1][2] = true;
        matrix[1][4] = true;
        matrix[2][3] = true;
        matrix[2][4] = true;
        matrix[3][2] = true;
        matrix[4][3] = true;

        // visit 초기화
        visit = new boolean[5]; // 0 dummy

//		dfs(1);  // 사직 정점 1

        bfs(1);
    }

    static void dfs( int v ) {
        // 해당 정점에서 할 일 진행
        visit[v] = true;
        System.out.print(v + " -> ");

        // dfs() 를 이어갈 수 있는 다음 정점 방문
        for (int i = 1; i <= 4; i++) {
            if( ! matrix[v][i] || visit[i] ) continue; // 갈 수 없거나, 이미 방문한 정점 제외
            dfs(i);
        }
    }

    static void bfs( int sv ) {
        // 시작  Node 를 queue 에 넣고 출발
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer( sv );
        visit[sv] = true;

        while( ! queue.isEmpty() ) {

            int v = queue.poll();
            System.out.print(v + " -> ");

            for (int i = 1; i <= 4; i++) {
                if( ! matrix[v][i] || visit[i] ) continue; // 갈 수 없거나, 이미 방문한 정점 제외
                queue.offer(i);
                visit[i] = true;
            }
        }
    }


}