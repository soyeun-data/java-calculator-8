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
            String[] inputSplit = splitByDefaultDelimiter(input);
            System.out.println(Arrays.toString(inputSplit));
        }
        // TODO: 커스텀 구분자로 문자열 분리
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
}
