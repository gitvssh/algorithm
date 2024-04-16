package algorithm.baek.simulation;

import static org.assertj.core.api.Assertions.assertThat;

import algorithm.baek.simulation.Wheel.WheelBoard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WheelTest {

    @DisplayName("돌림판의 색을 출력할 수 있다.")
    @Test
    public void print() {
        //given
        WheelBoard wheel = new WheelBoard("RGB",3);
        //when
        wheel.printColor();
        //then
        assertThat(wheel.red).isEqualTo(1);
        assertThat(wheel.green).isEqualTo(1);
        assertThat(wheel.blue).isEqualTo(1);
    }

    @DisplayName("돌림판의 색을 1번 규칙에 맞게 변경할 수 있다.")
    @Test
    public void change1() {
        //given
        WheelBoard wheel = new WheelBoard("RRR",3);
        WheelBoard wheel2 = new WheelBoard("GGG",3);
        //when
        wheel.changeColor();
        wheel2.changeColor();
        //then
        //BRR -> BGR -> BGB
        assertThat(wheel.red).isEqualTo(0);
        assertThat(wheel.green).isEqualTo(0);
        assertThat(wheel.blue).isEqualTo(3);

        //BGG -> BRG -> BRB
        assertThat(wheel2.red).isEqualTo(0);
        assertThat(wheel2.green).isEqualTo(0);
        assertThat(wheel2.blue).isEqualTo(3);
    }

    @DisplayName("돌림판의 색을 여러번 변경할 수 있다.")
    @Test
    public void change5() {
        //given
        WheelBoard wheel = new WheelBoard("RGB",3);
        WheelBoard wheel2 = new WheelBoard("RRGGBB",6);
        // BGB -> BGB -> BGG
        //
        //when
        wheel.changeColor(5);
        wheel2.changeColor(3);
        //then
        assertThat(wheel.red).isEqualTo(0);
        assertThat(wheel.green).isEqualTo(0);
        assertThat(wheel.blue).isEqualTo(3);

        assertThat(wheel2.red).isEqualTo(3);
        assertThat(wheel2.green).isEqualTo(3);
        assertThat(wheel2.blue).isEqualTo(0);
    }
}