package ch18.ex3;

import java.io.*;

public class Test {
    //Buffer 보조 스트림
    public static void main(String[] args) throws Exception{
        // copy() 입출력 stream
        InputStream is = new FileInputStream("C:/Temp/test.jpg");
        OutputStream os = new FileOutputStream("C:/Temp/test2.png");

        // copy() 입출력 + buffer stream
        InputStream is2 = new FileInputStream("C:/Temp/test.jpg");
        OutputStream os2 = new FileOutputStream("C:/Temp/test2.png");
        BufferedInputStream bis = new BufferedInputStream(is2);
        BufferedOutputStream bos = new BufferedOutputStream(os2);

        //buffer를 이용하지 않는 작업
        long nonBufferTime = copy(is, os);
        System.out.println(nonBufferTime);

        //buffer를 이용하는 작업
        long bufferTime = copy(bis, bos);
        System.out.println(bufferTime);

        is.close();
        os.close();

        bis.close();
        bos.close();
        is2.close();
        os2.close();

    }

    public static long copy(InputStream is, OutputStream os) throws Exception{
        long start = System.nanoTime();
        //복사
        while(true) {
            int data = is.read();
            if( data == -1 ) break;
            os.write(data);
        }

        long end = System.nanoTime();

        return end - start;
    }
}
