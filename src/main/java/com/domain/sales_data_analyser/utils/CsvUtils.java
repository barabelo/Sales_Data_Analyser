package com.domain.sales_data_analyser.utils;

import com.domain.sales_data_analyser.model.Sale;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

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

    public static void writeSalesDequeToCsv(ConcurrentLinkedDeque<Sale> salesList, Path csvPath) throws IOException {
        try (Writer writer = Files.newBufferedWriter(csvPath)) {
            StatefulBeanToCsv<Sale> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            beanToCsv.write(salesList.iterator());
        } catch (IOException e) {
            throw new IOException("An error occurred while opening the file.");
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            throw new RuntimeException();
        }
    }
}
