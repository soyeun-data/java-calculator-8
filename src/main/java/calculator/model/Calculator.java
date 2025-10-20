package calculator.model;

import java.util.Arrays;

/**
 * 파싱된 숫자 리스트를 더하기(계산)
 */
public class Calculator {
    public int sumNum(String[] inputSplit) {
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
