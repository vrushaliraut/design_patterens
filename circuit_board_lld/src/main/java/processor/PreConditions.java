package processor;

public class PreConditions {
    public static <T> boolean validateEquals(T expected, T result) {
        if (expected.toString().equals(result.toString())) {
            return true;
        }
        throw new IllegalArgumentException();
    }

}
