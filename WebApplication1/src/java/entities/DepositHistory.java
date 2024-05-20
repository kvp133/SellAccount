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
public class DepositHistory {

    private int historyID;
    Customer customer;
    private double amount;
    private Date transactionDate;
    private boolean status;

    // Getter and setter methods
    public DepositHistory() {
    }
    public DepositHistory(int historyID, Customer customer, double amount, Date transactionDate, boolean status) {
        this.historyID = historyID;
        this.customer = customer;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.status = status;
    }

    public int getHistoryID() {
        return historyID;
    }

    public void setHistoryID(int historyID) {
        this.historyID = historyID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
