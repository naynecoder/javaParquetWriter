package net.nayne.parquet.csv_reader;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomStringSplitterTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomStringSplitterTest.class);
    private final String TEST_STRING = "253816,FL,CLAY COUNTY,831498.3,831498.3,831498.3,831498.3,831498.3,1117791.48,0,0,0,0,30.10216,-81.719444,Residential,Masonry,1,253816,FL,CLAY COUNTY,831498.3,831498.3,831498.3,831498.3,831498.3,1117791.48,0,0,0,0,30.10216,-81.719444,Residential,Masonry,1,253816,FL,CLAY COUNTY,831498.3,831498.3,831498.3,831498.3,831498.3,1117791.48,0,0,0,0,30.10216,-81.719444,Residential,Masonry,1,253816,FL,CLAY COUNTY,831498.3,831498.3,831498.3,831498.3,831498.3,1117791.48,0,0,0,0,30.10216,-81.719444,Residential,Masonry,1";
    private final char SEPARATOR = ',';

    @Test
    public void split() {
        int size = TEST_STRING.split(",").length;
        String[] result = CustomStringSplitter.split(TEST_STRING, SEPARATOR, size);
        assertTrue(result[0].equals("253816"));
        assertTrue(result[1].equals("FL"));
        assertTrue(result[size - 1].equals("1"));
    }

    @Test
    public void performanceTest() {
        //Compare split in Java 15 vs customized split
        //No big difference, tried with Java 11 and 15
        int loops = 10000;
        long resultSplit = 0;
        int size = TEST_STRING.split(",").length;
        long resultCustom = 0;
        long start = System.currentTimeMillis();
        for (int k = 0; k < loops; k++) {
            CustomStringSplitter.split(TEST_STRING, SEPARATOR, size);
        }
        resultCustom = System.currentTimeMillis() - start;
        start = System.currentTimeMillis();
        for (int k = 0; k < loops; k++) {
            TEST_STRING.split(",");
        }
        resultSplit = System.currentTimeMillis() - start;
        LOGGER.info("String split average time: " + resultSplit + " ms");
        LOGGER.info("Custom average time: " + resultCustom + " ms");
    }
}
