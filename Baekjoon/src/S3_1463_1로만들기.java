import java.io.*;

public class S3_1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        while(N != 1){
            if(N % 3 == 0) {
                N /= 3;
                result++;
            }else if(N % 2 == 0) {
                N /= 2;
                result++;
            }else {
                N--;
                result++;
            }
        }

        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
