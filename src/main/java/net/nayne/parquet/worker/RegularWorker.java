package net.nayne.parquet.worker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.nayne.parquet.model.LineRecord;
/*
Same as AsyncWoker, but with ExecutorService and Callable instead of CompletableFuture
 */
public class RegularWorker implements IWorker {

    ExecutorService executorService = Executors.newWorkStealingPool();
    List<Future<LineRecord>> futures = new ArrayList<>();

    @Override
    public void process(String[] raw) {
        Callable<LineRecord> callable = () -> LineParser.parse(raw);
        futures.add(executorService.submit(callable));
    }

    @Override
    public List<LineRecord> getRecords() throws ExecutionException, InterruptedException {
        executorService.shutdown();
        List<LineRecord> records = new ArrayList<>();
        for (Future<LineRecord> fut : futures) {
            records.add(fut.get());
        }
        return records;
    }
}
