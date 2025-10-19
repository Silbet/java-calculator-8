package calculator;

import java.util.List;

public class Application {

    public static int addNumber(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
