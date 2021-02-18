package net.nayne.parquet.csv_reader;

public class CustomStringSplitter {

    /*
    Customized splitter working only on one char to split. Overall the performance is not much better compared to split
    Based on this Stackoverflow thread:
    https://softwareengineering.stackexchange.com/questions/221997/quickest-way-to-split-a-delimited-string-in-java
     */
    public static String[] split(String originalString, char separator, int size) {
        String[] result = new String[size];
        int position = 0;

        int pointer = 0;
        int delimiterPosition = originalString.indexOf(separator, position);
        while (delimiterPosition >= 0) {
            result[position++] = originalString.substring(pointer, delimiterPosition);
            pointer = delimiterPosition + 1;
            delimiterPosition = originalString.indexOf(separator, pointer);
        }
        result[position++] = originalString.substring(pointer);

        return result;
    }

}
