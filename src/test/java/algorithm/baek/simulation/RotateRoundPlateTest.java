package algorithm.baek.simulation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RotateRoundPlateTest {

    @DisplayName("원판을 생성할 수 있다.")
    @Test
    void initRoundPlate() {
        //given
        RotateRoundPlate.RoundPlate roundPlate = new RotateRoundPlate.RoundPlate(4, 4);
        String[] numbers = {
            "1 1 2 3",
            "5 2 4 2",
            "3 1 3 5",
            "2 1 3 2"
        };

        roundPlate.initRoundPlate(numbers);
        //when

        //then
        assertThat(roundPlate.getRoundPlate().length).isEqualTo(4);
    }

    @DisplayName("x의 배수인 원판을 회전할 수 있다.")
    @Test
    void rotateXPlate() {
        //given
        RotateRoundPlate.RoundPlate roundPlate = new RotateRoundPlate.RoundPlate(4, 4);
        String[] numbers = {
                "1 1 2 3",
                "5 2 4 2",
                "3 1 3 5",
                "2 1 3 2"
        };

        roundPlate.initRoundPlate(numbers);
        //when
        roundPlate.rotateNPlate(1, 0, 1);
        //then
        assertThat(roundPlate.getRoundPlate()[0][0]).isEqualTo(3);
        assertThat(roundPlate.getRoundPlate()[1][0]).isEqualTo(2);
        assertThat(roundPlate.getRoundPlate()[2][0]).isEqualTo(5);
        assertThat(roundPlate.getRoundPlate()[3][0]).isEqualTo(2);
    }

    @DisplayName("원판은 회전시킨 원판의 수를 변경할 수 있다.")
    @Test
    void changeNumber() {
        //given
        RotateRoundPlate.RoundPlate roundPlate = new RotateRoundPlate.RoundPlate(4, 4);
        String[] numbers = {
                "1 1 2 3",
                "5 2 4 2",
                "3 1 3 5",
                "2 1 3 2"
        };

        roundPlate.initRoundPlate(numbers);
        //when
        roundPlate.rotateNPlate(2, 0, 1);
        roundPlate.changeNumber();
        //then
        assertThat(roundPlate.getRoundPlate()[0][0]).isEqualTo(-1);
        assertThat(roundPlate.getRoundPlate()[3][0]).isEqualTo(-1);
    }

    @DisplayName("원판은 회전시킨 후 최종 합을 구할 수 있다.")
    @Test
    void getSum() {
        //given
        RotateRoundPlate.RoundPlate roundPlate = new RotateRoundPlate.RoundPlate(4, 4);
        String[] numbers = {
                "1 1 2 3",
                "5 2 4 2",
                "3 1 3 5",
                "2 1 3 2"
        };

        roundPlate.initRoundPlate(numbers);
        //when
        roundPlate.rotateNPlate(2, 0, 1);
        roundPlate.changeNumber();
        //then
        assertThat(roundPlate.getSum()).isEqualTo(30);
    }
}