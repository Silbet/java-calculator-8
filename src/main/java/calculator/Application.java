package calculator;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static String delimiters = ",|:";

    public static List<Integer> extractNumber(String s) {
        List<Integer> numbers = new ArrayList<>();

        String[] parts = s.split(delimiters);

        // 추출한 숫자를 List<Integer> 형태로 변환 후 리턴
        for (String part : parts) {
            numbers.add(Integer.parseInt(part));
        }

        return numbers;
    }

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
