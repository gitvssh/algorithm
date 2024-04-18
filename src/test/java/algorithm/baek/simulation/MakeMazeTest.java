package algorithm.baek.simulation;

import static org.assertj.core.api.Assertions.assertThat;

import algorithm.baek.simulation.MakeMaze.DIRECTION;
import algorithm.baek.simulation.MakeMaze.MazeBoard;
import algorithm.baek.simulation.MakeMaze.MazeUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MakeMazeTest {

    @DisplayName("미로를 만들 수 있다.")
    @Test
    public void makeMaze() {
        //given
        MazeBoard maze = new MazeBoard();
        //when

        //then
        assertThat(maze).isNotNull();
    }

    @DisplayName("사용자는 명령어를 통해 움직일 수 있다.")
    @Test
    public void canMove() {
        //given
        MazeUser user = new MazeUser();
        MazeUser user2 = new MazeUser();
        //when
        user.command("R");
        user2.command("RF");
        //then
        assertThat(user.dir).isEqualTo(DIRECTION.WEST);
        assertThat(user.x).isEqualTo(0);
        assertThat(user2.dir).isEqualTo(DIRECTION.WEST);
        assertThat(user2.x).isEqualTo(-1);
    }

    @DisplayName("사용자는 움직인 장소를 기록할 수 있다.")
    @Test
    public void writeMap() {
        //given
        MazeBoard maze = new MazeBoard();
        MazeUser user = new MazeUser(maze);
        MazeUser user2 = new MazeUser(maze);
        //when
        user.command("RFFF");
        //then
        assertThat(maze.maze[49][50]).isEqualTo('.');
        assertThat(maze.maze[48][50]).isEqualTo('.');
        assertThat(maze.maze[47][50]).isEqualTo('.');
        assertThat(maze.maxX).isEqualTo(50);
        assertThat(maze.minX).isEqualTo(47);
    }

    @DisplayName("사용자는 움직인 지도를 출력할 수 있다.")
    @Test
    public void printMap() {
        //given
        MazeBoard maze = new MazeBoard();
        MazeBoard maze2 = new MazeBoard();
        MazeUser user = new MazeUser(maze);
        MazeUser user2 = new MazeUser(maze2);
        //when
        user.command("RRFRF");
        user2.command("LFFRFF");

        //then
        assertThat(user.printMap().toString()).isEqualTo("..\n.#\n");
        assertThat(user2.printMap().toString()).isEqualTo("...\n##.\n##.\n");
    }

}