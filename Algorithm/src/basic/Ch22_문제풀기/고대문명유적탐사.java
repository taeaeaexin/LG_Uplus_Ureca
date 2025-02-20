package basic.Ch22_문제풀기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//3x3 격자 선택(for) -> 회전(dps) -> 애니팡 최댓값 탐색(bfs)
//각 턴 마다 획득한 유물의 가치의 총합 출력

public class 고대문명유적탐사 {
    static int K, M;
    static int[][] relic = new int[5][5];
    static int[] num;

    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    static class Node{
        int y, x;
        Node(int y, int x){
            this.y = y; this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < 5; j++) {
                relic[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        num = new int[M];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < M; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        //3x3 격자 중심 dfs 탐색
        for (int i = 1; i <= 3 ; i++) {
            for (int j = 3; j >= 1 ; j--) {
                if(rotation(j, i) == 0) break;
                System.out.print(rotation(j, i)+" ");
            }
        }
    }

    public static int rotation(int y, int x) {
        // 90도 회전
        int[][] relic90 = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (y - 1 <= i && i <= y + 1 && x - 1 <= j && j <= x + 1) {
                    int ny = y - (j - x);
                    int nx = (i - y) + x + 1;
                    if (ny >= 0 && ny < 5 && nx >= 0 && nx < 5) {
                        relic90[i][j] = relic[ny][nx];
                    }
                } else {
                    relic90[i][j] = relic[i][j];
                }
            }
        }
        int score90 = boom(relic90);

        // 180도 회전
        int[][] relic180 = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (y - 1 <= i && i <= y + 1 && x - 1 <= j && j <= x + 1) {
                    int ny = (y + 1) - (i - y);
                    int nx = (x + 1) - (j - x);
                    if (ny >= 0 && ny < 5 && nx >= 0 && nx < 5) {
                        relic180[i][j] = relic[ny][nx];
                    }
                } else {
                    relic180[i][j] = relic[i][j];
                }
            }
        }
        int score180 = boom(relic180);

        // 270도 회전
        int[][] relic270 = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (y - 1 <= i && i <= y + 1 && x - 1 <= j && j <= x + 1) {
                    int ny = (y + 1) - (j - x);
                    int nx = i - y + x;
                    if (ny >= 0 && ny < 5 && nx >= 0 && nx < 5) {
                        relic270[i][j] = relic[ny][nx];
                    }
                } else {
                    relic270[i][j] = relic[i][j];
                }
            }
        }
        int score270 = boom(relic270);

        // 최대 점수 계산
        int max = 0;
        if(score90 >= score180) max = score90;
        else max = score180;
        if(max < score270) max = score270;
        return max;
    }


    public static int boom(int[][] arr){
        boolean[][] visited = new boolean[5][5];
        int score = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(!visited[i][j] && arr[i][j] != 0) {
                    List<Node> connected = new ArrayList<>();
                    Queue<Node> queue = new LinkedList<>();

                    queue.offer(new Node(i, j));
                    visited[i][j] = true;
                    int number = arr[i][j];

                    while(!queue.isEmpty()){
                        Node node = queue.poll();
                        connected.add(node);

                        for (int d = 0; d < 4; d++) {
                            int ny = node.y + dy[d];
                            int nx = node.x + dx[d];

                            if (ny >= 0 && ny < 5 && nx >= 0 && nx < 5 && !visited[ny][nx] && arr[ny][nx] == number) {
                                queue.offer(new Node(ny, nx));
                                visited[ny][nx] = true;
                            }
                        }
                    }

                    if(connected.size() >= 3){
                        for (Node node : connected) {
                            arr[node.y][node.x] = 0;
                        }
                        score += connected.size() * number;
                    }
                }

            }
        }
        addblock(arr);
        return score;
    }

    public static void addblock(int[][] arr) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 4; j >= 0; j--) {
                if (arr[j][i] == 0 && !queue.isEmpty()) {
                    arr[j][i] = queue.poll();
                }
            }
        }

        for (int numValue : num) {
            queue.offer(numValue);
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 4; j >= 0; j--) {
                if (arr[j][i] == 0 && !queue.isEmpty()) {
                    arr[j][i] = queue.poll();
                }
            }
        }
    }
}