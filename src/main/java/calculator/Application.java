package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    private static String delimiters = ",|:";

    public static String inputString() {
        return Console.readLine();
    }

    public static void appendDelimiters(String s) {
        // 커스텀 구분자는 문자 하나만 가능하다는 정규표현식
        Pattern pattern = Pattern.compile("//(.)\n");
        Matcher matcher = pattern.matcher(s);

        // TODO: find() 값이 false가 나왔을 때 예외 처리 필요
        if (matcher.find()) {
            String result = matcher.group(1);
            delimiters += "|" + result;
        }
    }

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

    public static void outputResult(int result) {
        System.out.println(result);
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
