package basic.Ch15_Greedy;
import java.util.Arrays;
// 그리디
// 무거운 사람부터 태운다.
// 무거운 사람을 우선 고려하되, limit 에 여유가 있으면 가벼운 사람을 태워 본다.
// 사람을 무게 순으로 정렬
// 무게로 정렬된 사람들 중에 가장 무거운 사람과 가장 가벼운 사람을 태워 본다. ( 만약 2명이 함께 타지 못하면 무거운 사람만 태운다 ) <= 반복
public class boat {
    public int solution(int[] people, int limit) {

        // 무게별로 정렬
        Arrays.sort(people); // 가벼운 ~~ 무거운 순
        int count = 0; // 총 사용된 구명보트 수
        int i = 0; // 가장 가벼운 왼쪽 끝에서 시작 인덱스
        int j = people.length - 1; // 가장 무거운 오른쪽 끝에서 시작 인덱스

        // 모두 다 태울 때까지 반복
        while( i <= j ) {

            // 현 시점에서 가장 무거운 사람과 가장 가벼운 사람을 고려
            if( people[i] + people[j] <= limit ) {
                i++; // 가벼운 사람도 함께 태운다.
            }

            // 무조건 무거운 사람 태운다.
            j--;
            count++;
        }
        return count;
    }
}