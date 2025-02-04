package ch16;

public class Test {
    public static void main(String[] args) {
//        //Calculable 이용 덧셈
//        Calculable calcPlus = new CalculableImplPlus();
//        calcPlus.calculate(10, 20);
//
//        //Calculable 이용 뺄셈
//        Calculable calcMinus = new CalculableImplMinus();
//        calcMinus.calculate(10, 20);

        //Calculable 파라미터를 가진 메소드 호출
        Calculable calcPlus = new CalculableImplPlus();
        action(calcPlus);

        Calculable calcMinus = new CalculableImplMinus();
        action(calcMinus);

        //익명 클래스 객체를 이용한 덧셈
        action(new Calculable(){
            @Override
            public void calculate(int x, int y) {
                System.out.println(x + y);
            }
        });

        //한 단계 더 간단히
        //컴파일러 입장에서는 Functional Interface를 구현한 객체를 어떻게 처리할지는
        //인터페이스에 있는 메소드의 파라미터와 그것을 구현하는 코드
        action((x, y) -> {
            System.out.println(x + y);
        });

    }

    //Functional Interface 타입의 파라미터
    public static void action(Calculable calculable) {
        //하나의 메소드만 호출 가능
        calculable.calculate(10, 20);
    }
}
