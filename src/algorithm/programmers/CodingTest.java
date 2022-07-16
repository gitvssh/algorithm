package algorithm.programmers;

public class CodingTest {
    final int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};

    public int solution(int[][] office, int r, int c, String[] move) {
        /*
        매트릭스 탐색 문제, 재귀로 함수로직 구하고, 먼지 값 더해서 반환하면 됨
        최초장소 청소, 이동, 이동못하면 다음 명령어로
        r : 북 - 남 방향 좌표 = y축
        c : 서 - 동 방향 좌표 = x축

        1. 명령어 인출(for문)
        2. 이동 수행 가능 여부 판단(go일 시), 불가능하면 continue
        3. 이동 수행 or 방향 변경(방향 상태 값 가지고 있어야함)
        4. 현재칸 청소(result +, 생성자에서 처음위치 청소해서 현재 위치 먼지 0으로)
        5. 반복

        종료상태 : 모든 move 배열 인출 후

        구현후 개선사항 -> 로봇 클래스 작성, 재귀함수(move) 도메인함수로, 청소된 양 로봇이 가지고있게
        스트링배열 이터레이터, 포문 돌려도 됨
        무언가 흐름이 꼬임, 최초 초기화시키고 로봇 안움직임
        좌표 출력 디버깅?
        */
        Robot myRobot = new Robot(office,r,c);

        for(int i=0;i<move.length;i++){
            if(!myRobot.canMove(office, move[i])) continue;//방향전환 다음 명령어
            myRobot.move();
            myRobot.clean(office);
        }
        int answer = 0;
        answer = myRobot.getTotalDust();

        return answer;
    }

    private class Robot{
        private int x = 0, y = 0;
        private int direction = 0; //0:동, 1:서, 2:남, 3:북 //
        private int totalDust = 0;

        public Robot(){

        }

        public int getTotalDust(){
            return this.totalDust;
        }

        public Robot(int[][] office, int r,int c){
            y = r;
            x = c;
            this.clean(office);
        }

        private void move(){
            x += dir[direction][1];//다음 x좌표
            y += dir[direction][0];//다음 y좌표
        }

        private boolean canMove(int[][] office, String move){
            if(move != "go"){
                this.changeDir(move);
                return false;//? 방향만 바꾸고 다음명령어, 이동 안함
            }
            //방향 전환, 순환로직 북->서->남->동->북, switch로 하드코딩? +1? -1?
            // 북(0) 서(1) 남(2) 동(3)
            // 북(0) 동(3) 남(2) 서(1)

            int i = x + dir[direction][1];//다음 x좌표
            int j = y + dir[direction][0];//다음 y좌표
            if(i<0 || i>office.length || j<0 || j>office.length || office[j][i]==-1){
                return false;
            }else{
                return true;
            }
        }

        private void changeDir(String move){
            if(move=="left"){//반시계 ++
                if(direction==3) direction=0;
                direction++;
            }else{//"right" 시계 --
                if(direction==0) direction=3;
                direction--;
            }
        }

        private void clean(int[][] office){
            totalDust += office[this.y][this.x];
            office[this.y][this.x] = 0;
        }

    }
}
