package com.domain.sales_data_analyser.service;

import com.domain.sales_data_analyser.SearchByRegionWorker;
import com.domain.sales_data_analyser.model.Sale;

import java.util.concurrent.ConcurrentLinkedDeque;

public class ServiceKey {
    public ConcurrentLinkedDeque<Sale> searchByRegion (ConcurrentLinkedDeque<Sale> salesList) {
        final int numWorkers = 10;
        ConcurrentLinkedDeque<Sale> filteredList = new ConcurrentLinkedDeque<>();
        Thread workers[] = new Thread[numWorkers];
        for (int i = 0; i < workers.length; i += numWorkers) {
        }
        return filteredList;
    }
}
