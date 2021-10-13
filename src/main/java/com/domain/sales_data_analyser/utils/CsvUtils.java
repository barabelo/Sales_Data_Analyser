package com.domain.sales_data_analyser.utils;

import com.domain.sales_data_analyser.model.Sale;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvUtils {
    public static List<Sale> readSalesCsv(Path csvPath) throws IOException {
        List<Sale> salesList;

        try {
            Reader reader = Files.newBufferedReader(csvPath);
            CsvToBean<Sale> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Sale.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            salesList = csvToBean.parse();
            return salesList;
        } catch (IOException e) {
            throw new IOException("An error occurred while opening the file.");
        }
    }
}
