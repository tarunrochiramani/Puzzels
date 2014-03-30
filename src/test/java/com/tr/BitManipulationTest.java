package com.tr;

import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BitManipulationTest {
    private static final Logger logger = Logger.getLogger(BitManipulationTest.class.getName());

    private BitManipulation bitManipulation = new BitManipulation();

    @Test public void printBinaryStr() {
        logger.info("1 << 4 -> " + Integer.toBinaryString(1 << 4));
        logger.info("4 << 1 -> " + Integer.toBinaryString(4 << 1));
        logger.info("1 >> 4 -> " + Integer.toBinaryString(1 >> 4));
        logger.info("4 >> 1 -> " + Integer.toBinaryString(4 >> 1));
    }

    @Test
    public void testBinaryRepresentation() {
        String binaryStr = bitManipulation.getBinaryRepresentation(4);
        assertNotNull(binaryStr);
        logger.info(binaryStr);
    }

    @Test
    public void testGetBit() {
        int n = 4;
        int bit = bitManipulation.getBit(n, 0);
        assertEquals(0, bit);

        bit = bitManipulation.getBit(n, 1);
        assertEquals(0, bit);

        bit = bitManipulation.getBit(n, 2);
        assertEquals(1, bit);

        bit = bitManipulation.getBit(n, 3);
        assertEquals(0, bit);
    }

    @Test
    public void testSetBit() {
        int n = 4;
        int bit = bitManipulation.setBit(n, 0);
        assertEquals(n + 1, bit);

        bit = bitManipulation.setBit(n, 1);
        assertEquals(n + 2, bit);
    }

    @Test
    public void testClearBit() {
        int number = 7;

        int result = bitManipulation.clearBit(number, 0);
        assertEquals(number-1, result);

        result = bitManipulation.clearBit(number, 1);
        assertEquals(number-2, result);
    }

    @Test
    public void testSetBitsInNumberAtPos() {
        int result = bitManipulation.setBitsInNumberAtPos(4, 1, 0, 1);
        assertEquals(-1, result);

        result = bitManipulation.setBitsInNumberAtPos(4, 4, 2, 1);
        assertEquals(-1, result);

        result = bitManipulation.setBitsInNumberAtPos(4, 1, 1, 0);
        assertEquals(5, result);

        result = bitManipulation.setBitsInNumberAtPos(9, 3, 2, 1);
        assertEquals(15, result);

        result = bitManipulation.setBitsInNumberAtPos(11, 3, 2, 1);
        assertEquals(15, result);

    }




}
