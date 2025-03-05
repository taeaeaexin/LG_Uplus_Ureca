import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_2775_부녀회장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int k  = Integer.parseInt(br.readLine());
            int n  = Integer.parseInt(br.readLine());
            int[] num = new int[n+1];
            for (int j = 1; j <= n ; j++) {
                num[j] = j;
            }
            for (int j = 0; j < k; j++) {
                for (int l = 2; l <= n; l++) {
                    num[l] += num[l-1];
                }
            }
            System.out.println(num[n]);
        }
    }
}
