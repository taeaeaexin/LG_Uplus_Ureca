import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_117262_2xn타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int result = 0;

        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) arr[i] = (arr[i - 1] + arr[i - 2])%10007;

        System.out.println(arr[n]);
    }
}