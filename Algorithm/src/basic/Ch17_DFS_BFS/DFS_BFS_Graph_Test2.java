package basic.Ch17_DFS_BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 그래프 자료구조 중 인접 리스트
// 재방문 X <= visit
// 가중치 X, 유향 => 자료구조 활용, 방문 순서 집중!!
/*
debugger 를 통한 adjList
[]
[2, 4]
[3, 4]
[2]
[3]
 */
public class DFS_BFS_Graph_Test2 {

    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visit; // 정점에 대해서 관리

    public static void main(String[] args) {
        // 정점 1, 2, 3, 4 와 연결 간선을 직접 처리
        // 정점의 개수만큼 ArrayList 객체를 adjList 에 추가
        // 정점번호의 dummy 가 있을 경우 dummy 를 위한 ArrayList 도 같이 추가
        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<Integer>()); //  0 번째는 dummy
        }

        // 간선
        // 1 -> 2, 4
        // 2 -> 3, 4
        // 3 -> 2
        // 4 -> 3
//		adjList.get(1);   <<= 1번 정점을 위한 ArrayList 객체 획득
        // 방문할 수 있는 정점만 관리
        adjList.get(1).add(2);
        adjList.get(1).add(4);
        adjList.get(2).add(3);
        adjList.get(2).add(4);
        adjList.get(3).add(2);
        adjList.get(4).add(3);

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
        List<Integer> list = adjList.get(v);
        for (Integer i : list) {
            if( visit[i] ) continue; // 갈 수 없거나, 이미 방문한 정점 제외
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

            List<Integer> list = adjList.get(v);
            for (Integer i : list) {
                if( visit[i] ) continue; // 갈 수 없거나, 이미 방문한 정점 제외
                queue.offer(i);
                visit[i] = true;
            }
        }
    }


}