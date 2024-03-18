package algorithm.baek.etc;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17143
 * 낚시왕
 * 구현
 */
public class FishingKing implements TestCase {
    static int R, C, M;

    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        FishingGround fishingGround = new FishingGround(R, C);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(r, c, s, d, z);
            fishingGround.addShark(shark);
        }

        for (int i = 0; i < C; i++) {
            fishingGround.nextTurn();
        }
        bw.write(fishingGround.sum + "\n");
        bw.flush();
        bw.close();
    }

    class FishingGround {
        ArrayList<Shark>[][][] sharks;

        int sum = 0;
        int kingPos = 0;

        public FishingGround(int r, int c) {
            sharks = new ArrayList[r][c][2];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sharks[i][j][0] = new ArrayList<Shark>();
                    sharks[i][j][1] = new ArrayList<Shark>();
                }
            }
        }

        public void addShark(Shark shark) {
            sharks[shark.r][shark.c][0].add(shark);
        }

        public void nextTurn() {
            if (kingPos == C) return;
            catchShark();
            kingPos++;
            moveShark();
            eatSharks();
            clearNextShark();
        }

        private void catchShark() {
            for (int i = 0; i < R; i++) {
                if (sharks[i][kingPos][0].size() > 0) {
                    sum += sharks[i][kingPos][0].get(0).z;
                    sharks[i][kingPos][0].clear();
                    break;
                }
            }
        }

        public void clearNextShark() {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sharks[i][j][1].clear();
                }
            }
        }

        public void moveShark() {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (sharks[i][j] != null) {
                        for (int k = 0; k < sharks[i][j][0].size(); k++) {
                            Shark shark = sharks[i][j][0].get(k);
                            shark.move();
                            sharks[shark.r][shark.c][1].add(shark);
                        }
                    }
                }
            }
        }

        public void eatSharks() {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (sharks[i][j][1].size() > 1) {
                        Shark maxShark = sharks[i][j][1].get(0);
                        for (int k = 1; k < sharks[i][j][1].size(); k++) {
                            Shark shark = sharks[i][j][1].get(k);
                            if (maxShark.z < shark.z) {
                                maxShark = shark;
                            }
                        }
                        sharks[i][j][1].clear();
                        sharks[i][j][1].add(maxShark);
                    }
                }
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sharks[i][j][0].clear();
                    if (sharks[i][j][1].size() > 0) {
                        sharks[i][j][0].add(sharks[i][j][1].get(0));
                    }
                }
            }
        }

    }

    class Shark {
        int r;
        int c;
        int s;
        int d;
        int z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r; //상어의 위치
            this.c = c; //상어의 위치
            this.s = s; //속력
            this.d = d; //이동 방향 1:위, 2:아래, 3:오른쪽, 4:왼쪽
            this.z = z; //크기
        }

        public void move() {
            int nr = r;
            int nc = c;
            int ns = s;
            int nd = d;
            while (ns > 0) {
                if (nd == 1) {
                    if (nr - ns < 0) {
                        ns -= nr;
                        nr = 0;
                        nd = 2;
                    } else {
                        nr -= ns;
                        ns = 0;
                    }
                } else if (nd == 2) {
                    if (nr + ns >= R) {
                        ns -= (R - nr - 1);
                        nr = R - 1;
                        nd = 1;
                    } else {
                        nr += ns;
                        ns = 0;
                    }
                } else if (nd == 3) {
                    if (nc + ns >= C) {
                        ns -= (C - nc - 1);
                        nc = C - 1;
                        nd = 4;
                    } else {
                        nc += ns;
                        ns = 0;
                    }
                } else if (nd == 4) {
                    if (nc - ns < 0) {
                        ns -= nc;
                        nc = 0;
                        nd = 3;
                    } else {
                        nc -= ns;
                        ns = 0;
                    }
                }
            }
            r = nr;
            c = nc;
            d = nd;
        }
    }
}
