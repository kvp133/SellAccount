package entities;

import dals.AccountProductDAO;

import java.util.Vector;

public class Cart {
    private Vector<Item> items;
    public  Cart(){
        items = new Vector<Item>();
    }
    public Vector<Item> getItems(){
        return items;
    }
    public int getSize(){
        return items.size();
    }
    public Item getItemById(int id){
        for(Item item: items){
            if(item.getProduct().getProductID() == id){
                return item;
            }
        }
        return null;
    }
    public int getQuantityById(int id){
        return getItemById(id).getQuantity();
    }
    public void addItem(Item item){
        if (getItemById(item.getProduct().getProductID()) == null){
            items.add(item);
    }else {
            Item item1 = getItemById(item.getProduct().getProductID());
            item1.increaseQuantity(item.getQuantity()+item1.getQuantity());
        }
    }
    public void removeItemById(int id){
        items.remove(getItemById(id));
    }
    public double getTotalPrice(){
        double total = 0;
        for(Item item: items){
            total += (item.getPrice()*item.getQuantity());
        }
        return total;
    }
    public void updateItem(int id, int quantity){
        getItemById(id).setQuantity(quantity);
    }
    public void clear(){
        items.clear();
    }
    //Check Cart is empty
    public boolean isEmpty(){
        if (items.size() == 0){
            return true;
        }
        return false;
    }


}
