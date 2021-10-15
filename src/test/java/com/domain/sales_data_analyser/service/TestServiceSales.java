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
import java.util.ArrayList;
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

    @Test(expected = IllegalArgumentException.class)
    public void testSearchByRegionSendingNullSalesList() {
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByRegion(null, "Sub-Saharan Africa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchByRegionSendingNullKey() {
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByRegion(salesList, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchByRegionSendingEmptySalesList() {
        List<Sale> emptySalesList = new ArrayList<>();
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByRegion(emptySalesList, "Sub-Saharan Africa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchByRegionSendingEmptyKey() {
        String emptyString = new String();
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByRegion(salesList, emptyString);
    }

    @Test
    public void testSearchByCountryAustralia() {
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByCountry(salesList, "Australia");
        Assert.assertEquals(3, searchResults.size());
    }

    @Test
    public void testSearchByCountryAtlantis() {
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByCountry(salesList, "Atlantis");
        Assert.assertEquals(0, searchResults.size());
    }

}
