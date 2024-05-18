package application;

import application.baseball.BaseballGameMachine;
import application.baseball.ui.BaseballUI;

import java.util.Scanner;

public class BaseballPlayApplication {
    public static void main(String[] args) throws Exception {
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine();
        Scanner scanner = new Scanner(System.in);
        BaseballUI baseballUI = new BaseballUI(scanner, baseballGameMachine);

        boolean isContinue = true;
        while (isContinue) {
            System.out.println("========= 야구게임을 시작하겠습니다 =========");
            baseballUI.checkPlayerNumber();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isContinue = baseballUI.isContinueGame(scanner);
            baseballGameMachine.reGeneratedComputerNumber();
        }
        scanner.close(); // 스캐너 닫기
    }

}
