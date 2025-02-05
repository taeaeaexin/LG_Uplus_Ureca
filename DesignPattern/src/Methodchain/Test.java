package Methodchain;

public class Test {
    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("Hello World");
//        sb.append("!").append("아 자고싶다");
//
//        System.out.println(sb);

        //Calculator - pattern 적용 전
//        Calculator calc = new Calculator();
//        //3+5
//        calc.setFirst(3);
//        calc.setSecond(5);
//        calc.add();

        //Calculator - pattern 적용 후
        Calculator calc = new Calculator();
        calc.setFirst(3).setSecond(5).add();
    }
}
