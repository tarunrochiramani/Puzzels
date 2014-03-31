package com.tr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

class Parentheses {
    public enum Braces {OPEN, CLOSE};

    private List<Braces> braces = new ArrayList<>();

    public Parentheses() {}
    public Parentheses(Parentheses parentheses) {
        braces.addAll(parentheses.getBraces());
    }

    public boolean equals(Object object) {
        if (object == null || !(object instanceof Parentheses)) {
            return false;
        }

        Parentheses comparable = (Parentheses)object;
        if (comparable.getBraces().size() != this.getBraces().size()) {
            return false;
        }

        for (int count = 0; count<getBraces().size(); count++) {
            if (!getBraces().get(count).equals(comparable.getBraces().get(count))) {
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        int counter = 0;
        for (int count = 0; count<getBraces().size(); count++) {
            if (getBraces().get(count).equals(Braces.OPEN)) {
                counter ++;
            } else {
                counter --;
            }
        }

        return counter;
    }

    public List<Braces> getBraces() {
        return braces;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Braces braces : this.braces) {
            switch (braces) {
                case OPEN: stringBuilder.append("(");
                    break;
                case CLOSE: stringBuilder.append(")");
                    break;
            }
        }

        return stringBuilder.toString();
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
            List<Point> pointList = new ArrayList<>();
            pointList.addAll(result);
            pointList.add(point);
            pointMoves.add(pointList);
        }
    }

    public List<String> getPermutations(String input) {
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }

        // If there is one character, remaining string will be "", so will not get in IndexOutOfBoundException
        char currentChar = input.charAt(0);
        String remainingString = input.substring(1);

        List<String> remainingStringPermutations = getPermutations(remainingString);
        List<String> results = insertCharToEveryPosition(Character.toString(currentChar), remainingStringPermutations);

        return results;
    }

    private List<String> insertCharToEveryPosition(String currentChar, List<String> permutations) {
        List<String> results = new ArrayList<String>();

        if (permutations.isEmpty()) {
            results.add(currentChar);
            return results;
        }

        for (String permutation : permutations) {
            results.add(currentChar + permutation);

            if (!permutation.isEmpty()) {
                for (int count=1; count<=permutation.length(); count++) {
                    String prefix = permutation.substring(0, count); //end position is excluded from result
                    String postfix = permutation.substring(count);

                    results.add(prefix + currentChar + postfix);
                }
            }
        }

        return results;
    }

    public Set<Parentheses> generateParentheses(int count) {
        Map<Integer, Set<Parentheses>> map = new HashMap<Integer, Set<Parentheses>>();
        generateParenthesesDP(count, map);

        return map.get(count);
    }

    private void generateParenthesesDP(Integer count, Map<Integer, Set<Parentheses>> parenthesesMap) {
        if (parenthesesMap == null || parenthesesMap.containsKey(count)) {
            return;
        }

        Set<Parentheses> parenthesesSet;
        if (count > 0) {
            generateParenthesesDP(count - 1, parenthesesMap);
            Set<Parentheses> previousCountParentheses = parenthesesMap.get(count - 1);

            //insert () into the previous count's combinations
            parenthesesSet = insertParentheses(previousCountParentheses);
        } else {
            parenthesesSet = new HashSet<Parentheses>();
        }
        parenthesesMap.put(count, parenthesesSet);
    }

    private Set<Parentheses> insertParentheses(Set<Parentheses> previousCountParentheses) {
        Set<Parentheses> retVal = new HashSet<Parentheses>();
        if (previousCountParentheses == null || previousCountParentheses.isEmpty()) {
            Parentheses current = new Parentheses();
            current.getBraces().add(Parentheses.Braces.OPEN);
            current.getBraces().add(Parentheses.Braces.CLOSE);
            retVal.add(current);
            return retVal;
        }

        for (Parentheses previousParentheses : previousCountParentheses) {
            Parentheses current = new Parentheses(previousParentheses);
            current.getBraces().add(Parentheses.Braces.OPEN);
            current.getBraces().add(Parentheses.Braces.CLOSE);
            retVal.add(new Parentheses(current));

            for (int count = current.getBraces().size() -1; count >0; count --) {
                if (current.getBraces().get(count) == Parentheses.Braces.OPEN && current.getBraces().get(count-1) == Parentheses.Braces.CLOSE) {
                    current.getBraces().set(count, Parentheses.Braces.CLOSE);
                    current.getBraces().set(count-1, Parentheses.Braces.OPEN);

                    retVal.add(new Parentheses(current));
                }
            }
        }

        return retVal;
    }
}
