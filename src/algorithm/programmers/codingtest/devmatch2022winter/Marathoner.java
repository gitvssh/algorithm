package algorithm.programmers.codingtest.devmatch2022winter;

import algorithm.TestCase;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;

public class Marathoner implements TestCase {
    @Override
    public void test() throws ParseException, IOException {
        String[] marathonRecords = {"jack:9,10,13,9,15", "jerry:7,7,14,10,171", "jean:0,0,11,20,0", "alex:21,2,7,11,4", "kevin:8,4,5,0,0",
                "brown:3,5,16,3,18", "ted:0,8,0,0,8", "lala:0,12,0,7,9", "hue:17,16,8,6,10", "elsa:11,13,10,4,13"};

        Course[] courses = new Course[6];
        for (int i = 0; i < 5; i++) {
            courses[i + 1] = new Course(i + 1);
        }
        Marathoner2[] marathoners = new Marathoner2[marathonRecords.length];

        //1. 참가자들의 기록을 저장
        for (int i = 0; i < marathonRecords.length; i++) {
            marathoners[i] = new Marathoner2(marathonRecords[i]);
            for (int j = 0; j < 5; j++) {
                int finishCnt = courses[j + 1].getFinishCnt();
                courses[j + 1].setFinishCnt(finishCnt + ((marathoners[i].records[j] > 0) ? 1 : 0));
            }
        }
        // 2. 각 코스의 메달 커트라인 기록
        for (int i = 0; i < 5; i++) {
            courses[i + 1].setRank();
            int n = 0;
            for (int j = 0; j < marathonRecords.length; j++) {
                if (marathoners[j].records[i] >0) {
                    courses[i + 1].recordList[n] = marathoners[j].records[i];
                    n++;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            courses[i+1].sortRecord();
        }
        // 3. 각 선수의 메달 수 기록
        for (int i = 0; i < marathonRecords.length; i++) {
            for (int j = 0; j < 5; j++) {
                int courseRecord = marathoners[i].records[j];
                if(courses[j + 1].recordMap.get(courseRecord)!=null){
                    if (courses[j + 1].recordMap.get(courseRecord) <= courses[j + 1].getGold()) {
                        marathoners[i].setGold(marathoners[i].getGold() + 1);
                    } else if (courses[j + 1].recordMap.get(courseRecord) <= courses[j + 1].getSilver()) {
                        marathoners[i].setSilver(marathoners[i].getSilver() + 1);
                    } else if (courses[j + 1].recordMap.get(courseRecord) <= courses[j + 1].getBronze()) {
                        marathoners[i].setBronze(marathoners[i].getBronze() + 1);
                    }
                }
            }
        }

        Arrays.sort(marathoners, (o1, o2) -> {
            if (o1.getFinish() != o2.getFinish()) {  //조건 1
                return Integer.compare(o2.getFinish(), o1.getFinish()); //조건 1
            }else if (o1.getMostDiff() != o2.getMostDiff()) { //조건 2
                return Integer.compare(o2.getMostDiff(), o1.getMostDiff()); //조건2
            }else if (o1.getGold() == o2.getGold()) { //조건 3
                if (o1.getSilver() == o2.getSilver()) { //조건 3
                    if (o1.getBronze() == o2.getBronze()) { //조건 3
                        if (o1.getTotalFinish() == o2.getTotalFinish()) { //조건 4
                            return o1.getName().compareTo(o2.getName());
                        }
                        return Integer.compare(o2.getTotalFinish(), o1.getTotalFinish());//조건4
                    }
                    return Integer.compare(o2.getBronze(), o1.getBronze());//조건3
                }
                return Integer.compare(o2.getSilver(), o1.getSilver()); //조건3
            }
            return Integer.compare(o2.getGold(), o1.getGold()); //조건2
        });
        String[] answer = new String[marathoners.length];
        for (int i = 0; i < marathoners.length; i++) {
            answer[i] = marathoners[i].getName();
        }
    }

    static class Marathoner2 {
        String name;
        int[] records;

        int finish;
        int mostDiff;

        int totalFinish;

        int gold;
        int silver;
        int bronze;

        public Marathoner2(String str) {
            String[] split = str.split(":");
            this.name = split[0];
            String[] tmpRecords = split[1].split(",");
            this.records = new int[tmpRecords.length];
            for (int i = 0; i < 5; i++) {
                records[i] = Integer.parseInt(tmpRecords[i]);
            }

            this.finish = setFinish(this.records[0], this.records[1], this.records[2], this.records[3], this.records[4]);

            this.gold = 0;
            this.silver = 0;
            this.bronze = 0;
        }

        private int setFinish(int record1, int record2, int record3, int record4, int record5) {
            int complete = 0;
            int maxDiff = 0;
            if (record1 != 0) {
                complete++;
                totalFinish += record1;
                maxDiff = Math.max(maxDiff, 1);
            }
            if (record2 != 0) {
                complete++;
                totalFinish += record1;
                maxDiff = Math.max(maxDiff, 2);
            }
            if (record3 != 0) {
                complete++;
                totalFinish += record1;
                maxDiff = Math.max(maxDiff, 3);
            }
            if (record4 != 0) {
                complete++;
                totalFinish += record1;
                maxDiff = Math.max(maxDiff, 4);
            }
            if (record5 != 0) {
                complete++;
                totalFinish += record1;
                maxDiff = Math.max(maxDiff, 5);
            }
            this.mostDiff = maxDiff;
            return complete;
        }

        public String getName() {
            return name;
        }

        public int getFinish() {
            return finish;
        }

        public int getTotalFinish() {
            return totalFinish;
        }

        public int getMostDiff() {
            return mostDiff;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public int getSilver() {
            return silver;
        }

        public void setSilver(int silver) {
            this.silver = silver;
        }

        public int getBronze() {
            return bronze;
        }

        public void setBronze(int bronze) {
            this.bronze = bronze;
        }
    }

    static class Course {
        int courseName;
        int finishCnt;

        int[] recordList;
        HashMap<Integer,Integer> recordMap;

        int goldLine;
        int silverLine;
        int bronzeLine;

        public Course(int courseName) {
            this.courseName = courseName;
            recordMap = new HashMap<>();
        }

        public int getFinishCnt() {
            return finishCnt;
        }

        public void setFinishCnt(int finishCnt) {
            this.finishCnt = finishCnt;
        }

        public int getGold() {
            return goldLine;
        }

        public int getSilver() {
            return silverLine;
        }

        public int getBronze() {
            return bronzeLine;
        }

        public void setRank() {
            this.goldLine = (int) Math.ceil(finishCnt / (double)12);
            this.silverLine = (int) Math.ceil(finishCnt / (double)4);
            this.bronzeLine = (int) Math.ceil(finishCnt / (double)2);
            makeRecordList(finishCnt);
        }

        private void makeRecordList(int finishCnt) {
            this.recordList = new int[finishCnt];
        }

        public void sortRecord() {
            Arrays.sort(recordList);
            for (int i = 0; i < recordList.length; i++) {
                this.recordMap.put(recordList[i],i+1);
            }
        }
    }
}
