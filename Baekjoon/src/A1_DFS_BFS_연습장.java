import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1_DFS_BFS_연습장 {
    //예상 결과 1 2 4 3 / 1 2 3 4
    static int N = 4, M = 5, V = 1;
    static int[][] arr = {{1, 2}, {1, 3}, {1, 4}, {2, 4}, {3, 4}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = 2;

        for (int i = 0; i < test_case; i++) {
            dfs(V);
            bfs(V);
        }
    }

    public static void dfs(int node){

    }

    public static void bfs(int node){

    }
}