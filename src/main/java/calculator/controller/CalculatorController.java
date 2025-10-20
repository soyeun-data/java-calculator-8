package calculator.controller;

import calculator.model.Expression;
import calculator.view.InputView;
import calculator.view.OutputView;

/**
 * 전체 흐름 제어
 * Input → Expression → Output
 */
public class CalculatorController {
    InputView inputView = new InputView();
    Expression expression = new Expression();
    OutputView outputView = new OutputView();

    public void run() {
        String input = inputView.readInput();

        int result = expression.evaluate(input);

        outputView.printResult(result);
    }
}
