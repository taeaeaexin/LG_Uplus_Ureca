import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_1260_dfs_bfs {
    static int N, M, V;
    static ArrayList<ArrayList<Integer>> graph; // 그래프 저장할 리스트
    static boolean[] visited; // 방문 여부 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 정점 개수
        M = Integer.parseInt(st.nextToken()); // 간선 개수
        V = Integer.parseInt(st.nextToken()); // 시작 정점

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 그래프이므로 양쪽에 추가
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 정점 번호가 작은 순서대로 방문하도록 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS 실행
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        // BFS 실행
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println();
    }

    // DFS (재귀)
    public static void dfs(int node) {
        System.out.print(node + " "); // 현재 노드 방문
        visited[node] = true;

        // 연결된 노드 탐색
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    // BFS (큐 사용)
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}