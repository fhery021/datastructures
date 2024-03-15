package humanreadable;

public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        final long hours = seconds / 3600;
        final long minutes = seconds % 3600 / 60;
        final long sec = seconds - 3600 * hours - 60 * minutes;
        return String.format("%s:%s:%s",twoDigit(hours), twoDigit(minutes), twoDigit(sec));
    }

    private static String twoDigit(long value) {
        return value < 10 ? "0" + value : String.valueOf(value);
    }
}
