package algorithm.baek.datastructure;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineUpTest {
    @DisplayName("학생이 새로 추가되면 제일 뒤에 추가된다.")
    @Test
    void addStudent() {
        //given
        LineUp.Line line = new LineUp.Line();
        //when
        line.addStudent(new LineUp.Student(1),0);
        line.addStudent(new LineUp.Student(2),1);
        //then
        assertThat(line.getStudents(0)).isEqualTo(new LineUp.Student(2));
    }

    @DisplayName("학생이 번호표를 뽑아 추가되면, 해당 수 만큼 뒤에서 앞으로 이동한다.")
    @Test
    void addSpecifyPosition() {
        //given
        LineUp.Line line = new LineUp.Line();
        //when
        line.addStudent(new LineUp.Student(1),0);
        line.addStudent(new LineUp.Student(2),1);
        line.addStudent(new LineUp.Student(3),1);
        line.addStudent(new LineUp.Student(4),3);
        line.addStudent(new LineUp.Student(5),2);
        //then
        assertThat(line.getStudents(0)).isEqualTo(new LineUp.Student(4));
        assertThat(line.getStudents(1)).isEqualTo(new LineUp.Student(2));
        assertThat(line.getStudents(2)).isEqualTo(new LineUp.Student(5));
        assertThat(line.getStudents(3)).isEqualTo(new LineUp.Student(3));
        assertThat(line.getStudents(4)).isEqualTo(new LineUp.Student(1));
    }

    @DisplayName("최종적으로 줄을 선 순서를 출력할 수 있다.")
    @Test
    void printResult() {
        //given
        LineUp.Line line = new LineUp.Line();
        //when
        line.addStudent(new LineUp.Student(1),0);
        line.addStudent(new LineUp.Student(2),1);
        line.addStudent(new LineUp.Student(3),1);
        line.addStudent(new LineUp.Student(4),3);
        line.addStudent(new LineUp.Student(5),2);
        //then
        assertThat(line.getLine()).isEqualTo("4 2 5 3 1");
    }

    @DisplayName("문자열을 입력받아 학생을 추가할 수 있다.")
    @Test
    void addStudentByString() {
        //given
        LineUp.Line line = new LineUp.Line();
        //when
        line.addStudentByString(5, "0 1 1 3 2");
        //then
        assertThat(line.getLine()).isEqualTo("4 2 5 3 1");
    }
}