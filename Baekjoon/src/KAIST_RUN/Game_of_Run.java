package KAIST_RUN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game_of_Run {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(n);
        }
    }
}
