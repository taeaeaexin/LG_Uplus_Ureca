package basic.Ch22_문제풀기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class G4_14502_연구소 {
    static int N, M, result;
    static int[][] lab;

    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    static Queue<Node> queue = new ArrayDeque<>();

    static class Node{
        int y, x;
        Node(int y, int x){
            this.y = y; this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        wall(0);
        System.out.println(result);
    }

    public static void wall(int n){
        if(n == 3){
            virus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(lab[i][j] == 0){
                    lab[i][j] = 1;
                    wall(n+1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    public static void virus(){
        queue = new ArrayDeque<Node>();

        int lab2[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                lab2[i][j] = lab[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(lab2[i][j] == 2){
                    queue.offer(new Node(i, j));
                }
            }
        }

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if(ny >= 0 && ny < N && nx >= 0 && nx < M && lab2[ny][nx] == 0){
                    queue.offer(new Node(ny, nx));
                    lab2[ny][nx] = 2;
                }
            }
        }
        isSafe(lab2);
    }

    public static void isSafe(int[][] lab2){
        int safe = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(lab2[i][j] == 0){
                    safe++;
                }
            }
        }

        if(result < safe) result = safe;
    }
}