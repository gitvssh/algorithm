package algorithm.programmers.level1;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;

public class WalkPark implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
//        int[] solution = solution(new String[]{"XXX", "XSX", "XXX"}, new String[]{"E 1"});
//        int[] solution =  solution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"});
//        int[] solution =  solution(new String[]{"SOO", "OXX", "OOO"}, new String[]{"E 2", "S 2", "W 1"});
//        int[] solution =  solution(new String[]{"OSO", "OOO", "OXO", "OOO"}, new String[]{"E 2", "S 3", "W 1"});
//        int[] solution =  solution(new String[]{"OSO", "OOO", "OOO", "OOO"}, new String[]{"W 2"});
//        int[] solution =  solution(new String[]{"OSO", "OOO", "OOO", "OOO"}, new String[]{"N 2"});
//        int[] solution =  solution(new String[]{"OSO", "OOO", "OOO", "OOO"}, new String[]{"S 5"});
//        int[] solution =  solution(new String[]{"OSO", "OOO", "OOO", "OOO"}, new String[]{"E 5"});
//        int[] solution =  solution(new String[]{"XXX", "XSX", "XXX"}, new String[]{"E 1"});
//        int[] solution =  solution(new String[]{"XXX", "XSX", "XXX"}, new String[]{"W 1"});
//        int[] solution =  solution(new String[]{"XXX", "XSX", "XXX"}, new String[]{"S 1"});
//        int[] solution =  solution(new String[]{"XXX", "XSX", "XXX"}, new String[]{"N 1"});
//        int[] solution =  solution(new String[]{"SOXOO", "OOOOO", "OOOOO", "OOOOO", "OOOOO"}, new String[] {"E 3"});
//        int[] solution =  solution(new String[]{"SOOOX", "OOOOO", "OOOOO", "OOOOO", "OOOOO"}, new String[] {"E 3"});
//        int[] solution =  solution(new String[]{"XOOOS", "OOOOO", "OOOOO", "OOOOO", "OOOOO"}, new String[] {"W 3"});
//        int[] solution =  solution(new String[]{"OOXOS", "OOOOO", "OOOOO", "OOOOO", "OOOOO"}, new String[] {"W 3"});
//        int[] solution =  solution(new String[]{"SOOOO", "OOOOO", "XOOOO", "OOOOO", "OOOOO"}, new String[] {"S 3"});
//        int[] solution =  solution(new String[]{"SOOOO", "OOOOO", "OOOOO", "OOOOO", "XOOOO"}, new String[]{"S 3"});
        int[] solution =  solution(new String[]{"OOOOO", "OOOOO", "XOOOO", "OOOOO", "SOOOO"}, new String[]{"N 3"});
//        int[] solution =  solution(new String[]{"XOOOO", "OOOOO", "OOOOO", "OOOOO", "SOOOO"}, new String[]{"N 3"});
        System.out.println(solution[0] + " " + solution[1]);
    }

    public int[] solution(String[] park, String[] routes) {
        String[][] newMap = new String[park.length][];
        for (int i = 0; i < park.length; i++) {
            newMap[i] = park[i].split("");
        }

        int[] answer = new int[2];
        RobotDog dog = null;
        for (int i = 0; i < newMap.length; i++) {
            for (int j = 0; j < newMap[0].length; j++) {
                if (newMap[i][j].equals("S")) {
                    dog = new RobotDog(j, i);
                    break;
                }
            }
        }
        for (String oper : routes) {
            int[] dir = dog.parseOper(oper);
            if (dog.canMove(dir[0], dir[1], newMap)) {
                dog.move(dir[0], dir[1]);
            }
        }
        answer[0] = dog.getY();
        answer[1] = dog.getX();

        return answer;
    }

    static class RobotDog {
        private int x;
        private int y;

        RobotDog(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(int y, int x) {
            this.x += x;
            this.y += y;
        }

        public boolean canMove(int moveY, int moveX, String[][] park) {
            int nx = this.x + moveX;
            int ny = this.y + moveY;
            if (nx < 0 || nx >= park[0].length || ny < 0 || ny >= park.length) return false;
            if(moveY>0 || moveX>0){
                for (int movingX = this.x ; movingX <= nx; movingX++) {
                    if (park[this.y][movingX].equals("X")) return false;
                }
                for (int movingY = this.y ; movingY <= ny; movingY++) {
                    if (park[movingY][this.x].equals("X")) return false;
                }
            }else{
                for (int movingX = this.x ; movingX >= nx; movingX--) {
                    if (park[this.y][movingX].equals("X")) return false;
                }
                for (int movingY = this.y ; movingY >= ny; movingY--) {
                    if (park[movingY][this.x].equals("X")) return false;
                }
            }
            return true;
        }

        public int[] parseOper(String oper) {
            String[] opers = oper.split(" ");
            String dir = opers[0];
            int len = Integer.parseInt(opers[1]);
            int[] res = {0, 0};
            switch (dir) {
                case "N":
                    res[0] -= len;
                    break;
                case "S":
                    res[0] += len;
                    break;
                case "W":
                    res[1] -= len;
                    break;
                default:
                    res[1] += len;
            }
            return res;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }
}

