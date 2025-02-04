package ch05;

public class test1 {
    public static void main(String[] args) {
        // 참조타입 객체 생성 == 비교 <- heap의 객체 위치 비교
        MyClass mc1 = new MyClass();
        MyClass mc2 = new MyClass();
        MyClass mc3 = mc1;

        System.out.println(mc1 == mc2);
        System.out.println(mc1 == mc3);

        // null
        System.out.println(mc1);
        MyClass mc4 = null;
        System.out.println(mc4);

        mc4 = getObject();
        System.out.println(mc4.getName());
    }

    static MyClass getObject() {
        return new MyClass();
    }
}
