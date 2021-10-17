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

    @Test
    public void testSearchByRegion_aFRica() {
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByRegion(salesList, "aFRica");
        Assert.assertEquals(46, searchResults.size());
    }

    @Test
    public void testSearchByRegionThatIsNotOnTheSalesList() {
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByRegion(salesList, "Pluto");
        Assert.assertEquals(0, searchResults.size());
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
        String emptyString = "";
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByRegion(salesList, emptyString);
    }

    @Test
    public void testSearchByCountryAustralia() {
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByCountry(salesList, "Australia");
        Assert.assertEquals(3, searchResults.size());
    }

    @Test
    public void testSearchByCountry_coNGO() {
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByCountry(salesList, "coNGO");
        Assert.assertEquals(2, searchResults.size());
    }

    @Test
    public void testSearchByCountryThatIsNotOnTheSalesList() {
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByCountry(salesList, "Atlantis");
        Assert.assertEquals(0, searchResults.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchByCountrySendingEmptySalesListAndEmptyKey() {
        List<Sale> emptySalesList = new ArrayList<>();
        String emptyString = "";
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByCountry(emptySalesList, emptyString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchByCountrySendingNullSalesListAndNullKey() {
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByCountry(null, null);
    }

    @Test
    public void testSearchByItemTypeSnacks() {
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByItemType(salesList, "Snacks");
        Assert.assertEquals(3, searchResults.size());
    }

    @Test
    public void testSearchByItemType_FOod() {
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByItemType(salesList, "FOod");
        Assert.assertEquals(7, searchResults.size());
    }

    @Test
    public void testSearchByItemTypeThatIsNotOnTheSalesList() {
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByItemType(salesList, "Nails");
        Assert.assertEquals(0, searchResults.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchByItemTypeSendingEmptySalesListAndEmptyKey() {
        List<Sale> emptySalesList = new ArrayList<>();
        String emptyString = "";
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByItemType(emptySalesList, emptyString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSearchByItemTypeSendingNullSalesListAndNullKey() {
        ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByItemType(null, null);
    }

}
