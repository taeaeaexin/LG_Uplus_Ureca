package basic.Ch05_recursive;

public class Test {
    public static void main(String[] args) {
//        m1();
//        m1_param(0);
//        m2();
        m3();
    }

    //변수
    static int m1_i = 0;

    static void m1() {
        //local 변수 <= 재귀호출마다 stack에 새로 만들어지고 초기화 됨
//        int i = 0;

        //static 변수 <= 재귀호출마다 공유
//        System.out.println("m1() : " + m1_i++);
//        m1();
//        m2();
//        m3();
        m4(5);
    }

    static void m1_param(int i){
        //파라미터 변수
        System.out.println("m1_param() : " + i++);
        m1_param(i);
    }

    //기저 조건
    static int m2_cnt = 5;
    static void m2() {
        System.out.println("앞 m2() : "+ m2_cnt);
        //기저조건
        if(m2_cnt > 0) {
            m2_cnt--;
            m2();
        }
        System.out.println("뒤 m2() : "+ m2_cnt);
    }

    //Static 변수 이용
    static int m3_cnt = 5;
    static void m3() {
        if(m3_cnt == 0) return;

        System.out.println("앞 m3() : "+ m3_cnt);

        m3_cnt--;
        m3();
        m3_cnt++; //없으면 0으로 감소 한 후 계속 0 유지, 원복 필요

        System.out.println("뒤 m3() : "+ m3_cnt);
    }

    //파라미터 이용
    static void m4(int m4_cnt) {
        if(m4_cnt == 0) return;

        System.out.println("앞 m4() : "+ m4_cnt);

        m4(m4_cnt - 1); //호출 시 전달받은 m4_cnt는 변화X

        System.out.println("뒤 m4() : "+ m4_cnt);
    }
}
