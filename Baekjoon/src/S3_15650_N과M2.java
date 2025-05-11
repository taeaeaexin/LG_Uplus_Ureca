import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_15650_N과M2 {
    public static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] pick = new int[M];
        dfs(pick,1, 0);
    }

    public static void dfs(int[] pick, int point, int size){
        if(size == M){
            for (int i = 0; i < M; i++) {
                System.out.print(pick[i]+" ");
            }
            System.out.println();
            return;
        }

        for (int i = point; i <= N; i++) {
            pick[size] = i;
            dfs(pick, i+1, size+1);
        }
    }
}