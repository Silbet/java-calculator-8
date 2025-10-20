package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DELIMITERS = ",|:";

    public int calculator(String input) {
        String delimiters = DELIMITERS;

        delimiters += appendDelimiters(input);
        String trimmedInput = trimString(input);

        List<Integer> numbers = extractNumber(trimmedInput, delimiters);
        return addNumber(numbers);
    }

    // 커스텀 구분자를 분리해 리턴하는 메소드
    private String appendDelimiters(String s) {
        // 커스텀 구분자는 문자 하나만 가능하다는 정규표현식
        Pattern pattern = Pattern.compile("^//(.)\\\\n");
        Matcher matcher = pattern.matcher(s);
        // 커스텀 구분자 양식이 일치하는 경우 커스텀 구분자 리턴
        if (matcher.find()) {
            return "|" + matcher.group(1);
        }
        return "";
    }

    // 커스텀 구분자 양식이 있다면 지우고 문자열을 리턴하는 메소드
    private String trimString(String s) {
        Pattern pattern = Pattern.compile("^//(.)\\\\n");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            return matcher.replaceFirst("");
        }
        return s;
    }

    private List<Integer> extractNumber(String s, String delimiters) {
        List<Integer> numbers = new ArrayList<>();

        String[] parts = s.split(delimiters, -1);

        // 추출한 숫자를 List<Integer> 형태로 변환 후 리턴
        for (String part : parts) {
            // ""인 경우 값을 0으로 바꾸기
            if (part.equals("")) {
                part = "0";
            }
            validateNumber(part);
            numbers.add(Integer.parseInt(part));
        }

        return numbers;
    }

    private void validateNumber(String part) {
        if (!part.matches("\\d+")) {
            throw new IllegalArgumentException("숫자, 구분자 외의 문자는 입력할 수 없습니다.");
        }

        if (Integer.parseInt(part) <= 0) {
            throw new IllegalArgumentException("양수가 아닌 정수는 입력할 수 없습니다.");
        }
    }

    private int addNumber(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}
