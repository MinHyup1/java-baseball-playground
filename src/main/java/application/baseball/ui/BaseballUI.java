package application.baseball.ui;

import application.baseball.BaseballGameMachine;
import application.baseball.PitchResultVo;

import java.util.Scanner;

public class BaseballUI {
    private Scanner scanner;
    private BaseballGameMachine baseballGameMachine;

    public BaseballUI(Scanner scanner, BaseballGameMachine baseballGameMachine) {
        this.scanner = scanner;
        this.baseballGameMachine = baseballGameMachine;
    }

    public boolean pitched(BaseballGameMachine baseballGameMachine, String inputForPlayer) {
        boolean isFail;
        PitchResultVo pitchedResult = baseballGameMachine.pitched(inputForPlayer);
        System.out.println(pitchedResult.getResultString());
        isFail = !pitchedResult.getIsWin();
        return isFail;
    }

    public String getInputForPlayer() {
        System.out.print("숫자를 입력해 주세요 : ");
        String inputForPlayer = getInputForPlayer(this.scanner);
        if(!this.baseballGameMachine.validatePlayerNumber(inputForPlayer)) {
            System.out.println("서로다른 3개의 숫자로 입력해주세요");
            return null;
        }
        return inputForPlayer;
    }

    public boolean isContinueGame(Scanner scanner) {
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String inputForPlayer = getInputForPlayer(scanner);
            if("1".equals(inputForPlayer)) return true;
            if("2".equals(inputForPlayer)) {
                System.out.println("게임을 종료합니다.");
                return false;
            }
            System.out.println("잘못된 입력입니다 다시 입력해주세요");
        }
    }

    public void checkPlayerNumber() {
        boolean isFail = true;
        while (isFail) {
            String inputForPlayer = getInputForPlayer();
            if (inputForPlayer == null) continue;
            isFail = this.pitched(this.baseballGameMachine, inputForPlayer);
            System.out.println("=========================");
        }
    }

    public String getInputForPlayer(Scanner scanner) {
        return scanner.nextLine().replaceAll(" ", "");
    }
}
