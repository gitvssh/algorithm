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
 * https://www.acmicpc.net/problem/20665 독서실 거리두기
 */
public class StudyRoomDistancing implements TestCase {

    /*
    분석(10m)
    설계(15m)
    구현(30m)

    분석
    - 독서실에는 1번부터 N번까지의 자리가 있다.
    - T명의 예약자가 있다.
    - 독서실에는 정해진 자리배치 규칙이 있다.
    - 가장 가까이에 앉아있는 사람이 가장 먼 자리를 선호한다.
    - 이용하는 사람이 없다면 1번 자리를 가장 선호한다.
    - 가장 먼 좌석들 중에서 좌석 번호가 가장 작은 자리를 선호한다.
    - 관리자가 선호하는 자리의 이용가능 시간을 구하라.

    설계
    독서실
    - 2차원 배열로 시간/좌석을 표현한다.
    - 독서실은 예약자들의 자리를 배치할 수 있다.
    - 독서실은 자리배치 규칙을 가지고 있다.
    - 독서실은 특정 자리의 가용 시간을 알 수 있다.
     */
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        StudyRoom studyRoom = new StudyRoom(n);
        List<Reservator> reservators = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            String startTime = st.nextToken();
            String endTime = st.nextToken();
            if(startTime.equals(endTime)) {
                continue;
            }
            reservators.add(new Reservator(startTime, endTime));
        }
        studyRoom.setReservator(reservators);
        System.out.println(studyRoom.getAvailableTime(p));
    }

    public static class Reservator implements Comparable<Reservator> {

        int startTime;
        int endTime;

        final int OPEN_TIME = 540;


        @Override
        public int compareTo(Reservator o) {
            return this.startTime - o.startTime;
        }

        public Reservator(String startTime, String endTime) {
            int startHour = Integer.parseInt(startTime.substring(0, 2));
            int startMinute = Integer.parseInt(startTime.substring(2, 4));

            int endHour = Integer.parseInt(endTime.substring(0, 2));
            int endMinute = Integer.parseInt(endTime.substring(2, 4));

            this.startTime = startHour * 60 + startMinute - OPEN_TIME;
            this.endTime = endHour * 60 + endMinute - OPEN_TIME;
        }
    }

    public static class StudyRoom {

        private boolean[][] room;

        public StudyRoom(int i) {
            room = new boolean[i][720];
        }

        public boolean setReservator(List<Reservator> reservators) {
            reservators.sort(Reservator::compareTo);
            for (Reservator reservator : reservators) {
                int roomPosition = getAvailableRoom(reservator.startTime);
                for (int i = reservator.startTime; i < reservator.endTime; i++) {
                    room[roomPosition][i] = true;
                }
            }
            return true;
        }

        private int getAvailableRoom(int startTime) {
            if (room[0][startTime] == false) {
                return 0;
            }
            int pos = 1;
            int maxDistance = 0;
            // 1번부터 N번까지의 자리를 순회하면서 가장 먼 자리를 찾는다.
            for (int i = 1; i < room.length; i++) {
                if (room[i][startTime]) {
                    continue;
                }
                int distance = 0;
                int leftMaxDistance = 0;
                // 현재 자리에서 가장 가까운 왼쪽 자리를 찾는다.
                for (int j = i; j > 0; j--) {
                    if (room[j - 1][startTime]) {
                        if (distance > leftMaxDistance) {
                            leftMaxDistance = distance;
                            pos = i;
                        }
                        break;
                    }
                    distance++;
                }
                distance = 0;
                int rightMaxDistance = 0;
                // 현재 자리에서 가장 가까운 오른쪽 자리를 찾는다.
                for (int j = i; j < room.length; j++) {
                    if (room[j][startTime]) {
                        if (distance > rightMaxDistance) {
                            rightMaxDistance = distance;
                            pos = i;
                        }
                        break;
                    }
                    distance++;
                }
                int minDintance = Math.min(leftMaxDistance, rightMaxDistance);
                if (minDintance > maxDistance) {
                    maxDistance = distance;
                    pos = i;
                }
            }
            return pos;
        }

        public boolean canReservation(String time, int po) {
            int startTime = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(2, 4)) - 540;
            return !room[po-1][startTime];
        }

        public int getAvailableTime(int i) {
            int cnt = 0;
            for (int time = 0; time < 720; time++) {
                if (!room[i - 1][time]) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
