package net.nayne.parquet;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import net.nayne.parquet.csv_reader.CsvReader;
import net.nayne.parquet.worker.AsyncWorker;
import net.nayne.parquet.worker.IWorker;
import net.nayne.parquet.writer.Writer;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        ClassLoader classLoader = Main.class.getClassLoader();
        String outputPath = "result.parquet";
        String filePath = classLoader.getResource("FL_insurance_sample.zip").getPath();
        File file = new File(filePath);
        IWorker worker = new AsyncWorker();
        CsvReader csvReader = new CsvReader(worker);
        csvReader.readFile(file);
        Writer.write(worker.getRecords(), outputPath);
    }

}
