import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1_14940_쉬운최단거리 {
    public static int n, m, startY, startX;
    public static int[][] map, result;
    public static boolean[][] visited;
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    startY = i;
                    startX = j;
                }
                result[i][j] = -1;
            }
        }

        bfs(startY, startX);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    System.out.print("0 ");
                } else {
                    System.out.print(result[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void bfs(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        result[y][x] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0], cx = cur[1];

            for (int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (!visited[ny][nx] && map[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        result[ny][nx] = result[cy][cx] + 1;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
