package algorithm.baek.simulation;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import algorithm.baek.simulation.PuttingSticker.Notebook;
import algorithm.baek.simulation.PuttingSticker.Sticker;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class PuttingStickerTest {

    @DisplayName("노트북에는 스티커를 붙일 수 있다.")
    @Test
    public void puttingSticker() {
        //given
        PuttingSticker.Notebook notebook = new PuttingSticker.Notebook(5, 5);
        PuttingSticker.Sticker sticker = new PuttingSticker.Sticker(new int[][]{{1, 0, 1}, {1, 1, 1}, {1, 0, 1}});
        //when
        notebook.puttingSticker(0, 0, sticker);
        //then
        assertThat(notebook.notebook[0][0]).isTrue();
    }

    @DisplayName("노트북은 스티커가 붙여진 칸의 개수를 구할 수 있다.")
    @Test
    public void getStickerCount() {
        //given
        PuttingSticker.Notebook notebook = new PuttingSticker.Notebook(5, 5);
        PuttingSticker.Sticker sticker = new PuttingSticker.Sticker(new int[][]{{1, 0, 1}, {1, 1, 1}, {1, 0, 1}});
        //when
        notebook.puttingSticker(0, 0, sticker);
        //then
        assertThat(notebook.getStickerCount()).isEqualTo(7);
    }

    @DisplayName("노트북은 스티커를 붙일 수 있는지 확인할 수 있다.")
    @Test
    public void checkPuttingSticker() {
        //given
        PuttingSticker.Notebook notebook = new PuttingSticker.Notebook(5, 5);
        PuttingSticker.Sticker sticker = new PuttingSticker.Sticker(new int[][]{{1, 0, 1}, {1, 1, 1}, {1, 0, 1}});
        //when
        //then
        assertThat(notebook.checkPuttingSticker(0, 0, sticker)).isTrue();
    }

    @DisplayName("스티커는 시계방향으로 회전할 수 있다.")
    @Test
    public void rotateSticker() {
        //given
        PuttingSticker.Sticker sticker = new PuttingSticker.Sticker(new int[][]{{1, 0, 1}, {1, 1, 1}, {1, 0, 1}});
        //when
        PuttingSticker.Sticker newSticker = sticker.rotate();
        //then
        assertThat(newSticker).isEqualTo(new PuttingSticker.Sticker(new int[][]{{1, 1, 1}, {0, 1, 0}, {1, 1, 1}}));
    }

    @DisplayName("노트북은 정해진 규칙에 따라 스티커를 붙일 수 잇다.")
    @Test
    public void putSticker() {
        //given
        PuttingSticker.Notebook notebook = new PuttingSticker.Notebook(5, 4);
        PuttingSticker.Sticker sticker = new PuttingSticker.Sticker(new int[][]{{1, 0, 1}, {1, 1, 1}, {1, 0, 1}});
        PuttingSticker.Sticker sticker2 = new PuttingSticker.Sticker(new int[][]{{1, 1, 1, 1, 1}, {0, 0, 0, 1, 0}});
        PuttingSticker.Sticker sticker3 = new PuttingSticker.Sticker(new int[][]{{1, 1, 1}, {1, 0, 1}});
        PuttingSticker.Sticker sticker4 = new PuttingSticker.Sticker(new int[][]{{1, 0, 0}, {1, 1, 1}, {1, 0, 0}});
        ArrayList<PuttingSticker.Sticker> stickers = new ArrayList<>();
        stickers.add(sticker);
        stickers.add(sticker2);
        stickers.add(sticker3);
        stickers.add(sticker4);
        //when
        notebook.puttingStickers(stickers);
        //then
        assertThat(notebook.getStickerCount()).isEqualTo(18);
    }

    @DisplayName("알고리즘을 최종 테스트 할 수 있다.")
    @CsvSource(value = {"5 4 4\\n"
        + "3 3\\n"
        + "1 0 1\\n"
        + "1 1 1\\n"
        + "1 0 1\\n"
        + "2 5\\n"
        + "1 1 1 1 1\\n"
        + "0 0 0 1 0\\n"
        + "2 3\\n"
        + "1 1 1\\n"
        + "1 0 1\\n"
        + "3 3\\n"
        + "1 0 0\\n"
        + "1 1 1\\n"
        + "1 0 0:18",
    "1 3 3\\n"
            + "2 3\\n"
            + "1 0 0\\n"
            + "1 1 1\\n"
            + "1 1\\n"
            + "1\\n"
            + "3 1\\n"
            + "1\\n"
            + "1\\n"
            + "1:1"}, delimiter = ':')
    @ParameterizedTest
    public void finalTest(String input, int expected) {
        //given
        String[] split = input.split("\\\\n");
        int splitIndex = 0;
        StringTokenizer st = new StringTokenizer(split[splitIndex++]);
        ArrayList<Sticker> stickers = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Notebook notebook = new Notebook(N, M);

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(split[splitIndex++]);
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[][] graph = new int[R][C];
            for (int j = 0; j < R; j++) {
                st = new StringTokenizer(split[splitIndex++]);
                for (int k = 0; k < C; k++) {
                    graph[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(new Sticker(graph));
        }

        notebook.puttingStickers(stickers);
        //when

        //then
        assertThat(notebook.getStickerCount()).isEqualTo(expected);
    }
}