package algorithm.baek.simulation;

public class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position add(Position pos) {
        return new Position(x + pos.x, y + pos.y);
    }

    @Override
    public int hashCode() {
        return x * 31 + y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Position){
            Position pos = (Position) obj;
            return x == pos.x && y == pos.y;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
