package com.tr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ArraysAndStringsTest {

    ArraysAndStrings arraysAndStrings = new ArraysAndStrings();

    @Test
    public void testUniqueCharsWithEmptyAndNullString() {
        boolean nullValueResult = arraysAndStrings.uniqueChars(null);
        boolean emptyStringResult = arraysAndStrings.uniqueChars("");

        assertFalse(nullValueResult);
        assertFalse(emptyStringResult);
    }

    @Test
    public void testUniqueCharsWithSingleCharString() {
        boolean result = arraysAndStrings.uniqueChars("a");

        assertTrue(result);
    }

    @Test
    public void testUniqueCharsWithUniqueCharString() {
        String testStr = "abcdefghijklmnopqrstuvwxyz";
        boolean lowerCaseResult = arraysAndStrings.uniqueChars(testStr.toLowerCase());
        boolean upperCaseResult = arraysAndStrings.uniqueChars(testStr.toUpperCase());

        assertTrue(lowerCaseResult);
        assertTrue(upperCaseResult);
    }

    @Test
    public void testUniqueCharsWithNonUniqueCharString() {
        String testStr = "abcadef";
        boolean lowerCaseResult = arraysAndStrings.uniqueChars(testStr.toLowerCase());
        boolean upperCaseResult = arraysAndStrings.uniqueChars(testStr.toUpperCase());
        boolean mixedCaseResult = arraysAndStrings.uniqueChars("abcABCaB");

        assertFalse(lowerCaseResult);
        assertFalse(upperCaseResult);
        assertFalse(mixedCaseResult);
    }

    @Test (expected = Exception.class)
    public void testReverseWithNull() throws Exception {
        arraysAndStrings.reverse(null);
    }

    @Test (expected = Exception.class)
    public void testReverseWithEmpty() throws Exception {
        arraysAndStrings.reverse("");
    }

    @Test
    public void canReverseValidString() throws Exception {
        String input = "abcABC";

        String reversed = arraysAndStrings.reverse(input);
        assertNotNull(reversed);
        assertEquals(input, arraysAndStrings.reverse(reversed));
    }

    @Test
    public void testTwoStringAreAnagramsWithOneNull() {
        boolean result = arraysAndStrings.checkAnagram(null, "blah");
        assertFalse(result);

        result = arraysAndStrings.checkAnagram("blah", null);
        assertFalse(result);

        result = arraysAndStrings.checkAnagram(null, null);
        assertFalse(result);
    }

    @Test
    public void testAnagramsForFalseCases() {
        boolean result = arraysAndStrings.checkAnagram("blah", "b");
        assertFalse(result);

        result = arraysAndStrings.checkAnagram("blah", "blah      ");
        assertFalse(result);

        result = arraysAndStrings.checkAnagram("", "");
        assertFalse(result);

        result = arraysAndStrings.checkAnagram("abcd", "efgh");
        assertFalse(result);
    }

    @Test
    public void testAnagramsForTrueCases() {
        boolean result = arraysAndStrings.checkAnagram("blah", "hlba");
        assertTrue(result);

        result = arraysAndStrings.checkAnagram("blah", "hlbA");
        assertTrue(result);
    }

    @Test
    public void canInsert20() {
        String expectedStr = "%20a%20b";
        String actualStr   = " a b    ";

        char[] characters = actualStr.toCharArray();
        assertEquals(actualStr.length(), characters.length);

        arraysAndStrings.insert20AtWhiteSpace(characters);
        assertEquals(expectedStr, new String(characters));
    }
    @Test
    public void canInsert20WithNoChar() {
        String expectedStr = "%20";
        String actualStr   = "   ";

        char[] characters = actualStr.toCharArray();
        assertEquals(actualStr.length(), characters.length);

        arraysAndStrings.insert20AtWhiteSpace(characters);
        assertEquals(expectedStr, new String(characters));
    }


    @Test
    public void canInsert20WithValid() {
        String expectedStr = "c";
        String actualStr   = "c";

        char[] characters = actualStr.toCharArray();
        assertEquals(actualStr.length(), characters.length);

        arraysAndStrings.insert20AtWhiteSpace(characters);
        assertEquals(expectedStr, new String(characters));
    }

    @Test
    public void testCompressForNullAndEmptyString() {
        assertNull(arraysAndStrings.compressString(null));
        assertNull(arraysAndStrings.compressString(""));
    }

    @Test
    public void testCompressForSingleCharString() {
        String input = "a";
        assertEquals(input, arraysAndStrings.compressString(input));
    }

    @Test
    public void testCompressForNonRepeatingCharString() {
        String input = "abcdefgh";
        assertEquals(input, arraysAndStrings.compressString(input));
    }

    @Test
    public void testCompressForRepeatingCharString() {
        String input = "aabccddddeff";
        assertEquals("a2bc2d4ef2", arraysAndStrings.compressString(input));
    }

    @Test
    public void testIsSubstringForInvalidValues() {
        assertEquals(-1, arraysAndStrings.isSubstring(null, null));
        assertEquals(-1, arraysAndStrings.isSubstring(null, "abc"));
        assertEquals(-1, arraysAndStrings.isSubstring("abc", null));
        assertEquals(-1, arraysAndStrings.isSubstring("", ""));
        assertEquals(-1, arraysAndStrings.isSubstring("", "abc"));
        assertEquals(-1, arraysAndStrings.isSubstring("abc", ""));
        assertEquals(-1, arraysAndStrings.isSubstring("efg", "abc"));
    }

    @Test
    public void testIsSubstringForValidValues() {
        int position = arraysAndStrings.isSubstring("abcdefghi", "cde");
        assertEquals(2, position);


        position = arraysAndStrings.isSubstring("abccdefghi", "cde");
        assertEquals(3, position);
    }

    @Test
    public void testSubstringAndAnagramForInvalidValues() {
        assertFalse(arraysAndStrings.checkSubstringAndAnagram(null, null));
        assertFalse(arraysAndStrings.checkSubstringAndAnagram(null, "abc"));
        assertFalse(arraysAndStrings.checkSubstringAndAnagram("abc", null));
        assertFalse(arraysAndStrings.checkSubstringAndAnagram("", ""));
        assertFalse(arraysAndStrings.checkSubstringAndAnagram("abc", ""));
        assertFalse(arraysAndStrings.checkSubstringAndAnagram("", "abc"));
        assertFalse(arraysAndStrings.checkSubstringAndAnagram("de", "abc"));
        assertFalse(arraysAndStrings.checkSubstringAndAnagram("defghijks", "abc"));
    }

    @Test
    public void testSubstringAndAnagramForValidValues() {
        assertTrue(arraysAndStrings.checkSubstringAndAnagram("abcdefijklm", "def"));
        assertTrue(arraysAndStrings.checkSubstringAndAnagram("abcdefijklm", "edf"));
        assertTrue(arraysAndStrings.checkSubstringAndAnagram("abcdefijklm", "efd"));
        assertTrue(arraysAndStrings.checkSubstringAndAnagram("abcdefijklm", "fde"));
    }

    @Test
    public void testCharCheckRegex() {
        String input = "ab d";
        int spacesFound = 0;
        for (char c : input.toCharArray()) {
            System.out.println("Char: " + c);
            if (arraysAndStrings.charCheckRegex(c, "\\s")) {
                spacesFound++;
            }
        }

        assertTrue(spacesFound > 0);
        assertEquals(1, spacesFound);
    }

    @Test
    public void testReverseStringWithNumbersInPlaceForInvalidInputs() {
        String input = null;
        assertNull(arraysAndStrings.reverseStringWithNumbersInPlace(input));

        input = "";
        assertEquals(input, arraysAndStrings.reverseStringWithNumbersInPlace(input));

        input = "abc";
        assertEquals("cba", arraysAndStrings.reverseStringWithNumbersInPlace(input));
    }

    @Test
    public void testReverseStringWithNumbersInPlace() {
        String input = "ab2cde3f";
        String expectedOutput = "fe2dcb3a";

        assertEquals(expectedOutput, arraysAndStrings.reverseStringWithNumbersInPlace(input));
    }

    @Test
    public void testCanProcessString() {
        String input = "abc/{def}";

        assertEquals("abc/abc", arraysAndStrings.processString(input, "abc"));

        input = "abc";
        assertEquals(input, arraysAndStrings.processString(input, "def"));

        input = "abc/{def}/{ghi}/def";
        assertEquals("abc/abc/abc/def", arraysAndStrings.processString(input, "abc"));
    }
}
