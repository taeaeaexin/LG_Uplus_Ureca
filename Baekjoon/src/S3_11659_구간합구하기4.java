import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        arr[0] = 0;
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 1; i <= N; i++) arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            System.out.println(arr[l] - arr[s-1]);
        }
    }
}
