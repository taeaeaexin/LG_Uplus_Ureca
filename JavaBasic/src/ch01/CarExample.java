package ch01;

public class CarExample {
    public static void main(String[] args) {
        Car car1 = new Car("자가용");
        System.out.println(car1.company);
        System.out.println(car1.model);
        System.out.println(car1.color);
        System.out.println(car1.maxSpeed);
    }
}
