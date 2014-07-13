package com.tr;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

    @Test
    public void testGetPermutationsForNullAndEmptyString() {
        List<String> result = recursive.getPermutations(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());

        result = recursive.getPermutations("");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGetPermutations() throws Exception {
        String input = "a";

        List<String> permutations = recursive.getPermutations(input);
        assertNotNull(permutations);
        assertFalse(permutations.isEmpty());
        assertEquals(1, permutations.size());
        assertEquals(input, permutations.get(0));

        input = "ab";
        permutations = recursive.getPermutations(input);
        assertNotNull(permutations);
        assertFalse(permutations.isEmpty());
        assertEquals(2, permutations.size());
        assertEquals("ab", permutations.get(0));
        assertEquals("ba", permutations.get(1));

        input = "abc";
        permutations = recursive.getPermutations(input);
        assertNotNull(permutations);
        assertFalse(permutations.isEmpty());
        assertEquals(6, permutations.size());
        assertEquals("abc", permutations.get(0));
        assertEquals("bac", permutations.get(1));
        assertEquals("bca", permutations.get(2));
        assertEquals("acb", permutations.get(3));
        assertEquals("cab", permutations.get(4));
        assertEquals("cba", permutations.get(5));
    }

    @Test
    public void testGenerateParenthesesForZeroOrNegative() {
        Set<Parentheses> results = recursive.generateParentheses(-1);
        assertNotNull(results);
        assertTrue(results.isEmpty());

        results = recursive.generateParentheses(0);
        assertNotNull(results);
        assertTrue(results.isEmpty());
    }

    @Test
    public void testGenerateParenthesesForValidValues() {
        Set<Parentheses> results = recursive.generateParentheses(1);
        assertNotNull(results);
        assertFalse(results.isEmpty());
        assertEquals(1, results.size());
        assertTrue(validateResults(results, "()"));

        results = recursive.generateParentheses(2);
        assertNotNull(results);
        assertFalse(results.isEmpty());
        assertEquals(2, results.size());
        assertTrue(validateResults(results, "()()", "(())"));



        results = recursive.generateParentheses(3);
        assertNotNull(results);
        assertFalse(results.isEmpty());
        assertEquals(5, results.size());
        assertTrue(validateResults(results, "()()()", "()(())", "(()())", "(())()", "((()))"));
    }

    @Test
    public void canGetSubsets() {
        List<String> results = recursive.getSubsets("abc");

        assertNotNull(results);
        assertEquals(8, results.size());
        assertTrue(results.contains("{}"));
        assertTrue(results.contains("{a}"));
        assertTrue(results.contains("{b}"));
        assertTrue(results.contains("{c}"));
        assertTrue(results.contains("{a, b}"));
        assertTrue(results.contains("{b, c}"));
        assertTrue(results.contains("{a, b}"));
        assertTrue(results.contains("{a, b, c}"));
    }

    @Test
    public void canGetSubsetsWhenInputIsEmpty() {
        List<String> results = recursive.getSubsets("");

        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals("{}", results.get(0));
    }

    @Test
    public void canGetSubsetsWhenInputIsNull() {
        List<String> results = recursive.getSubsets(null);

        assertNotNull(results);
        assertTrue(results.isEmpty());
    }

    private boolean validateResults(Set<Parentheses> results, String... expectedValues) {
        if (expectedValues == null) {
            return false;
        }

        Set<String> valuesToCheck = new HashSet<String>();
        for (String value : expectedValues) {
            valuesToCheck.add(value);
        }

        Iterator<Parentheses> iterator = results.iterator();
        while (iterator.hasNext()) {
            String result = iterator.next().toString();
            if (valuesToCheck.contains(result)) {
                valuesToCheck.remove(result);
            } else {
                return false;
            }
        }

        if (!valuesToCheck.isEmpty()) {
            return false;
        }

        return true;
    }


}
