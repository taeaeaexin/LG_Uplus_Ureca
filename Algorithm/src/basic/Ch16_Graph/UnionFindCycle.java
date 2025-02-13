package basic.Ch16_Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UnionFindCycle {

    static int v, e;
    static int[] parent; // 각 원소(정점 번호)별 집합 관계를 표현하는 1차원 배열
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // 그래프 정점(1 ~ 6) 간 집합 표현
        // #1. 1차원 배열 생성
        parent = new int[v + 1]; // 0 dummy

        // #2. 1차원 배열 초기화
        // 각 원소별 자기 자신이 대표원소가 되도록 ( 모든 정점이 각각 서로소인 집합 )
        makeSet();

        // 최초 parent 배열
        System.out.println(Arrays.toString(parent));

        // #3. 주어진 테케에 맞게 union() 진행
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // union  전에 cycle 확인
            if( findSet(x) == findSet(y) ) {
                // cycle  발생
                System.out.println(x + ", " + y + " cycle 발생!!!");
                System.out.println(Arrays.toString(parent));

            }else {
                union(x, y); // findSet(x) == findSet(y) 이 이미 union() 에 포함 <= cycle 처리에 비효율적임. MST 에서 개선!!
                System.out.println(x + ", " + y + " union");
                System.out.println(Arrays.toString(parent));
            }

        }
    }

    static void makeSet() {
        for (int i = 1; i <= v; i++) {
            parent[i] = i;  // 모두가 대표 원소
        }
    }

    // 전달된 x 원소의 대표원소 찾아서 return
//	static int findSet(int x) {
//		if( parent[x] == x ) return x;  // 대표원소이면 x 리턴
//		return findSet(parent[x]);
//	}

    // 전달된 x 원소의 대표원소 찾아서 return
    // Path Compression
    static int findSet(int x) {
        if( parent[x] == x ) return x;  // 대표원소이면 x 리턴
        return parent[x] = findSet(parent[x]); // 맨 꼭대기 대표원소의 index 값이 리턴되어 돌아오는데 이 중간 과정의 x 의 부모 parent[x] 에 넣는다.
    }

    // 전달된 두 원소 x, y 에 대해, x가 속한 집합과 y가 속한 집합을 하나의 집합으로 합친다.
    static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        // px == py 이면 이미 같은 집합
        // 그렇지 않은 경우 규칙부여할 수 있다. 아래 코드는 작은 값을 부모로.
        if( px < py ) parent[py] = px;
        else parent[px] = py;
    }
}
/*
7 9
1 2
1 5
5 6
2 3
2 6
3 4
6 4
6 7
4 7
*/