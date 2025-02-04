package ch07.methodpoly;

import java.io.IOException;

public class Super {
    // primitive type return
    int m(){
        System.out.println("Super -m()");
        return 1;
    }

    // reference type return
    B m2() {
        System.out.println("Super -m2()");
        return new B();
    }

    // access modifier
    // private - default - protected - public
    protected void m3() {
        System.out.println("Super -m3()");
    }

    // Exception <- IOException <- FilleNotFoundException
    void m4() throws IOException {
        System.out.println("Super -m4()");
    }
}
