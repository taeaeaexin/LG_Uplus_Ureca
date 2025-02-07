package basic.Ch04_delta;

import java.util.Arrays;

public class DeltaTest1 {
    static char[][] map = new char[5][5];

    public static void main(String[] args) {
        char ch = 'A';

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = ch++;
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        //사방 탐색 상하좌우
        int y = 2;
        int x = 2;

        print4x(y, x);
    }

    //delta는 이동방향에 대해서 y의 변화량, x의 변화량을 미리 배열에 저장하고 이를 활용해서 새로운 이동(상하좌우) 좌표를 구하는 방식
    //                  상 하 좌 우
    //                  0  1 2  3 <= d
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static void print4x(int y, int x){

        for (int d = 0; d < 4; d++) {
            //y,x에서 현재 d 방향으로 이동한 새로운 좌표 계산
            int ny = y + dy[d];
            int nx = x + dx[d];

            //새로운 좌표 ny, nx는 배열의 범위를 벗어날 수 있따. 이에 대한 장치 필요
            if(ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue; //범위를 벗어난 좌표 무시
            System.out.println(map[ny][nx]);
        }
    }
    //문제 : 상하좌우로 이동할 수 있따
    //문제 : 맨 위부터 탐식 시계 방향으로
    //문제 : 대각선, 8방, 장기의 말 이동
}