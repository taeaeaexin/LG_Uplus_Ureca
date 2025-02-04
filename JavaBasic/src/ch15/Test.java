package ch15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //List - ArrayList
        List<Board> list = new ArrayList<>();
//        {
//            list.add(new Board("제목1", "내용1", "작성자1"));
//            list.add(new Board("제목2", "내용2", "작성자2"));
//            list.add(new Board("제목3", "내용3", "작성자3"));
//            list.add(new Board("제목4", "내용4", "작성자4"));
//
//            System.out.println(list); //Board의 toString() 재정의, 순서 O
//            System.out.println(list.size()); //크기
//            System.out.println(list.get(2)); //index 기반 객체 탐색
//
//            //중복 O
//            Board board = new Board("제목5", "내용5", "작성자5"); //heap에 1개 객체
//            list.add(board);    //동일객체 참조1
//            System.out.println(list.size());
//            list.add(board);    //동일객체 참조2
//            System.out.println(list.size());
//
//            //삭제 (index, 객체)
//            list.remove(1); //제목2 항목 삭제
//            System.out.println(list);
//
//            list.remove(new Board("제목3", "내용3", "작성자3")); //전달되는 객체의 equals()로 처리
//            System.out.println(list); //삭제X <- equals() 재정의 X
//
//            list.remove(board); //board 참조 값(주소값)으로 찾는다. object의 equals() => == 비교
//            System.out.println(list);
//            //만약 필드값 등 전달 되는 객체의 내용으로 삭제하고 싶으면 equals(), hashCode() Overriding 해야 함
//            //재정의 후에 "제목3" 객체가 삭제됨을 확인
//
//            //전체 삭제(초기화)
//            list.clear();
//            System.out.println(list);
//        }

        //순회
        //equals(), hashCode() 재정의된 상태
        {
            list.add(new Board("제목1", "내용1", "작성자1"));
            list.add(new Board("제목2", "내용2", "작성자2"));
            list.add(new Board("제목3", "내용3", "작성자3"));
            list.add(new Board("제목4", "내용4", "작성자4"));
            list.add(new Board("제목4", "내용4", "작성자4"));

            //index 기반
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

            //foreach 기반
            for (Board board : list) {
                System.out.println(board);
            }

            //literator
            Iterator<Board> iterator = list.iterator();
            while (iterator.hasNext()) {
                Board board = iterator.next();
                System.out.println(board);
            }

            //Board 객체 중에 new Board("제목4", "내용4", "작성자4")와 동일한 객체
            Board board = new Board("제목4", "내용4", "작성자4");
            for (int i = 0; i < list.size(); i++) {
                list.remove(board);
            }
            System.out.println(list);

            //literator
            Iterator<Board> itr2 = list.iterator();
            while (itr2.hasNext()) {
                Board board2 = itr2.next();
                if(board2.equals(board)) itr2.remove();
            }
            System.out.println(board);
        }
    }
}