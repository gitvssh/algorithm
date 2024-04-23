package algorithm.baek.simulation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RollingDiceTest {

    @DisplayName("주사위는 명령에 따라 움직일 수 있다.")
    @Test
    public void diceCanMove() {
        //given
        RollingDice.Dice dice = new RollingDice.Dice(0, 0);
        RollingDice.Map map = new RollingDice.Map(4, 2, dice);
        //when
        map.moveDice(4);
        map.moveDice(4);
        map.moveDice(4);
        //then
        assertThat(map.getDice().getPoint()).isEqualTo("0 3");
    }

    @DisplayName("주사위는 지도 밖으로 이동하지 않는다.")
    @Test
    public void diceCantMoveOutToMap() {
        //given
        RollingDice.Dice dice = new RollingDice.Dice(0, 0);
        RollingDice.Map map = new RollingDice.Map(4, 2, dice);
        //when
        map.moveDice(4);
        map.moveDice(4);
        map.moveDice(4);
        map.moveDice(4);
        map.moveDice(4);
        map.moveDice(4);

        //then
        assertThat(map.getDice().getPoint()).isEqualTo("0 3");
    }

    @DisplayName("지도는 특정 상황에서 값이 변경된다.")
    @Test
    public void mapCanChangeValue() {
        //given
        RollingDice.Dice dice = new RollingDice.Dice(0, 0);
        RollingDice.Map map = new RollingDice.Map(6, 2, dice);
        map.map = new int[][]{{0, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}, {0, 12}};
        //when
        map.moveDice(4);
        map.moveDice(4);
        map.moveDice(4);
        map.moveDice(4);
        map.moveDice(4);
        map.moveDice(4);
        //then
        assertThat(map.map[5][0]).isEqualTo(3);
    }

    @DisplayName("주사위는 특정 규칙에 따라 값이 변경된다.")
    @Test
    public void diceCanChangeValue() {
        //given
        RollingDice.Dice dice = new RollingDice.Dice(0, 0);
        RollingDice.Map map = new RollingDice.Map(6, 2, dice);
        map.map = new int[][]{{0, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}, {0, 12}};
        //when
        map.moveDice(4);
        //then
        assertThat(dice.dice[5]).isEqualTo(3);
    }

    @DisplayName("주사위는 현재 상단의 값을 출력할 수 있다.")
    @Test
    public void printTopOfDice() {
        //given
        RollingDice.Dice dice = new RollingDice.Dice(0, 0);
        RollingDice.Map map = new RollingDice.Map(4, 2, dice);
        map.map = new int[][]{{0, 2}, {3, 4}, {5, 6}, {7, 8}};
        //when
        map.moveDice(4);
        map.moveDice(4);
        map.moveDice(4);
        //then
        assertThat(dice.dice[0]).isEqualTo(3);
    }
}