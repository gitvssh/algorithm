package algorithm.baek.dynamicprograming;

import algorithm.baek.dynamicprograming.Employees.Employee;
import java.io.BufferedReader;
import java.io.IOException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompanyCultureTest {

    @DisplayName("칭찬을 저장할 수 있다.")
    @Test
    void saveCompliment() {
        //given
        Employee employee = new Employee();
        //when
        employee.bePraised(1);
        //then
        Assertions.assertThat(employee.getCompliment()).isEqualTo(1);
    }

    @DisplayName("부하직원의 칭찬을 저장할 수 있다.")
    @Test
    void saveSubordinates() {
        //given
        Employee employee = new Employee();
        Employee subordinate = new Employee();
        subordinate.registerBoss(employee);
        //when
        employee.bePraised(1);
        subordinate.bePraised(2);
        //then
        Assertions.assertThat(subordinate.getCompliment()).isEqualTo(2);
    }

    @DisplayName("모든 직원의 칭찬을 출력할 수 있다.")
    @Test
    void getResult() throws IOException {
        //given
        Employees companyCulture = new Employees();
        //when
        String input = "5 3\n"
                + "-1 1 2 3 4\n"
                + "2 2\n"
                + "3 4\n"
                + "5 6";

        BufferedReader br = new BufferedReader(new java.io.StringReader(input));

        companyCulture.init(br);
        //then
        Assertions.assertThat(companyCulture.getResult()).isEqualTo("0 2 6 6 12");
    }
}