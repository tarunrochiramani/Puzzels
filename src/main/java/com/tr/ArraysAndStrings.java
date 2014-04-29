package com.tr;

import org.apache.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArraysAndStrings {

    private static Logger logger = Logger.getLogger(ArraysAndStrings.class);

    public boolean uniqueChars(String str) {
        if (str == null || str.length() == 0) {
            return false; // or throw exception
        }

        int checker = 0;
        for (char c : str.toCharArray()) {
            int rightShiftedValue = 1 << c;
            if ((checker & rightShiftedValue) > 0) {
                return false;
            }
            checker |= rightShiftedValue;

            System.out.println("Right shifted value: " + rightShiftedValue);
            System.out.println("Checker " + checker);

        }

        return true;
    }


    public String reverse(String str) throws Exception {
        if (str == null || str.isEmpty()) {
            throw new Exception("Empty String");
        }

        char[] chars = str.toCharArray();
        for (int start=0, end=chars.length-1; start < end; start++, end--) {
            if (chars[start] != chars[end]){
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
            }
        }

        return new String(chars);
    }

    /**
     * Consider whitespace as a character
     * Consider case insensitive
     * @return
     */
    public boolean checkAnagram(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        if (str1.length() != str2.length()) {
            return false;
        }

        if (str1.isEmpty() || str2.isEmpty()) {
            return false;
        }

        try {
            if (bitManupilation(str1.toLowerCase()) == bitManupilation(str2.toUpperCase())) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private int bitManupilation(String str) throws Exception {
        if (str.isEmpty()) {
            throw new Exception("Empty String");
        }

        int result = 0;
        for (char c : str.toCharArray()) {
            result |= (1 << c);
        }

        logger.info("String: " + str + " Binary representation: " + Integer.toBinaryString(result));

        return result;
    }

    /**
     * assume the last char would be a non-whitespace
     * assume char array has space at the end for replacements i.e space to %20
     * @param characters
     */
    public void insert20AtWhiteSpace(char[] characters) {

        int nonSpaceCharacterIndex = 0;
        int spacesFound = 0;
        for (int count = 0; count < characters.length; count++) {
            if (characters[count] != ' ') {
                nonSpaceCharacterIndex = count;
            } else {
                spacesFound++;
            }
        }

        if (spacesFound == 0) {
            return;
        }

        int totalSize = characters.length -1;
        while (true) {
            if (totalSize == nonSpaceCharacterIndex) break;

            if (characters[nonSpaceCharacterIndex] != ' ') {
                characters[totalSize--] = characters[nonSpaceCharacterIndex];
            } else {
                characters[totalSize--] = '0';
                characters[totalSize--] = '2';
                characters[totalSize--] = '%';
            }

            nonSpaceCharacterIndex --;
        }
    }


    public String compressString(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();

        int count = 0;
        char lastChar = '\0';
        for (char c : input.toCharArray()) {
            if (c != lastChar) {
                if (count > 1) {
                    stringBuilder.append(count);
                }
                count = 1;
                stringBuilder.append(c);
            } else {
                count ++;
            }

            lastChar = c;
        }

        if (count > 1) {
            stringBuilder.append(count);
        }

        return stringBuilder.toString();
    }

    public int isSubstring(String text, String pattern) {
        if (text == null || pattern == null) {
            return -1;
        }

        if (text.isEmpty() || pattern.isEmpty()) {
            return -1;
        }

        char[] textArray = text.toCharArray();
        char[] patternArray = pattern.toCharArray();

        for (int count = 0; count < textArray.length; count++) {
            if (textArray[count] == patternArray[0]) {
                int textCount = count;
                int patternCount;
                for (patternCount = 1; patternCount < patternArray.length; patternCount++) {
                    textCount++;
                    if (textArray[textCount] != patternArray[patternCount]) {
                        break;
                    }

                }

                if (patternCount == patternArray.length) {
                    return count;
                }
            }
        }

        return -1;
    }

    public boolean checkSubstringAndAnagram(String text, String pattern) {
        if (text == null || pattern == null) {
            return false;
        }

        if (text.isEmpty() || pattern.isEmpty()) {
            return false;
        }

        if (text.length() < pattern.length()) {
            return false;
        }

        char[] patternArray = pattern.toCharArray();

        for (int count = 0, runner = count + patternArray.length; runner <= text.length(); count++, runner++) {
            String subStr = text.substring(count, runner);
            if (checkAnagram(subStr, pattern)) {
                return true;
            }
        }

        return false;
    }


    public boolean charCheckRegex(char input, String regex) {
        if (regex == null || regex.isEmpty()) {
            return false;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Character.toString(input));

        return matcher.matches();
    }

    public String reverseStringWithNumbersInPlace(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        char[] chars = input.toCharArray();
        int start = 0;
        int end = input.length()-1;
        while (start < end) {
            if (charCheckRegex(chars[start], "[0-9]")) {
                start++;
                continue;
            }

            if (charCheckRegex(chars[end], "[0-9]")) {
                end--;
                continue;
            }

            char tempChar = chars[start];
            chars[start] = chars[end];
            chars[end] = tempChar;

            start++;
            end--;
        }

        return new String(chars);
    }

    public String processString(String url, String replaceValue) {
        String regex = "\\{(.)*\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);

        int lastEnd = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            int start = matcher.start();
            stringBuilder.append(url.substring(lastEnd, start));
            stringBuilder.append(replaceValue);
            lastEnd = matcher.end();
        }
        stringBuilder.append(url.substring(lastEnd));
        return stringBuilder.toString();
    }
}
