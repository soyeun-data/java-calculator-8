package calculator.model;

import java.util.regex.Pattern;

/**
 * 기본 구분자인지, 커스텀 구분자인지 판별, 구분자 기준으로 split
 */
public class DelimiterParser {
    public String[] parse(String input) {
        if (isNull(input)) {
            return new String[0];
        }

        if (isCustomDelimiter(input)) {
            return splitByCustomDelimiter(input);
        } else {
            return splitByDefaultDelimiter(input);
        }
    }

    public boolean isNull(String input) {
        return input == null || input.isEmpty();
    }

    public boolean isCustomDelimiter(String input) {
        isValidCustomDelimiter(input);
        return input.contains("//") && input.contains("\\n");
    }

    public void isValidCustomDelimiter(String input) {
        int start = input.indexOf("//");
        int end = input.indexOf("\\n");

        if (start == -1 || end == -1 || end <= start + 2) {
            throw new IllegalArgumentException("커스텀 구분자가 잘못되었습니다.");
        }

        if (start > 0) {
            throw new IllegalArgumentException("커스텀 구분자가 처음부터 시작하지 않습니다.");
        }
    }

    public static String[] splitByDefaultDelimiter(String input) {
        return input.split("[,:]");
    }

    public static String[] splitByCustomDelimiter(String input) {
        int start = input.indexOf("//");
        int end = input.indexOf("\\n");

        String between = input.substring(start + 2, end);
        isValidBetween(between);

        String numbers = input.substring(end + 2);

        return numbers.split(Pattern.quote(between));
    }

    public static void isValidBetween(String between) {
        if (between.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 존재하지 않습니다.");
        }

        if (between.length() > 1) {
            throw new IllegalArgumentException("커스텀 구분자가 한 자 이상입니다.");
        }

        if (between.matches("\\d+")) {
            throw new IllegalArgumentException("커스텀 구분자가 숫자입니다.");
        }
    }
}
