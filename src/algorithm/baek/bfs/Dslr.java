package algorithm.baek.bfs;

import algorithm.TestCase;

import java.io.*;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9019
 * DSLR
 */
public class Dslr implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(bfs(a, b) + "\n");
        }
        bw.close();
    }

    private String bfs(int a, int b) {
        boolean[] visited = new boolean[10000];
        visited[a] = true;

        Queue<Register> queue = new LinkedList<>();
        queue.add(new Register(a, ""));

        String result = "";
        while(!queue.isEmpty()){
            Register register = queue.poll();
            if(register.num == b){
                result = register.command;
                break;
            }

            if(!visited[register.D()]){
                visited[register.D()] = true;
                queue.add(new Register(register.D(), register.command + "D"));
            }

            if(!visited[register.S()]){
                visited[register.S()] = true;
                queue.add(new Register(register.S(), register.command + "S"));
            }

            if(!visited[register.L()]){
                visited[register.L()] = true;
                queue.add(new Register(register.L(), register.command + "L"));
            }

            if(!visited[register.R()]){
                visited[register.R()] = true;
                queue.add(new Register(register.R(), register.command + "R"));
            }
        }
        return result;
    }

    static class Register{
        int num;
        String command;

        Register(int num, String command) {
            this.num = num;
            this.command = command;
        }

        int D(){
            return (num * 2) % 10000;
        }
        int S(){
            return num == 0 ? 9999 : num - 1;
        }

        int L(){
            return (num % 1000) * 10 + num / 1000;
        }

        int R(){
            return (num % 10) * 1000 + num / 10;
        }
    }
}
