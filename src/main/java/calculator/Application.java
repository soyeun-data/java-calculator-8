package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int result = 0;

        if (isNull(input)) {
            output(result);
        } else {
            String[] inputSplit;
            if (input.contains("//") && input.contains("\\n")) {
                inputSplit = splitByCustomDelimiter(input);
            } else {
                inputSplit = splitByDefaultDelimiter(input);
            }

            System.out.println(Arrays.toString(inputSplit));
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
        String numbers = input.substring(end + 2);

        return numbers.split(between);
    }
}
