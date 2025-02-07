package basic.Ch01_star;

public class Star1 {
    public static void main(String[] args) {
        int turnCnt = 5;
        int spaceCnt = 0;

        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 5 ; j++) {
                if(j < spaceCnt){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
            spaceCnt++;
        }
    }
}
