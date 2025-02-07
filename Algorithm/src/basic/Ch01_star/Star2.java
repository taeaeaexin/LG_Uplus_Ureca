package basic.Ch01_star;

public class Star2 {
    public static void main(String[] args) {
        int turnCnt = 7 / 2; //모양이 바뀌는 지점 (공백문자가 증가하다가 감소하는 지점)
        int spaceCnt = 0; //출력 공백 수 (증가했다가 감소)
        boolean spaceIncrease = true; //공백 문자가 계속 증가해야하는지, 감소해야 하는지
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if(j < spaceCnt){
                    System.out.print(" ");
                }else if(j < 7-spaceCnt){
                    System.out.print("*");
                }
            }
            System.out.println();

            if(spaceIncrease) spaceCnt++;
            else spaceCnt--;

            if(spaceCnt == turnCnt) spaceIncrease = false;
        }
    }
}
