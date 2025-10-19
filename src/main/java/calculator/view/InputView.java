package calculator.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 문자열 입력, 안내 메시지 제공(”덧셈할 문자열을 입력해 주세요.”)
 */
public class InputView {
    public String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
