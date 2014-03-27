package com.tr;

import org.apache.log4j.Logger;

public class Bitwise {
    private static final Logger logger = Logger.getLogger(Bitwise.class.getName());

    public String getBinaryRepresentation(int number) {
        return Integer.toBinaryString(number);
    }

    public int getBit(int number, int bitPosition) {
        logger.info("1 << " + bitPosition + " : " + Integer.toBinaryString(1 << bitPosition));
        logger.info(Integer.toBinaryString(number) + " & " + Integer.toBinaryString(1 << bitPosition));
        if ((number & (1 << bitPosition)) == 0) {
            return 0;
        }
        return 1;
    }

    public int setBit(int number, int bitPosition) {
        return (number |= (1 << bitPosition));
    }

    public int clearBit(int number, int bitPosition) {
        int mask = ~(1 << bitPosition);

        return (number &= mask);
    }
}
