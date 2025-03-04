import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2_15829_Hashing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int[] num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        for (int i = 0; i < N; i++) {
            num[i] = str.charAt(i) - '0' - 48;
        }
        for (int i = 0; i < N; i++) {
            result += (num[i] * Math.pow(31,i)) % 1234567891;
        }
        System.out.println(result);
    }
}
