package algorithm.baek.datastructure;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SameWordGroupingTest {

    @DisplayName("헬퍼 클래스는 단어를 저장할 수 있다.")
    @Test
    void saveWord() {
        //given
        SameWordGrouping.WordHelper wh = new SameWordGrouping.WordHelper();
        List<String> words = new ArrayList<>();
        //when
        words.add("cat");
        words.add("dog");
        words.add("god");
        words.add("tca");
        //then
        assertThat(wh.saveWord(words)).isTrue();
    }

    @DisplayName("헬퍼 클래스는 단어를 정렬할 수 있다.")
    @Test
    void countGroup() {
        //given
        SameWordGrouping.WordHelper wh = new SameWordGrouping.WordHelper();
        List<String> words = new ArrayList<>();
        //when
        words.add("cat");
        words.add("dog");
        words.add("god");
        words.add("tca");
        wh.saveWord(words);
        //then
        assertThat(wh.countGroup()).isEqualTo(2);
    }
}