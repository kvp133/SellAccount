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
public class OrderHistory {

    private int historyID;
    private Order order;
    private String orderStatus;
    private Date updateDate;
    private boolean status;

    public OrderHistory() {
    }

    public OrderHistory(int historyID, Order order, String orderStatus, Date updateDate, boolean status) {
        this.historyID = historyID;
        this.order = order;
        this.orderStatus = orderStatus;
        this.updateDate = updateDate;
        this.status = status;
    }

    public int getHistoryID() {
        return historyID;
    }

    public void setHistoryID(int historyID) {
        this.historyID = historyID;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
