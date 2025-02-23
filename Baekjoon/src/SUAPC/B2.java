package SUAPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int count = 0;
        boolean flag = true;
        while (flag) {
            int i = str.indexOf("skeep");
            int j = -1;
            if (str.indexOf("s0000") != -1) j = str.indexOf("s0000");
            else if(str.indexOf("sk000") != -1) j = str.indexOf("sk000");
            else if(str.indexOf("s0e00") != -1) j = str.indexOf("s0e00");
            else if(str.indexOf("s00e0") != -1) j = str.indexOf("s00e0");
            else if(str.indexOf("s000p") != -1) j = str.indexOf("s000p");
            else if(str.indexOf("ske00") != -1) j = str.indexOf("ske00");
            else if(str.indexOf("sk0e0") != -1) j = str.indexOf("sk0e0");
            else if(str.indexOf("sk00p") != -1) j = str.indexOf("sk00p");
            else if(str.indexOf("s0ee0") != -1) j = str.indexOf("s0ee0");
            else if(str.indexOf("s0e0p") != -1) j = str.indexOf("s0e0p");
            else if(str.indexOf("s00ep") != -1) j = str.indexOf("s00ep");
            else if(str.indexOf("skee0") != -1) j = str.indexOf("skee0");
            else if(str.indexOf("ske0p") != -1) j = str.indexOf("ske0p");
            else if(str.indexOf("sk0ep") != -1) j = str.indexOf("sk0ep");
            else if(str.indexOf("s0eep") != -1) j = str.indexOf("s0eep");

            if (i == -1 && j == -1) break;

            if (i != -1 && i < str.length() - 4) {
                str = str.substring(0, i) + "0" + str.substring(i + 5, str.length());
                count++;
            } else if (j != -1 && j < str.length() - 4) {
                str = str.substring(0, j) + "0" + str.substring(j + 5, str.length());
                count++;
            }
        }
        System.out.println(count);
    }
}