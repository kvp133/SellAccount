/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author KieuVietPhuoc
 */
public class Promo {
    private int promoID;
    private String promoCode;
    private String promoDiscount;
    Product product;
    private boolean status;

    public Promo() {
    }

    public Promo(int promoID, String promoCode, String promoDiscount, Product product, boolean status) {
        this.promoID = promoID;
        this.promoCode = promoCode;
        this.promoDiscount = promoDiscount;
        this.product = product;
        this.status = status;
    }

    public int getPromoID() {
        return promoID;
    }

    public void setPromoID(int promoID) {
        this.promoID = promoID;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getPromoDiscount() {
        return promoDiscount;
    }

    public void setPromoDiscount(String promoDiscount) {
        this.promoDiscount = promoDiscount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}

