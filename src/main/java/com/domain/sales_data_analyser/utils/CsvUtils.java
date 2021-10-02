package com.domain.sales_data_analyser.utils;

import com.domain.sales_data_analyser.model.Sale;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CsvUtils {
    public static List<Sale> readSalesCsv(Path csvPath) throws IOException {
        List<Sale> safeSalesList = Collections.synchronizedList(new ArrayList<>());

        Reader reader = null;
        try {
            reader = Files.newBufferedReader(csvPath);
            CsvToBean<Sale> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Sale.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            safeSalesList = csvToBean.parse();
        } catch (IOException e) {
            throw new IOException("Houve um erro ao abrir o arquivo.");
        }

        return safeSalesList;

    }
}
