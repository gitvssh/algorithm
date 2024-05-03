package algorithm.baek.simulation;

import algorithm.TestCase;
import algorithm.baek.simulation.DiceYutnori.YutnoriBoard.YutnoriTile.TileType;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;

/**
 * https://www.acmicpc.net/problem/17825
 * 백준 17825. 주사위 윷놀이
 */
public class DiceYutnori implements TestCase {

    /*
    분석(5m - 9:16)
    설계(20m - 9:36)
    구현(30m - 10:06)

    분석
    - 시작 칸에 말 4개가 있다.
    - 말은 게임판에 그려진 하살표 방향대로만 이동할 수 있다.
    - 파란색 칸에서 시작하면 파란색 화살표를 타야 한다.
    - 이동중이거나 파란색이 아닌 칸에서 이동을 시작하면 빨간색 화살표를 타야한다.
    - 게임은 10개의 턴으로 이뤄지며, 매 턴마다 1부터 5까지의 수를 주사위로 굴려 나온 수만큼 이동한다.
    - 말이 이동을 마치는 칸에 다른 말이 있으면 그 말은 고를 수 없다. 단 이동을 마치는 칸이 도착 칸이면 고를 수 있다.
    - 말이 이동을 마칠 때마다 칸에 적힌 수만큼 점수를 얻는다.
    - 주사위 10개가 주어질 떄, 얻을 수 있는 점수의 최댓값을 구하라.

    설계
    - 게임판은 링크드리스트 커스텀 자료구조로 구현한다.(빨간색, 파란색 화살표 구현)
    - 말은 4개로 고정이므로 4개의 말을 배열로 관리한다.
    - 백트래킹을 위해 재귀함수로 구현한다.
    - 시뮬레이션은 말을 선택하는 중복선택가능한 조합을 고르는 것이다.

    게임판:
    - 게임판은 커스텀 자료구조로 구현한다.
    - 시작칸과 도착칸을 제외한 칸에는 하나의 말만 존재할 수 있다.
    - 각 칸에는 점수, 빨간색 화살표, 파란색 화살표, 칸의 종류, 말 존재 여부를 저장한다.
    - 칸의 종류는 시작칸, 도착칸, 일반칸으로 구분한다.
    - 게임판은 게임이 종료된 후 게임 점수를 구할 수 있다.
    말:
    - 말은 이동가능 여부를 가지고 있다.
    - 말은 주어진 숫자만큼 이동할 수 있다.

    요구사항:
    o 말은 주어진 숫자만큼 이동할 수 있다.
    o 파란색 칸에서 이동을 시작하면 파란색 화살표를 타야한다.
    o 이동중이거나 파란색이 아닌 칸에서 이동을 시작하면 빨간색 화살표를 타야한다.
    o 말이 이동을 마치는 칸에 다른 말이 있으면 그 말은 고를 수 없다. 단 이동을 마치는 칸이 도착 칸이면 고를 수 있다.
    o 말이 이동을 마칠 때마다 칸에 적힌 수만큼 점수를 얻는다.

     */
    @Override
    public void test() throws ParseException, IOException {

    }

    public static class YutnoriBoard {

        private int totalPoint;
        private LinkedList<YutnoriTile> board;

        YutnoriBoard() {
            init();
        }

        private void init() {

            board = new LinkedList<YutnoriTile>();
            //midTop line
            YutnoriTile endTile = new YutnoriTile(0, TileType.END, null);
            board.add(endTile);
            YutnoriTile midTop1 = new YutnoriTile(40, TileType.NORMAL, endTile);
            board.add(midTop1);
            YutnoriTile midTop2 = new YutnoriTile(35, TileType.NORMAL, midTop1);
            board.add(midTop2);
            YutnoriTile midTop3 = new YutnoriTile(30, TileType.NORMAL, midTop2);
            board.add(midTop3);
            //middle tile
            YutnoriTile middle = new YutnoriTile(25, TileType.NORMAL, midTop3);
            board.add(middle);
            //midDown line
            YutnoriTile midDown1 = new YutnoriTile(24, TileType.NORMAL, middle);
            board.add(midDown1);
            YutnoriTile midDown2 = new YutnoriTile(22, TileType.NORMAL, midDown1);
            board.add(midDown2);
            //rightUp line
            YutnoriTile rihgtUp1 = new YutnoriTile(38, TileType.NORMAL, midTop1);
            board.add(rihgtUp1);
            YutnoriTile rightUp2 = new YutnoriTile(36, TileType.NORMAL, rihgtUp1);
            board.add(rightUp2);
            YutnoriTile rightUp3 = new YutnoriTile(34, TileType.NORMAL, rightUp2);
            board.add(rightUp3);
            YutnoriTile rightUp4 = new YutnoriTile(32, TileType.NORMAL, rightUp3);
            board.add(rightUp4);
            //midRight line
            YutnoriTile midRight1 = new YutnoriTile(26, TileType.NORMAL, middle);
            board.add(midRight1);
            YutnoriTile midRight2 = new YutnoriTile(27, TileType.NORMAL, midRight1);
            board.add(midRight2);
            YutnoriTile midRight3 = new YutnoriTile(28, TileType.NORMAL, midRight2);
            board.add(midRight3);
            YutnoriTile right = new YutnoriTile(30, TileType.BLUE, rightUp4, midRight3);
            board.add(right);
            //rightDown line
            YutnoriTile rightDown1 = new YutnoriTile(28, TileType.NORMAL, right);
            board.add(rightDown1);
            YutnoriTile rightDown2 = new YutnoriTile(26, TileType.NORMAL, rightDown1);
            board.add(rightDown2);
            YutnoriTile rightDown3 = new YutnoriTile(24, TileType.NORMAL, rightDown2);
            board.add(rightDown3);
            YutnoriTile rightDown4 = new YutnoriTile(22, TileType.NORMAL, rightDown3);
            board.add(rightDown4);
            YutnoriTile down = new YutnoriTile(20, TileType.BLUE, rightDown4, midDown2);
            board.add(down);
            //leftDown line
            YutnoriTile leftDown1 = new YutnoriTile(18, TileType.NORMAL, down);
            board.add(leftDown1);
            YutnoriTile leftDown2 = new YutnoriTile(16, TileType.NORMAL, leftDown1);
            board.add(leftDown2);
            YutnoriTile leftDown3 = new YutnoriTile(14, TileType.NORMAL, leftDown2);
            board.add(leftDown3);
            YutnoriTile leftDown4 = new YutnoriTile(12, TileType.NORMAL, leftDown3);
            board.add(leftDown4);
            // midLeft line
            YutnoriTile midLeft1 = new YutnoriTile(19, TileType.NORMAL, middle);
            board.add(midLeft1);
            YutnoriTile midLeft2 = new YutnoriTile(16, TileType.NORMAL, midLeft1);
            board.add(midLeft2);
            YutnoriTile midLeft3 = new YutnoriTile(13, TileType.NORMAL, midLeft2);
            board.add(midLeft3);
            //leftUp line
            YutnoriTile left = new YutnoriTile(10, TileType.BLUE, leftDown4, midLeft3);
            board.add(left);
            YutnoriTile leftUp1 = new YutnoriTile(8, TileType.NORMAL, left);
            board.add(leftUp1);
            YutnoriTile leftUp2 = new YutnoriTile(6, TileType.NORMAL, leftUp1);
            board.add(leftUp2);
            YutnoriTile leftUp3 = new YutnoriTile(4, TileType.NORMAL, leftUp2);
            board.add(leftUp3);
            YutnoriTile leftUp4 = new YutnoriTile(2, TileType.NORMAL, leftUp3);
            board.add(leftUp4);
            YutnoriTile start = new YutnoriTile(0, TileType.START, leftUp4);
            board.add(start);
        }

        public int simulate(String input) {
            int[] dices = new int[10];
    //        Yut[] yuts = initYuts();

            String[] inputs = input.split(" ");
            for (int i = 0; i < 10; i++) {
                dices[i] = Integer.parseInt(inputs[i]);
            }
    //        return backtracking(dices, yuts, 0, 0, "");
            return backtracking(dices, board.get(board.size() - 1), board.get(board.size() - 1), board.get(board.size() - 1),
                    board.get(board.size() - 1), 0, 0, "");
        }

        public Yut[] initYuts() {
            Yut[] yuts = new Yut[4];
            for (int i = 0; i < 4; i++) {
                yuts[i] = new Yut(board.get(board.size() - 1));
            }
            return yuts;
        }

        private int backtracking(int[] dices, YutnoriTile yut1, YutnoriTile yut2, YutnoriTile yut3, YutnoriTile yut4, int stage, int totalPoint,
                String preTrace) {
            int maxPoint = 0;
            if (stage == 10) {
                System.out.println(preTrace);
                return Math.max(totalPoint, maxPoint);
            }
            Yut[] yutsCopy = new Yut[4];
            yutsCopy[0] = new Yut(yut1);
            yutsCopy[1] = new Yut(yut2);
            yutsCopy[2] = new Yut(yut3);
            yutsCopy[3] = new Yut(yut4);
            int dice = dices[stage];
            for (int i = 0; i < 4; i++) {
                Yut yut = yutsCopy[i];
                String trace = preTrace + "(" + totalPoint + ") " + i;
                if (!yut.isEnd()) {
                    if (!yut.canMove(yutsCopy, dice)) {
                        continue;
                    }
                    yut.currentTile = yut.getMoveTarget(dices[stage]);
                    int localPoint = backtracking(dices, yutsCopy[0].currentTile, yutsCopy[1].currentTile, yutsCopy[2].currentTile, yutsCopy[3].currentTile,  stage + 1, totalPoint + yut.currentTile.getPoint(), trace);
                    maxPoint = Math.max(maxPoint, localPoint);
                }
            }
            return maxPoint;
        }

        private int backtracking(int[] dices, Yut[] yuts, int stage, int totalPoint, String preTrace) {
            int maxPoint = 0;
            if (stage == 10) {
                System.out.println(preTrace);
                return Math.max(totalPoint, maxPoint);
            }
            Yut[] yutsCopy = new Yut[4];
            for (int i = 0; i < 4; i++) {
                yutsCopy[i] = new Yut(yuts[i].currentTile);
            }

            int dice = dices[stage];
            for (int i = 0; i < 4; i++) {
                Yut yut = yutsCopy[i];
                String trace = preTrace + "(" + totalPoint + ") " + i;
                if (!yut.isEnd()) {
                    if (!yut.canMove(yuts, dice)) {
                        continue;
                    }
                    yut.currentTile = yut.getMoveTarget(dices[stage]);
                    int localPoint = backtracking(dices, yutsCopy, stage + 1, totalPoint + yut.currentTile.getPoint(), trace);
                    maxPoint = Math.max(maxPoint, localPoint);
                }
            }
            return maxPoint;
        }

        private int backtracking(int[] dices, Yut[] yuts, int stage, int totalPoint) {
            int maxPoint = 0;
            if (stage == 10) {
                return Math.max(totalPoint, maxPoint);
            }
            Yut[] yutsCopy = null;
            yutsCopy = new Yut[4];
            for (int i = 0; i < 4; i++) {
                yutsCopy[i] = new Yut(yuts[i].currentTile);
            }

            int dice = dices[stage];
            for (int i = 0; i < 4; i++) {
                Yut yut = yutsCopy[i];
                if (!yut.isEnd()) {
                    if (!yut.canMove(yutsCopy, dice)) {
                        continue;
                    }
                    yut.currentTile = yut.getMoveTarget(dices[stage]);
                    int localPoint = backtracking(dices, yutsCopy, stage + 1, totalPoint + yut.currentTile.getPoint());
                    maxPoint = Math.max(maxPoint, localPoint);
                }
            }
            return maxPoint;
        }

        public Yut[] moveItem(Yut[] yuts, int item, int dicePoint) {
            if (yuts[item].canMove(yuts, dicePoint)) {
                yuts[item].currentTile = yuts[item].getMoveTarget(dicePoint);
            }
            totalPoint += yuts[item].currentTile.getPoint();

            return yuts;
        }

        public int getTotalPoint() {
            return totalPoint;
        }

        protected class Yut {

            private YutnoriTile currentTile;
            private boolean isEnd;

            public Yut(YutnoriTile currentTile) {
                this.currentTile = currentTile;
            }

            public boolean isEnd() {
                return isEnd;
            }

            public boolean canMove(Yut[] yuts, int dicePoint) {
                if (currentTile.getType() == TileType.END) {
                    isEnd = true;
                    return false;
                }
                if (isEmptyTile(yuts, this.getMoveTarget(dicePoint))) {
                    return true;
                }
                return false;
            }

            private YutnoriTile getMoveTarget(int dicePoint) {
                YutnoriTile nextTile = currentTile;
                if (nextTile.getType() == TileType.BLUE) {
                    nextTile = nextTile.getNextBlueTile();
                } else {
                    nextTile = nextTile.getNextTile();
                }

                for (int i = 0; i < dicePoint - 1; i++) {
                    if (nextTile.getType() == TileType.END) {
                        break;
                    }
                    nextTile = nextTile.getNextTile();
                }
                return nextTile;
            }
        }

        private boolean isEmptyTile(Yut[] yuts, YutnoriTile moveTarget) {
            for (Yut yut : yuts) {
                if (yut.currentTile == moveTarget) {
                    if (yut.currentTile.getType() != TileType.END) {
                        return false;
                    }
                }
            }
            return true;
        }

        protected class YutnoriTile {

            private int point;

            private TileType type;

            private YutnoriTile nextTile;
            private YutnoriTile nextBlueTile;

            YutnoriTile(int point, TileType type, YutnoriTile nextTile) {
                this.point = point;
                this.type = type;
                this.nextTile = nextTile;
            }

            YutnoriTile(int point, TileType type, YutnoriTile nextTile, YutnoriTile nextBlueTile) {
                this(point, type, nextTile);
                this.nextBlueTile = nextBlueTile;
            }

            public YutnoriTile getNextTile() {
                return nextTile;
            }

            public YutnoriTile getNextBlueTile() {
                return nextBlueTile;
            }

            public void setNextTile(YutnoriTile nextTile) {
                this.nextTile = nextTile;
            }

            public void setNextBlueTile(YutnoriTile nextBlueTile) {
                this.nextBlueTile = nextBlueTile;
            }

            public int getPoint() {
                return point;
            }

            public TileType getType() {
                return type;
            }

            enum TileType {
                START, END, NORMAL, BLUE;
            }
        }
    }
}
