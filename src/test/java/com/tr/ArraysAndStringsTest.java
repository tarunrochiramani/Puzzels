package com.tr;

import com.tr.ArraysAndStrings;
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

        result = arraysAndStrings.checkAnagram("blah", "b");
        assertFalse(result);

        result = arraysAndStrings.checkAnagram("blah", "blah      ");
        assertFalse(result);

        result = arraysAndStrings.checkAnagram("", "");
        assertFalse(result);

        result = arraysAndStrings.checkAnagram("blah", "hlba");
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
}
