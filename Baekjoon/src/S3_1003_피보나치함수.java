import java.io.*;

public class S3_1003_피보나치함수 {
    public int zero = 0;
    public int one = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            
        }
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            System.out.println(0);
            return 0;
        } else if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}