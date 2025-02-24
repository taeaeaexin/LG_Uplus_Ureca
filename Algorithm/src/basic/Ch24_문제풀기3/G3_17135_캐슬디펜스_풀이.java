package basic.Ch24_문제풀기3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
// 조합 + 시물레이션
// 궁사의 x 위치를 3개 조합으로 뽑고
//    적들 중에 D 거리안에 해당하는 적만 대상으로 가장 가까운 적을 골라 제거, 적 이동( 아래 1칸 ) 처리
// 자료구조
//    2차원 배열에 적을 두고 이동...부담..
//    적을 ArrayList 에 담고 제거...이동...
public class G3_17135_캐슬디펜스_풀이 {
    static int N, M, D, max;
    static int[] archer = new int[3]; // 조합의 tgt 에 해당
    static List<Enemy> enemyCopy = new ArrayList<>();  // 복사원본
    static List<Enemy> enemy = new ArrayList<>();  // 작업본
    static PriorityQueue<Enemy> pqueue = new PriorityQueue<>( (e1, e2) -> e1.d == e2.d ? e1.x - e2.x : e1.d - e2.d); // 가장 가까운 거리의 Enemy 찾는 용도

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        // 입력을 받으면서 적만 enemyCopy 에 넣는다.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                if( n == 1 ) enemyCopy.add(new Enemy(i, j)); // 좌표만 이용
            }
        }

        // 궁사 3명의 위치(x) 를 조합으로 선택
        comb(0, 0);
        System.out.println(max);
    }
    // 시물레이션 진행
    static void check() {
        // 원본 자료구조 => 작업 자료구조 복사
        // enemyCopy clone ( 담긴 객체가 동일한 객체 ) X
        enemy.clear();
        for (Enemy e : enemyCopy) {
            enemy.add(new Enemy(e.y, e.x)); // enemy.add(e) : 얕은 복사 (객체 공유) X
        }

        // 현재 궁사의 조합에서 적을 최대로 죽여야 한다.
        int dead = 0;
        while(true) {
            // 3명의 궁사가 한 번씩 D 거리안의 적에게 화살 쏜다.
            for (int i = 0; i < 3; i++) {
                // 가장 가까운 거리의 적 계산
                pqueue.clear();
                int ac = archer[i]; // 현재 궁사의 x 좌표
                int size = enemy.size();

                // 모든 적들 중에 현재 궁사와의 거리가 D 이하인 적만 pqueue 에 담는다.
                for (int j = 0; j < size; j++) {
                    Enemy e = enemy.get(j);
                    // 현재 궁사의 위치와 꺼낸 e 적의 위치에서 맨하탄 거리
                    e.d = Math.abs(ac - e.x) + Math.abs(N - e.y);

                    if( e.d > D ) continue; // 현재 궁사와의 거리가 유효거리인 D 밖일 경우 무시

                    pqueue.offer(e);
                }
                // pqueue 가 empty 하지 않으면 적 1개를 꺼내고 죽었다 표시
                if( ! pqueue.isEmpty() ) {
                    pqueue.poll().dead = true;
                }
            }

            // 죽은 적 정리 ( ArrayList 에서 삭제 ), 이동 ( 한칸 아래로 )
            // Collection 에서 삭제 시 뒤부터 처리, 또는 Iterator 사용
            for (int i = enemy.size()-1; i >= 0; i--) {
                Enemy e = enemy.get(i);
                if( e.dead ) { // 죽은 적군
                    enemy.remove(i);
                    dead++;
                }else if( e.y == N - 1) { // 죽지 않았지만 마지막 행이면 삭제
                    enemy.remove(i);
                }else {
                    e.y++;
                }
            }
            // 모든 적이 다 사라지면 while 종료
            if( enemy.size() == 0 ) break;
        } // while

        max = Math.max(max, dead);
    }

    static void comb(int srcIdx, int tgtIdx) {
        // 기저조건
        if( tgtIdx == 3 ) {
            check(); // 시물레이션 진행
            return;
        }

        // srcIdx
        if( srcIdx == M ) return;

        archer[tgtIdx] = srcIdx; // 현재 tgtIdx 자리에 srcIdx 선택

        comb(srcIdx + 1, tgtIdx + 1);// 선택 O
        comb(srcIdx + 1, tgtIdx );// 선택 X
    }


    static class Enemy{
        int y, x, d; // d: 현재 따지는 궁수와의 거리 <= 객체 생성 시점이 아닌 궁수의 위치가 결정되면 d 를 계산
        boolean dead;

        Enemy(int y, int x){
            this.y = y; this.x = x;
        }
    }
}