/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author KieuVietPhuoc
 */
public class AccountProduct {

    private int accountProductID;
    private String infoAccount;
    private Product product;
    private boolean statusSell;
    private boolean status;

    private OrderDetail orderDetail;

    public AccountProduct() {
    }

    public AccountProduct(int accountProductID, String infoAccount, Product product, boolean statusSell, boolean status, OrderDetail orderDetail) {
        this.accountProductID = accountProductID;
        this.infoAccount = infoAccount;
        this.product = product;
        this.statusSell = statusSell;
        this.status = status;
        this.orderDetail = orderDetail;
    }

    public int getAccountProductID() {
        return accountProductID;
    }

    public void setAccountProductID(int accountProductID) {
        this.accountProductID = accountProductID;
    }

    public String getInfoAccount() {
        return infoAccount;
    }

    public void setInfoAccount(String infoAccount) {
        this.infoAccount = infoAccount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean isStatusSell() {
        return statusSell;
    }

    public void setStatusSell(boolean statusSell) {
        this.statusSell = statusSell;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }
}