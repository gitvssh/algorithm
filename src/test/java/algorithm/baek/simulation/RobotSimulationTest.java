package algorithm.baek.simulation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import algorithm.baek.simulation.RobotSimulation.Position;
import algorithm.baek.simulation.RobotSimulation.Robot.DuplicatePostionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import algorithm.baek.simulation.RobotSimulation.Ground;
import algorithm.baek.simulation.RobotSimulation.Robot;
import algorithm.baek.simulation.RobotSimulation.Direction;

class RobotSimulationTest {

    /*
    1. 로봇은 땅에 배치될 수 있다.
    2. 로봇은 회전할 수 있다.
    3. 로봇은 이동할 수 있다.
    4. 로봇은 잘못된 명령을 감지할 수 있다.
     */

    @DisplayName("로봇은 땅에 배치될 수 있다.")
    @Test
    public void positioning() {
        //given
        Ground ground = new Ground(5, 5);
        Robot robot = new Robot(1,new Position(1, 1), Direction.N, ground);
        //when
        ground.putRobot(robot);
        //then
        assertThat(ground.getRobot(robot.getPosition())).isEqualTo(robot);
    }

    @DisplayName("로봇은 회전할 수 있다.")
    @Test
    public void canRotate() throws DuplicatePostionException {
        //given
        Ground ground = new Ground(5, 5);
        Robot robot = new Robot(1,new Position(1, 1), Direction.N, ground);
        Robot robot2 = new Robot(2,new Position(1, 1), Direction.N, ground);
        Robot robot3 = new Robot(3,new Position(1, 1), Direction.N, ground);
        Robot robot4 = new Robot(4,new Position(1, 1), Direction.N, ground);
        //when
        robot.command('L');
        robot2.command('R');
        robot3.command('R');
        robot3.command('R');
        robot4.command('L');
        robot4.command('R');
        //then
        assertThat(robot.getDirection()).isEqualTo(Direction.W);
        assertThat(robot2.getDirection()).isEqualTo(Direction.E);
        assertThat(robot3.getDirection()).isEqualTo(Direction.S);
        assertThat(robot4.getDirection()).isEqualTo(Direction.N);
    }

    @DisplayName("로봇은 이동할 수 있다.")
    @Test
    public void canMove() throws DuplicatePostionException {
        //given
        Ground ground = new Ground(5, 5);
        Robot robot = new Robot(1, new Position(1, 1), Direction.N, ground);
        //when
        ground.putRobot(robot);
        robot.command('F');
        //then
        assertThat(ground.getRobot(robot.getPosition())).isEqualTo(robot);
    }

    @DisplayName("로봇은 잘못된 명령을 감지할 수 있다.")
    @Test
    public void detectErrorCommand() {
        //given
        Ground ground = new Ground(5, 5);
        Robot robot = new Robot(1, new Position(1, 1), Direction.N, ground);
        Robot robot2 = new Robot(2, new Position(1, 2), Direction.N, ground);
        Robot robot3 = new Robot(3, new Position(2, 1), Direction.N, ground);
        //when
        ground.putRobot(robot);
        ground.putRobot(robot2);
        ground.putRobot(robot3);
        try{
            robot.command('F');
        } catch (DuplicatePostionException e) {
            //then
            assertThat(e.getMessage()).isEqualTo("2");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("벽에 부딪혔습니다.");
        }
        try{
            robot3.command('L');
            robot3.command('F');
            robot3.command('F');
        } catch (DuplicatePostionException e) {
            //then
            assertThat(e.getMessage()).isEqualTo("다른 로봇에 부딪혔습니다.");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("벽에 부딪혔습니다.");
        }
    }
}