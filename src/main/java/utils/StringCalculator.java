package utils;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedList;

public class StringCalculator {
    /* 요구사항  */
    //사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
    //문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
    //예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

    //문자열 계산기 프로세스 문자열에 포함된 연산기호의 위치(index)를 파악 후 연산기호 위치 기반으로 String을 자른 후 계산한다.

    public int stringNumberCalculate(String input) throws Exception {

        // 부등호의 위치 파악
        LinkedList<Integer> operationSymbolLocations = findOperationSymbol(input);

        int firstTerm = Integer.parseInt(input.substring(0,operationSymbolLocations.get(0)));

        //연산기호가 한개밖에 없을때
        if(operationSymbolLocations.size() == 1) {
            return calculate(firstTerm, Integer.parseInt(input.substring(operationSymbolLocations.get(0)+1)), input.charAt(operationSymbolLocations.get(0)));
        }

        //연산기호가 한개 이상일 때
        for (int i = 0; i < operationSymbolLocations.size(); i++) {
            int secondTerm = getSecondTerm(input, operationSymbolLocations, i);
            firstTerm = calculate(firstTerm,secondTerm,input.charAt(operationSymbolLocations.get(i)));
        }
        return firstTerm;
    }

    private int getSecondTerm(String input, LinkedList<Integer> operationSymbolLocations, int i) {
        if(i == operationSymbolLocations.size() - 1 ) {
            return Integer.parseInt(input.substring(operationSymbolLocations.get(i) + 1));
        }
        return Integer.parseInt(input.substring(operationSymbolLocations.get(i) + 1, operationSymbolLocations.get(i + 1)));
    }

    private int calculate(int firstTerm, int secondTerm, char operationSymbol) throws Exception {
        if(operationSymbol == '+') return firstTerm + secondTerm;
        if(operationSymbol == '-') return firstTerm - secondTerm;
        if(operationSymbol == '*') return firstTerm * secondTerm;
        if(operationSymbol == '/') return firstTerm / secondTerm;
        throw new Exception("not operationSymbol");
    }

    private LinkedList<Integer> findOperationSymbol(String input) {
        LinkedList<Integer> operationSymbolLocations = new LinkedList<>();
        final char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            if(charArray[i] == '+'
               || charArray[i] == '-'
               || charArray[i] == '*'
               || charArray[i] == '/'
            ) {
                operationSymbolLocations.add(i);
            }
        }
        return operationSymbolLocations;
    }
}
