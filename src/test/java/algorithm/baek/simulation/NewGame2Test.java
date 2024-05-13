package algorithm.baek.simulation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Stack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NewGame2Test {

    @DisplayName("체스판을 생성할 수 있다.")
    @Test
    void makeChessBoard() {
        //given
        Game game = new Game();
        //when
        String[] input = {"0 0 0 2", "0 0 1 0", "0 0 1 2", "0 2 0 0"};
        game.init(input);
        //then
        assertThat(game.checkBoard()).isNotNull();
    }

    @DisplayName("말을 체스판에 배치할 수 있다.")
    @Test
    void placeUnit() {
        //given
        Game game = new Game();
        //when
        String[] boards = {"0 0 0 2", "0 0 1 0", "0 0 1 2", "0 2 0 0"};
        String[] units = {"2 1 1", "3 2 3", "2 2 1", "4 1 2"};
        game.init(boards, units);
        //then
        assertThat(game.checkBoard()).isNotNull();
    }

    @DisplayName("말을 이동할 수 있다.")
    @Test
    void moveUnit() {
        //given
        Game game = new Game();
        String[] boards = {"0 0 0 2", "0 0 1 0", "0 0 1 2", "0 2 0 0"};
        String[] units = {"2 1 1", "3 2 3", "2 2 1", "4 1 2"};
        game.init(boards, units);
        //when
        ChessBoard chessBoard = game.getChessBoard();
        Stack<Unit> unit = chessBoard.tiles.get(1).get(1).getUnit();
        Unit unit1 = unit.pop();
        unit1.move(chessBoard);

        //then
        assertThat(unit1.getPosition()).isEqualTo(new Position(2,1));
    }
}