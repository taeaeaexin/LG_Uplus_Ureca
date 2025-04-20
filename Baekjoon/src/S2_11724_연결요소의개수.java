import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S2_11724_연결요소의개수 {
    public static int N, M, result;
    public static ArrayList<Integer>[] list;
    public static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        isVisited = new boolean[N+1];

        for (int i = 0; i < N+1; i++) list[i] = new ArrayList<>();

        int result = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            if(!isVisited[i]){
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    public static void dfs(int n){
        isVisited[n] = true;
        for (int i = 0; i < list[n].size(); i++) {
            int N = list[n].get(i);
            if(!isVisited[N]){
                dfs(N);
            }
        }
    }
}