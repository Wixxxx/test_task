package org.example;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class CalculatorPage {

    // Локаторы элементов на странице калькулятора
    private SelenideElement firstNumberField = $("#number1Field");
    private SelenideElement secondNumberField = $("#number2Field");
    private SelenideElement operationSelect = $("#selectOperationDropdown");
    private SelenideElement calculateButton = $("#calculateButton");
    private SelenideElement answerField = $("#numberAnswerField");
    private SelenideElement buildSelect = $("#selectBuild");

    // Методы взаимодействия с элементами страницы
    public void selectBuild(String build) {
        buildSelect.selectOption(build);
    }

    public void enterFirstNumber(String number) {
        firstNumberField.setValue(number);
    }

    public void enterSecondNumber(String number) {
        secondNumberField.setValue(number);
    }

    public void selectOperation(String operation) {
        operationSelect.selectOption(operation);
    }

    public void clickCalculate() {
        calculateButton.click();
    }

    public String getAnswer() {
        return answerField.getValue();
    }

    public void scrollToBottom() {
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
