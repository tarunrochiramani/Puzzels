import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Point {
    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

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

    public int countWaysDP(int n, int[] map) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (map[n] > -1) {
            return map[n];
        }

        map[n] = countWaysDP(n-1, map) + countWaysDP(n-2, map) + countWaysDP(n-3, map);

        return map[n];
    }

    public int robotMove(int[][] matrix, int x, int y) {
        if (matrix == null || matrix.length < x) {
            return 0;
        }

        if (x == 0 || y == 0) {
            return 1;
        }

        if (matrix[x][y] > 0) {
            return matrix[x][y];
        }

        matrix[x][y] = robotMove(matrix, x-1, y) + robotMove(matrix, x, y-1);

        return matrix[x][y];
    }

    public List<List<Point>> getRobotMove(int size) {
        if (size <= 0 ) {
            return null;
        }

        Map<Point, List<List<Point>>> pointListMap = new HashMap<Point, List<List<Point>>>();

        return getRobotMove(pointListMap, size-1, size-1);
    }

    private List<List<Point>> getRobotMove(Map<Point, List<List<Point>>> pointListMap, int x, int y) {
        if (pointListMap == null) {
            return null;
        }

        if (x < 0 || y < 0) {
            return new ArrayList<List<Point>>();
        }

        Point point = new Point(x, y);
        if (pointListMap.containsKey(point)) {
            return pointListMap.get(point);
        }

        if (x == 0 && y == 0) {
            List<List<Point>> pointList = new ArrayList<List<Point>>();
            pointList.add(new ArrayList<Point>());
            pointList.get(0).add(point);

            pointListMap.put(point, pointList);
            return pointList;
        }

        List<List<Point>> downResults = getRobotMove(pointListMap, x - 1, y);
        List<List<Point>> rightResults = getRobotMove(pointListMap, x, y - 1);

        List<List<Point>> pointMoves = new ArrayList<List<Point>>();
        addResults(point, downResults, pointMoves);
        addResults(point, rightResults, pointMoves);
        pointListMap.put(point, pointMoves);

        return pointMoves;
    }

    private void addResults(Point point, List<List<Point>> previousStepResults, List<List<Point>> pointMoves) {
        for (List<Point> result : previousStepResults) {
            List<Point> pointList = new ArrayList<Point>();
            pointList.addAll(result);
            pointList.add(point);
            pointMoves.add(pointList);
        }
    }
}
