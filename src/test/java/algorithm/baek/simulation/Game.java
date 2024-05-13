package algorithm.baek.simulation;

public class Game {
    private ChessBoard chessBoard;

    public void init(String[] boards) {
        chessBoard = new ChessBoard();
        chessBoard.makeBoard(boards);
    }

    public void init(String[] boards, String[] units) {
        init(boards);
        chessBoard.placeUnit(units);
    }

    public boolean checkBoard() {
        return chessBoard.getBoard();
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }
}
