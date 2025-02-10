package basic.Ch10_StackQueue;

import java.util.ArrayDeque;
import java.util.Deque;
// board
/*
[0,0,0,0,0],
[0,0,1,0,3],
[0,2,5,0,1],
[4,2,4,4,2],
[3,5,1,3,1]
바깥 배열(board)의 맨 뒤행부터 처리
*/
public class 크레인인형뽑기게임2 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        int answer = new 크레인인형뽑기게임2().solution(board, moves);
        System.out.println(answer);
    }

    public int solution(int[][] board, int[] moves) {
        int[] col_top_idx = new int[board[0].length]; // 일차원 배열에 각 컬럼별 최상위 인형의 index 관리

        // 컬럼 (옆) 이동하면서
        for (int col = 0; col < col_top_idx.length; col++) {
            // 맨 꼭대기부터 시작 0 이 아닌 첫 번째 index
            int top_idx = 0;
            while( top_idx < board.length - 1 && board[top_idx][col] == 0 ) top_idx++;
            col_top_idx[col] = top_idx;
        }

        Deque<Integer> bucket = new ArrayDeque<>(); // Stack -> ArrayDeque
        int answer = 0;

        for (int move : moves) { // 1  기반 index

            if( col_top_idx[move -1] > board.length - 1 ) continue; // 해당 열에서 꺼낼 인형 X

            // 꺼낼 인형이 있다.
            int doll = board[ col_top_idx[move -1] ][move-1];
            col_top_idx[move -1]++; // 현재 최상 높이의 인형을 꺼내고 하나 밑으로 조정


            if( ! bucket.isEmpty() && bucket.peek() == doll) { // 같은 인형
                bucket.pop(); // 맨 꼭대기 인형 꺼낸다.
                answer += 2;
            }else {
                bucket.push(doll);
            }

        }


        return answer;
    }
}
/*
테스트 1 〉 통과 (0.07ms, 73MB)
테스트 2 〉 통과 (0.09ms, 79.3MB)
테스트 3 〉 통과 (0.06ms, 72.4MB)
테스트 4 〉 통과 (0.73ms, 83.7MB)
테스트 5 〉 통과 (0.08ms, 83.6MB)
테스트 6 〉 통과 (0.09ms, 81MB)
테스트 7 〉 통과 (0.16ms, 75.5MB)
테스트 8 〉 통과 (0.51ms, 98.4MB)
테스트 9 〉 통과 (0.30ms, 70.1MB)
테스트 10 〉    통과 (0.42ms, 89.7MB)
테스트 11 〉    통과 (0.93ms, 81.3MB)
 */
