package Ureca;

import Ureca.Student.Team1;
import Ureca.Student.Team2;
import Ureca.Student.Team3;
import Ureca.Student.Team4;
import Ureca.Student.Team5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomTeamShuffle {
    public static void main(String[] args) {
        // 모든 조원들을 하나의 리스트로 합치기
        List<String> allMembers = new ArrayList<>();
        Collections.addAll(allMembers, Team1.members);
        Collections.addAll(allMembers, Team2.members);
        Collections.addAll(allMembers, Team3.members);
        Collections.addAll(allMembers, Team4.members);
        Collections.addAll(allMembers, Team5.members);

        // 리스트 섞기
        Collections.shuffle(allMembers);

        // 팀 수 계산
        int totalTeams = 5;
        int totalMembers = allMembers.size();
        int baseSize = totalMembers / totalTeams; // 기본적으로 팀에 들어갈 인원 수
        int extraMembers = totalMembers % totalTeams; // 나머지 인원 수

        // 팀 나누기
        List<List<String>> teams = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < totalTeams; i++) {
            int currentTeamSize = baseSize + (extraMembers > 0 ? 1 : 0); // 나머지가 있는 경우 한 명 추가
            extraMembers--;
            teams.add(new ArrayList<>(allMembers.subList(index, index + currentTeamSize)));
            index += currentTeamSize;
        }

        // 각 팀 출력
        for (int i = 0; i < teams.size(); i++) {
            System.out.println("Team " + (i + 1) + ":");
            for (String member : teams.get(i)) {
                System.out.println("- " + member);
            }
            System.out.println();
        }
    }
}
