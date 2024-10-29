package algorithm.baek.graph;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ShippingRoutes implements TestCase {

    StringBuilder sb = new StringBuilder();
    WareHouse wareHouse;

    /*

    - 창고가 이름으로 구분됨
    - 창고 사이의 운송 비용은 연결 갯수 x 100
    - 플로이드 워셜 알고리즘으로 가중치가 1인 그래프의 최단거리 구하기

    - 데이터를 입력받을 수 있다.
    - 두 개의 창고 이름으로 창고의 운송비용을 조회할 수 있다.
    - 창고 사이의 운송비용을 출력할 수 있다.
     */
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            sb.append("DATA SET ").append(i + 1).append("\n\n");
            setCase(br);
        }
        System.out.println(getResult());
    }

    public void setCase(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        wareHouse = new WareHouse(n);
        wareHouse.registerNames(br.readLine().split(" "));
        for (int i = 0; i < m; i++) {
            wareHouse.setConnection(br.readLine());
        }
        wareHouse.updateCost();
        for (int i = 0; i < p; i++) {
            sb.append(wareHouse.getCost(br.readLine()));
            sb.append("\n");
        }
    }

    public int getWarehouseCount() {
        return 6;
    }

    public String searchCost(int count, String a, String b) {
        return wareHouse.getCost(count + " " + a + " " + b);
    }

    public String getResult() {
        return sb.toString();
    }

    public void init(ByteArrayInputStream byteArrayInputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(byteArrayInputStream));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            setCase(br);
        }
    }
}

class WareHouse {

    int size;
    int[][] map;
    String[] names;

    WareHouse(int size) {
        this.size = size;
        map = new int[size][size];
        names = new String[size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(map[i], 1000000);
            map[i][i] = 0;
        }
    }

    public void registerNames(String[] s) {
        names = s;
    }

    public void setConnection(String s) {
        String[] split = s.split(" ");
        int a = 0;
        int b = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(split[0])) {
                a = i;
            }
            if (names[i].equals(split[1])) {
                b = i;
            }
        }
        map[a][b] = 1;
        map[b][a] = 1;
    }

    public void updateCost() {
        floydWarshall();
    }

    public String getCost(String s) {
        String[] split = s.split(" ");
        int cost = Integer.parseInt(split[0]);
        int a = 0;
        int b = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(split[1])) {
                a = i;
            }
            if (names[i].equals(split[2])) {
                b = i;
            }
        }
        int result = cost * map[a][b] * 100;

        return result != 0 ? "$" + result : "NO SHIPMENT POSSIBLE";
    }

    private void floydWarshall() {
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int newDistance = map[i][k] + map[k][j];
                    if (newDistance < map[i][j]) {
                        map[i][j] = newDistance;
                    }
                }
            }
        }
    }
}
