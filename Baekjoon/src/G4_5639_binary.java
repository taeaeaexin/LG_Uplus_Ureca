import java.io.*;

public class G4_5639_binary {
    // 전역 변수로 출력할 결과를 저장할 StringBuilder
    static StringBuilder sb;
    // 루트 노드를 저장할 전역 변수
    static Node root = null;

    // 노드 클래스 정의
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) throws Exception {
        // 빠른 입출력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 빠른 출력을 위한 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 결과를 저장할 StringBuilder 초기화
        sb = new StringBuilder();

        String input;
        // EOF까지 입력을 받음
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int value = Integer.parseInt(input);
            root = insertNode(root, value);
        }

        // 후위 순회 실행
        postOrder(root);

        // 결과 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // insertNode: BST에 새로운 노드를 삽입하는 함수
    static Node insertNode(Node node, int value) {
        // 현재 위치가 비어있다면 새 노드 생성
        if (node == null) {
            return new Node(value);
        }

        // value가 현재 노드보다 작거나 같으면 왼쪽으로 삽입
        if (value <= node.data) {
            node.left = insertNode(node.left, value);
        }
        // value가 현재 노드보다 크면 오른쪽으로 삽입
        else {
            node.right = insertNode(node.right, value);
        }

        return node;
    }

    // postOrder: 후위 순회를 수행하고 결과를 StringBuilder에 저장
    static void postOrder(Node node) {
        // 노드가 null이면 종료
        if (node == null) {
            return;
        }

        // 왼쪽 서브트리 순회
        postOrder(node.left);
        // 오른쪽 서브트리 순회
        postOrder(node.right);
        // 현재 노드의 값을 StringBuilder에 추가
        sb.append(node.data).append("\n");
    }
}