package basic.Ch23_문제풀기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_17471_게리맨더링 {
    static int N, result = 101;
    static ArrayList<ArrayList<Integer>> map;
    static int[] population;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력
        N = Integer.parseInt(br.readLine());
        map = new ArrayList<>();
        population = new int[N+1];

        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                map.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= N; i++) {
            result = Math.min(result, bfs(i));
        }
        System.out.println(result);
    }

    public static int bfs(int n){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);
        boolean[] visited = new boolean[N+1];
        visited[n] = true;
        int min = 101;
        while(!queue.isEmpty()){
            //값 끼리 뺄셈
            int A = 0;
            int B = 0;
            for (int i = 1; i <= N; i++) {
                if(visited[i]) A += population[i];
                else B += population[i];
            }
            if(min > Math.abs(A-B)) min = Math.abs(A-B);

            int node = queue.poll();
            for (int next:map.get(node)) {
                if(!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }

        //안 이어진 노드 있을 때
        if(connect()) return min;
        return -1;
    }

    public static boolean connect(){
        for (int i = 1; i <= N; i++) {
            if(map.get(i).isEmpty()) return false;
        }
        return true;
    }
}