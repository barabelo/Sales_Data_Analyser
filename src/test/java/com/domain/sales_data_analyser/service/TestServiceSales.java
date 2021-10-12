package com.domain.sales_data_analyser.service;

import com.domain.sales_data_analyser.model.Sale;
import com.domain.sales_data_analyser.utils.CsvUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class TestServiceSales {
    private static List<Sale> salesList;

    @BeforeClass
    public static void initializeClass() throws URISyntaxException, IOException {
        Path path = Paths.get(ClassLoader.getSystemResource("test_CSV_with_100_Sales_Records.csv").toURI());
        salesList = CsvUtils.readSalesCsv(path);
    }

    @Test
    public void testSearchByRegionSubSaharanAfrica() {
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByRegion(salesList, "Sub-Saharan Africa");
        Assert.assertEquals(36, searchResults.size());
    }
}
