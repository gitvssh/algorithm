package algorithm.baek.simulation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import algorithm.baek.simulation.MostFavoriteTeamMate.TeamMate;
import algorithm.baek.simulation.MostFavoriteTeamMate.TeamMates;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MostFavoriteTeamMateTest {

    /**
     * 요구사항 정수 N(1 <= N <= 1000), N은 홀수 이후 2부터 N+1번째 줄까지 일렬로 서있는 학생들의 이니셜과 학번의 마지막 자리두 자리가 공백으로 구분되어 주어진다. 이니셜은 대문자 알파벳 한 글자에서 치대 세 글자까지
     * 주어진다. 학번이 00인 경우는 없고, 십의 자리가 0인 경우는 표시하지 않는다.
     * <p>
     * 최애의 팀원 찾는 방법 가장 앞에 선 학생은 뒤돌아 나머지 학생 마주봄 최애의 팀원이면 둘이 손 잡고 떠남, 아니면 "패스" 외침 - "패스"를 외치면 팀원 후보 중 가장 앞 사람은 하납퀴 돌아서 다시 줄의 맨 끝에 서면 됨
     */

    @DisplayName("팀원은 자신의 최애의 팀원을 찾을 수 있다.")
    @Test
    public void name() {
        //given
        TeamMates teamMates = new TeamMates();
        TeamMate teamMate = new TeamMate("A", 2);
        TeamMate teamMate2 = new TeamMate("B", 3);
        TeamMate teamMate3 = new TeamMate("c", 1);
        teamMates.add(teamMate);
        teamMates.add(teamMate2);
        teamMates.add(teamMate3);
        //when
        TeamMate mostFavoriteTeamMate = teamMates.findMostFavoriteTeamMate(teamMate);
        teamMate.setMostFavoriteTeamMate(mostFavoriteTeamMate);
        //then
        assertThat(teamMate.getMostFavoriteTeamMate()).isEqualTo(teamMate3);
    }

    @DisplayName("최애의 팀원을 찾은 뒤 팀원 순서를 변경할 수 있다.")
    @Test
    public void remove() {
        //given
        TeamMates teamMates = new TeamMates();
        TeamMate teamMate = new TeamMate("A", 2);
        TeamMate teamMate2 = new TeamMate("B", 3);
        TeamMate teamMate3 = new TeamMate("c", 1);
        teamMates.add(teamMate);
        teamMates.add(teamMate2);
        teamMates.add(teamMate3);
        //when
        TeamMate mostFavoriteTeamMate = teamMates.findMostFavoriteTeamMate(teamMate);
        teamMate.setMostFavoriteTeamMate(mostFavoriteTeamMate);
        //then
        assertThat(teamMates.getTeamMates().get(0)).isEqualTo(teamMate2);
    }

    @DisplayName("여러 팀원의 최애의 팀원을 찾을 수 있다.")
    @Test
    public void allFind() {
        //given
        TeamMates teamMates = new TeamMates();
        TeamMate teamMate = new TeamMate("A", 3);
        TeamMate teamMate2 = new TeamMate("B", 2);
        TeamMate teamMate3 = new TeamMate("C", 8);
        TeamMate teamMate4 = new TeamMate("D", 5);
        TeamMate teamMate5 = new TeamMate("E", 4);
        teamMates.add(teamMate);
        teamMates.add(teamMate2);
        teamMates.add(teamMate3);
        teamMates.add(teamMate4);
        teamMates.add(teamMate5);
        //when
        teamMates.findMostFavoriteTeamMateAll();
        //then
        assertThat(teamMates.getTeamMates().size()).isEqualTo(1);
        assertThat(teamMates.getTeamMates().get(0)).isEqualTo(teamMate2);
    }

    @DisplayName("다양한 케이스의 팀원의 최애의 팀원을 찾을 수 있다.")
    @Test
    public void manyFind() {
        //given
        TeamMates teamMates = new TeamMates();
        TeamMate teamMate = new TeamMate("D", 3);
        TeamMate teamMate2 = new TeamMate("BZ", 99);
        TeamMate teamMate3 = new TeamMate("PVC", 46);
        TeamMate teamMate4 = new TeamMate("R", 2);
        TeamMate teamMate5 = new TeamMate("HG", 13);
        TeamMate teamMate6 = new TeamMate("T", 5);
        TeamMate teamMate7 = new TeamMate("YU", 7);
        teamMates.add(teamMate);
        teamMates.add(teamMate2);
        teamMates.add(teamMate3);
        teamMates.add(teamMate4);
        teamMates.add(teamMate5);
        teamMates.add(teamMate6);
        teamMates.add(teamMate7);
        //when
        teamMates.findMostFavoriteTeamMateAll();
        //then
        assertThat(teamMates.getTeamMates().size()).isEqualTo(1);
        assertThat(teamMates.getTeamMates().get(0)).isEqualTo(teamMate3);
    }

    @DisplayName("마지막 남은 팀원을 찾을 수 있다.")
    @Test
    public void getResult() {
        //given
        TeamMates teamMates = new TeamMates();
        TeamMate teamMate = new TeamMate("A", 3);
        TeamMate teamMate2 = new TeamMate("B", 2);
        TeamMate teamMate3 = new TeamMate("C", 8);
        TeamMate teamMate4 = new TeamMate("D", 5);
        TeamMate teamMate5 = new TeamMate("E", 4);
        teamMates.add(teamMate);
        teamMates.add(teamMate2);
        teamMates.add(teamMate3);
        teamMates.add(teamMate4);
        teamMates.add(teamMate5);
        //when
        teamMates.findMostFavoriteTeamMateAll();
        //then
        assertThat(teamMates.getLast()).isEqualTo(teamMate2);
        assertThat(teamMates.getLast().toString()).isEqualTo("B");
    }
}