package algorithm.baek.simulation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CastleDefenceTest {

    @DisplayName("게임을 만들 수 있어야 한다.")
    @Test
    public void makeGame() {
        //given
        CastleDefence.Game game = new CastleDefence.Game(5, 5, 1);
        //when
        String[] map = {
                "0 0 0 0 0",
                "0 0 0 0 0",
                "0 0 0 0 0",
                "0 0 0 0 0",
                "1 1 1 1 1"
        };
        game.init(map);
        //then
        assertThat(game.getMap().length).isEqualTo(5);
        assertThat(game.getMap()[0].length).isEqualTo(5);
        assertThat(game.getArcherLimit()).isEqualTo(1);
    }

    @DisplayName("게임은 궁수의 위치를 입력받아 시뮬레이션을 시행할 수 있어야 한다.")
    @Test
    public void runSimulation() {
        //given
        CastleDefence.Game game = new CastleDefence.Game(5, 5, 1);
        //when
        game.setArcher(0, 1, 3);
        game.run();
        //then
        assertThat(game.getArcher().get(0).getPosition().getX()).isEqualTo(0);
        assertThat(game.getArcher().get(1).getPosition().getX()).isEqualTo(1);
        assertThat(game.getArcher().get(2).getPosition().getX()).isEqualTo(3);
    }

    @DisplayName("적은 이동할 수 있다.")
    @Test
    public void enermyCanMove() {
        //given
        CastleDefence.Game game = new CastleDefence.Game(5, 5, 1);
        String[] map = {
                "0 0 0 0 0",
                "0 0 0 0 0",
                "0 0 0 0 0",
                "1 1 1 1 1",
                "0 0 0 0 0"
        };
        game.init(map);
        //when
        game.run();
        //then
        assertThat(game.getMap()[4][0]).isEqualTo(0);
        assertThat(game.getMap()[4][1]).isEqualTo(0);
        assertThat(game.getMap()[4][2]).isEqualTo(0);
        assertThat(game.getMap()[4][3]).isEqualTo(0);
        assertThat(game.getMap()[4][4]).isEqualTo(0);
    }

    @DisplayName("적이 성이 있는 칸으로 이동하면 게임에서 제외된다.")
    @Test
    public void enermyCanRemove() {
        //given
        CastleDefence.Game game = new CastleDefence.Game(5, 5, 1);
        String[] map = {
                "0 0 0 0 0",
                "0 0 0 0 0",
                "0 0 0 0 0",
                "0 0 0 0 0",
                "1 1 1 1 1"
        };
        game.init(map);
        //when
        game.endTurn();
        //then
        assertThat(game.getMap()[4][0]).isEqualTo(0);
        assertThat(game.getMap()[4][1]).isEqualTo(0);
        assertThat(game.getMap()[4][2]).isEqualTo(0);
        assertThat(game.getMap()[4][3]).isEqualTo(0);
        assertThat(game.getMap()[4][4]).isEqualTo(0);
    }

    @DisplayName("모든 적이 제외되면 게임이 종료된다")
    @Test
    public void endGame() {
        //given
        CastleDefence.Game game = new CastleDefence.Game(5, 5, 1);
        String[] map = {
                "0 0 0 0 0",
                "0 0 0 0 0",
                "0 0 0 0 0",
                "0 0 0 0 0",
                "1 1 1 1 1"
        };
        game.init(map);
        //when
        game.endTurn();
        //then
        assertThat(game.isEndGame()).isTrue();
    }

    @DisplayName("궁수는 적을 공격하여 게임에서 제외할 수 있다.")
    @Test
    public void archerCanEliminateEnermy() {
        //given
        CastleDefence.Game game = new CastleDefence.Game(5, 5, 1);
        //when
        String[] map = {
                "0 0 0 0 0",
                "0 0 0 0 0",
                "0 0 0 0 0",
                "1 0 0 0 0",
                "0 0 0 0 0"
        };
        game.init(map);
        game.setArcher(0, 1, 3);
        //when
        game.run();

        //then
        assertThat(game.getMap()[4][0]).isEqualTo(0);
    }

    @DisplayName("시뮬레이션은 제거할 수 있는 적의 최대 수를 출력할 수 있다.")
    @Test
    public void printMaxEnermy() {
        //given
        CastleDefence.Game game = new CastleDefence.Game(5, 5, 1);
        //when
        String[] map = {
                "0 0 0 0 0",
                "0 0 0 0 0",
                "0 0 0 0 0",
                "1 0 0 0 0",
                "0 0 0 0 0"
        };
        game.init(map);
        game.setArcher(0, 1, 3);
        //when
        game.run();

        //then
        assertThat(game.getMaxEnermy()).isEqualTo(1);
    }

    @DisplayName("시뮬레이션을 여러 번 수행하여 최대값을 구할 수 있다.")
    @Test
    public void doSimulation() {
        //given
        CastleDefence.Game game = new CastleDefence.Game(5, 5, 1);
        //when
        String[] map = {
                "0 0 0 0 0",
                "0 0 0 0 0",
                "0 0 0 0 0",
                "0 0 0 0 0",
                "1 1 1 1 1"
        };
        game.init(map);
        //when
        //then
        assertThat(game.doSimulation()).isEqualTo(3);
    }

}