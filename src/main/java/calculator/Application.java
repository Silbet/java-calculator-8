package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static String inputString() {
        return Console.readLine();
    }

    public static void outputResult(int result) {
        System.out.println("결과 : " + result);
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        
        String input = inputString();
        int result = stringCalculator.calculator(input);
        outputResult(result);
    }
}
