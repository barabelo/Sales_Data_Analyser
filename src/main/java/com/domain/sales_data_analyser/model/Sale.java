package com.domain.sales_data_analyser.model;

import java.time.LocalDate;
import java.util.Currency;

public class Sale {
    public String region;
    public String country;
    public String itemType;
    public String salesChannel;
    public char orderPriority;
    public LocalDate orderDate;
    public int orderID;
    public LocalDate shipDate;
    public int unitsSold;
    public Currency unitPrice;
    public Currency unitCost;
    public Currency totalRevenue;
    public Currency totalCost;
    public Currency totalProfit;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getSalesChannel() {
        return salesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
    }

    public char getOrderPriority() {
        return orderPriority;
    }

    public void setOrderPriority(char orderPriority) {
        this.orderPriority = orderPriority;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public LocalDate getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDate shipDate) {
        this.shipDate = shipDate;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }

    public Currency getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Currency unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Currency getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Currency unitCost) {
        this.unitCost = unitCost;
    }

    public Currency getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Currency totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Currency getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Currency totalCost) {
        this.totalCost = totalCost;
    }

    public Currency getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(Currency totalProfit) {
        this.totalProfit = totalProfit;
    }
}
