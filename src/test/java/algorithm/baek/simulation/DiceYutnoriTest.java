package algorithm.baek.simulation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import algorithm.baek.simulation.DiceYutnori.YutnoriBoard.Yut;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiceYutnoriTest {

    @DisplayName("말은 주어진 숫자만큼 이동할 수 있다.")
    @Test
    void moveItem() {
        //given
        DiceYutnori.YutnoriBoard board = new DiceYutnori.YutnoriBoard();
        Yut[] yuts = board.initYuts();
        //when
        board.moveItem(yuts,1, 1);
        //then
        assertThat(board.getTotalPoint()).isEqualTo(2);
    }

    @DisplayName("파란색 칸에서 이동을 시작하면 파란색 화살표를 타야한다.")
    @Test
    void moveByBlueStart() {
        //given
        DiceYutnori.YutnoriBoard board = new DiceYutnori.YutnoriBoard();
        Yut[] yuts = board.initYuts();
        //when
        board.moveItem(yuts,1, 5);
        board.moveItem(yuts,1, 1);
        //then
        assertThat(board.getTotalPoint()).isEqualTo(23);
    }

    @DisplayName("이동중이거나 파란색이 아닌 칸에서 이동을 시작하면 빨간색 화살표를 타야한다.")
    @Test
    void moveByNormalStart() {
        //given
        DiceYutnori.YutnoriBoard board = new DiceYutnori.YutnoriBoard();
        Yut[] yuts = board.initYuts();
        //when
        board.moveItem(yuts,1, 4);
        board.moveItem(yuts,1, 3);
        //then
        assertThat(board.getTotalPoint()).isEqualTo(22);
    }

    @DisplayName("말이 이동을 마치는 칸에 다른 말이 있으면 그 말은 고를 수 없다. 단 이동을 마치는 칸이 도착 칸이면 고를 수 있다.")
    @Test
    void canNotDuplicateItemOnTile() {
        //given
        DiceYutnori.YutnoriBoard board = new DiceYutnori.YutnoriBoard();
        Yut[] yuts = board.initYuts();
        //when
        board.moveItem(yuts,1, 4);
        board.moveItem(yuts,0, 4);
        //then
        assertThat(board.getTotalPoint()).isEqualTo(8);
    }

    @DisplayName("주사위 10개를 입력하여 최대값을 시뮬레이션 할 수 있다.")
    @Test
    void simulate() {
        //given
        DiceYutnori.YutnoriBoard board = new DiceYutnori.YutnoriBoard();
        //when
        int maxPoint = board.simulate("1 2 3 4 1 2 3 4 1 2");
        //then
        assertThat(maxPoint).isEqualTo(190);
    }
}