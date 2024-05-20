package entities;

import dals.AccountProductDAO;

public class Item {
    private Product product;
    private int quantity;
    private Promo promo;

    public Item() {
    }
    public Item(Product product, int quantity, Promo promo) {
        this.product = product;
        this.quantity = quantity;
        this.promo = promo;


    }
    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public Item(Product product) {
        this.product = product;
        this.quantity = 1;
    }
    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice(){
        return product.getPrice();
    }
    public void increaseQuantity(int quantity){
        this.quantity += quantity;
    }
    public void decreaseQuantity(int quantity){
        this.quantity -= quantity;
    }
    public Promo getPromo() {
        return promo;
    }
    public void setPromo(Promo promo) {
        this.promo = promo;
    }
    public double getPromoPrice(){
        return product.getPrice()*(100-Integer.parseInt(promo.getPromoDiscount()))/100;
    }
    public double getPromoTotalPrice(){
        return getPromoPrice()*quantity;
    }
    public double getTotalPrice(){
        return getPrice()*quantity;
    }
    public double getSavePrice(){
        return getTotalPrice()-getPromoTotalPrice();
    }

    public boolean checkAccountInStock(int quality, int idProduct){
        AccountProductDAO accountProductDAO = new AccountProductDAO();
        return accountProductDAO.checkAccountInStock(quality, idProduct);
    }
    public int countTotalAccountProductStatusSell(int idProduct){
        AccountProductDAO accountProductDAO = new AccountProductDAO();
        return accountProductDAO.countTotalAccountProductStatusSell(idProduct);
    }

}
