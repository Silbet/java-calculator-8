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

    public static String appendDelimiters(String s) {
        // 커스텀 구분자는 문자 하나만 가능하다는 정규표현식
        Pattern pattern = Pattern.compile("//(.)\n");
        Matcher matcher = pattern.matcher(s);
        // 커스텀 구분자 양식이 일치하는 경우 양식을 제거하고 뒤 문자열 리턴
        if (matcher.find()) {
            String result = matcher.group(1);
            delimiters += "|" + result;
            return matcher.replaceFirst("");
        }
        return s;
    }

    public static List<Integer> extractNumber(String s) {
        List<Integer> numbers = new ArrayList<>();

        String[] parts = s.split(delimiters, -1);

        // 추출한 숫자를 List<Integer> 형태로 변환 후 리턴
        for (String part : parts) {
            // ""인 경우 값을 0으로 바꾸기
            if (part.equals("")) {
                part = "0";
            }
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
