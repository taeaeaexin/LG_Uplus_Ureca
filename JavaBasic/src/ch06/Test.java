package ch06;

public class Test {
    public static void main(String[] args) {



//        // 1. 생성자가 없는 경우
//        Car car = new Car();
//        System.out.println(car);
//        Car car2 = new Car(1); // 오류
//
//        // 2. 생성자가 있는 경우
//        Car car2 = new Car(1);
//        System.out.println(car2);
//        Car car = new Car(); // 오류

        // 3. 생성자 여러개 (Overloading)
        {
            // 5. this() 활용 후 출력
            Car car1 = new Car(1);
            Car car2 = new Car("소나타", 10);
            System.out.println(car1.name);
            System.out.println(car2.speed);
            System.out.println(car2.name);
            System.out.println(car2.speed);

            // 6. 메소드 테스트
            car1.drive();
            car2.drive();

            System.out.println(car1.getDriveInfo());
            System.out.println(car2.getDriveInfo());

            System.out.println(car1.getDriveInfo("고속도로"));
            System.out.println(car2.getDriveInfo("남해도로"));
        }
    }
}
