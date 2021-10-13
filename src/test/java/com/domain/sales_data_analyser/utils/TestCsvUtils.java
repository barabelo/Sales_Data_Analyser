package com.domain.sales_data_analyser.utils;

import com.domain.sales_data_analyser.model.Sale;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;


public class TestCsvUtils {
    private static List<Sale> salesList;
    private final Sale specificSale = new Sale();

    @BeforeClass
    public static void initializeClass() throws URISyntaxException, IOException {
        Path path = Paths.get(ClassLoader
                .getSystemResource("test_CSV_with_100_Sales_Records.csv")
                .toURI());
        salesList = CsvUtils.readSalesCsv(path);
    }

    @Test
    public void testNumberOfLines() throws IOException {
        int numberOfLines = salesList.size();
        Assert.assertEquals(100, numberOfLines);
    }

    @Before
    public void initializeSpecificSale() {
        specificSale.setRegion("Sub-Saharan Africa");
        specificSale.setCountry("Sao Tome and Principe");
        specificSale.setItemType("Fruits");
        specificSale.setSalesChannel("Online");
        specificSale.setOrderPriority('C');
        specificSale.setOrderDate(LocalDate.of(2014, 6, 20));
        specificSale.setOrderID(514321792);
        specificSale.setShipDate(LocalDate.of(2014, 7, 5));
        specificSale.setUnitsSold(8102);
        specificSale.setUnitPrice(new BigDecimal("9.33"));
        specificSale.setUnitCost(new BigDecimal("6.92"));
        specificSale.setTotalRevenue(new BigDecimal("75591.66"));
        specificSale.setTotalCost(new BigDecimal("56065.84"));
        specificSale.setTotalProfit(new BigDecimal("19525.82"));
    }

    @Test
    public void testContainsSpecificSale() {
        Assert.assertTrue(salesList.get(3).equals(specificSale));
    }

    @Test
    public void testIfTheSalesRegionOnTheFourthLineOfTheSalesListIsSubSaharanAfrica() {
        Assert.assertEquals("Sub-Saharan Africa", salesList.get(3).getRegion());
    }

    @Test
    public void testIfTheSalesCountryOnTheFourthLineOfTheSalesListIsSaoTomeAndPrincipe() {
        Assert.assertEquals("Sao Tome and Principe", salesList.get(3).getCountry());
    }

    @Test
    public void testIfTheSalesOrderDateOnTheFourthLineOfTheSalesListIsNotNull() {
        Assert.assertNotNull(salesList.get(3).getOrderDate());
    }

    @Test
    public void testIfTheSalesOrderDateOnTheFourthLineOfTheSalesListIs_6_20_2014() {
        Assert.assertTrue(LocalDate.of(2014, 6, 20).isEqual(salesList.get(3).getOrderDate()));
    }

}
