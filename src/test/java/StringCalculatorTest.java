import static org.assertj.core.api.Assertions.*;
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
    void should_return_zero_for_uncoherence_string() {
        assertThat(calculator.Add("2;5")).isEqualTo(0);
    }

    @Test
    void should_return_number_for_one_number() {
        assertThat(calculator.Add("5")).isEqualTo(5);
    }

}