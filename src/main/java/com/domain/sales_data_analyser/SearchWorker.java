package com.domain.sales_data_analyser;

import com.domain.sales_data_analyser.model.Sale;
import com.domain.sales_data_analyser.model.SalesKeyTypes;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SearchWorker implements Runnable {
    private ConcurrentLinkedDeque<Sale> salesListChunk;
    private int start;
    private int end;
    private String key;
    private SalesKeyTypes salesKeyType;
    private ConcurrentLinkedDeque<Sale> result;

    public SearchWorker(ConcurrentLinkedDeque<Sale> salesListChunk, int start, int end, String key, SalesKeyTypes salesKeyType) {
        if (salesListChunk.equals(null) || start < 0 || end < 0 || end < start || key.equals(null) ||
        salesKeyType.equals(null)) {
            throw new IllegalArgumentException();
        } else {
            this.salesListChunk = salesListChunk;
            this.start = start;
            this.end = end;
            this.key = key;
            this.salesKeyType = salesKeyType;
        }
    }

    @Override
    public void run() {
        salesListChunk.stream().forEach(sale -> {
            switch(salesKeyType) {
                case REGION:
                    if (sale.getRegion().equals(key)) result.add(sale);
                    break;
                case COUNTRY:
                    if (sale.getCountry().equals(key)) result.add(sale);
                    break;
                case ITEM_TYPE:
                    if (sale.getItemType().equals(key)) result.add(sale);
                    break;
                case SALES_CHANNEL:
                    if (sale.getSalesChannel().equals(key)) result.add(sale);
                    break;
                default:
                    throw new IllegalArgumentException("Key type must be REGION, COUNTRY, ITEM_TYPE" +
                            "or SALES_CHANNEL.");
            }
        });
    }
}
