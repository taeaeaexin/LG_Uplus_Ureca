package ch07;

public class Child extends Parent {
    public Child(){
        super(1); // 없으면 컴파일러가 넣어 준다.
    }

    int n = 20;

    public void m(){
        System.out.println(n);
        System.out.println(this.n);
        System.out.println(super.n);
    }
}
