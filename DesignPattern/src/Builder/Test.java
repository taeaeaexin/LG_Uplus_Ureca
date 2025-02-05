package Builder;

//빌더 패턴은 개발자 코드 작성 및 유지보수에는 장점이 있음
//Builder 클래스 자체가 복잡하고
//객체 생성시 메모리 낭비가 심하다
public class Test {
    public static void main(String[] args) {
        //패턴 적용 전
        //필요한 생성자를 모두 제공하기 어렵다
//        Board board1 = new Board();
//        Board board2 = new Board("제목", "내용");
//        Board board2 = new Board("제목", "내용", "작성자");

        //패턴 적용 후
        //Board.Builder() : 기본 생성자 호출
        Board board1 = new Board.Builder().title("제목1").build();
        Board board2 = new Board.Builder().title("제목1").content("내용").build();
        Board board3 = new Board.Builder()
                .title("제목1")
                .content("내용")
                .writer("작성자")
                .build();
        System.out.println(board1);
    }
}
