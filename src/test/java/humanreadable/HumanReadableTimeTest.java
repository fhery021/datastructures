package humanreadable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class HumanReadableTimeTest {

    @ParameterizedTest(name = "Given {0} seconds, makeReadable should return {1}")
    @CsvSource(value = { "0, 00:00:00", "5, 00:00:05", "9, 00:00:09", "3600, 01:00:00", "60, 00:01:00", "86399, 23:59:59", "359999, 99:59:59" })
    void givenSecondsMakeReadableShouldReturnReadable(int seconds, String expectedTime) {
        // Given Arguments
        // When
        String readable = HumanReadableTime.makeReadable(seconds);
        // Then
        assertThat(readable).isEqualTo(expectedTime);
    }

}
