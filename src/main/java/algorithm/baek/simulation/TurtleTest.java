package algorithm.baek.simulation;

import static org.assertj.core.api.Assertions.assertThat;

import algorithm.baek.simulation.Turtle.Direction;
import algorithm.baek.simulation.Turtle.Position;
import algorithm.baek.simulation.Turtle.TurtleRobot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TurtleTest {

    @DisplayName("거북이는 4가지 방향을 가질 수 있다.")
    @Test
    public void position() {
        //given

        //when

        //then
    }

    @DisplayName("거북이는 움직일 수 있다.")
    @Test
    public void canMove() {
        //given
        TurtleRobot turtle = new TurtleRobot();
        turtle.move('F');
        turtle.move('F');
        turtle.move('F');
        turtle.move('F');
        //when
        Position position = turtle.getPosition();
        //then
        assertThat(position.x).isEqualTo(0);
        assertThat(position.y).isEqualTo(4);
    }

    @DisplayName("거북이는 방향을 바꿀 수 있다.")
    @Test
    public void canChangeDirection() {
        //given
        TurtleRobot turtle = new TurtleRobot();
        Direction dir = turtle.getDirection();
        assertThat(dir).isEqualTo(Direction.NORTH);
        //when
        turtle.move('L');
        //then
        assertThat(turtle.getDirection()).isEqualTo(Direction.WEST);
    }

    @DisplayName("거북이는 이동한 면적을 구할 수 있다.")
    @Test
    public void getArea() {
        //given
        TurtleRobot turtle = new TurtleRobot();
        turtle.move('F');
        turtle.move('F');
        turtle.move('F');
        turtle.move('F');
        turtle.move('L');
        turtle.move('F');

        //when
        int area = turtle.getArea();
        //then
        assertThat(area).isEqualTo(4);
    }
}