package net.nayne.parquet.writer;

import java.io.IOException;
import java.util.List;
import net.nayne.parquet.model.LineRecord;
import org.apache.parquet.hadoop.ParquetWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Writer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Writer.class);

    public static void write(List<LineRecord> recordList, String outputPath) {
        try (ParquetWriter parquetWriter = ParquetWriterGenerator.getWriter(outputPath)) {
            ;
            for (LineRecord lineRecord : recordList) {
                parquetWriter.write(lineRecord);
            }
        } catch (IOException e) {
            LOGGER.error("Error writing Parquet file");
        }

    }

}
