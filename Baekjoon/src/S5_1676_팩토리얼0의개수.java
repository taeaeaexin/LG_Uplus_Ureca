import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5_1676_팩토리얼0의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while(n >= 5){
            count += n / 5;
            n /= 5;
        }
        System.out.println(count);
    }
}