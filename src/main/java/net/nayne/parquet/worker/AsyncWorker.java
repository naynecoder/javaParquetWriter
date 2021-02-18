package net.nayne.parquet.worker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import net.nayne.parquet.model.LineRecord;

public class AsyncWorker implements IWorker{

    List<CompletableFuture<LineRecord>> completableFutureArrayList = new ArrayList<>();

    public void process(String[] raw) {
        CompletableFuture<LineRecord> future = CompletableFuture.supplyAsync(() -> LineParser.parse(raw));
        completableFutureArrayList.add(future);
    }

    public List<LineRecord> getRecords() throws ExecutionException, InterruptedException {
        ArrayList<LineRecord> list = new ArrayList<>();
        for (CompletableFuture<LineRecord> cf : completableFutureArrayList) {
            list.add(cf.get());
        }
        return list;
    }

}
