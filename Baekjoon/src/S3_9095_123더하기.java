import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3_9095_123더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(onetwothree(n, 0));
        }

    }

    public static int onetwothree(int n, int count){
        if(n == 0) return count;
        
    }
}
