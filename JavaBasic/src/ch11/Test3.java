package ch11;

//사용자 정의 예외, throw
public class Test3 {
    public static void main(String[] args) {
        Account account = new Account();
        //입금
        account.deposit(10_000);
        System.out.println(account.getBalance());

        //출금
        try {
            account.withdraw(50_000);
        }catch (InsufficientException e) {
            System.out.println(e.getMessage());
            e.printStackTrace(); //디버깅하기 편함
        }
        System.out.println(account.getBalance());
    }
}
