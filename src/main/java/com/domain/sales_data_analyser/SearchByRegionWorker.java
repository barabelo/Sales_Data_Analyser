package com.domain.sales_data_analyser;

import com.domain.sales_data_analyser.model.Sale;

import java.util.concurrent.ConcurrentLinkedDeque;

public class SearchByRegionWorker implements Runnable {
    private ConcurrentLinkedDeque<Sale> salesListChunk;
    private int start;
    private int end;
    private String key;
    private ConcurrentLinkedDeque<Sale> result;

    public SearchByRegionWorker(ConcurrentLinkedDeque<Sale> salesListChunk, int start, int end, String key) {
        this.salesListChunk = salesListChunk;
        this.start = start;
        this.end = end;
        this.key = key;
    }

    @Override
    public void run() {
        salesListChunk.forEach(sale -> {if (sale.getRegion().equals(key)) result.add(sale);});
    }
}
