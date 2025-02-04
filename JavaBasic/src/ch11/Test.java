package ch11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//자바는 기본적으로 돌다리도 두드려보고 건너라 개념
//생성자나 메소드를 만들 때 발생할 수 있는 문제를 예외로 만들고, 그 상황에 대한 대응책도 미리 만들어 둠
public class Test {
    public static void main (String[] args) throws Exception{
        //Error vs Exception
//        m();
//        m2();
//        m3();
//        m4(); //대응책이 없음
        //대응코드
        {
            //#1 직접 처리 : try-catch로 처리된 m3() 호출
            m3();

            try {
                m4();
            }catch(FileNotFoundException e) {
                System.out.println("예외 처리");
            }finally {
                System.out.println("항상 출력");
            }

            //#3 RuntimeException 처리
            //throws가 없어도 자동으로 위로 toss
            //try-catch 적용 가능
            m2();
        }
    }

    //Exception in thread "main" java.lang.StackOverflowError
    static void m() {
        m();
    }

    //Exception in thread "main" java.lang.NullPointerException
    //Compile Error (X)
    static void m2() {
        String str = null;
        System.out.println(str.length());
    }

    //Compile Error (O)
    //Unhandled exception type FileNotFoundException
    //Checked exception
//    static void m3() {
//        //throws FileNotFoundException으로 만들어진 메소드를 호출할 때 만약 파일이 없으면 어떻게 대응?
//        //대응책이 없으면 문법 오류 발생
//        FileInputStream fis = new FileInputStream("readme.md");
//    }

    static void m3() throws Exception{
        //#1 내가 직접 처리
//        try {
//            FileInputStream fis = new FileInputStream("read.md");
//            fis.read();
//        }catch (IOException e) {
//            System.out.println("파일 없으면 처리");
//        }finally {
//            System.out.println("항상 수행됨");
//        }

        //#2 회피 : 나를 호출한 곳으로 toss
        // 메소드 선언부에 throws 처리
    }

    static void m4() throws FileNotFoundException {
        System.out.println("m4()");
    }
}