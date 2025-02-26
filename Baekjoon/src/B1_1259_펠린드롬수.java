import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_1259_펠린드롬수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) break;
            String result = "yes";
            int num2 = num;

            String number = String.valueOf(num);
            for (int i = 0; i < number.length(); i++) {
                if(number.charAt(i) != number.charAt(number.length()-i-1)){
                    result = "no";
                    break;
                }
            }
            System.out.println(result);
        }

    }
}