/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Date;

/**
 *
 * @author KieuVietPhuoc
 */
public class Order {
    private int orderID;
    Customer customer;
    private Date orderDate;

    double total;

    private boolean statusPayment;

    public Order() {
    }

    public Order(int orderID, Customer customer, Date orderDate, double total, boolean statusPayment) {
        this.orderID = orderID;
        this.customer = customer;
        this.orderDate = orderDate;
        this.total = total;
        this.statusPayment = statusPayment;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(boolean statusPayment) {
        this.statusPayment = statusPayment;
    }
}

