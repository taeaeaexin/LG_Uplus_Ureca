package basic.Ch13_DivideNConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_1074_Z {
    static int result = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        //배열 크기와 r,c를 인자로 넣음
        func((int)Math.pow(2, N), r, c);
        System.out.println(result);
    }

    public static void func(int size, int r, int c){
        //크기가 1이면 return
        if(size == 1) return;

        //아니면 4분할
        if(r < size/2 && c < size/2){ //2사분면에 속하면
            func(size/2, r, c);

        }else if(r < size/2 && c >= size/2){ //1사분면에 속하면
            result += size * size/4;
            func(size/2, r, c-size/2);

        }else if(r >= size/2 && c < size/2) { //3사분면에 속하면
            result += (size * size/4) * 2;
            func(size/2, r - size/2, c);

        }else { //4사분면에 속하면
            result += (size * size/4) * 3;
            func(size/2, r-size/2, c-size/2);
        }
    }
}