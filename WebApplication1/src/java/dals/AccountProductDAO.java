package dals;

import entities.AccountProduct;
import entities.Order;
import entities.OrderDetail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class AccountProductDAO extends DbConnect {
    //count total account product Status sell = 0
    public int countTotalAccountProductStatusSell(int idProduct) {
        int n = 0;
        String sql = "select count(*) from AccountProducts where AccProductID = ? and StatusSell = 0";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, idProduct);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                n = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;

    }

    //check account in stock or not
    public boolean checkAccountInStock(int quality, int idProduct) {
        boolean check = false;
        if (countTotalAccountProductStatusSell(idProduct) >= quality) {
            check = true;
        }
        return check;
    }
    //get Account In Stock by product ID
    public int getQuantityInStock(int idProduct) {
        int n = 0;
        String sql = "select count(*) from AccountProducts where AccProductID = ? and StatusSell = 0";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, idProduct);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                n = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }


    //add account product
    public int addAccountProduct(String infoAccount, int idProduct, boolean statusSell, boolean status) {
        int n = 0;
        String sql = "insert into AccountProducts(InfoAccount,ProductID,StatusSell,Status) values(?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, infoAccount);
            pre.setInt(2, idProduct);
            pre.setBoolean(3, statusSell);
            pre.setBoolean(4, status);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    //update account product status and orderdetailID sold when paid
    public int updateAccountProductStatusSell(int idProduct, int quality, int idOrderDetail) {
        int n = 0;
        String sql = "update TOP(?) AccountProducts set StatusSell = 1, OrderDetailID = ? where AccProductID = ? and StatusSell = 0 ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, quality);
            pre.setInt(2, idOrderDetail);
            pre.setInt(3, idProduct);

            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    public Vector<OrderDetail> getOrderdetailsbyOrderID(int idOrder) {
        Vector<OrderDetail> orderDetails = new Vector<OrderDetail>();
        String sql = "select * from OrderDetails where OrderID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, idOrder);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setOrderDetailID(rs.getInt(1));
                orderDetail.setOrder(new OrderDAO().getOrder(rs.getInt(2)));
                orderDetail.setProduct(new ProductDAO().getProductByID(rs.getInt(3)));
                orderDetail.setQuantity(rs.getInt(4));
                orderDetails.add(orderDetail);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orderDetails;

    }
    public int updateAccountProductStatusSell(int idOrder){
        int n = 0;
        Vector<OrderDetail> orderDetails = getOrderdetailsbyOrderID(idOrder);
        for (OrderDetail orderDetail : orderDetails) {
            n += updateAccountProductStatusSell(orderDetail.getProduct().getProductID(), orderDetail.getQuantity(), orderDetail.getOrderDetailID());
        }
        return n;
    }
    //check total account product stock or not in order by id order
    public boolean checkTotalAccountProductStock(int idOrder) {
        boolean check = true;
        Vector<OrderDetail> orderDetails = getOrderdetailsbyOrderID(idOrder);
        for (OrderDetail orderDetail : orderDetails) {
            if (!checkAccountInStock(orderDetail.getQuantity(), orderDetail.getProduct().getProductID())) {
                check = false;
                break;
            }
        }
        return check;
    }
    public OrderDetail getOrderDetail(int idOrderDetail){
        OrderDetail orderDetail = new OrderDetail();
        String sql = "select * from OrderDetails where OrderDetailID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, idOrderDetail);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                orderDetail.setOrderDetailID(rs.getInt(1));
                orderDetail.setOrder(new OrderDAO().getOrder(rs.getInt(2)));
                orderDetail.setProduct(new ProductDAO().getProductByID(rs.getInt(3)));
                orderDetail.setQuantity(rs.getInt(4));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return orderDetail;
    }
    //get list account product by order id
    public Vector<AccountProduct> getAccountProductByOrderID(int idOrder) {
        Vector<AccountProduct> accountProducts = new Vector<AccountProduct>();
        String sql = "select * from AccountProducts where OrderDetailID in (select OrderDetailID from OrderDetails where OrderID = ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, idOrder);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                AccountProduct accountProduct = new AccountProduct();
                accountProduct.setAccountProductID(rs.getInt(1));
                accountProduct.setInfoAccount(rs.getString(2));
                accountProduct.setProduct(new ProductDAO().getProductByID(rs.getInt(3)));
                accountProduct.setStatusSell(rs.getBoolean(4));
                accountProduct.setStatus(rs.getBoolean(5));
                accountProduct.setOrderDetail(getOrderDetail(rs.getInt(6)));
                accountProducts.add(accountProduct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return accountProducts;
    }
    //get all account product
    public Vector<AccountProduct> getAll() {
        Vector<AccountProduct> accountProducts = new Vector<AccountProduct>();
        String sql = "select * from AccountProducts";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                AccountProduct accountProduct = new AccountProduct();
                accountProduct.setAccountProductID(rs.getInt(1));
                accountProduct.setInfoAccount(rs.getString(2));
                accountProduct.setProduct(new ProductDAO().getProductByID(rs.getInt(3)));
                accountProduct.setStatusSell(rs.getBoolean(4));
                accountProduct.setStatus(rs.getBoolean(5));
                accountProduct.setOrderDetail(getOrderDetail(rs.getInt(6)));
                accountProducts.add(accountProduct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return accountProducts;
    }

    //search account product by product name if null or empty then get all
    public Vector<AccountProduct> searchAccountProductByName(String searchName) {
        Vector<AccountProduct> accountProducts = new Vector<AccountProduct>();
        String sql = "select * from AccountProducts where 1=1 ";
        if (searchName != null && !searchName.equals("")) {
            sql += " and AccProductID in (select ProductID from Products where ProductName like '%" + searchName + "%')";
        }
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                AccountProduct accountProduct = new AccountProduct();
                accountProduct.setAccountProductID(rs.getInt(1));
                accountProduct.setInfoAccount(rs.getString(2));
                accountProduct.setProduct(new ProductDAO().getProductByID(rs.getInt(3)));
                accountProduct.setStatusSell(rs.getBoolean(4));
                accountProduct.setStatus(rs.getBoolean(5));
                accountProduct.setOrderDetail(getOrderDetail(rs.getInt(6)));
                accountProducts.add(accountProduct);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return accountProducts;
    }
    //update account product with id, info account,nameproduct, status sell, status, order detail id
    public int updateAccountProduct(int id, String infoAccount, String nameProduct, boolean statusSell, boolean status, int idOrderDetail) {
        int n = 0;
        String sql = "update AccountProducts set InfoAccount = ?, ProductID = ?, StatusSell = ?, Status = ?, OrderDetailID = ? where AccProductID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, infoAccount);
            pre.setInt(2, new ProductDAO().getProductByName(nameProduct).getProductID());
            pre.setBoolean(3, statusSell);
            pre.setBoolean(4, status);
            pre.setInt(5, idOrderDetail);
            pre.setInt(6, id);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    public int updateAccountProduct(AccountProduct accountProduct) {
        int n = 0;
        String sql = "update AccountProducts set InfoAccount = ?, ProductID = ?, StatusSell = ?, Status = ?, OrderDetailID = ? where AccProductID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, accountProduct.getInfoAccount());
            pre.setInt(2, accountProduct.getProduct().getProductID());
            pre.setBoolean(3, accountProduct.isStatusSell());
            pre.setBoolean(4, accountProduct.isStatus());
            pre.setInt(5, accountProduct.getOrderDetail().getOrderDetailID());
            pre.setInt(6, accountProduct.getAccountProductID());
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    //delete account product by id
    public int deleteAccountProduct(int id) {
        int n = 0;
        String sql = "delete from AccountProducts where AccountProductID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    //get account product by id
    public AccountProduct getAccountProduct(int id) {
        AccountProduct accountProduct = new AccountProduct();
        String sql = "select * from AccountProducts where AccountProductID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                accountProduct.setAccountProductID(rs.getInt(1));
                accountProduct.setInfoAccount(rs.getString(2));
                accountProduct.setProduct(new ProductDAO().getProductByID(rs.getInt(3)));
                accountProduct.setStatusSell(rs.getBoolean(4));
                accountProduct.setStatus(rs.getBoolean(5));
                accountProduct.setOrderDetail(getOrderDetail(rs.getInt(6)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return accountProduct;
    }
    //add account product
    public int addAccountProduct(String nameProduct, String infoAccount) {
        int n = 0;
        String sql = "insert into AccountProducts(AccountProductID,InfoAccount,AccProductID,StatusSell,Status) values(?,?,?,0,1)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,getLastIndexAccountProduct()+1);
            pre.setString(2, infoAccount);
            pre.setInt(3, new ProductDAO().getProductByName(nameProduct).getProductID());

            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    //get last index of account product
    public int getLastIndexAccountProduct() {
        int n = 0;
        String sql = "select top 1 AccountProductID from AccountProducts order by AccountProductID desc";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                n = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }










    


}
