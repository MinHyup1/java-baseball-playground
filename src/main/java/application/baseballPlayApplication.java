package application;

import utils.StringCalculator;

import java.util.Scanner;

public class baseballPlayApplication {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine().replaceAll(" ","");
        StringCalculator stringCalculator = new StringCalculator();
        System.out.println("values = " + stringCalculator.stringNumberCalculate(value));
    }
}
