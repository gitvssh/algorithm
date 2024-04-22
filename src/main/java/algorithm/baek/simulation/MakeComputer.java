package algorithm.baek.simulation;

import algorithm.TestCase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/6568
 * 귀도 반 로섬은 Python을 만들었다.
 */
public class MakeComputer implements TestCase {

    /*
    문제(3m)
    컴퓨터 구현
    - pc(5bit, 프로그램 카운터, 다음에 실행할 명령어의 주소를 가리킨다)
    - 가산기(8bit, 덧셈, 뺄셈)
    - 메모리(32byte, 8bit * 32)
    - 명령어 파싱
    - 오버플로우

    -> 컴퓨터 구성요소에 대한 이해 필요

    분석(5m)
    명령어 종류:
    - 000xxxxx STA x : 메모리 x에 가산기의 값을 저장
    - 001xxxxx LDA x : 메모리 x의 값을 가산기에 저장
    - 010xxxxx BEQ x : 가산기의 값이 0이면 x로 이동
    - 011xxxxx NOP : 아무것도 하지 않음
    - 100xxxxx DEC : 가산기의 값을 1 감소
    - 101xxxxx INC : 가산기의 값을 1 증가
    - 110xxxxx JMP x : x로 이동
    - 111xxxxx HLT : 프로그램 종료

    총 32개 명령어(5bit)

    메모리:

    가산기:
    - 8비트
    - 초기값 0
    pc:
    - 5비트
    - 초기값 0

    parser:
    - 명령어를 파싱한다.


    설계(5m)
    1. 주어진 명령어를 파싱한다.
    2. 명령어에 따라 가산기, 메모리, pc를 조작한다.
    3. 가산기의 값을 출력한다.
     */

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void test() throws ParseException, IOException {
        while(true) {
            String line = br.readLine();
            if(line == null) {
                break;
            }
            MyComputer myComputer = initComputer(line);
            myComputer.executeCommand();
            System.out.println(myComputer.getAccumulator().printValue());
        }
    }

    private MyComputer initComputer(String line) throws IOException {
        MyComputer myComputer = new MyComputer();
        myComputer.getMemory().setMemory(0, line);
        for (int i = 1; i < 32; i++) {
            myComputer.getMemory().setMemory(i, br.readLine());
        }
        return myComputer;
    }

    static class MyComputer {
        private ProgramCounter pc;
        private Memory memory;
        private Accumulator accumulator;

        public MyComputer() {
            this.pc = new ProgramCounter();
            this.memory = new Memory();
            this.accumulator = new Accumulator();
        }

        public void readProgram(List<String> lines) {
            for (int i = 0; i < 32; i++) {
                memory.setMemory(i,lines.get(i));
            }
        }

        public Memory getMemory() {
            return this.memory;
        }

        public Accumulator getAccumulator() {
            return this.accumulator;
        }

        public void executeCommand() {
            while (true) {
                String command = memory.getMemory()[pc.getPc()];
                int opcode = Integer.parseInt(command.substring(0, 3), 2);
                int address = Integer.parseInt(command.substring(3, 8), 2);
                pc.increasePc();
                switch (opcode) {
                    case 0:
                        memory.setMemory(address, accumulator.printValue());
                        break;
                    case 1:
                        accumulator.setValue(Integer.parseInt(memory.getMemory()[address], 2));
                        break;
                    case 2:
                        if (accumulator.getValue() == 0) {
                            pc.setPc(address);
                        }
                        break;
                    case 3:
                        break;
                    case 4:
                        accumulator.decreaseValue();
                        break;
                    case 5:
                        accumulator.increaseValue();
                        break;
                    case 6:
                        pc.setPc(address);
                        break;
                    case 7:
                        return;
                }
            }
        }
    }

    static class Accumulator {
        private int value;

        public Accumulator() {
            this.value = 0;
        }

        public int getValue() {
            return value;
        }

        public String printValue() {
            return String.format("%08d", Integer.parseInt(Integer.toBinaryString(value)));
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void decreaseValue() {
            if(value == 0) {
                value = 255;
            } else {
                value--;
            }
        }

        public void increaseValue() {
            if(value == 255) {
                value = 0;
            } else {
                value++;
            }
        }
    }

    static class Memory {
        private String[] memory;

        public Memory() {
            this.memory = new String[32];
        }

        public String[] getMemory() {
            return memory;
        }

        public void setMemory(int idx, String value) {
            memory[idx] = value;
        }
    }

    static class ProgramCounter {
        private int pc;

        public ProgramCounter() {
            this.pc = 0;
        }

        public int getPc() {
            return pc;
        }

        public void setPc(int pc) {
            this.pc = pc;
        }

        public void increasePc() {
            if(pc == 31) {
                pc = 0;
            } else {
                pc++;
            }
        }
    }
}
