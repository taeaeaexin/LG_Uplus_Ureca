package ch11;

//사용자 정의 예외
//extends RuntimeException일 경우 compile 오류 발생 X
public class InsufficientException extends Exception{
    //반드시 호출 되어야 함
    public InsufficientException(String message){
        super(message);
    }
}
