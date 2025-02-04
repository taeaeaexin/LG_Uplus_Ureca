package ch04;

public class quest4 {
    public static void main(String[] args) {
        while(true){
            int a = (int)(Math.random()*6)+1;
            int b = (int)(Math.random()*6)+1;
            if(a+b == 5){
                System.out.println(a+" "+b);
                break;
            }
        }
    }
}
