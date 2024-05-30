package algorithm.baek.simulation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyRoomTest {

    @DisplayName("독서실은 예약자들의 자리를 배치할 수 있다.")
    @Test
    void setReservator() {
        //given
        StudyRoomDistancing.StudyRoom studyRoom = new StudyRoomDistancing.StudyRoom(5);
        //when
        List<StudyRoomDistancing.Reservator> reservators = new ArrayList<>();
        reservators.add(new StudyRoomDistancing.Reservator("0915","0930"));
        reservators.add(new StudyRoomDistancing.Reservator("0940","2040"));
        reservators.add(new StudyRoomDistancing.Reservator("0910","0920"));
        reservators.add(new StudyRoomDistancing.Reservator("2040","2050"));
        reservators.add(new StudyRoomDistancing.Reservator("2043","2047"));
        reservators.add(new StudyRoomDistancing.Reservator("2044","2046"));
        //then
        assertThat(studyRoom.setReservator(reservators)).isTrue();
    }

    @DisplayName("독서실은 자리배치 규칙을 가지고 있다.")
    @Test
    void studyroomHasPositioningRule() {
        //given
        StudyRoomDistancing.StudyRoom studyRoom = new StudyRoomDistancing.StudyRoom(5);
        //when
        List<StudyRoomDistancing.Reservator> reservators = new ArrayList<>();
        reservators.add(new StudyRoomDistancing.Reservator("0915","0930"));
        reservators.add(new StudyRoomDistancing.Reservator("0940","2040"));
        reservators.add(new StudyRoomDistancing.Reservator("0910","0920"));
        reservators.add(new StudyRoomDistancing.Reservator("2040","2050"));
        reservators.add(new StudyRoomDistancing.Reservator("2043","2047"));
        reservators.add(new StudyRoomDistancing.Reservator("2044","2049"));
        studyRoom.setReservator(reservators);
        //then
        assertThat(studyRoom.canReservation("0916",1)).isFalse();
    }

    @DisplayName("독서실은 특정 자리의 가용 시간을 알 수 있다.")
    @Test
    void getAvailableTime() {
        //given
        StudyRoomDistancing.StudyRoom studyRoom = new StudyRoomDistancing.StudyRoom(5);
        //when
        List<StudyRoomDistancing.Reservator> reservators = new ArrayList<>();
        reservators.add(new StudyRoomDistancing.Reservator("0915","0930"));
        reservators.add(new StudyRoomDistancing.Reservator("0940","2040"));
        reservators.add(new StudyRoomDistancing.Reservator("0910","0920"));
        reservators.add(new StudyRoomDistancing.Reservator("2040","2050"));
        reservators.add(new StudyRoomDistancing.Reservator("2043","2047"));
        reservators.add(new StudyRoomDistancing.Reservator("2044","2049"));
        studyRoom.setReservator(reservators);
        //then
        assertThat(studyRoom.getAvailableTime(1)).isEqualTo(40);
    }
}