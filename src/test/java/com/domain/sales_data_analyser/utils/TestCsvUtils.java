package com.domain.sales_data_analyser.utils;

import com.domain.sales_data_analyser.model.Sale;
import org.junit.BeforeClass;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class TestCsvUtils {
    private static List<Sale> salesList;

    @BeforeClass
    public static void initializeClass() throws URISyntaxException, IOException {
        Path path = Paths.get(ClassLoader
                .getSystemResource("test_CSV_with_100_Sales_Records.csv")
                .toURI());
        salesList = CsvUtils.readSalesCsv(path);
    }

}
