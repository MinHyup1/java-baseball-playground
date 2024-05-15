package application.baseball;

import java.util.Objects;

public class pitchResultVo {

    private boolean isWin; // 게임승리 여부
    private int ballCount; // 볼 개수
    private int strikeCount; // 스트라이크 개수

    public pitchResultVo(boolean isWin, int ballCount, int strikeCount) {
        this.isWin = isWin;
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public String getResultString() {
        String result = "";

        if(ballCount != 0) {
            result += ballCount + "볼";
        }

        if(strikeCount != 0) {
            result += " " + strikeCount + "스트라이크";
        }

        if(ballCount == 0 && strikeCount == 0){
            result +="낫싱";
        }

        return result;
    }

    // equals and hashCode for comparison in tests
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        pitchResultVo that = (pitchResultVo) o;
        return isWin == that.isWin &&
                ballCount == that.ballCount &&
                strikeCount == that.strikeCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isWin, ballCount, strikeCount);
    }
}
