package Testing.Calculator.controller;

import Testing.Calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }


    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String add(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Ошибка: необходимы параметры num1 и num2!");
        }
        int result = calculatorService.plus(num1, num2);
        return num1 + " + " + num2 + " = " + result;
    }

    @GetMapping("/minus")
    public String subtract(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Ошибка: необходимы параметры num1 и num2!");
        }
        int result = calculatorService.minus(num1, num2);
        return num1 + " - " + num2 + " = " + result;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Ошибка: необходимы параметры num1 и num2!");
        }
        int result = calculatorService.multiply(num1, num2);
        return num1 + " * " + num2 + " = " + result;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(required = false) Integer num1,
                         @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Ошибка: необходимы параметры num1 и num2!");
        }
        try {
            int result = calculatorService.divide(num1, num2);
            return num1 + " / " + num2 + " = " + result;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Ошибка: деление на ноль невозможно!");
        }
    }
}
