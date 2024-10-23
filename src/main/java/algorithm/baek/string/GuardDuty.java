package algorithm.baek.string;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;

public class GuardDuty implements TestCase {

    /*
    분석(1m)
    설계(2m)
    구현(5m)

    분석
    - 근무시간은 4,6,4,10 4종류
    - 각 인원의 근무시간이 12시간 이하로 차이, 최대 50주치
    입력조건
    - 첫째줄 주의 개수
    - 각 주는 7일
    - -가 존재하는 날은 모든 근무 없음
    - 근무자 이름은 알파벳 소문자, 20글자 넘지 않음

    설계
    - 근무자를 해시맵에 저장
    - 각 근무 시간을 누적함
    - 해시맵에서 최대, 최소 차이를 구함
    - 최대, 최소 차이가 12시간 이하이면 근무 가능

    - 근무자의 근무 시간을 저장할 수 있다.
    - 근무자의 최대, 최소 근무시간을 알 수 있다.
    - 근무자의 근무시간 차이가 12시간 이하인지 알 수 있다.
     */

    @Override
    public void test() throws ParseException, IOException {
        TimeTable timetable = new TimeTable();
        timetable.init(new InputStreamReader(System.in));
        System.out.println(timetable.getResult());
    }

    public static class TimeTable {

        HashMap<String, Integer> dutyTimeTable = new HashMap<>();

        Integer min;
        Integer max;

        public void init(InputStreamReader ir) {
            BufferedReader br = new BufferedReader(ir);
            int[] dutyTime = new int[4];
            dutyTime[0] = 4;
            dutyTime[1] = 6;
            dutyTime[2] = 4;
            dutyTime[3] = 10;
            try {
                int tc = Integer.parseInt(br.readLine());
                for (int i = 0; i < tc; i++) {
                    for (int j = 0; j < dutyTime.length; j++) {
                        String[] duty = br.readLine().split(" ");
                        for (int k = 0; k < duty.length; k++) {
                            String name = duty[k];
                            if (duty[k].equals("-")) {
                                continue;
                            }
                            dutyTimeTable.put(name, dutyTimeTable.getOrDefault(name, 0) + dutyTime[j]);
                        }

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public int getDutyTime(String name) {
            return dutyTimeTable.get(name);
        }

        public int getMax() {
            return max = dutyTimeTable.values().stream().max(Integer::compareTo).get();
        }

        public int getMin() {
            return min = dutyTimeTable.values().stream().min(Integer::compareTo).get();
        }

        public boolean isEqual() {
            return (getMax() - getMin()) <= 12;
        }

        public String getResult() {
            return isEqual() ? "Yes" : "No";
        }
    }
}
