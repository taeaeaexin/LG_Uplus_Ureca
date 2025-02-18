import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Mai {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] c = br.readLine().toCharArray();
            int result = 0;
            int score = 0;
            for (int j = 0; j < c.length; j++) {
                if(c[j] == 'O'){
                    score++;
                    result += score;
                }else{
                    score = 0;
                }
            }
            System.out.println(result);
        }
    }
}