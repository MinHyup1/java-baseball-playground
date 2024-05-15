package application.baseball;

import java.util.*;
import java.util.regex.Pattern;

public class baseballGameMachine {
    //기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
    //같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    //e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱
    //위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게 임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
    //이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
    //게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
    private String computerDigitString;


    public baseballGameMachine() {
        this.computerDigitString = createThreeUniqueDigitString();
    }

    public pitchResultVo pitched (String playerDigitString) {
        // 스트라이크 검사
        LinkedList<String> playerDigitStringCharArray = convertStringToLinkedList(playerDigitString);

        int strikeCount = countStrike(playerDigitStringCharArray);
        
        // 플레이어 승리
        if(strikeCount == 3) return new pitchResultVo(true, 0, 3);
        int ballCount = countBall(playerDigitStringCharArray);

        // 볼 검사
        return new pitchResultVo(false,ballCount,strikeCount);
    }

    private int countBall(LinkedList<String> playerDigitStringCharArray) {
        int ballCount = 0;
        for (int i = 0; i < playerDigitStringCharArray.size(); i++) {
            if(computerDigitString.contains(playerDigitStringCharArray.get(i)) && !playerDigitStringCharArray.get(i).isEmpty()) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private int countStrike(LinkedList<String> playerDigitStringCharArray) {
        int strikeCount = 0;
        for (int i = 0; i < playerDigitStringCharArray.size(); i++) {
            if(computerDigitString.substring(i, i + 1).equals(playerDigitStringCharArray.get(i))) {
                playerDigitStringCharArray.set(i,"");
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public boolean validatePlayerNumber(String playerNumber) {
        Pattern pattern = Pattern.compile("^(?!.*(.).*\\1)\\d{3}$");
        return pattern.matcher(playerNumber).matches();
    }

    private String createThreeUniqueDigitString() {
        List<Integer> digits = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Collections.shuffle(digits);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            result.append(digits.get(i));
        }
        return result.toString();
    }

    private LinkedList<String> convertStringToLinkedList(String input) {
        LinkedList<String> linkedList = new LinkedList<>();
        for (char c : input.toCharArray()) {
            linkedList.add(String.valueOf(c));
        }
        return linkedList;
    }
}
