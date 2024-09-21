package Testing.Calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        calculatorService = new CalculatorServiceImpl() {
        };
    }

    @Test
    void testPlus() {
        assertEquals(10, calculatorService.plus(5, 5));
        assertEquals(0, calculatorService.plus(-5, 5));
    }

    @Test
    void testMinus() {
        assertEquals(0, calculatorService.minus(5, 5));
        assertEquals(-10, calculatorService.minus(-5, 5));
    }

    @Test
    void testMultiply() {
        assertEquals(25, calculatorService.multiply(5, 5));
        assertEquals(-25, calculatorService.multiply(-5, 5));
    }

    @Test
    void testDivide() {
        assertEquals(1, calculatorService.divide(5, 5));
        assertEquals(-1, calculatorService.divide(-5, 5));
    }

    @Test
    void testDivideByZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> calculatorService.divide(5, 0));
        assertEquals("Деление на ноль не допускается", exception.getMessage());
    }
}