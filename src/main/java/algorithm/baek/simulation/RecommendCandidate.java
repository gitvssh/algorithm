package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1713 후보 추천하기
 */
public class RecommendCandidate implements TestCase {

    /*
    1. 사진틀은 추천받은 학생의 사진이 게시된다.
    2. 한 번 추천받은 학생이 추천을 받으면 추천수가 1 증가한다.
    3. 사진틀이 꽉 차있으면, 추천수가 가장 적은 학생의 사진이 사진틀에서 제거되고, 그 자리에 새롭게 추천받은 학생의 사진이 게시된다.
    4. 추천수가 가장 적은 학생이 여럿일 경우에는 게시된지 오래된 학생의 사진이 사진틀에서 제거된다.
    5. 사진틀에 게시된 사진이 삭제되는 경우, 해당 학생이 추천받은 횟수는 0으로 바뀐다.
    6. 사진틀에 사진이 게재된 최종 후보의 학생 번호를 증가하는 순서대로 출력한다.(스트림 활용)

    학생
    1. 학생의 번호는 1부터 100까지이다.
    2. 학생은 추천수를 가지고 있다.
    사진틀
    1. 사진틀의 개수는 입력을 받는다.
    2. 사진틀은 학생을 가지고 있다.
    3. 사진틀은 게시 시간을 가지고 있다.
    4. 사진틀은 추천받은 학생을 등록할 수 있다.
    5. 사진틀은 최종 후보를 출력할 수 있다.
     */
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Frame frame = new Frame(n);
        int recommend = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < recommend; i++) {
            int studentNumber = Integer.parseInt(st.nextToken());
            frame.recommendStudent(new Student(studentNumber));
        }
        System.out.println(frame.printFinalCandidate());
    }

    static class Frame {

        private HashMap<Student, Integer> frame;
        private int size;
        private int time;

        public Frame(int size) {
            this.frame = new HashMap<>(size);
            this.size = size;
            this.time = 0;
        }

        public void recommendStudent(Student student) {
            time++;
            if (frame.size() == size) {
                if(getStudent(student.number) == null) {
                    removeLeastRecommend();
                }
            }
            Student foundStudent = getStudent(student.getNumber());
            if (foundStudent != null) {
                foundStudent.recommend++;
            } else {
                frame.put(student, time);
                student.recommend++;
            }
        }

        private void removeLeastRecommend() {
            Student leastRecommend = frame.entrySet().stream()
                    .min((o1, o2) -> {
                        if (o1.getKey().getRecommend() == o2.getKey().getRecommend()) {
                            return o1.getValue().compareTo(o2.getValue());
                        }
                        return o1.getKey().getRecommend() - o2.getKey().getRecommend();
                    })
                    .map(student -> student.getKey())
                    .orElse(null);
            frame.remove(leastRecommend);
            leastRecommend.recommend = 0;
        }

        public HashMap<Student, Integer> getFrame() {
            return frame;
        }

        public Student getStudent(int number) {
            return frame.entrySet().stream()
                    .filter(student -> student.getKey().getNumber().equals(number))
                    .findFirst()
                    .map(student -> student.getKey())
                    .orElse(null);
        }

        public String printFinalCandidate() {
            StringBuilder sb = new StringBuilder();
            frame.entrySet().stream()
                    .sorted((o1, o2) -> o1.getKey().getNumber().compareTo(o2.getKey().getNumber()))
                    .forEach(student -> sb.append(student.getKey().getNumber()).append(" "));
            return sb.toString().trim();
        }
    }

    static class Student {

        private int number;
        private int recommend;

        public Student(int number) {
            this.number = number;
            this.recommend = 0;
        }

        public int getRecommend() {
            return recommend;
        }

        public Integer getNumber() {
            return number;
        }
    }
}
