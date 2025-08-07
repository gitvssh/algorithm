package algorithm.baek.datastructure;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/11531 ACM 대회 채점
 */
public class ACMContestScoring implements TestCase {

    /*
    분석(5m)
    설계(10m)
    구현(15m)

    분석
    - 푼 문제 수와 총 걸린 시간(패널티 포함)을 출력한다.
    - 풀지 못한 문제는 고려하지 않는다.
    - 푼 문제는 틀린 횟수만큼 패널티가 적용된다.

    설계
    - 로그 클래스를 만들어 문제를 저장한다.
    - 문제 클래스는 성공여부, 완료 시간, 틀린 횟수를 저장한다.
    - 문제 클래스는 패널티를 계산할 수 있다.
    - 로그 클래스는 최종 결과를 출력할 수 있다.
     */

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ACMLog log = new ACMLog();
        while (true) {
            String s = br.readLine();
            if (s.equals("-1")) {
                break;
            }
            log.addLog(s);
        }
        System.out.println(log.getResult());
    }

    public static class ACMLog {

        HashMap<String, Question> logs = new HashMap<>();

        public void addLog(String s) {
            String[] split = s.split(" ");
            int time = Integer.parseInt(split[0]);
            String name = split[1];
            boolean solved = split[2].equals("right");
            if(logs.get(name) == null){
                logs.put(name, new Question(name, time, solved));
            }else{
                logs.get(name).update(time, solved);
            }
        }

        public Question getLogs(String h) {
            return logs.get(h);
        }

        public String getResult() {
            List<Question> list = new ArrayList<>();
            for (Question value : logs.values()) {
                if (value.getSolved()) {
                    list.add(value);
                }
            }
            Integer totalPanalty = list.stream()
                    .map(Question::getPanalty)
                    .reduce(Integer::sum)
                    .orElse(0);

            return list.size() + " " + totalPanalty;
        }
    }

    public static class Question {

        int solvedTime;
        boolean solved;
        int failCount;
        String name;

        public Question(String name, int time, boolean solved) {
            this.name = name;
            if (solved) {
                this.solvedTime = time;
            }
            failCount = solved ? 0 : 1;
            this.solved = solved;
        }

        public boolean getSolved() {
            return solved;
        }

        public int getCompleteTime() {
            return solvedTime;
        }

        public int getFailCount() {
            return failCount;
        }

        public int getPanalty() {
            return solvedTime + failCount * 20;
        }

        public void update(int time, boolean solved) {
            if (this.solved) {
                return;
            }
            if (solved) {
                this.solvedTime = time;
                this.solved = true;
            } else {
                failCount++;
            }
        }
    }
}
