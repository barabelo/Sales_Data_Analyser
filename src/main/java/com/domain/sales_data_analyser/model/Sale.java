package com.domain.sales_data_analyser.model;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;

import java.util.Currency;
import java.util.Date;

@Getter
public class Sale {
    @CsvBindByName(column = "Region")
    public String region;

    @CsvBindByName(column = "Country")
    public String country;

    @CsvBindByName(column = "Item Type")
    public String itemType;

    @CsvBindByName(column = "Sales Channel")
    public String salesChannel;

    @CsvBindByName(column = "Order Priority")
    public char orderPriority;

    @CsvBindByName(column = "Order Date")
    public Date orderDate;

    @CsvBindByName(column = "Order ID")
    public int orderID;

    @CsvBindByName(column = "Ship Date")
    public Date shipDate;

    @CsvBindByName(column = "Units Sold")
    public int unitsSold;

    @CsvBindByName(column = "Unit Price")
    public Currency unitPrice;

    @CsvBindByName(column = "Unit Cost")
    public Currency unitCost;

    @CsvBindByName(column = "Total Revenue")
    public Currency totalRevenue;

    @CsvBindByName(column = "Total Cost")
    public Currency totalCost;

    @CsvBindByName(column = "Total Profit")
    public Currency totalProfit;
}
