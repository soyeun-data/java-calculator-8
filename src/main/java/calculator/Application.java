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
        calculatorController.run();
}}
