package net.nayne.parquet.writer;

import org.apache.commons.lang3.StringUtils;
import org.apache.parquet.io.api.Binary;
import org.apache.parquet.io.api.RecordConsumer;

public class ParquetUtils {

    public static final int EPOCH_DAYS = 13879; //days from 1st Jan 1970 until 1st Jan 2008

    public static void writeInt(RecordConsumer recordConsumer, int index, String fieldName, int value) {
        recordConsumer.startField(fieldName, index);
        recordConsumer.addInteger(value);
        recordConsumer.endField(fieldName, index);
    }

    public static void writeShort(RecordConsumer recordConsumer, int index, String fieldName, Short value) {
        if (value != null) {
            recordConsumer.startField(fieldName, index);
            recordConsumer.addInteger(value.intValue());
            recordConsumer.endField(fieldName, index);
        }
    }

    public static void writeLong(RecordConsumer recordConsumer, int index, String fieldName, long value) {
        recordConsumer.startField(fieldName, index);
        recordConsumer.addLong(value);
        recordConsumer.endField(fieldName, index);
    }

    public static void writeFloat(RecordConsumer recordConsumer, int index, String fieldName, float value) {
        recordConsumer.startField(fieldName, index);
        recordConsumer.addFloat(value);
        recordConsumer.endField(fieldName, index);
    }

    public static void writeDouble(RecordConsumer recordConsumer, int index, String fieldName, double value) {
        recordConsumer.startField(fieldName, index);
        recordConsumer.addDouble(value);
        recordConsumer.endField(fieldName, index);
    }

    public static void writeDouble(RecordConsumer recordConsumer, int index, String fieldName, Double value) {
        if (value != null) {
            recordConsumer.startField(fieldName, index);
            recordConsumer.addDouble(value);
            recordConsumer.endField(fieldName, index);
        }
    }

    public static void writeString(RecordConsumer recordConsumer, int index, String fieldName, String value) {
        if (value != null) {
            recordConsumer.startField(fieldName, index);
            recordConsumer.addBinary(fromString(value));
            recordConsumer.endField(fieldName, index);
        }
    }

    public static void writeStringNullifyEmpty(RecordConsumer recordConsumer, int index, String fieldName, String value) {
        if (value != null && !value.isEmpty()) {
            recordConsumer.startField(fieldName, index);
            recordConsumer.addBinary(fromString(value));
            recordConsumer.endField(fieldName, index);
        }
    }

    public static void writeStringToZeroEmpty(RecordConsumer recordConsumer, int index, String fieldName, String value) {
        String zeroedValue = StringUtils.isBlank(value) ? "0" : value;
        recordConsumer.startField(fieldName, index);
        recordConsumer.addBinary(fromString(zeroedValue));
        recordConsumer.endField(fieldName, index);
    }

    private static Binary fromString(String value) {
        return Binary.fromCharSequence(value);
    }

}
