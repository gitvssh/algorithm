package algorithm.baek.string;

import algorithm.baek.string.GuardDuty.TimeTable;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuardDutyTest {

    /*
    - 근무자의 근무 시간을 저장할 수 있다.
    - 근무자의 최대, 최소 근무시간을 알 수 있다.
    - 근무자의 근무시간 차이가 12시간 이하인지 알 수 있다.
     */

    @DisplayName("근무자의 근무시간을 저장할 수 있다")
    @Test
    void saveDutyTime() {
        //given
        TimeTable timeTable = new TimeTable();
        String input = "4\n"
                + "- - - - - pangyo puang\n"
                + "- - - - - sally boss\n"
                + "- - - - - leonard brown\n"
                + "- - - - - edward edward\n"
                + "puang pangyo choco leonard cony leonard choco\n"
                + "cony edward cony leonard moon puang edward\n"
                + "choco boss puang brown brown pangyo cony\n"
                + "choco edward puang cony moon choco boss\n"
                + "brown moon moon sally pangyo puang choco\n"
                + "pangyo edward boss sally moon cony pangyo\n"
                + "brown puang james moon cony choco choco\n"
                + "sally brown sally puang james moon sally\n"
                + "leonard pangyo - - - - -\n"
                + "boss choco - - - - -\n"
                + "moon edward - - - - -\n"
                + "moon sally - - - - -";
        //String을 InputStreamReader로 변환
        InputStreamReader ir = new InputStreamReader(new ByteArrayInputStream(input.getBytes()));
        //when
        timeTable.init(ir);
        //then
        Assertions.assertThat(timeTable.getDutyTime("pangyo")).isEqualTo(32);
    }

    @DisplayName("근무자의 최대, 최소 근무시간을 알 수 있다.")
    @Test
    void getMinMaxTime() {
        //given
        TimeTable timeTable = new TimeTable();
        String input = "4\n"
                + "- - - - - pangyo puang\n"
                + "- - - - - sally boss\n"
                + "- - - - - leonard brown\n"
                + "- - - - - edward edward\n"
                + "puang pangyo choco leonard cony leonard choco\n"
                + "cony edward cony leonard moon puang edward\n"
                + "choco boss puang brown brown pangyo cony\n"
                + "choco edward puang cony moon choco boss\n"
                + "brown moon moon sally pangyo puang choco\n"
                + "pangyo edward boss sally moon cony pangyo\n"
                + "brown puang james moon cony choco choco\n"
                + "sally brown sally puang james moon sally\n"
                + "leonard pangyo - - - - -\n"
                + "boss choco - - - - -\n"
                + "moon edward - - - - -\n"
                + "moon sally - - - - -";
        //String을 InputStreamReader로 변환
        InputStreamReader ir = new InputStreamReader(new ByteArrayInputStream(input.getBytes()));
        //when
        timeTable.init(ir);
        //then
        Assertions.assertThat(timeTable.getMax()).isEqualTo(58);
        Assertions.assertThat(timeTable.getMin()).isEqualTo(14);
    }

    @DisplayName("근무시간 차이가 12시간 이하인지 알 수 있다")
    @Test
    void printDiffTime() {
        //given
        TimeTable timeTable = new TimeTable();
        String input = "4\n"
                + "- - - - - sally boss\n"
                + "- - - - - brown boss\n"
                + "- - - - - moon sally\n"
                + "- - - - - leonard edward\n"
                + "pangyo moon cony boss james sally brown\n"
                + "moon brown sally cony brown choco edward\n"
                + "moon leonard pangyo moon edward puang puang\n"
                + "leonard sally boss choco cony boss edward\n"
                + "brown sally jessica leonard moon jessica james\n"
                + "jessica brown leonard puang james pangyo puang\n"
                + "puang choco james cony jessica pangyo jessica\n"
                + "pangyo jessica choco james puang cony pangyo\n"
                + "moon moon james choco edward - -\n"
                + "jessica brown james sally puang - -\n"
                + "cony leonard moon boss choco - -\n"
                + "edward jessica cony brown leonard - -";
        //String을 InputStreamReader로 변환
        InputStreamReader ir = new InputStreamReader(new ByteArrayInputStream(input.getBytes()));
        //when
        timeTable.init(ir);
        //then
        Assertions.assertThat(timeTable.isEqual()).isTrue();
    }

}