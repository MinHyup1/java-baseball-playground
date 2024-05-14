package application;

import java.util.Scanner;

public class StringCalculatorApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        String[] values = value.split(" ");
        System.out.println("values = " + values);
    }
}
