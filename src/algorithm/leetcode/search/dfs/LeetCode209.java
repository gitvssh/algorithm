package algorithm.leetcode.search.dfs;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.
*/
public class LeetCode209 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==1) return true;
        if(prerequisites.length==0) return false;
        boolean result = false;

        int m = prerequisites.length; //n = 2
        int[] cache = new int[m];


//        Arrays.stream(prerequisites).filter(y -> )

        for (int i = 0; i < numCourses; i++) {
            if (!checkPrq(prerequisites, i, m, cache)) {
                result = false;
                break;
            }
            result = true;
        }
        return result;
    }
//배열의 첫번째 항이 코스 명과 일치하지 않음, 검색해야 함
    private boolean checkPrq(int[][] prerequisites, int i, int m, int[] cache) {
        if (cache[i] != 0) return true;
        if(i >= m) return false;
        int nextCourse = prerequisites[i][1];
        if (i < 0 || i == prerequisites[nextCourse][1]) return false;
        boolean result = false;
        result = checkPrq(prerequisites, prerequisites[i][1],m, cache);
        cache[i] = 1;
        return result;
    }
}
