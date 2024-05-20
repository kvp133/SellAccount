/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author KieuVietPhuoc
 */
public class Product {

    private int productID;
    private String productName;
    private double price;
    private String thumbnailURL;
    private String description;
    ProductType productType;
    private boolean ProductFavorite;
    private boolean status;

    // Getter and setter methods
    public Product() {
    }

    public Product(int productID, String productName, double price, String thumbnailURL, String description, ProductType productType, boolean ProductFavorite, boolean status) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.thumbnailURL = thumbnailURL;
        this.description = description;
        this.productType = productType;
        this.ProductFavorite = ProductFavorite;
        this.status = status;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public boolean isProductFavorite() {
        return ProductFavorite;
    }

    public void setProductFavorite(boolean ProductFavorite) {
        this.ProductFavorite = ProductFavorite;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
