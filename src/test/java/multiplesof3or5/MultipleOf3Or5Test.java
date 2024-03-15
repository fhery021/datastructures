package multiplesof3or5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MultipleOf3Or5Test {

    @ParameterizedTest(name = "Given {0}, sum of multiples of 3 or 5 should be {1}")
    @CsvSource(value = {"10, 23", "4, 3", "6, 8", "-5, 0"})
    void givenArgumentSolutionShouldReturnSumOfMultiplesOf3Or5(int number, int expected) {
        // Given Arguments
        // When
        int solution = new MultipleOf3Or5().solution(number);
        // Then
        assertThat(solution).isEqualTo(expected);
    }
}
