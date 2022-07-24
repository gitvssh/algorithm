package algorithm.leetcode.search.bfs;

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
public class WordLadder {

    private String beginWord;
    private String endWord;
    private Set<String> wordList = new HashSet<>();

    public WordLadder(String beginWord, String endWord) {
        this.beginWord = beginWord;
        this.endWord = endWord;
    }

    public void test() {
        ladderLength(beginWord, endWord, wordList);
    }

    public void ladderLength(String beginWord, String endWord, Set<String> wordList) {
        //컬렉션 공통함수
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        //방문노드 체크
        HashSet<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<>();
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
                            return;
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
        }
    }
}
