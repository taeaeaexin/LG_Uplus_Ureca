import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3_4153_직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==0 && b==0 && c==0) break;

            int temp = Math.max(a, Math.max(b, c));
            boolean flag = true;
            if(temp == a){
                flag = (Math.pow(a,2) == Math.pow(b,2) + Math.pow(c,2));
            }else if(temp == b){
                flag = (Math.pow(b,2) == Math.pow(a,2) + Math.pow(c,2));
            }else if(temp == c){
                flag = (Math.pow(c,2) == Math.pow(b,2) + Math.pow(a,2));
            }

            if(flag) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}
