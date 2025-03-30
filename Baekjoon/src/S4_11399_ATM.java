import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P);
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                result += P[j];
            }
        }
        System.out.println(result);
    }
}