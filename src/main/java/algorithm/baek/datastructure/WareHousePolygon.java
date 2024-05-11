package algorithm.baek.datastructure;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * https://www.acmicpc.net/problem/2304 창고 다각형
 */
public class WareHousePolygon implements TestCase {

    /*
    주어진 자료를 입력받고, 창고의 면적을 계산한다
    
    설계
    창고
    - 스택 자료구조로 구현
    - 최초 입력 받을 때, 최대값을 업데이트 하면서 넓이를 계산
    - 이후 뒤에서부터 최대값을 업데이트 하면서 넓이를 계산
    - 창고는 다각형 면적을 구할 수 있다.
     */
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = br.readLine();
        }
        WareHouse wareHouse = new WareHouse();
        wareHouse.init(n, input);
        System.out.println(wareHouse.getArea());
    }

    public static class WareHouse {

        Deque<Pillar> pillars;
        int area;
        int maxY;
        int idxFirstMaxY;
        int idxLastMaxY;
        int size;

        public void init(int n, String[] input) {
            maxY = 0;
            Arrays.sort(input, (o1, o2) -> {
                String[] split1 = o1.split(" ");
                String[] split2 = o2.split(" ");
                return Integer.parseInt(split1[0]) - Integer.parseInt(split2[0]);
            });
            pillars = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                String[] nextSplit = input[i].split(" ");
                int x = Integer.parseInt(nextSplit[0]);
                int y = Integer.parseInt(nextSplit[1]);
                pillars.addLast(new Pillar(x, y));
                if (maxY < y) {
                    idxFirstMaxY = x;
                    idxLastMaxY = x;
                    maxY = y;
                } else if (maxY == y) {
                    idxLastMaxY = x;
                }
            }
            size = pillars.size();
        }

        private void calculateArea() {
            area = 0;
            area += getLeftArea();
            area += getRightArea();
            area += getMidArea();
        }

        private int getMidArea() {
            return (idxLastMaxY - idxFirstMaxY + 1) * maxY;
        }

        private int getRightArea() {
            Pillar pop = pillars.getLast();
            int startX = pop.x;
            if (startX == idxLastMaxY) {
                return 0;
            }
            int curX = pop.x;
            int localMaxY = pop.y;
            int rightArea = 0;
            while(startX > idxLastMaxY) {
                Pillar pillar = pillars.pollLast();
                curX = pillar.x;
                int y = pillar.y;
                if(y > localMaxY) {
                    int localArea = (startX - curX) * localMaxY;
                    startX = curX;
                    localMaxY = y;
                    rightArea += localArea;
                }
            }
            return rightArea;
        }

        private int getLeftArea() {
            Pillar pillar = pillars.getFirst();
            int startX = pillar.x;
            if (startX == idxFirstMaxY) {
                return 0;
            }
            int localMaxY = pillar.y;
            int leftArea = 0;
            while(startX < idxFirstMaxY) {
                pillar = pillars.pop();
                int x = pillar.x;
                int y = pillar.y;
                if(y > localMaxY) {
                    int localArea = (x - startX) * localMaxY;
                    startX = x;
                    localMaxY = y;
                    leftArea += localArea;
                }
            }
            pillars.addFirst(pillar);
            return leftArea;
        }

        public int getPillarsMaxSize() {
            return size;
        }

        public int getArea() {
            calculateArea();
            return area;
        }
    }

    public static class Pillar {

        int x;
        int y;

        public Pillar(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
