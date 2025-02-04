package ch07.methodpoly;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Sub extends Super{
    int m(){
        System.out.println("Sub -m()");
        return 1;
    }

    // Super의 m2() 리턴 타입이 B
    // 다형성에 의해 B와 B의 하위 클래스 타입을 리턴할 수 있다.
    B m2() {
        System.out.println("Sub -m2()");
        return new D();
    }

    // 부모 클래스의 접근 제한을 더 줄일 수 없다.
    protected void m3() {
        System.out.println("Sub -m3()");
    }

    // 부모 클래스의 처리 예외보다 더 일반적인 예외를처리할 수 없다.
    void m4() throws IOException {
        System.out.println("Sub -m4()");
    }
}