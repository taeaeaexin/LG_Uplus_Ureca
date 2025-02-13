package basic.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class S1_2267_Address{
    //이동
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};

    //단지와 방문여부
    static int[][] map;
    static boolean[][] visited;

    //단지 번호와 결과
    static int address = 1;
    static List<Integer> result = new ArrayList<>();

    //변수 정의
    static int N, num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력 받고 초기화
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        result = new LinkedList<>();

        //단지 입력 받기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        //DFS
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == address && !visited[i][j]){
                    num = 0;
                    dfs(i, j);
                    result.add(num);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int r: result) System.out.println(r);
    }

    public static void dfs(int y, int x){
        visited[y][x] = true;
        num++;

        for (int i = 0; i < 4; i++) {
            int ny = dy[i] + y;
            int nx = dx[i] + x;

            if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(ny, nx);
                }
            }
        }
    }
}