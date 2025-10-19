package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorController calculatorController = new CalculatorController();
        String input = calculatorController.run();

        int result = 0;

        if (isNull(input)) {
            output(result);
        } else {
            String[] inputSplit;
            if (input.contains("//") && input.contains("\\n")) {
                isValidCustomDelimiter(input);
                inputSplit = splitByCustomDelimiter(input);
            } else {
                inputSplit = splitByDefaultDelimiter(input);
            }

            result = sumNum(inputSplit);
            output(result);
        }
    }

    public static void output(int result) {
        System.out.println("결과 : " + result);
    }

    public static boolean isNull(String input) {
        return input == null || input.isEmpty();
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

    public static void isValidCustomDelimiter(String input) {
        int start = input.indexOf("//");
        int end = input.indexOf("\\n");

        if (start == -1 || end == -1 || end <= start + 2) {
            throw new IllegalArgumentException("커스텀 구분자가 잘못되었습니다.");
        }

        if (start > 0) {
            throw new IllegalArgumentException("커스텀 구분자가 처음부터 시작하지 않습니다.");
        }
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

    public static int sumNum(String[] inputSplit) {
        try {
            return Arrays.stream(inputSplit)
                    .mapToInt(Integer::parseInt)
                    .peek(n -> {
                        if (n < 0) {
                            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
                        }
                    })
                    .sum();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("허용되지 않은 구분자가 포함되어 있습니다.");
        }
    }
}
