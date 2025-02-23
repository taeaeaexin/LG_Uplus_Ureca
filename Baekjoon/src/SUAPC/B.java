package SUAPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int count = 0;
        int i = 0;
        boolean flag = true;
        while(flag){
            if(i == str.length()-5) flag = false;
            if(str.charAt(i) == 's'){
                if(str.substring(i, i+5).equals("skeep")) {
                    count++;
                    str = str.substring(0,i) + "0" + str.substring(i+5,str.length());
                }
            }
            i++;
        }

        for (int j = 0; j < str.length()-4; j++) {
            if(str.substring(j, j+5).equals("s0000")) count++;
        }
        System.out.println(count);
    }
}
