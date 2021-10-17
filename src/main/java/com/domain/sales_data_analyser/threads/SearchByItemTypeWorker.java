package com.domain.sales_data_analyser.threads;

import com.domain.sales_data_analyser.model.Sale;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SearchByItemTypeWorker implements Runnable {
    private List<Sale> salesListChunk;
    private ConcurrentLinkedDeque<Sale> searchResult;
    private String key;

    public SearchByItemTypeWorker(List<Sale> salesListChunk, ConcurrentLinkedDeque<Sale> searchResult, String key) {
        this.salesListChunk = salesListChunk;
        this.searchResult = searchResult;
        this.key = key;
    }

    @Override
    public void run() {
        for (Sale sale :
                salesListChunk) {
            if (sale.getItemType().toLowerCase().contains(key.toLowerCase())) searchResult.addFirst(sale);
        }
    }
}
