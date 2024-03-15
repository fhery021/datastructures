package multiplesof3or5;

import java.util.stream.IntStream;

public class MultipleOf3Or5 {
    private static boolean isMultipleOf3Or5(int nr) {
        return nr % 3 == 0 || nr % 5 == 0;
    }

    public int solution(int number) {
        return IntStream.range(0, number).parallel().filter(MultipleOf3Or5::isMultipleOf3Or5).sum();
    }
}
