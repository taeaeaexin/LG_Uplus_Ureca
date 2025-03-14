package basic.Ch11_Hash;


import java.util.ArrayList;
import java.util.HashMap;
public class 오픈채팅방 {
    // 닉네임이 최종적으로 변경된 것을 선택
    // 닉네임은 유저아이디 별로 관리
    // 전체 진행 record 를 추적하면서 각 유저아이디별 최종 닉네임을 관리 ( Enter, Change 추적 )
    //   => 유저아이디별 닉네임을 관리 <= HashMap (key=유저아이디, value=닉네임)
    // 정답의 문자열 배열은 다시 전체 진행 record 를 추척 Enter, Leave 만 대상으로 문자열을 구성하는데, 닉네임은  HashMap 을 이용해서 처리

    // 교재 풀이
    public String[] solution(String[] record) {
        // Enter, Leave 에 대한 문자열도 HashMap 에 관리
        HashMap<String, String> msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");

        // 유저아이디별 닉네임 관리 HashMap
        // Enter, Change 대상
        HashMap<String, String> uid = new HashMap<>();
        for (String s : record) {
            String[] cmd = s.split(" ");
            if( cmd.length == 3 ) {
                uid.put(cmd[1], cmd[2]); //  cmd[1] : 유저아이디 인데, 이 값이 중복되면 덮어쓴다. 최신화
            }
        }

        // 정답 구성
        ArrayList<String> answer = new ArrayList<>();
        for (String s : record) {
            String[] cmd = s.split(" ");
            // Enter, Leave 에 대서만 처리를 msg 를 이용
            if( msg.containsKey(cmd[0]) ) { // Change 는 거린다.
                answer.add( uid.get(cmd[1]) + msg.get(cmd[0]));
            }
        }

        return answer.toArray(new String[0]);  // ArrayList => String[]
    }


}