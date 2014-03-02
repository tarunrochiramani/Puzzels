import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RecursiveTest {
    Recursive recursive = new Recursive();

    @Test (expected = Exception.class)
    public void cannotFactorialNegativeNumber() throws Exception {
        recursive.factorial(-1);
    }


    public void canFactorialNonNegativeNumber() throws Exception {
        int result = recursive.factorial(4);

        assertTrue(result > 0);
        assertEquals(24, result);
    }
}
