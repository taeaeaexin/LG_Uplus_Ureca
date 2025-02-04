package ch07.methodpoly;

import java.io.IOException;

public class Test2 {
    public static void main(String[] args) throws Exception {
        // Overriding 조건
//        Super s = new Sub();
//        s.m();
//        s.m2();
//        s.m3();
//        s.m4();

        // Overriding 호출 관계
//        A x = new B();
//        x.a();
//        x.b(); //X
//        x.a(10); //X

//        B x = new C();
//        x.a(); // C -a()
//        x.c(); // X

//        A x = new C();
//        x.a();

//        C x = new D();
//        x.b(); // D - b()
//        x.a(10); // D - a(int i)

        // instance of
        {
            A a = new A();
            B b = new B();
            C c = new C();
            D d = new D();

            System.out.println(a instanceof A); //t
            System.out.println(b instanceof B); //t
            System.out.println(c instanceof C); //t
            System.out.println(d instanceof D); //t

            System.out.println(a instanceof A); //t
            System.out.println(b instanceof A); //t
            System.out.println(c instanceof A); //t
            System.out.println(d instanceof A); //t

            System.out.println(a instanceof B); //f
            System.out.println(b instanceof B); //t
            System.out.println(c instanceof B); //t
            System.out.println(d instanceof B); //t

            System.out.println(a instanceof C); //f
            System.out.println(b instanceof C); //f
            System.out.println(c instanceof C); //t
            System.out.println(d instanceof C); //t

            System.out.println(a instanceof D); //f
            System.out.println(b instanceof D); //f
            System.out.println(c instanceof D); //f
            System.out.println(d instanceof D); //t

            // A의 객체(B,C,D의 객체일수도 있는)가 전달 되었을 때
            // 서로 다른 객체 구별처리
            A x = new C();
            if(x instanceof D){
                System.out.println("D 객체");
            }else if(x instanceof C){
                System.out.println("C 객체");
            }else if(x instanceof B){
                System.out.println("B 객체");
            }else if(x instanceof A){
                System.out.println("A 객체");
            }
        }

    }
}
