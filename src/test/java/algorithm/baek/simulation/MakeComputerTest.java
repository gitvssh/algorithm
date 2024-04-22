package algorithm.baek.simulation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import algorithm.baek.simulation.MakeComputer.MyComputer;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MakeComputerTest {

    @BeforeAll
    static void init() throws IOException {

    }

    @DisplayName("컴퓨터에 명령어를 입력 수 있다.")
    @Test
    public void readProgram() {
        //given
        MyComputer myComputer = new MyComputer();
        myComputer.readProgram(List.of("00111110"
                , "10100000"
                , "01010000"
                , "11100000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00111111"
                , "10000000"
                , "00000010"
                , "11000010"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "11111111"
                , "10001001"));
        //when

        //then
        assertThat(myComputer.getMemory()).isNotNull();
        assertThat(myComputer.getMemory().getMemory().length).isEqualTo(32);
    }

    @DisplayName("명령어를 실행할 수 있다.")
    @Test
    public void excuteCommand() {
        //given
        MyComputer myComputer = new MyComputer();
        myComputer.readProgram(List.of("00111110"
                , "10100000"
                , "01010000"
                , "11100000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00111111"
                , "10000000"
                , "00000010"
                , "11000010"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "00000000"
                , "11111111"
                , "10001001"));
        //when
        myComputer.executeCommand();
        //then
        assertThat(myComputer.getAccumulator().printValue()).isEqualTo("10000111");
    }
}