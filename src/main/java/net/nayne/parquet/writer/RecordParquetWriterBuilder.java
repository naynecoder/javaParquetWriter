package net.nayne.parquet.writer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.ParquetWriter.Builder;
import org.apache.parquet.hadoop.api.WriteSupport;

public class RecordParquetWriterBuilder extends ParquetWriter.Builder{

    public RecordParquetWriterBuilder(Path path) {
        super(path);
    }

    @Override
    protected Builder self() {
        return this;
    }

    @Override
    protected WriteSupport getWriteSupport(Configuration configuration) {
        return new LineRecordWriterSupport();
    }
}
