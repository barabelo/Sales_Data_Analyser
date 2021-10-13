package com.domain.sales_data_analyser.service;

import com.domain.sales_data_analyser.model.Sale;
import com.domain.sales_data_analyser.utils.SearchByRegionWorker;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ServiceSales {
    public static ConcurrentLinkedDeque<Sale> searchByRegion(List<Sale> salesList, String key) {
        final int numWorkers = 10;

        ConcurrentLinkedDeque<Sale> searchResult = new ConcurrentLinkedDeque<>();
        Thread[] threads = new Thread[numWorkers];

        int fromIndex = 0;
        int salesPerWorker = salesList.size() / numWorkers;
        int toIndex = fromIndex + salesPerWorker + salesList.size() % numWorkers;

        for (int i = 0; i < threads.length; i++) {
            SearchByRegionWorker searchByRegionWorker
                    = new SearchByRegionWorker(salesList.subList(fromIndex, toIndex), searchResult, key);
            threads[i] = new Thread(searchByRegionWorker);
            threads[i].start();
            fromIndex = toIndex;
            toIndex = fromIndex + salesPerWorker;
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
        return searchResult;
    }
}
