package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/29813 최애의 팀원
 */
public class MostFavoriteTeamMate implements TestCase {

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TeamMates teamMates = new TeamMates();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            teamMates.add(new TeamMate(st.nextToken(), Integer.parseInt(st.nextToken())));
        }
        teamMates.findMostFavoriteTeamMateAll();
        System.out.println(teamMates.getLast());
    }

    static class TeamMates {
        ArrayList<TeamMate> teamMates = new ArrayList<>();

        public void add(TeamMate teamMate) {
            teamMates.add(teamMate);
        }

        public ArrayList<TeamMate> getTeamMates() {
            return teamMates;
        }

        public void removeTeamMate(TeamMate teamMate) {
            teamMates.remove(teamMate);
        }

        public TeamMate findMostFavoriteTeamMate(TeamMate teamMate) {
            teamMates.remove(0);
            if(teamMates.size() == 1) {
                return teamMates.get(0);
            }
            int index = teamMate.classOf-1 % teamMates.size();
            if(index >= teamMates.size()) {
                index = index % teamMates.size();
            }
            TeamMate mostFavoriteTeamMate = teamMates.get(index);
            repositioning(index);
            return mostFavoriteTeamMate;
        }

        /**
         * index를 기준으로 teamMates를 재배치한다.
         * @param index
         */
        private void repositioning(int index) {
            teamMates.remove(index);
            ArrayList<TeamMate> list = new ArrayList<>(teamMates);
            List<TeamMate> sublist = new ArrayList<>(list.subList(0, index));
            // 원래 list에서 sublist 삭제
            list.subList(0, index).clear();

            // sublist를 원래 list 뒤에 추가
            list.addAll(sublist);

            teamMates = list;
        }

        public void findMostFavoriteTeamMateAll() {
            while (teamMates.size() > 1) {
                TeamMate teamMate = teamMates.get(0);
                TeamMate mostFavoriteTeamMate = findMostFavoriteTeamMate(teamMate);
                teamMate.setMostFavoriteTeamMate(mostFavoriteTeamMate);
            }
        }

        public TeamMate getLast() {
            if(teamMates.size() != 1) {
                throw new IllegalArgumentException("팀원이 1명이 아닙니다.");
            }
            return teamMates.get(0);
        }
    }

    static class TeamMate {

        String initial;
        int classOf;

        TeamMate mostFavoriteTeamMate;

        public TeamMate(String initial, int classOf) {
            this.initial = initial;
            this.classOf = classOf;
        }

        public void setMostFavoriteTeamMate(TeamMate mostFavoriteTeamMate) {
            this.mostFavoriteTeamMate = mostFavoriteTeamMate;
        }

        public TeamMate getMostFavoriteTeamMate() {
            return this.mostFavoriteTeamMate;
        }

        @Override
        public String toString() {
            return initial;
        }
    }
}
