import java.io.*;
import java.util.StringTokenizer;

public class S5_11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int num = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            int n = 0;
            switch (str) {
                case "add":
                    n = Integer.parseInt(st.nextToken());
                    num |= (1 << n-1);
                    break;
                case "remove":
                    n = Integer.parseInt(st.nextToken());
                    num &= ~(1 << n-1);
                    break;
                case "check":
                    n = Integer.parseInt(st.nextToken());
                    bw.write(((num & (1 << (n - 1))) > 0) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    n = Integer.parseInt(st.nextToken());
                    num ^= (1 << (n - 1));
                    break;
                case "all":
                    num = (1 << 20)-1;
                    break;
                case "empty":
                    num = 0;
                    break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

}
