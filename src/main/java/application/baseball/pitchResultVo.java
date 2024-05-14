package application.baseball;

public class pitchResultVo {

    private boolean isWin; // 게임승리 여부
    private int ballCount; // 볼 개수
    private int strikeCount; // 스트라이크 개수

    public pitchResultVo(boolean isWin, int ballCount, int strikeCount) {
        this.isWin = isWin;
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }
}
