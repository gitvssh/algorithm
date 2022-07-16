package algorithm.leetcode.search.BFS;

import java.util.HashSet;
import java.util.Set;

/*
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList,
 * return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 * 노드 탐색 문제
 * 전체에서 가장 짧은 길이를 찾아야 함
 *
 * */
public class WordLadder{

    private String beginWord, endWord;
    private Set<String> wordList = new HashSet();

    private void init() {
        beginWord = "hit";
        endWord = "cog";
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
    }

    public WordLadder() {
        init();
    }

    public void test() {
        int result = ladderLength(beginWord,endWord,wordList);
        System.out.println("result = " + result);
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        //컬렉션 공통함수
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        //방문노드 체크
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            //뎁스별 전체검사
            for (String word : beginSet) {
                //파싱
                char[] chs = word.toCharArray();
                //문자별 검사
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        //최초방문 && 단어리스트 포함
                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }
}
