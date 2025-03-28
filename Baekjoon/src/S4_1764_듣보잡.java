import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class S4_1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> hash = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) hash.add(br.readLine());
        while(M-- > 0) {
            String str = br.readLine();
            if(hash.contains(str)){
                list.add(str);
            }
        }

        Collections.sort(list);
        bw.write(list.size()+"\n");
        for (String str:list){
            bw.write(str+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}