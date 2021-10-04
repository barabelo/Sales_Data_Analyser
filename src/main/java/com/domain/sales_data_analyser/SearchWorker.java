package com.domain.sales_data_analyser;

import com.domain.sales_data_analyser.model.Sale;
import com.domain.sales_data_analyser.model.SalesKeyTypes;
import lombok.AllArgsConstructor;
import java.util.concurrent.ConcurrentLinkedDeque;

@AllArgsConstructor
public class SearchWorker implements Runnable {
    private ConcurrentLinkedDeque<Sale> salesListChunk;
    private int start;
    private int end;
    private String key;
    private SalesKeyTypes salesKeyType;
    private ConcurrentLinkedDeque<Sale> result;

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
