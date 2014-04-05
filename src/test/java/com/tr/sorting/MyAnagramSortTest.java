package com.tr.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MyAnagramSortTest {

    @Test
    public void testSort() {
        List<String> stringList = Arrays.asList("abc", "rst", "rtt", "trs");

        Collections.sort(stringList, new MyAnagramSort());
        assertEquals(stringList.indexOf("rst") + 1, stringList.indexOf("trs"));
    }
}
