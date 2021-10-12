package com.domain.sales_data_analyser.utils;

import com.domain.sales_data_analyser.model.Sale;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SearchByRegionWorker implements Runnable {
    private List<Sale> salesListChunk;
    private ConcurrentLinkedDeque<Sale> searchResult;
    private String key;

    public SearchByRegionWorker(List<Sale> salesListChunk, ConcurrentLinkedDeque<Sale> searchResult, String key) {
        this.salesListChunk = salesListChunk;
        this.searchResult = searchResult;
        this.key = key;
    }

    @Override
    public void run() {
        for (Sale sale :
                salesListChunk) {
            if (sale.getRegion().contains(key)) searchResult.addFirst(sale);
        }
    }
}
