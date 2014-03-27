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

    public int setBitsInNumberAtPos(int source, int destination, int msbPosition, int lsbPosition) {
        if (source == destination) {
            return -1;
        }

        if (msbPosition <= lsbPosition) {
            return -1;
        }

        // clear the bits between start and end in source
        int allOnes = ~(0);
        int msbMask = allOnes << msbPosition;
        logger.info("msb mask : " + Integer.toBinaryString(msbMask));

        int lsbMask = (1 << lsbPosition) - 1;
        logger.info("lsb mask : " + Integer.toBinaryString(lsbMask));

        int mask = msbMask | lsbMask;
        logger.info("mask : " + Integer.toBinaryString(mask));

        int result = source & mask;
        logger.info("Source: " + Integer.toBinaryString(source));
        logger.info("Clear bits of source: " + Integer.toBinaryString(result));

        // Shift destination to fit in between msb and lsb
        int shiftedDestination = destination << lsbPosition;
        logger.info("Desitation: " + Integer.toBinaryString(destination));
        logger.info("Shifted destination: " + Integer.toBinaryString(shiftedDestination));

        return (result |= shiftedDestination);
    }
}
