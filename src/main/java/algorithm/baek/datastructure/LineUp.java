package algorithm.baek.datastructure;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2605 줄 세우기
 */
public class LineUp implements TestCase {

    /*
    분석(3m)
    설계(10m)
    구현(15m)

    연결리스트 구현
    기본 정책은 뒤에 추가되지만, 숫자를 입력받으면 뒤에서부터 해당 숫자만큼 앞의 순서로 이동한다.

    요구사항
    - 학생이 새로 추가되면 제일 뒤에 추가된다.
    - 학생이 번호표를 뽑아 추가되면, 해당 수 만큼 뒤에서 앞으로 이동한다.
    - 최종적으로 줄을 선 순서를 출력할 수 있다.
     */

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Line line = new Line();
        line.addStudentByString(n, br.readLine());
        bw.write(line.getLine());
        bw.flush();
        bw.close();
    }

    public static class Line {

        LinkedList<Student> students;

        Line() {
            students = new LinkedList<>();
        }

        public void addStudent(Student student, int index) {
            if (students.isEmpty()) {
                students.add(student);
                return;
            }
            if (index == 0) {
                students.addLast(student);
                return;
            }
            students.add(students.size() - index, student);
        }

        public Student getStudents(int index) {
            return students.get(index);
        }

        public String getLine() {
            StringBuilder sb = new StringBuilder();
            students.forEach(student -> sb.append(student.getNumber()).append(" "));
            return sb.toString().trim();
        }

        public void addStudentByString(int size, String listString) {
            StringTokenizer st = new StringTokenizer(listString);
            int index = 1;
            for (int i = 0; i < size; i++) {
                int number = Integer.parseInt(st.nextToken());
                addStudent(new Student(index++), number);
            }
        }
    }

    public static class Student {

        private final int number;

        public Student(int i) {
            this.number = i;
        }

        public int getNumber() {
            return number;
        }

        @Override
        public int hashCode() {
            return number;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Student) {
                Student target = (Student) obj;
                return number == target.number;
            }
            return false;
        }

        @Override
        public String toString() {
            return String.valueOf(number);
        }
    }
}
