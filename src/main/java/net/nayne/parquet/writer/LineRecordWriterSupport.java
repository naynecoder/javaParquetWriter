package net.nayne.parquet.writer;

import java.util.HashMap;
import java.util.Map;
import net.nayne.parquet.model.LineRecord;
import org.apache.hadoop.conf.Configuration;
import org.apache.parquet.hadoop.api.WriteSupport;
import org.apache.parquet.io.api.RecordConsumer;
import org.apache.parquet.schema.MessageType;

public class LineRecordWriterSupport<T> extends WriteSupport<T> {

    RecordConsumer recordConsumer;
    MessageType schema;
    String[] fields;

    public LineRecordWriterSupport() {
        this.schema = RecordMessage.getSchema();
        this.fields = Headers.HEADERS;
    }

    @Override
    public WriteContext init(Configuration configuration) {
        Map<String, String> extraMetaData = new HashMap<>();
        return new WriteContext(schema, extraMetaData);
    }

    @Override
    public void prepareForWrite(RecordConsumer recordConsumer) {
        this.recordConsumer = recordConsumer;
    }

    @Override
    public void write(T record) {
        int index = 0;
        LineRecord lineRecord = (LineRecord) record;
        recordConsumer.startMessage();
        ParquetUtils.writeInt(recordConsumer, index, fields[index++], lineRecord.getPolicyID());
        ParquetUtils.writeString(recordConsumer, index, fields[index++], lineRecord.getStatecode());
        ParquetUtils.writeString(recordConsumer, index, fields[index++], lineRecord.getCounty());
        ParquetUtils.writeFloat(recordConsumer, index, fields[index++], lineRecord.getEqSiteLimit());
        ParquetUtils.writeFloat(recordConsumer, index, fields[index++], lineRecord.getHuSiteLimit());
        ParquetUtils.writeFloat(recordConsumer, index, fields[index++], lineRecord.getFlSiteLimit());
        ParquetUtils.writeFloat(recordConsumer, index, fields[index++], lineRecord.getFrSiteLimit());
        ParquetUtils.writeFloat(recordConsumer, index, fields[index++], lineRecord.getTiv2011());
        ParquetUtils.writeFloat(recordConsumer, index, fields[index++], lineRecord.getTiv2012());
        ParquetUtils.writeFloat(recordConsumer, index, fields[index++], lineRecord.getEqSiteDeductible());
        ParquetUtils.writeFloat(recordConsumer, index, fields[index++], lineRecord.getHuSiteDeductible());
        ParquetUtils.writeFloat(recordConsumer, index, fields[index++], lineRecord.getFlSiteDeductible());
        ParquetUtils.writeFloat(recordConsumer, index, fields[index++], lineRecord.getFrSiteDeductible());
        ParquetUtils.writeFloat(recordConsumer, index, fields[index++], lineRecord.getPointLatitude());
        ParquetUtils.writeFloat(recordConsumer, index, fields[index++], lineRecord.getPointLongitude());
        ParquetUtils.writeString(recordConsumer, index, fields[index++], lineRecord.getLine());
        ParquetUtils.writeString(recordConsumer, index, fields[index++], lineRecord.getConstruction());
        ParquetUtils.writeInt(recordConsumer, index, fields[index++], lineRecord.getPointGranularity());
        recordConsumer.endMessage();

    }

}
