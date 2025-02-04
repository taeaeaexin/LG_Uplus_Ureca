package ch15;

import java.util.HashSet;
import java.util.Set;

public class Test3 {
    public static void main(String[] args) {
        //set
        Set<String> set = new HashSet<String>();
        set.add("java");
        set.add("Hello");
        set.add("java");
        set.add("World");
        set.add("World");

        for (String str : set) {
            System.out.println(str);
        }

        //Board
        //equals(), hashCode() 재정의
        //만약 Board의 hashCode()를 재정의하지 않으면
        Set<Board> boardSet = new HashSet<>();
        boardSet.add(new Board("제목1", "내용1", "작성자1"));
        boardSet.add(new Board("제목1", "내용1", "작성자1"));
        boardSet.add(new Board("제목2", "내용2", "작성자2"));

        for(Board board : boardSet) {
            System.out.println(board);
        }
    }
}
