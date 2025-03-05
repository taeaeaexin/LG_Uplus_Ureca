import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2_15829_Hashing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 0;
        long pow = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        for (int i = 0; i < N; i++) {
            result += (str.charAt(i) - '0' - 48) * pow;
            pow = (pow * 31) % 1234567891;
        }
        System.out.println(result % 1234567891);
    }
}
