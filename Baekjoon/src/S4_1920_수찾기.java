import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1920_수찾기 {
    static int[] arr;
    static int[] arr2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            System.out.println(func(arr2[i], 0, arr.length - 1));
        }
    }

    public static int func(int num, int h_len, int t_len) {
        if (h_len > t_len) return 0;

        int mid = (h_len + t_len) / 2;

        if (num == arr[mid]) return 1;

        if (num < arr[mid]) return func(num, h_len, mid - 1);
        else return func(num, mid + 1, t_len);
    }
}
