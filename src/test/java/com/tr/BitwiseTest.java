package com.tr;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BitwiseTest {
    private static final Logger logger = Logger.getLogger(BitwiseTest.class.getName());

    private Bitwise bitwise = new Bitwise();

    @Test public void printBinaryStr() {
        logger.info("1 << 4 -> " + Integer.toBinaryString(1 << 4));
        logger.info("4 << 1 -> " + Integer.toBinaryString(4 << 1));
        logger.info("1 >> 4 -> " + Integer.toBinaryString(1 >> 4));
        logger.info("4 >> 1 -> " + Integer.toBinaryString(4 >> 1));
    }

    @Test
    public void testBinaryRepresentation() {
        String binaryStr = bitwise.getBinaryRepresentation(4);
        assertNotNull(binaryStr);
        logger.info(binaryStr);
    }

    @Test
    public void testGetBit() {
        int n = 4;
        int bit = bitwise.getBit(n, 0);
        assertEquals(0, bit);

        bit = bitwise.getBit(n, 1);
        assertEquals(0, bit);

        bit = bitwise.getBit(n, 2);
        assertEquals(1, bit);

        bit = bitwise.getBit(n, 3);
        assertEquals(0, bit);
    }

    @Test
    public void testSetBit() {
        int n = 4;
        int bit = bitwise.setBit(n, 0);
        assertEquals(n + 1, bit);

        bit = bitwise.setBit(n, 1);
        assertEquals(n + 2, bit);
    }

    @Test
    public void testClearBit() {
        int number = 7;

        int result = bitwise.clearBit(number, 0);
        assertEquals(number-1, result);

        result = bitwise.clearBit(number, 1);
        assertEquals(number-2, result);
    }




}
