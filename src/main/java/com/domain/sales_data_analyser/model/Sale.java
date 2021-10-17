package com.domain.sales_data_analyser.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Sale {
    @CsvBindByName(column = "Region")
    private String region;

    @CsvBindByName(column = "Country")
    private String country;

    @CsvBindByName(column = "Item Type")
    private String itemType;

    @CsvBindByName(column = "Sales Channel")
    private String salesChannel;

    @CsvBindByName(column = "Order Priority")
    private char orderPriority;

    @CsvBindByName(column = "Order Date")
    @CsvDate(value = "M/d/yyyy")
    private LocalDate orderDate;

    @CsvBindByName(column = "Order ID")
    private long orderID;

    @CsvBindByName(column = "Ship Date")
    @CsvDate(value = "M/d/yyyy")
    private LocalDate shipDate;

    @CsvBindByName(column = "Units Sold")
    private long unitsSold;

    @CsvBindByName(column = "Unit Price")
    private BigDecimal unitPrice;

    @CsvBindByName(column = "Unit Cost")
    private BigDecimal unitCost;

    @CsvBindByName(column = "Total Revenue")
    private BigDecimal totalRevenue;

    @CsvBindByName(column = "Total Cost")
    private BigDecimal totalCost;

    @CsvBindByName(column = "Total Profit")
    private BigDecimal totalProfit;

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

    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
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

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public void setShipDate(LocalDate shipDate) {
        this.shipDate = shipDate;
    }

    public void setUnitsSold(long unitsSold) {
        this.unitsSold = unitsSold;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public void setTotalProfit(BigDecimal totalProfit) {
        this.totalProfit = totalProfit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sale sale = (Sale) o;

        if (orderPriority != sale.orderPriority) return false;
        if (orderID != sale.orderID) return false;
        if (unitsSold != sale.unitsSold) return false;
        if (!region.equals(sale.region)) return false;
        if (!country.equals(sale.country)) return false;
        if (!itemType.equals(sale.itemType)) return false;
        if (!salesChannel.equals(sale.salesChannel)) return false;
        if (!orderDate.equals(sale.orderDate)) return false;
        if (!shipDate.equals(sale.shipDate)) return false;
        if (!unitPrice.equals(sale.unitPrice)) return false;
        if (!unitCost.equals(sale.unitCost)) return false;
        if (!totalRevenue.equals(sale.totalRevenue)) return false;
        if (!totalCost.equals(sale.totalCost)) return false;
        return totalProfit.equals(sale.totalProfit);
    }

    @Override
    public int hashCode() {
        int result = region.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + itemType.hashCode();
        result = 31 * result + salesChannel.hashCode();
        result = 31 * result + (int) orderPriority;
        result = 31 * result + orderDate.hashCode();
        result = 31 * result + (int) (orderID ^ (orderID >>> 32));
        result = 31 * result + shipDate.hashCode();
        result = 31 * result + (int) (unitsSold ^ (unitsSold >>> 32));
        result = 31 * result + unitPrice.hashCode();
        result = 31 * result + unitCost.hashCode();
        result = 31 * result + totalRevenue.hashCode();
        result = 31 * result + totalCost.hashCode();
        result = 31 * result + totalProfit.hashCode();
        return result;
    }
}
