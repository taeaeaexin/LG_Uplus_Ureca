import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1_28702_FizzBuzz {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false;
        int result = 0;
        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            if(str.charAt(0) == 'F' || str.charAt(0) == 'B'){
                if(flag) result++;
            }else{
                result = Integer.parseInt(str);
                flag = true;
            }
        }

        result++;
        if(result % 5 == 0 && result % 3 == 0){
            System.out.println("FizzBuzz");
        }else if(result % 3 == 0){
            System.out.println("Fizz");
        }else if(result % 5 == 0){
            System.out.println("Buzz");
        }else{
            System.out.println(result);
        }
    }
}
