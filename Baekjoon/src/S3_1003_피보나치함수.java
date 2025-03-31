//import java.io.*;
//
//public class S3_1003_피보나치함수 {
//    public static int zero;
//    public static int one;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int T = Integer.parseInt(br.readLine());
//        for (int i = 0; i < T; i++) {
//            int N = Integer.parseInt(br.readLine());
//            zero = 0;
//            one = 0;
//            fibonacci(N);
//            bw.write(zero + " " + one + "\n");
//        }
//        bw.flush();
//        br.close();
//        bw.close();
//    }
//
//    public static int fibonacci(int n) {
//        if (n == 0) {
//            zero++;
//            return 0;
//        } else if (n == 1) {
//            one++;
//            return 1;
//        } else {
//            return fibonacci(n - 1) + fibonacci(n - 2);
//        }
//    }
//}