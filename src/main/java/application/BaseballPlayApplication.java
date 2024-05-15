package application;

import application.baseball.BaseballGameMachine;
import application.baseball.PitchResultVo;

import java.util.Scanner;

public class BaseballPlayApplication {
    public static void main(String[] args) throws Exception {
        boolean isContinue = true;
        BaseballGameMachine baseballGameMachine = new BaseballGameMachine();
        Scanner scanner = new Scanner(System.in);

        while (isContinue) {
            System.out.println("========= 야구게임을 시작하겠습니다 =========");
            boolean isFail = true;
            while (isFail) {
                String inputForPlayer = getInputForPlayer(scanner, baseballGameMachine);
                if (inputForPlayer == null) continue;
                isFail = pitched(baseballGameMachine, inputForPlayer);
                System.out.println("=========================");
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isContinue = isContinueGame(scanner);
            baseballGameMachine.newBaseballGame();
        }

        scanner.close(); // 스캐너 닫기
    }

    private static boolean pitched(BaseballGameMachine baseballGameMachine, String inputForPlayer) {
        boolean isFail;
        PitchResultVo pitchedResult = baseballGameMachine.pitched(inputForPlayer);
        System.out.println(pitchedResult.getResultString());
        isFail = !pitchedResult.getIsWin();
        return isFail;
    }

    private static String getInputForPlayer(Scanner scanner, BaseballGameMachine baseballGameMachine) {
        System.out.print("숫자를 입력해 주세요 : ");
        String inputForPlayer = getInputForPlayer(scanner);
        if(!baseballGameMachine.validatePlayerNumber(inputForPlayer)) {
            System.out.println("서로다른 3개의 숫자로 입력해주세요");
            return null;
        }
        return inputForPlayer;
    }

    private static boolean isContinueGame(Scanner scanner) {
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

    private static String getInputForPlayer(Scanner scanner) {
        String input = scanner.nextLine().replaceAll(" ", "");
        return input;
    }
}
