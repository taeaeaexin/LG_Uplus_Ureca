package basic.Ch10_StackQueue;

// Queue 등 자료구조 사용 X, 주어진 배열 cards1, cards2 를 이용해서 처리
public class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;
        int idxG = 0;

        while(true) {
            // 맨 앞부터 배열의 index 를 이용해서 2개의 배열 문자열과 goal 문자열 비교
            if( idxG == goal.length ) return "Yes";

            String curr = goal[idxG];

            if( idx1 <= cards1.length - 1 && curr.equals(cards1[idx1])) {
                idxG++;
                idx1++;
            } else if( idx2 <= cards2.length - 1 && curr.equals(cards2[idx2])) {
                idxG++;
                idx2++;
            }else {
                return "No";
            }
        }
    }
}