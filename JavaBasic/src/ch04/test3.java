package ch04;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
//        // shile 반복 횟수가 정해지지 않은 경우, 코드를 반복적으로 수행하면서 변화에 따라 종료 결정
//        {
//            int i = 0;
//            while(i < 10){
//                System.out.println(i);
//                i++;
//            }
//        }
//
//        // do while
//        {
//            int i = 0;
//            do {
//                System.out.println(i);
//                i++;
//            }while(i < 10);
//        }
        // 교재 p133
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int speed = 0;

        while(run){
            System.out.println("-------------------");
            System.out.println("1: 증속 | 2: 감속 | 3: 중지");
            System.out.println("선택 : ");

            // 입력
            int num = sc.nextInt();
            if(num == 1){
                speed++;
                System.out.println("현재 속도 : "+speed);
            }else if(num == 2){
                System.out.println("현재 속도 : "+(--speed));
            }else if(num == 3){
                run = false;
            }
        }
        System.out.println("종료");
    }
}
