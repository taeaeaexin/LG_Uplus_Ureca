package ch12;

public class Test1 {
    //Wrapper 클래스
    public static void main(String[] args) {
        //Boxing
        Integer obj = 100;
        System.out.println(obj);

        //Unboxing
        int value = obj;
        System.out.println(value);

        int result = obj + 100; //자동으로 연산자에 의해 unboxing
        System.out.println(result);

        //객체 비교
        Integer obj1 = 300;
        Integer obj2 = 300;
        System.out.println(obj1 == obj2);
        System.out.println(obj1.equals(obj2));

        //-128 ~ 127의 수는 동일 객체로 관리
        Integer obj3 = 100;
        Integer obj4 = 100;
        System.out.println(obj3 == obj4);
        System.out.println(obj3.equals(obj4));
    }
}