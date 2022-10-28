package pl.luxoft.qaupskilling.cucumber.stepdefs.examples;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pl.luxoft.qaupskilling.cucumber.enums.OurColor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class ArgumentsExpressionSteps {

    String oneStringWord;
    BigDecimal bigDecimalNumber;

    LocalDate today;
    LocalDate future;

    @Given("{word} as a word step expression")
    public void as_a_word_step_expression(String word) {
        oneStringWord = word;
    }

    @Then("above word can not be split")
    public void above_word_can_not_be_split() {
        Assertions.assertEquals(1, oneStringWord.split(" ").length);
    }

    @Given("{bigdecimal} as a bigdecimal step expression")
    public void as_a_bigdecimal_step_expression(BigDecimal bigNumber) {
        bigDecimalNumber = bigNumber;
    }

    @Then("the variable value to which it assigned not equal to initial var value")
    public void the_variable_value_to_which_it_assigned_not_equal_to_initial_var_value() {
        Assertions.assertNotEquals(bigDecimalNumber, BigDecimal.ZERO);
    }

    @Given("{biginteger} is a big integer")
    public void is_a_big_integer(BigInteger bigInt) {
        System.out.println("************ our big integer + 1 = " + bigInt.add(BigInteger.ONE));
    }

    @Given("{} as anonymous argument will be converted into enum")
    public void blue_as_anonymous_argument_will_be_converted_into_enum(OurColor color) {
        System.out.println("Our color is  " + color.toString());
    }

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDate iso8601Date(String year, String month, String day) {
        return LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    }

    @Given("today is {iso8601Date}")
    public void today_is(LocalDate today1) {
        today = today1;
    }

    @When("we add {int} month to today's date")
    public void we_add_month_to_today_s_date(Integer monthToAdd) {
        future = today.plusMonths(monthToAdd);
    }

    @Then("result date will be in future")
    public void result_date_will_be_in_future() {
        Assertions.assertTrue(future.isAfter(today));
    }


}
