package org.example;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    public void testSubtraction() {
        open("https://testsheepnz.github.io/BasicCalculator.html");

        // Создание страницы
        CalculatorPage calculatorPage = new CalculatorPage();

        // Скролл вниз
        calculatorPage.scrollToBottom();

        // Выбор сборки "Prototype"
        calculatorPage.selectBuild("Prototype");

        // Ввод значения
        calculatorPage.enterFirstNumber("2");
        calculatorPage.enterSecondNumber("3");

        // Выбираем операцию вычитания
        calculatorPage.selectOperation("Subtract");

        // Нажимаем кнопку "Calculate"
        calculatorPage.clickCalculate();

        // Проверяем ответ
        String expectedAnswer = "-1";
        String actualAnswer = calculatorPage.getAnswer();
        assertEquals(expectedAnswer, actualAnswer, "Ответ должен быть -1");
    }
}
