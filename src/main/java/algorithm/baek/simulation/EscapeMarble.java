package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/13459
 * 백준 13459번 구슬 탈출
 */
public class EscapeMarble implements TestCase {

    /*
    분석(5m)
    설계(15m)
    구현(40m)

    분석
    - 직사각형 보드에 빨간 구슬과 파란 구슬이 존재
    - 빨간 구슬을 구멍을 통해 빼내는 게임
    - 파란 구슬이 빠지면 안됨
    - 동시에 빠져도 실패
    - 상하좌우로 기울이는 동작을 할 수 있음
    - 빨간 구슬이 구멍을 통해 빠져나가는지 판단
    - 더이상 구슬이 움직이지 않으면 게임 종료
    - 10번 이하로 기울여서 빨간 구슬을 구멍을 통해 빼낼 수 있는지 판단

    설계
    - 엔티티
    - 보드, 구슬
    - 보드
      - 구멍
      - 구슬
      - 기울이다
        - 구슬이 겹쳐있는 경우 주의
      - 시행 횟수
    - 구슬
      - enum 관리
      - 움직이다(중력)

    요구사항
    - 일정 횟수 이내로 빨간 구슬을 구멍을 통해 빼낼 수 있는지 알 수 있다.
    o 보드를 기울일 수 있다.
    o 구슬은 보드를 기울이면 움직일 수 있다.
    o 구슬은 구멍을 통해 빼낼 수 있다.
    o 입력을 통해 게임을 생성할 수 있다.
    o 게임은 실행할 수 있다.
     */

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String[] board = new String[n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }
        MarbleGame game = new MarbleGame();
        game.init(n, m, board);
        System.out.println(game.run());
    }

    public static class MarbleGame {

        Board board;
        State gameState;

        public void init(int n, int m, String[] input) {
            board = new Board(n, m, input);
            gameState = board.gameState;
        }

        public boolean isCreated() {
            return gameState != null;
        }

        public int run() {
            board.gameState = State.RUN;
            return bfs(board);
        }

        private int bfs(Board board) {
            Queue<Board> queue = new LinkedList<>();
            queue.add(board);
            int stage = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Board currentBoard = queue.poll();
                    if (currentBoard.gameState == State.END) {
                        return 1;
                    }
                    if (stage > 10) {
                        return board.gameState == State.END ? 1 : 0;
                    }
                    for (Direction direction : Direction.values()) {
                        Board newBoard = currentBoard.copy();
                        if (newBoard.tilt(direction)) {
                            queue.add(newBoard);
                        }
                    }
                }
                stage++;
            }
            return board.gameState == State.END ? 1 : 0;
        }
    }

    public enum Direction {
        UP(new Position(0, -1)), DOWN(new Position(0, 1)), LEFT(new Position(-1, 0)), RIGHT(new Position(1, 0));

        private final Position correlation;

        Direction(Position correlation) {
            this.correlation = correlation;
        }

        public Position getCorrelation() {
            return correlation;
        }
    }

    public static class Board {

        Position redMarble;
        Position blueMarble;

        State gameState;

        char[][] board;
        int yLen;
        int xLen;

        public Board(int n, int m, String[] input) {
            board = new char[n][m];
            for (int i = 0; i < n; i++) {
                board[i] = input[i].toCharArray();
            }
            gameState = State.INIT;
            yLen = n;
            xLen = m;

            for (int y = 0; y < yLen; y++) {
                for (int x = 0; x < xLen; x++) {
                    if (board[y][x] == 'R') {
                        redMarble = new Position(x, y);
                    }
                    if (board[y][x] == 'B') {
                        blueMarble = new Position(x, y);
                    }
                }
            }
        }

        public Board copy() {
            String[] newBoardArr = new String[yLen];
            for (int y = 0; y < yLen; y++) {
                newBoardArr[y] = new String(board[y]);
            }
            Board newBoard = new Board(yLen, xLen, newBoardArr);
            newBoard.redMarble = new Position(redMarble.getX(), redMarble.getY());
            newBoard.blueMarble = new Position(blueMarble.getX(), blueMarble.getY());
            newBoard.gameState = gameState;
            return newBoard;
        }

        /**
         * 보드를 기울인다.
         * 결과적으로 빨간구슬과 파란 구슬이 기울인 방향으로 이동할 수 있는 곳까지 이동한다
         * 도중에 파란구슬이 구멍에 빠지면 false를 리턴한다.
         * @param direction
         * @return false 오류, 파랑구슬 탈출
         */
        public boolean tilt(Direction direction) {
            boolean redMarbleMoveFinished = false;
            boolean blueMarbleMovedFinished = false;
            while(moveMarble(redMarble, direction)){
                redMarble = redMarble.add(direction);
                Position next = redMarble.add(direction);
                if(getBoardItem(next) == '#'){
                    redMarbleMoveFinished = true;
                    break;
                }
                if(getBoardItem(next) == 'O'){
                    gameState = State.END;
                    setBoardItem(redMarble,'.');
                    redMarble = next;
                    break;
                }
                if(getBoardItem(next) == 'B'){
                    break;
                }
            }
            if(!redMarbleMoveFinished && getBoardItem(redMarble.add(direction))== '#'){
                redMarbleMoveFinished = true;
            }
            if(!redMarbleMoveFinished && getBoardItem(redMarble.add(direction))== 'O'){
                gameState = State.END;
                return true;
            }
            while(moveMarble(blueMarble, direction)){
                blueMarble = blueMarble.add(direction);
                Position next = blueMarble.add(direction);
                if(getBoardItem(next) == '#'){
                    blueMarbleMovedFinished = true;
                    break;
                }
                if(getBoardItem(next) == 'O'){
                    gameState = State.ERROR;
                    return false;
                }
                if(getBoardItem(next) == 'R' && redMarbleMoveFinished){
                    blueMarbleMovedFinished = true;
                    break;
                }
            }
            if(!blueMarbleMovedFinished && getBoardItem(blueMarble.add(direction))== '#'){
                blueMarbleMovedFinished = true;
            }
            if(!blueMarbleMovedFinished && getBoardItem(blueMarble.add(direction))== 'O'){
                gameState = State.ERROR;
                return false;
            }
            if(redMarbleMoveFinished && blueMarbleMovedFinished){
                return true;
            }
            // 구슬이 겹친 경우 재이동
            while(moveMarble(redMarble, direction)){
                redMarble = redMarble.add(direction);
                Position next = redMarble.add(direction);
                if(getBoardItem(next) == 'B'){
                    return true;
                }
            }
            if(getBoardItem(redMarble.add(direction))== 'B'){
                return true;
            }
            if(gameState == State.END){
                return true;
            }
            return false;
        }

        /**
         * 구슬을 이동시킨다.
         * @param marble 이동할 구슬 현재 위치
         * @param direction 이동할 방향
         * @return boolean 이동 수행 여부
         */
        private boolean moveMarble(Position marble, Direction direction) {
            Position next = marble.add(direction);
            if(!(next.getX() >= 0 && next.getX() < xLen && next.getY() >= 0 && next.getY() < yLen)){
                return false;
            }
            char nextChar = getBoardItem(next);
            if(nextChar == '#'){
                return false;
            }
            if(nextChar == 'O'){
                return false;
            }
            if(nextChar == 'R' || nextChar == 'B'){
                return false;
            }
            setBoardItem(next,getBoardItem(marble));
            setBoardItem(marble,'.');
            return true;
        }

        private char getBoardItem(Position position) {
            return board[position.getY()][position.getX()];
        }

        private void setBoardItem(Position position, char item) {
            board[position.getY()][position.getX()] = item;
        }

        public Position getRedMarblePosition() {
            return redMarble;
        }

        public State getGameState() {
            return gameState;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int y = 0; y < yLen; y++) {
                for (int x = 0; x < xLen; x++) {
                    if (redMarble.equals(new Position(x, y))) {
                        sb.append('R');
                    } else if (blueMarble.equals(new Position(x, y))) {
                        sb.append('B');
                    } else {
                        sb.append(board[y][x]);
                    }
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }

    public static class Position {

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

        public Position add(Direction direction) {
            return new Position(x + direction.getCorrelation().getX(), y + direction.getCorrelation().getY());
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Position) {
                Position position = (Position) o;
                return this.x == position.x && this.y == position.y;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return x * 31 + y;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public enum State {
        INIT, RUN, ERROR, END
    }
}
