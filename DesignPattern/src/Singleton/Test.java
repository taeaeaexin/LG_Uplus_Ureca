package Singleton;

public class Test {
    public static void main(String[] args) {
        //Logger 객체가 단 한개만 만들어져야 한다.
//        Logger logger1 = new Logger();
//        Logger logger2 = new Logger();

        Logger logger1 = Logger.getInstance();
        logger1.log("my message");

        Logger logger2 = Logger.getInstance();
        logger2.log("my message");

        System.out.println(logger1 == logger2);
    }
}
