package algorithm.baek.simulation;

public class Unit {
    Position pos;
    Direction dir;

    public Unit(Position pos, Direction dir) {
        this.pos = pos;
        this.dir = dir;
    }

    public void move(ChessBoard chessBoard) {
        Position nextPos = pos.add(dir.getCorrelation());
        Type type = chessBoard.tiles.get(nextPos.getY()).get(nextPos.getX()).getType();
        if (!chessBoard.isInBoard(nextPos) || type == Type.BLUE) {
            dir = dir.getOpposite(dir);
            return;
        }
        if (type == Type.WHITE) {
            return;
        }else if(type == Type.RED){
            dir = dir.getOpposite(dir);
        }
    }

    public Position getPosition() {
        return pos;
    }
}
