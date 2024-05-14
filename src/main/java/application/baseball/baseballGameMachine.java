package application.baseball;

import java.util.Collections;
import java.util.List;

public class baseballGameMachine {
    //기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
    //같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    //e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱
    //위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게 임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
    //이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
    //게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
    private String playerNumber;
    private String computerNumber;


    public baseballGameMachine(String playerNumber) {
        this.playerNumber = playerNumber;
        // 리스트를 섞어서 랜덤 순서로 만들기
        List<Integer> baseballNumber = new java.util.ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(baseballNumber);

        // 앞의 3개의 숫자를 선택
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(baseballNumber.get(i));
        }
        this.computerNumber = sb.toString();
    }

    public pitchResultVo pitched () {
        // 스트라이크 검사

        // 볼 검사


        return new pitchResultVo(false,0,0);
    }

}
