package com.domain.sales_data_analyser.service;

import com.domain.sales_data_analyser.model.Sale;
import com.domain.sales_data_analyser.threads.SearchByCountryWorker;
import com.domain.sales_data_analyser.threads.SearchByRegionWorker;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ServiceSales {
    private static final int numWorkers = 10;
    private static ConcurrentLinkedDeque<Sale> searchResult;
    private static Thread[] threads;
    private static int fromIndex;
    private static int salesPerWorker;
    private static int toIndex;

    private static void initialize(List<Sale> salesList, String key) {
        if ((salesList == null || salesList.isEmpty()) && (key == null || key.isEmpty()))
            throw new IllegalArgumentException("salesList and key must not be null or empty.");
        if (salesList == null || salesList.isEmpty())
            throw new IllegalArgumentException("salesList must not be null or empty.");
        if (key == null || key.isEmpty())
            throw new IllegalArgumentException("key must not be null or empty.");
        searchResult = new ConcurrentLinkedDeque<>();
        threads = new Thread[numWorkers];
        fromIndex = 0;
        salesPerWorker = salesList.size() / numWorkers;
        toIndex = fromIndex + salesPerWorker + salesList.size() % numWorkers;
    }

    public static ConcurrentLinkedDeque<Sale> searchByRegion(List<Sale> salesList, String key) {
        initialize(salesList, key);
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

    public static ConcurrentLinkedDeque<Sale> searchByCountry(List<Sale> salesList, String key) {
        initialize(salesList, key);
        for (int i = 0; i < threads.length; i++) {
            SearchByCountryWorker searchByCountryWorker
                    = new SearchByCountryWorker(salesList.subList(fromIndex, toIndex), searchResult, key);
            threads[i] = new Thread(searchByCountryWorker);
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
