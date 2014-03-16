import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class RecursiveTest {
    Recursive recursive = new Recursive();

    @Test (expected = Exception.class)
    public void cannotFactorialNegativeNumber() throws Exception {
        recursive.factorial(-1);
    }


    @Test
    public void canFactorialNonNegativeNumber() throws Exception {
        int result = recursive.factorial(4);

        assertTrue(result > 0);
        assertEquals(24, result);
    }

    @Test
    public void canCountWays() {
        int count = recursive.countWaysDP(4, new int[]{-1, -1 , -1, -1, -1});

        assertTrue(count > 0);
    }

    @Test
    public void testRobotMove() {
        assertEquals(0, recursive.robotMove(null, 0, 0));

        int size = 1;
        int[][] matrix = new int[size][size];
        assertEquals(1, recursive.robotMove(matrix, size-1, size-1));

        size = 2;
        matrix = new int[size][size];
        int moves = recursive.robotMove(matrix, size - 1, size - 1);
        assertTrue(moves > 1);
        assertEquals(2, moves);

        size = 3;
        matrix = new int[size][size];
        moves = recursive.robotMove(matrix, size - 1, size - 1);
        assertTrue(moves > 1);
        assertEquals(6, moves);

        size = 4;
        matrix = new int[size][size];
        moves = recursive.robotMove(matrix, size - 1, size - 1);
        assertTrue(moves > 1);
        assertEquals(20, moves);
    }

    @Test
    public void canGetRobotMoves() {
        int size = 0;
        assertNull(recursive.getRobotMove(size));

        size = 1;
        List<List<Point>> pointList = recursive.getRobotMove(size);
        assertNotNull(pointList);
        assertFalse(pointList.isEmpty());
        System.out.println("size: " + size + " - " + printMoves(pointList));

        size = 2;
        pointList = recursive.getRobotMove(size);
        assertNotNull(pointList);
        assertFalse(pointList.isEmpty());
        System.out.println("size: " + size + " - " + printMoves(pointList));

        size = 3;
        pointList = recursive.getRobotMove(size);
        assertNotNull(pointList);
        assertFalse(pointList.isEmpty());
        System.out.println("size: " + size + " - " + printMoves(pointList));
    }

    private String printMoves(List<List<Point>> pointList) {
        if (pointList == null) {
            System.out.println("Invalid Point list");
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (List<Point> points : pointList) {
            stringBuilder.append("\n");
            for (Point point : points) {
                stringBuilder.append("(");
                stringBuilder.append(point.getX() + "," + point.getY());
                stringBuilder.append(") ");
            }

        }

        return stringBuilder.toString();
    }

}
