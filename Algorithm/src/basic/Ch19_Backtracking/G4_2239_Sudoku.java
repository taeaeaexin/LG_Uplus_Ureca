package basic.Ch19_Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class G4_2239_Sudoku {
    static int[][] arr = new int[9][9];
    static boolean flag = false;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            char[] c = bf.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = c[j]-'0';
            }
        }

        backtracking(0, 0);
    }

    public static void backtracking(int y, int x){
        if(flag) return;

        if(y == 9) {
            printSudoku();
            flag = true;
            return;
        }

        int dy = (x==8) ? y+1 : y;
        int dx = (x==8) ? 0 : x+1;

        if(arr[y][x] != 0){
            backtracking(dy, dx);
            return;
        }

        for (int i = 1; i <= 9 ; i++) {
            if (func(y, x, i)){
                arr[y][x] = i;
                backtracking(dy, dx);
                arr[y][x] = 0;
            }
        }
    }

    public static boolean func(int y, int x, int num){
        int startY = (y/3)*3;
        int startX = (x/3)*3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(arr[startY+i][startX+j] == num){
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if(arr[y][i] == num || arr[i][x] == num){
                return false;
            }
        }
        return true;
    }

    public static void printSudoku() {
        for (int[] row : arr) {
            for (int num : row) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}