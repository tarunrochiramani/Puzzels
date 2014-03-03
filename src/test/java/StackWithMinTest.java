import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackWithMinTest {

    StackWithMin stackWithMin = new StackWithMin();

    @Test
    public void canMaintainMin() {
        assertEquals(Integer.MAX_VALUE, stackWithMin.getMin());
    }

    @Test
    public void canGetMin() {
        stackWithMin.push(5);
        stackWithMin.push(8);
        assertEquals(5, stackWithMin.getMin());

        stackWithMin.pop();
        assertEquals(5, stackWithMin.getMin());

        stackWithMin.push(1);
        stackWithMin.push(10);
        assertEquals(1, stackWithMin.getMin());

        stackWithMin.pop();
        assertEquals(1, stackWithMin.getMin());

        stackWithMin.pop();
        assertEquals(5, stackWithMin.getMin());

    }

}
