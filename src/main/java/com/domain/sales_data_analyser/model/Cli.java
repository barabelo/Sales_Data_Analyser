package com.domain.sales_data_analyser.model;

import com.domain.sales_data_analyser.service.ServiceSales;
import com.domain.sales_data_analyser.utils.CsvUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Cli {
    private final String REGION = "1";
    private final String COUNTRY = "2";
    private final String ITEM_TYPE = "3";
    private final String RETURN = "0";

    public void start() {
        String input = "";

        while (!input.equals("0")) {
            System.out.println("SALES DATA ANALYSER\n" +
                    "Type the path to the sales report or 0 to exit:");
            input = new Scanner(System.in).nextLine();
            if (!input.equals("0")) {
                try {
                    List<Sale> salesList = CsvUtils.readSalesCsv(Path.of(input));
                    System.out.println("Loaded.");
                    searchMenu(salesList);
                } catch (IOException e) {
                    System.out.println("An error has occurred. The informed path could be invalid.");
                }
            }
        }
    }

    private void searchMenu(List<Sale> saleList) {
        String option = "";
        while (!option.equals("0")) {
            System.out.println("Search by:\n" +
                    "1 - Region\n" +
                    "2 - Country\n" +
                    "3 - Item Type\n" +
                    "0 - Return");
            option = new Scanner(System.in).nextLine();
            switch (option) {
                case REGION:
                    searchByRegionMenu(saleList);
                    break;
                case COUNTRY:
                    searchByCountryMenu(saleList);
                    break;
                case ITEM_TYPE:
                    searchByItemTypeMenu(saleList);
                    break;
                case RETURN:
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    private void searchByRegionMenu(List<Sale> saleList) {
        String input = "";

        while (!input.equals("0")) {
            System.out.println("Type the region name or 0 to cancel:");
            input = new Scanner(System.in).nextLine();
            if (!input.equals("0")) {
                ConcurrentLinkedDeque<Sale> searchResults = ServiceSales.searchByRegion(saleList, input);

                int amountOfResultsFound = searchResults.size();
                if (amountOfResultsFound > 0) {
                    System.out.println(amountOfResultsFound + " matches found.");
                    saveResultsQuestion(searchResults);
                } else {
                    System.out.println("No results found.");
                }
            } else {
                System.out.println("Canceled.");
            }
        }
    }

    private void searchByCountryMenu(List<Sale> saleList) {

    }

    private void searchByItemTypeMenu(List<Sale> saleList) {

    }

    private void saveResultsQuestion(ConcurrentLinkedDeque<Sale> searchResults) {
        String option = "";

        while (!option.equals("y") && !option.equals("n")) {
            System.out.println("Do you want to save the results? (y/n)");
            option = new Scanner(System.in).nextLine().toLowerCase();
            switch (option) {
                case "y":
                    saveResultsMenu(searchResults);
                    break;
                case "n":
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    private void saveResultsMenu(ConcurrentLinkedDeque<Sale> searchResults) {
        String input = "";
        boolean saved = false;

        while (!input.equals("0") && !saved) {
            System.out.println("Type the path where you want to save the file including the file name or 0 to cancel:");
            input = new Scanner(System.in).nextLine();
            if (!input.equals("0")) try {
                CsvUtils.writeSalesDequeToCsv(searchResults, Path.of(input));
                System.out.println("Saved.");
                saved = true;
            } catch (IOException e) {
                System.out.println("An error has occurred. The informed path could be invalid. Don't forget to write " +
                        "the file name.");
            }
            else System.out.println("Canceled.");
        }
    }
}
