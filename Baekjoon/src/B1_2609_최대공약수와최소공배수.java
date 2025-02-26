import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1_2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result1 = 0;
        int result2 = 0;

        int min = Math.min(a, b);
        int max = Math.max(a, b);

        int mi = min;
        int ma = max;

        while(true){
            if(max % mi == 0 && min % mi == 0){
                result1 = mi;
                break;
            }
            mi--;
        }

        result2 = max/result1 * min/result1 * result1;


        System.out.println(result1);
        System.out.println(result2);
    }
}