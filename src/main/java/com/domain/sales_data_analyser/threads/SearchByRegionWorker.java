package com.domain.sales_data_analyser.threads;

import com.domain.sales_data_analyser.model.Sale;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SearchByRegionWorker implements Runnable {
    private final List<Sale> salesListChunk;
    private final ConcurrentLinkedDeque<Sale> searchResult;
    private final String key;

    public SearchByRegionWorker(List<Sale> salesListChunk, ConcurrentLinkedDeque<Sale> searchResult, String key) {
        this.salesListChunk = salesListChunk;
        this.searchResult = searchResult;
        this.key = key;
    }

    @Override
    public void run() {
        for (Sale sale :
                salesListChunk) {
            if (sale.getRegion().toLowerCase().contains(key.toLowerCase())) searchResult.addFirst(sale);
        }
    }
}
