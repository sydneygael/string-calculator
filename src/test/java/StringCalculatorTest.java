import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    private StringCalculator calculator = new StringCalculator();

    @Test
    void should_return_zero_for_empty_string() {
        assertThat(calculator.Add("")).isEqualTo(0);
    }

    @Test
    void should_return_zero_for_null_string() {
        assertThat(calculator.Add(null)).isEqualTo(0);
    }

    @Test
    void should_return_throw_Exception_for_uncoherence_string() {
        assertThatThrownBy(() ->calculator.Add("2;5"))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    void should_return_number_for_one_number() {
        assertThat(calculator.Add("5")).isEqualTo(5);
    }

    @Test
    void should_handle_an_unknown_amount_of_numbers() {
        assertThat(calculator.Add("1,2,3")).isEqualTo(6);
    }

    @Test
    void should_allow_the_add_method_to_handle_new_lines_between_numbers() {
        assertThat(calculator.Add("1\n2,3")).isEqualTo(6);
    }

    @Test
    void should_support_different_delimiters() {
        assertThat(calculator.Add("//;\n1;2")).isEqualTo(3);
    }

    @Test
    void should_support_different_delimiters_2() {
        assertThat(calculator.Add("//:\n1:2")).isEqualTo(3);
    }

}