package algorithm.baek.simulation;

public enum Direction {

    RIGHT(1, new int[]{0, 1}), LEFT(2, new int[]{0, -1}),
    UP(3, new int[]{-1, 0}), DOWN(4, new int[]{1, 0});
    private final int dir;
    private final int[] correlation;

    Direction(int dir, int[] correlation) {
        this.dir = dir;
        this.correlation = correlation;
    }

    public int getDir() {
        return dir;
    }

    public Position getCorrelation() {
        return new Position(correlation[1], correlation[0]);
    }

    public static Direction valueOf(int dir) {
        switch (dir) {
            case 1:
                return RIGHT;
            case 2:
                return LEFT;
            case 3:
                return UP;
            case 4:
                return DOWN;
            default:
                throw new IllegalArgumentException("Unexpected value: " + dir);
        }
    }

    public Direction getOpposite(Direction dir) {
        switch (dir) {
            case RIGHT:
                return LEFT;
            case LEFT:
                return RIGHT;
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            default:
                throw new IllegalArgumentException("Unexpected value: " + dir);
        }
    }
}
