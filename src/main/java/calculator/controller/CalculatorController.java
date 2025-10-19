package calculator.controller;

import calculator.view.InputView;

/**
 * 전체 흐름 제어
 * Input → Expression → Output
 */
public class CalculatorController {
    public String run() {
        InputView inputView = new InputView();

        String input = inputView.readInput();
        return input;
    }
}
