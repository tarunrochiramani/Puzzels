
public class Recursive {

    public int factorial(int value) throws Exception {
        if (value < 0) {
            throw new Exception("Negative number not supported");
        }

        if (value == 0) {
            return 1;
        }
        return value * factorial(value -1);
    }
}
