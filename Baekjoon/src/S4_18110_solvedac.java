import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S4_18110_solvedac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        for (int i = 0; i < n; i++)
            num[i] = Integer.parseInt(br.readLine());

        Arrays.sort(num);

        int n1 = (int)(Math.round((double)n * 0.15));

        int sum = 0;
        for (int i = n1; i < n-n1; i++){
            sum += num[i];
        }
        double result = Math.round((double)sum / (n-n1*2));

        System.out.println((int)result);
    }
}
