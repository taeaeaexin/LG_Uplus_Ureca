package Singleton;

import java.time.LocalDateTime;

//Singleton
public class Logger {
    //#3 static 필드로 Logger 변수 필요
    private static Logger logger = new Logger();

    //#1 생성자를 private로 만들어서 외부에서 생성자를 만들지 못하게 한다
    private Logger() {}

    //#2 자신 객체를 생성, 전달하는 메소드를 제공
    //static을 사용하여 객체 생성없이 호출
    public static Logger getInstance() {
//        return Logger(); //eager loading
        if(logger == null){
            logger = new Logger();
        }
        return logger;
    }

    public void log(String message) {
        LocalDateTime ldt = LocalDateTime.now();
        String date = ldt.getYear() + "/" + ldt.getMonthValue() + "/" + ldt.getDayOfMonth();
        String time = ldt.getHour() + ":" + ldt.getMinute() + ":" + ldt.getSecond();

        System.out.println("[" + date + " " + time + "] " + message);
    }
}
