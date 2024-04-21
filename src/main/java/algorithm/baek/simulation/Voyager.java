package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/3987 보이저 1호
 */
public class Voyager implements TestCase {


    /*
        분석
        1. 보이저 1호는 N x M 크기의 직사각형으로 이루어진 지도 위에 존재한다.
           (1 <= N, M <= 500)
        2. 보이저 1호는 시그널을 보낼 수 있다.
        3. 시그널은 항상 직진하며, 행성을 만나면 반사된다.
        4. 시그널은 직사각형의 경계를 만나면 사라진다.
        5. 시그널은 블랙홀을 만나면 사라진다.

        항성계 지도:
        .: 빈 공간
        C: 블랙홀
        /: 우상향 대각선 경계
        \: 우하향 대각선 경계
        S: 보이저 1호의 위치

        시그널:
        위, 아래 좌, 우 이동 가능
        경계를 만나면 사라짐
        항성계에 존재하는 시간 기록 필요

        설계(요구사항)
        1. 보이저 1호는 항성계 지도 위에 존재한다.
        2. 보이저 1호는 시그널을 보낼 수 있다.
        3. 보이저 1호는 시그널의 항성계 내부에서 최대 생존 시간과 방향을 알 수 있다.
         */
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        StarSystem starSystem = new StarSystem(y, x);
        String[] strings = new String[y];
        for (int i = 0; i < y; i++) {
            strings[i] = br.readLine();
        }
        starSystem.makeMap(strings);
        st = new StringTokenizer(br.readLine());
        int vx = Integer.parseInt(st.nextToken());
        int vy = Integer.parseInt(st.nextToken());
        ProbeVoyager voyager = new ProbeVoyager(vx, vy);
        starSystem.placeVoyager(voyager);
        voyager.sendSignal(starSystem);
        int maxSignalLive = voyager.getMaxSignalLive();
        System.out.println(voyager.getMaxDir());
        if (maxSignalLive > 10000) {
            System.out.println("Voyager");
        } else {
            System.out.println(maxSignalLive);
        }
    }


    public static class ProbeVoyager {

        private int x;
        private int y;
        private int maxSignalLive;
        private Direction maxDir;

        ProbeVoyager(int x, int y) {
            this.x = x - 1;
            this.y = y - 1;
            this.maxSignalLive = 0;
        }

        public int getX() {
            return x;
        }

        public void sendSignal(StarSystem starSystem) {
            for (Direction dir : Direction.values()) {
                sendDirectSignal(starSystem, dir, this);
            }
        }

        private void sendDirectSignal(StarSystem starSystem, Direction dir, ProbeVoyager probeVoyager) {
            int signalLive = 0;
            int nx = probeVoyager.x;
            int ny = probeVoyager.y;
            Direction sttDir = dir;
            while (true) {
                ny += dir == Direction.U ? -1 : dir == Direction.D ? 1 : 0;
                nx += dir == Direction.L ? -1 : dir == Direction.R ? 1 : 0;
                if (nx < 0 || nx >= starSystem.map[0].length || ny < 0 || ny >= starSystem.map.length) {
                    break;
                }
                if (starSystem.map[ny][nx] == '/') {
                    if (dir == Direction.U) {
                        dir = Direction.R;
                    } else if (dir == Direction.L) {
                        dir = Direction.D;
                    } else if (dir == Direction.R) {
                        dir = Direction.U;
                    } else if (dir == Direction.D) {
                        dir = Direction.L;
                    }
                } else if (starSystem.map[ny][nx] == '\\') {
                    if (dir == Direction.U) {
                        dir = Direction.L;
                    } else if (dir == Direction.L) {
                        dir = Direction.U;
                    } else if (dir == Direction.R) {
                        dir = Direction.D;
                    } else if (dir == Direction.D) {
                        dir = Direction.R;
                    }
                } else if (starSystem.map[ny][nx] == 'C') {
                    break;
                }
                signalLive++;

                if (signalLive > 250001) {
                    maxSignalLive = signalLive + 1;
                    maxDir = sttDir;
                    return;
                }
            }
            if( signalLive+1 == maxSignalLive) {
                //maxDir을 U,R,D,L 순으로 변경
                if(sttDir == Direction.U) {
                    maxDir = Direction.U;
                } else if(sttDir == Direction.R && maxDir != Direction.U) {
                    maxDir = Direction.R;
                } else if(sttDir == Direction.D && maxDir != Direction.U && maxDir != Direction.R) {
                    maxDir = Direction.D;
                } else if(sttDir == Direction.L && maxDir != Direction.U && maxDir != Direction.R && maxDir != Direction.D) {
                    maxDir = Direction.L;
                }
            }
            if (signalLive > maxSignalLive) {
                maxSignalLive = signalLive + 1;
                maxDir = sttDir;
            }
        }

        public int getMaxSignalLive() {
            return maxSignalLive;
        }

        public Direction getMaxDir() {
            return maxDir;
        }
    }

    enum Direction {
        U, D, L, R;
    }

    public static class StarSystem {

        ProbeVoyager voyager;
        char[][] map;

        public StarSystem(int y, int x) {
            map = new char[y][x];
        }

        public void makeMap(String[] strings) {
            for (int i = 0; i < strings.length; i++) {
                map[i] = strings[i].toCharArray();
            }
        }

        public void placeVoyager(ProbeVoyager voyager) {
            this.voyager = voyager;
            map[voyager.y][voyager.x] = 'S';
        }

        public ProbeVoyager getProbeVoyager() {
            return this.voyager;
        }
    }
}
