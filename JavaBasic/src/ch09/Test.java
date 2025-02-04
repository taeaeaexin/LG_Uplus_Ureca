package ch09;

public class Test {
    public static void main(String[] args) {
        // 필드에 익명 객체 사용하는 법
        Car car = new Car();
        car.run();

        //메소드 파라미터에 익명 객체
        Home home = new Home();
        //2.1) RemoteControl 인터페이스를 구현한 클래스를 만들고
        //2.2) 그 객체를 전달해야지만, 간단히 익명 객체를 생성전달 할 수 있음
        home.use(new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("익명 remote control 사용");
            }
        });

        home.use(new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("익명 remote control 사용 2");
            }
        });

        //3.1) static inner class
//        MyClass mc = new MyClass(); //O
//        MyClass2 mc2 = new MyClass(); //X
        MyClass3 mc3 = new MyClass3(); //O
    }
    //3.3)
    class MyClass2{}
    static class MyClass3{}
}

//3.2) 정적 클래스
//class MyClass{}
