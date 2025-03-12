import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S3_2108_통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        int max = -4001;
        int min = 4001;
        int[] mode = new int[8002];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);

            mode[arr[i]+4000]++;
        }

        int cnt = 0;
        int mode_max = 0;

        boolean flag = false;
        for (int i = min+4000; i <= max+4000; i++) {
            if(cnt < mode[i]) {
                cnt = mode[i];
                mode_max = i-4000;
                flag = true;
            }else if(cnt == mode[i] && flag == true){
                mode_max = i-4000;
                flag = false;
            }
        }

        int ave = (int)Math.round((double)sum/N);
        Arrays.sort(arr);

        System.out.println(ave);
        System.out.println(arr[N/2]);
        System.out.println(mode_max);
        System.out.println(max-min);
    }
}