package Testing.Calculator.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorServiceParameterizedTest {

    private CalculatorService calculatorService = new CalculatorServiceImpl();

    @ParameterizedTest
    @MethodSource("provideParamsForPlus")
    void testPlus(int num1, int num2, int expected) {
        assertEquals(expected, calculatorService.plus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMinus")
    void testMinus(int num1, int num2, int expected) {
        assertEquals(expected, calculatorService.minus(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForMultiply")
    void testMultiply(int num1, int num2, int expected) {
        assertEquals(expected, calculatorService.multiply(num1, num2));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForDivide")
    void testDivide(int num1, int num2, int expected) {
        assertEquals(expected, calculatorService.divide(num1, num2));
    }

    private static Stream<Arguments> provideParamsForPlus() {
        return Stream.of(
                Arguments.of(5, 5, 10),
                Arguments.of(-1, 1, 0)
        );
    }

    private static Stream<Arguments> provideParamsForMinus() {
        return Stream.of(
                Arguments.of(5, 5, 0),
                Arguments.of(-1, 1, -2)
        );
    }

    private static Stream<Arguments> provideParamsForMultiply() {
        return Stream.of(
                Arguments.of(5, 5, 25),
                Arguments.of(-1, 1, -1)
        );
    }

    private static Stream<Arguments> provideParamsForDivide() {
        return Stream.of(
                Arguments.of(5, 5, 1),
                Arguments.of(-1, 1, -1)
        );
    }
}