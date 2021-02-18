package net.nayne.parquet.worker;

import java.util.List;
import java.util.concurrent.ExecutionException;
import net.nayne.parquet.model.LineRecord;

public interface IWorker {

    void process(String[] raw);

    List<LineRecord> getRecords() throws ExecutionException, InterruptedException;

}
