package com.domain.sales_data_analyser.model;

import java.util.Currency;
import java.util.Date;

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

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getItemType() {
        return itemType;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public char getOrderPriority() {
        return orderPriority;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public Currency getUnitPrice() {
        return unitPrice;
    }

    public Currency getUnitCost() {
        return unitCost;
    }

    public Currency getTotalRevenue() {
        return totalRevenue;
    }

    public Currency getTotalCost() {
        return totalCost;
    }

    public Currency getTotalProfit() {
        return totalProfit;
    }
}
