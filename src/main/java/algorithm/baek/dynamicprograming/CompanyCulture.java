package algorithm.baek.dynamicprograming;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CompanyCulture implements TestCase {

    /*
    분석(5m)
    설계(5m)
    구현(15m)

    - 직속 상사가 존재하는 자료 구조 필요
    - 상사가 칭찬을 받으면, 직속 부하들도 칭찬을 받음

     */
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Employees employees = new Employees();
        employees.init(br);
        bw.write(employees.getResult());
        bw.close();
    }
}

class Employees {
    Employee[] employees;
    int N;
    int M;

    public void init(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        makeEmployeeGroup();
        registerBoss(br);
        praiseEmployees(br);
        dfs(employees[0]); // 사장부터 dfs 실행
    }

    private void praiseEmployees(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int employeeNumber = Integer.parseInt(st.nextToken()) - 1;
            int compliment = Integer.parseInt(st.nextToken());
            employees[employeeNumber].bePraised(compliment);
        }
    }

    private void makeEmployeeGroup() {
        employees = new Employee[N];
        for (int i = 0; i < N; i++) {
            employees[i] = new Employee();
        }
    }

    private void registerBoss(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if (boss != -1) {
                employees[i].registerBoss(employees[boss - 1]);
            }
        }
    }

    private void dfs(Employee employee) {
        for (Employee subordinate : employee.subordinates) {
            subordinate.compliment += employee.compliment; // 누적된 칭찬 전달
            dfs(subordinate);
        }
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        for (Employee employee : employees) {
            sb.append(employee.compliment).append(" ");
        }
        return sb.toString().trim();
    }

    static class Employee {
        int compliment = 0;
        List<Employee> subordinates = new ArrayList<>();

        public void registerBoss(Employee boss) {
            boss.subordinates.add(this);
        }

        public void bePraised(int i) {
            compliment += i;
        }

        public int getCompliment() {
            return compliment;
        }
    }
}