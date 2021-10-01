package com.domain.sales_data_analyser.model;

import lombok.Data;

import java.util.Currency;
import java.util.Date;

@Data
public class Sale {
    public String region;
    public String country;
    public String itemType;
    public String salesChannel;
    public char orderPriority;
    public Date orderDate;
    public int orderID;
    public Date shipDate;
    public int unitsSold;
    public Currency unitPrice;
    public Currency unitCost;
    public Currency totalRevenue;
    public Currency totalCost;
    public Currency totalProfit;
}
