import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class S1_1697_숨바꼭질 {
    public static int N, K;
    public static int[] isVisited = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }

    public static int bfs(int now){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        isVisited[now] = 1;
        queue.add(now);

        while(!queue.isEmpty()){
            int n = queue.poll();
            if(n == K) return isVisited[n]-1;

            if((0 <= n+1 && n+1 <= 100_000) && isVisited[n+1] == 0) {
                isVisited[n+1] = isVisited[n]+1;
                queue.add(n+1);
            }
            if((0 <= n-1 && n-1 <= 100_000) && isVisited[n-1] == 0) {
                isVisited[n-1] = isVisited[n]+1;
                queue.add(n-1);
            }
            if((0 <= n*2 && n*2 <= 100_000) && isVisited[n*2] == 0) {
                isVisited[n*2] = isVisited[n]+1;
                queue.add(n*2);
            }
        }
        return -1;
    }
}