package algorithm.baek.simulation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EscapeMarbleTest {

    @DisplayName("입력을 통해 게임을 생성할 수 있다.")
    @Test
    void makeGame() {
        //given
        EscapeMarble.MarbleGame game = new EscapeMarble.MarbleGame();
        //when
        game.init(5, 5, new String[]{
                "#####",
                "#..R#",
                "#.###",
                "#O..#",
                "#####"
        });
        //then
        assertThat(game.isCreated()).isTrue();
    }

    @DisplayName("게임은 실행할 수 있다.")
    @Test
    void runGame() {
        //given
        EscapeMarble.MarbleGame game = new EscapeMarble.MarbleGame();
        //when
        game.init(5, 5, new String[]{
                "#####",
                "#..B#",
                "#.#.#",
                "#RO.#",
                "#####"
        });
        //then
        assertThat(game.run()).isOne();
    }

    @DisplayName("보드를 기울일 수 있다.")
    @Test
    void tiltBoard() {
        //given
        EscapeMarble.Board board = new EscapeMarble.Board(5, 5, new String[]{
                "#####",
                "#..B#",
                "#.#.#",
                "#RO.#",
                "#####"
        });
        //when

        //then
        assertThat(board.tilt(EscapeMarble.Direction.UP)).isTrue();
    }

    @DisplayName("보드를 기울여 구슬을 이동시킬 수 있다.")
    @Test
    void moveMarbleByTilting() {
        //given
        EscapeMarble.Board board = new EscapeMarble.Board(5, 5, new String[]{
                "#####",
                "#..B#",
                "#.#.#",
                "#RO.#",
                "#####"
        });
        //when
        board.tilt(EscapeMarble.Direction.UP);
        //then
        assertThat(board.getRedMarblePosition()).isEqualTo(new EscapeMarble.Position(1, 1));
    }

    @DisplayName("구슬은 구멍을 만나면 빼낼 수 있다.")
    @Test
    void escapeMarble() {
        //given
        EscapeMarble.Board board = new EscapeMarble.Board(5, 5, new String[]{
                "#####",
                "#..B#",
                "#.#.#",
                "#RO.#",
                "#####"
        });
        //when
        board.tilt(EscapeMarble.Direction.RIGHT);
        //then
        assertThat(board.getGameState()).isEqualTo(EscapeMarble.State.END);
    }

    @DisplayName("다양한 테스트 케이스를 통과할 수 있다.")
    @Test
    void multiCase() {
        //given
        EscapeMarble.MarbleGame game = new EscapeMarble.MarbleGame();
        //when
        game.init(5, 5, new String[]{
                "#####",
                "#..B#",
                "#.#.#",
                "#RO.#",
                "#####"
        });
        //then
        assertThat(game.run()).isOne();

        //given
        EscapeMarble.MarbleGame game2 = new EscapeMarble.MarbleGame();
        //when
        game2.init(7, 7, new String[]{
                "#######",
                "#...RB#",
                "#.#####",
                "#.....#",
                "#####.#",
                "#O....#",
                "#######"
        });
        //then
        assertThat(game2.run()).isOne();

        //given
        EscapeMarble.MarbleGame game3 = new EscapeMarble.MarbleGame();
        //when
        game3.init(7, 7, new String[]{
                "#######",
                "#..R#B#",
                "#.#####",
                "#.....#",
                "#####.#",
                "#O....#",
                "#######"
        });
        //then
        assertThat(game3.run()).isOne();

        //given
        EscapeMarble.MarbleGame game4 = new EscapeMarble.MarbleGame();
        //when
        game4.init(10, 10, new String[]{
                "##########",
                "#R#...##B#",
                "#...#.##.#",
                "#####.##.#",
                "#......#.#",
                "#.######.#",
                "#.#....#.#",
                "#.#.#.#..#",
                "#...#.O#.#",
                "##########"
        });
        //then
        assertThat(game4.run()).isZero();

        //given
        EscapeMarble.MarbleGame game5 = new EscapeMarble.MarbleGame();
        //when
        game5.init(3, 7, new String[]{
                "#######",
                "#R.O.B#",
                "#######"
        });
        //then
        assertThat(game5.run()).isOne();

        //given
        EscapeMarble.MarbleGame game6 = new EscapeMarble.MarbleGame();
        //when
        game6.init(10, 10, new String[]{
                "##########",
                "#R#...##B#",
                "#...#.##.#",
                "#####.##.#",
                "#......#.#",
                "#.######.#",
                "#.#....#.#",
                "#.#.##...#",
                "#O..#....#",
                "##########"
        });
        //then
        assertThat(game6.run()).isOne();

        //given
        EscapeMarble.MarbleGame game7 = new EscapeMarble.MarbleGame();
        //when
        game7.init(3, 10, new String[]{
                "##########",
                "#.O....RB#",
                "##########"
        });
        //then
        assertThat(game7.run()).isZero();
    }
}