package algorithm.baek.graph;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountingConnectedVertexTest {

    @DisplayName("방문 노드를 확인할 수 있다.")
    @Test
    void checkVisitedVertex() {
        //given
        Map map = new Map(6);
        map.addVertex(1, 2);
        map.addVertex(2, 5);
        map.addVertex(5, 1);
        map.addVertex(3, 4);
        map.addVertex(4, 6);
        //when
        map.chekckVisitedVertex(1);
        //then
        assertThat(map.isVisited(1)).isTrue();
    }

    @DisplayName("연결된 노드를 확인할 수 있다.")
    @Test
    void checkConnectedVertec() {
        //given
        Map map = new Map(6);
        map.addVertex(1, 2);
        map.addVertex(2, 5);
        map.addVertex(5, 1);
        map.addVertex(3, 4);
        map.addVertex(4, 6);
        //when

        //then
        assertThat(map.isConnected(1, 2)).isTrue();
    }

    @DisplayName("깊이우선탐색을 할 수 있다.")
    @Test
    void dfs() {
        //given
        Map map = new Map(6);
        map.addVertex(1, 2);
        map.addVertex(2, 5);
        map.addVertex(5, 1);
        map.addVertex(3, 4);
        map.addVertex(4, 6);
        //when
        map.dfs(1);
        //then
        assertThat(map.isVisited(1)).isTrue();
        assertThat(map.isVisited(2)).isTrue();
        assertThat(map.isVisited(5)).isTrue();
    }

    @DisplayName("너비우선탐색을 할 수 있다.")
    @Test
    void bfs() {
        //given
        Map map = new Map(6);
        map.addVertex(1, 2);
        map.addVertex(2, 5);
        map.addVertex(5, 1);
        map.addVertex(3, 4);
        map.addVertex(4, 6);
        //when
        map.bfs(1);

        //then
        assertThat(map.isVisited(1)).isTrue();
        assertThat(map.isVisited(2)).isTrue();
        assertThat(map.isVisited(5)).isTrue();
    }

    @DisplayName("연결된 노드의 개수를 구할 수 있다.")
    @Test
    void getConnectedCount() {
        //given
        Map map = new Map(6);
        map.addVertex(1, 2);
        map.addVertex(2, 5);
        map.addVertex(5, 1);
        map.addVertex(3, 4);
        map.addVertex(4, 6);
        //when

        //then
        assertThat(map.getConnectedCount(1,null )).isEqualTo(3);
    }
}