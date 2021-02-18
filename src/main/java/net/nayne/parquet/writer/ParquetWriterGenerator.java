package net.nayne.parquet.writer;

import java.io.File;
import java.io.IOException;
import org.apache.hadoop.fs.Path;
import org.apache.parquet.column.ParquetProperties.WriterVersion;
import org.apache.parquet.hadoop.ParquetFileWriter.Mode;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;

public class ParquetWriterGenerator {

    public static ParquetWriter getWriter(String path) throws IOException {
        Path fsPath = new Path(new File(path).getPath());
        ParquetWriter.Builder builder = new RecordParquetWriterBuilder(fsPath);
        return builder.withCompressionCodec(CompressionCodecName.SNAPPY)
            .withWriterVersion(WriterVersion.PARQUET_1_0)
            .enableDictionaryEncoding()
            .withValidation(true)
            .withWriteMode(Mode.OVERWRITE)
            .build();
    }

}
