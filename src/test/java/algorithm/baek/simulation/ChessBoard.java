package algorithm.baek.simulation;

import java.util.ArrayList;

public class ChessBoard {

    ArrayList<ArrayList<Tile>> tiles;

    public void makeBoard(String[] boards) {
        int length = boards.length;
        tiles = new ArrayList<>();
        for (int y = 0; y < length; y++) {
            String[] split = boards[y].split(" ");
            tiles.add(new ArrayList<>());
            for (int x = 0; x < length; x++) {
                tiles.get(y).add(new Tile(new Position(x, y),split[x].charAt(0)));
            }
        }
    }

    public boolean getBoard() {
        return tiles != null;
    }

    public void placeUnit(String[] units) {
        for (String unit : units) {
            String[] split = unit.split(" ");
            int y = Integer.parseInt(split[0]) - 1;
            int x = Integer.parseInt(split[1]) - 1;
            Position pos = new Position(x, y);
            Direction dir = Direction.valueOf(Integer.parseInt(split[2]));
            tiles.get(y).get(x).setUnit(new Unit(pos, dir));
        }
    }

    public boolean isInBoard(Position nextPos) {
        return nextPos.getX() >= 0 && nextPos.getX() < tiles.size() && nextPos.getY() >= 0 && nextPos.getY() < tiles.size();
    }
}
