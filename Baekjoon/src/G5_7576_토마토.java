import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_7576_토마토 {
    public static Queue<int[]> queue = new ArrayDeque<>();
    public static int M, N;
    public static int[][] tomato;
    public static int[] dy = {1,-1,0,0};
    public static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1) queue.offer(new int[]{i ,j});
            }
        }

        bfs();

        int day = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tomato[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                day = Math.max(day, tomato[i][j]);
            }
        }
        System.out.println(day-1);
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int y = now[0];
            int x = now[1];

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(0 <= ny && ny < N && 0 <= nx && nx < M && tomato[ny][nx] == 0){
                    tomato[ny][nx] = tomato[y][x]+1;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }
}