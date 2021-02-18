package net.nayne.parquet.csv_reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.ZipInputStream;
import net.nayne.parquet.worker.IWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CsvReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsvReader.class);
    private static final char DELIMITER = ',';
    private final IWorker worker;

    public CsvReader(IWorker worker) {
        this.worker = worker;
    }

    public void readFile(File file) {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(file))) {
            zis.getNextEntry();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(zis))) {
                String rawLine = br.readLine();//header
                int size = rawLine.split(",").length;
                while ((rawLine = br.readLine()) != null) {
                    String[] parsedLines = CustomStringSplitter.split(rawLine, DELIMITER, size);
                    worker.process(parsedLines);
                }

            } catch (IOException e) {
                LOGGER.error("Error reading zipped line");
            }

        } catch (IOException e) {
            LOGGER.error("Error reading file");
        }
    }

}
