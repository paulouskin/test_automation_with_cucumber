package pl.luxoft.qaupskilling.cucumber.stepdefs.calculator;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pl.luxoft.qaupskilling.cucumber.calculator.Calculator;

public class CalculatorSteps {

    private Calculator calculator;
    int result;

    @Given("John has a calculator")
    public void john_has_a_calculator() {
        calculator = new Calculator();
    }

    @When("he add {int} and {int}")
    public void addTwoNumbers(Integer num1, Integer num2) {
        result = calculator.add(num1, num2);
    }

    @Then("result will be {int}")
    public void result_will_be(Integer result) {
        Assertions.assertEquals(this.result, result);
    }

    @When("he subtract {int} from {int}")
    public void heSubtractFrom(int subtrahend, int minuend) {
        result = Calculator.subtract(minuend, subtrahend);
    }

    @When("he multiply {int} by {int}")
    public void heMultiplyBy(int factor1, int factor2) {
        result = Calculator.multiply(factor1, factor2);
    }

    @When("he divide {int} by {int}")
    public void heDivideBy(int numerator, int denominator) {
        result = Calculator.divide(numerator, denominator);
    }
}
