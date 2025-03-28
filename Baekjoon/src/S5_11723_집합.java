import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        boolean[] num = new boolean[21];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            switch (str) {
                case "add":
                    num[n] = true;
                    break;
                case "remove":
                    num[n] = false;
                    break;
                case "check":
                    if (num[n]) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "toggle":
                    if (num[n]) num[n] = false;
                    else num[n] = true;
                    break;
                case "all":
                    for (int j = 1 ; j <= 20; j++) {
                        num[j] = true;
                    }
                    break;
                case "empty":
                    for (int j = 1 ; j <= 20 ; j++) {
                        num[j] = false;
                    }
                    break;
            }
        }
    }

}
