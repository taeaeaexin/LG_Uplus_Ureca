import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1_2063_철사연결 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Test_case = Integer.parseInt(br.readLine());

        for (int i = 0; i < Test_case; i++) {
            int N = Integer.parseInt(br.readLine());
            double[] arr = new double[N];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[j] = Double.parseDouble(st.nextToken());
            }

            if (N == 1) {
                System.out.println("NO");
                continue;
            }

            if (N == 2) {
                System.out.println(arr[0] == arr[1] ? "YES" : "NO");
                continue;
            }

            Arrays.sort(arr);
            double max = arr[N-1];
            double sum = 0;

            boolean flag = false;
            for (int j = 0; j < N-1; j++) {
                sum += arr[j];
                if (sum >= arr[j+1]) {
                    flag = true;
                    break;
                }
            }

            System.out.println((flag) ? "YES" : "NO");
        }
    }
}
