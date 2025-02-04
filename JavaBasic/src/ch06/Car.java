package ch06;

public class Car {
    // 4. 필드 추가
    String name;
    int speed;

    // 1. 생성자 없는 경우
    // 컴파일러가 기본 생성자를 추가

    // 2. 생성자 1개 추가
    // 컴파일러가 기본 생성자를 추가 X
//    public Car(int speed){
//        // 4. 추가된 필드에 값 지정
//        this.speed = speed;
//    }

    // 3. 생성자 overloading
    public Car(String name, int speed){
        // 4. 추가된 필드에 값 지정
        this.name = name;
        this.speed = speed;
    }

    // 5. this() 활용
    public Car(int speed){
        // name에 기본값(default)을 지정하고 Car(name, speed);
        this("아반떼", speed);
    }

    // 6. 메소드 추가
    public void drive(){
        System.out.println(this.name+"가 "+this.speed+"로 달림");
    }

    public String getDriveInfo(){
        return this.name+"가 "+this.speed+"로 달림";
    }

    // 7. 메소드 overloading
    public String getDriveInfo(String road) {
        return road+"를 "+this.name +"가 "+this.speed+"로 달림";
    }
}