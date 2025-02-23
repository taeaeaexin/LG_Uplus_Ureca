import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3_30802_웰컴키트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] size = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i = 0; i < 6; i++) {
            if(size[i]%T == 0){
                result += size[i]/T;
            }else result += size[i]/T + 1;
        }
        System.out.println(result);
        System.out.println(N/P+" "+N%P);
    }
}