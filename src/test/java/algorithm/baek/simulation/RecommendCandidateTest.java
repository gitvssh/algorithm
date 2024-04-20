package algorithm.baek.simulation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import algorithm.baek.simulation.RecommendCandidate.Frame;
import algorithm.baek.simulation.RecommendCandidate.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RecommendCandidateTest {

    @DisplayName("사진틀은 추천 받은 학생을 등록할 수 있다.")
    @CsvSource({"1", "30", "100"})
    @ParameterizedTest
    public void recommendStudent(int studentNumber) {
        //given
        Frame frame = new Frame(studentNumber);
        //when
        for (int i = 0; i < studentNumber; i++) {
            Student student = new Student(i+1);
            frame.recommendStudent(student);
        }
        //then
        assertThat(frame.getFrame().size()).isEqualTo(studentNumber);
    }

    @DisplayName("한 번 추천받은 학생이 추천을 받으면 추천수가 1 증가한다.")
    @CsvSource({"1", "30", "1000"})
    @ParameterizedTest
    public void updateVote(int recommend) {
        //given
        Frame frame = new Frame(10);
        Student student = new Student(1);
        //when
        for (int i = 0; i < recommend; i++) {
            frame.recommendStudent(student);
        }
        //then
        assertThat(frame.getStudent(1).getRecommend()).isEqualTo(recommend);
    }

    @DisplayName("사진틀이 꽉 차있으면, 추천수가 가장 적은 학생의 사진이 사진틀에서 제거되고, 그 자리에 새롭게 추천받은 학생의 사진이 게시된다.")
    @Test
    public void removeRecommend() {
        //given
        Frame frame = new Frame(3);
        Student student = new Student(1);
        Student student2 = new Student(2);
        Student student3 = new Student(3);
        Student student4 = new Student(4);

        //when
        frame.recommendStudent(student);
        frame.recommendStudent(student);
        frame.recommendStudent(student2);
        frame.recommendStudent(student2);
        frame.recommendStudent(student3);
        frame.recommendStudent(student4);

        //then
        assertThat(frame.getFrame().size()).isEqualTo(3);
        assertThat(frame.getStudent(3)).isNull();

    }

    @DisplayName("추천수가 가장 적은 학생이 여럿일 경우에는 게시된지 오래된 학생의 사진이 사진틀에서 제거된다.")
    @Test
    public void removeDuplicateRecommend() {
        //given
        Frame frame = new Frame(3);
        Student student = new Student(1);
        Student student2 = new Student(2);
        Student student3 = new Student(3);
        Student student4 = new Student(4);

        //when
        frame.recommendStudent(student);
        frame.recommendStudent(student);
        frame.recommendStudent(student);
        frame.recommendStudent(student2);
        frame.recommendStudent(student2);
        frame.recommendStudent(student3);
        frame.recommendStudent(student3);
        frame.recommendStudent(student4);
        frame.recommendStudent(student4);

        //then
        assertThat(frame.getFrame().size()).isEqualTo(3);
        assertThat(frame.getStudent(2)).isNull();
    }

    @DisplayName("사진틀에 게시된 사진이 삭제되는 경우, 해당 학생이 추천받은 횟수는 0으로 바뀐다.")
    @Test
    public void resetVote() {
        //given
        Frame frame = new Frame(3);
        Student student = new Student(1);
        Student student2 = new Student(2);
        Student student3 = new Student(3);
        Student student4 = new Student(4);

        //when
        frame.recommendStudent(student);
        frame.recommendStudent(student2);
        frame.recommendStudent(student3);
        frame.recommendStudent(student4);

        //then
        assertThat(student.getRecommend()).isEqualTo(0);
    }

    @DisplayName("사진틀에 등록된 최종 후보의 학생 번호를 증가하는 순서대로 출력한다.")
    @Test
    public void printCandidate() {
        //given
        Frame frame = new Frame(3);
        Student student = new Student(1);
        Student student2 = new Student(2);
        Student student3 = new Student(3);
        Student student4 = new Student(4);

        //when
        frame.recommendStudent(student);
        frame.recommendStudent(student2);
        frame.recommendStudent(student3);
        frame.recommendStudent(student4);

        //then
        assertThat(frame.printFinalCandidate()).isEqualTo("2 3 4");
    }
}