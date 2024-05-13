package algorithm.baek.simulation;

import algorithm.baek.simulation.RollingDice.Dice;
import java.util.Stack;

public class Tile {

    Type type;
    Position position;
    Stack<Unit> units;

    public Tile(char c) {
        type = Type.valueOf(c);
    }

    public Tile(Position position, char c) {
        type = Type.valueOf(c);
        this.position = position;
    }

    public void setUnit(Unit unit) {
        if (units == null) {
            units = new Stack<>();
        }
        units.push(unit);
    }

    public Stack<Unit> getUnit() {
        return units;
    }

    public Type getType() {
        return type;
    }
}
