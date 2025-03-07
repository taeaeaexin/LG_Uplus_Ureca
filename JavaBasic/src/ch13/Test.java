package ch13;

public class Test {
    public static void main(String[] args) {
        //Generic T
        Box<String> box1 = new Box<>();
        box1.content = "문태신";

        Box<Integer> box2 = new Box<>();
        box2.content = 990107;

        //복수개의 generic
        Product<TV, String> product1 = new Product<>();
        product1.setKind(new TV());
        product1.setModel("OLED");

        Product<Car, String> product2 = new Product<>();
        product2.setKind(new Car());
        product2.setModel("Porsche");

        //인터페이스와 generic
        Rentable<Home> homeAgency = new HomeAgency();
        Home home = homeAgency.rent();

        //메소드와 generic
        //main()과 별개인 static method 생성
        //Test 클래스에는 generic이 없음
        Box<Integer> box3 = boxing(100);
        System.out.println(box3.content);

        Box<String> box4 = boxing("Hello");
        System.out.println(box4.content);

        //제한된 generic T
        System.out.println(compare(10, 30));
    }

    //<T>가 메소드 return 앞에 표현
    //Parameter로 T 타입의 객체를 받는다
    //Box<T> 객체를 reuturn
    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<>();
        box.content = t;
        return box;
    }

    //T는 모든 타입의 객체가 아닌 Number를 포함한 Number의 하위 클래스로 제한
    //제한된 타입은 super(상위 클래스) 사용 불가
    public static <T extends Number> boolean compare(T t1, T t2) {
        return t1.doubleValue() == t2.doubleValue();
    }

}
