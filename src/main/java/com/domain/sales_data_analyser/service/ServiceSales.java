package com.domain.sales_data_analyser.service;

import com.domain.sales_data_analyser.model.Sale;
import com.domain.sales_data_analyser.threads.SearchByRegionWorker;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ServiceSales {
    private static final int numWorkers = 10;
    private static ConcurrentLinkedDeque<Sale> searchResult;
    private static Thread[] threads;
    private static int fromIndex;
    private static int salesPerWorker;
    private static int toIndex;

    private static void initialize(int salesListSize) {
        searchResult = new ConcurrentLinkedDeque<>();
        threads = new Thread[numWorkers];
        fromIndex = 0;
        salesPerWorker = salesListSize / numWorkers;
        toIndex = fromIndex + salesPerWorker + salesListSize % numWorkers;
    }

    public static ConcurrentLinkedDeque<Sale> searchByRegion(List<Sale> salesList, String key) {
        if (salesList == null && key == null) throw new IllegalArgumentException("salesList and key can't be null.");
        if (salesList == null) throw new IllegalArgumentException("salesList can't be null.");
        if (key == null) throw new IllegalArgumentException("key can't be null.");

        initialize(salesList.size());
        for (int i = 0; i < threads.length; i++) {
            SearchByRegionWorker searchByRegionWorker
                    = new SearchByRegionWorker(salesList.subList(fromIndex, toIndex), searchResult, key);
            threads[i] = new Thread(searchByRegionWorker);
            threads[i].start();
            fromIndex = toIndex;
            toIndex = fromIndex + salesPerWorker;
        }
        for (Thread thread : threads)
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        return searchResult;
    }

}
