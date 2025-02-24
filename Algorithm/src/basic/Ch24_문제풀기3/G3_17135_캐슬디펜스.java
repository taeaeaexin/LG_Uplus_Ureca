package basic.Ch24_문제풀기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_17135_캐슬디펜스 {
    static int N, M, D, result;
    static int[][] map;
    static int[] archer = new int[3];

    static class Node {
        int y, x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0;
        comb(0, 0);

        System.out.println(result);
    }

    public static void comb(int index, int depth) {
        if (depth == archer.length) {
            result = Math.max(result, kill());
            return;
        }
        if (index == M) return;

        archer[depth] = index;
        comb(index + 1, depth + 1);
        comb(index + 1, depth);
    }

    public static int kill() {
        int count = 0;
        int[][] new_map = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, new_map[i], 0, M);
        }

        for (int turn = 0; turn < N; turn++) {
            List<Node> targets = new ArrayList<>();

            // 궁수별로 타겟을 찾기
            for (int i = 0; i < 3; i++) {
                int ax = archer[i], ay = N; // 궁수 위치 (N, ax)
                int minDist = D + 1;
                int targetX = -1, targetY = -1;

                for (int j = N - 1; j >= 0; j--) {
                    for (int k = 0; k < M; k++) {
                        if (new_map[j][k] == 1) {
                            int dist = Math.abs(j - ay) + Math.abs(k - ax);
                            if (dist <= D) {
                                if (dist < minDist || (dist == minDist && k < targetX)) {
                                    minDist = dist;
                                    targetX = k;
                                    targetY = j;
                                }
                            }
                        }
                    }
                }

                if (targetX != -1 && targetY != -1) {
                    targets.add(new Node(targetY, targetX));
                }
            }

            // 적 제거
            for (Node target : targets) {
                if (new_map[target.y][target.x] == 1) {
                    new_map[target.y][target.x] = 0;
                    count++;
                }
            }

            // 몬스터 아래로 이동
            for (int j = N - 1; j > 0; j--) {
                System.arraycopy(new_map[j - 1], 0, new_map[j], 0, M);
            }
            Arrays.fill(new_map[0], 0);
        }

        return count;
    }
}
