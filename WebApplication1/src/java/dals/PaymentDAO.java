package dals;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAO extends DbConnect {
    AccountProductDAO accProduct = new AccountProductDAO();
    //check amount of money in account when paid
    public boolean checkAmountOfMoney(int idAccount, double total) {
        boolean check = false;
        String sql = "select CurrentBalance from Customers where CustomerID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, idAccount);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                if (rs.getDouble(1) >= total) {
                    check = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return check;
    }

    //update amount of money in account when paid
    public int updateAmountOfMoney(int idAccount, double total) {
        int n = 0;
        String sql = "update Customers set CurrentBalance = CurrentBalance - ? where CustomerID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setDouble(1, total);
            pre.setInt(2, idAccount);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    //update status payment when paid
    public int updateStatusPayment(int idOrder) {
        int n = 0;
        String sql = "update Orders set StatusPayment = 1 where OrderID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, idOrder);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    //add history order when paid
    public int addHistoryOrder(int idOrder, String OrderStatus) {
        //check id order exist in orderhistory or not
        int n = 0;
        String sqlCheck = "select * from OrderHistory where OrderID = ?";
        boolean check = false;
        try {
            PreparedStatement pre = conn.prepareStatement(sqlCheck);
            pre.setInt(1, idOrder);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                check = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    if (!check) {
        String sql = "insert into OrderHistory(HistoryID, OrderID, OrderStatus, UpdateDate,Status) values(?,?,?,?,0)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, getLastHistoryID()+1);
            pre.setInt(2, idOrder);
            pre.setString(3, OrderStatus);
            pre.setDate(4, new Date(System.currentTimeMillis()));
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


        return n;
    }
    //update history order when paid
    public int updateHistoryOrder(int idOrder, String OrderStatus) {
        int n = 0;
        String sql = "update OrderHistory set OrderStatus = ?, UpdateDate = ? where OrderID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, OrderStatus);
            pre.setDate(2, new Date(System.currentTimeMillis()));
            pre.setInt(3, idOrder);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    //get last history id
    public int getLastHistoryID() {
        int n = 0;
        String sql = "select max(HistoryID) from OrderHistory";
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
    //update orderstatus of OrderHistory when paid
    public int updateOrderStatus(int idOrder, String orderStatus) {
        int n = 0;
        String sql = "update OrderHistory set OrderStatus = ? where OrderID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, orderStatus);
            pre.setInt(2, idOrder);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }


    //get total price of order un paid by id customer
    public double getTotalPriceOrderUnPaid(int idCustomer, int idOrder) {
        double total = 0;
        String sql = "select TotalPrice from Orders where CustomerID = ? and OrderID = ? and StatusPayment = 0";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, idCustomer);
            pre.setInt(2, idOrder);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                total = rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return total;

    }
    //update account product status sold when paid
    public int updateAccountProductStatusSell(int idOrders) {
        return accProduct.updateAccountProductStatusSell(idOrders);
    }
    //check total account product stock or not in order by id order
    public boolean checkTotalAccountProductStock(int idOrder) {
        return accProduct.checkTotalAccountProductStock(idOrder);
    }
    //check status Order History by id order
    public boolean checkStatusOrderHistory(int idOrder) {
        boolean check = false;
        String sql = "select OrderStatus from OrderHistory where OrderID = ? AND OrderStatus = 'Paid'";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, idOrder);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    check = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return check;
    }





}