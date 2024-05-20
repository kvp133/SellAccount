package dals;

import entities.Cart;
import entities.Item;
import entities.Order;
import entities.OrderHistory;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Vector;

public class OrderDAO extends DbConnect{
    public int getLastIndex(){
        int n = 0;
        String sql = "select max(OrderID) from Orders";
        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if(rs.next()){
                n = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    public int addOrder(int CustomerID){
        int n = 0;
        String sql = "insert into Orders(OrderID, CustomerID, OrderDate,StatusPayment) values(?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, getLastIndex()+1);
            pre.setInt(2, CustomerID);
            pre.setString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
            pre.setBoolean(4, false);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    public int addOrderDetail(int OrderID, int ProductID, int Quantity){
        int n = 0;
        String sql = "insert into OrderDetails(OrderDetailID,OrderID, ProductID, Quantity) values(?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, getLastIndexOrderDetails()+1);
            pre.setInt(2, OrderID);
            pre.setInt(3, ProductID);
            pre.setInt(4, Quantity);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    public int updateOrder(int OrderID, double TotalPrice){
        int n = 0;
        String sql = "update Orders set TotalPrice = ? where OrderID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setDouble(1, TotalPrice);
            pre.setInt(2, OrderID);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    public Order getOrder(int OrderID){
        Order order = new Order();
        String sql = "select * from Orders where OrderID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, OrderID);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                order.setOrderID(rs.getInt(1));
                order.setCustomer(new CustomerDAO().getCustomerByID(rs.getInt(2)));
                order.setOrderDate(rs.getDate(3));
                order.setTotal(rs.getDouble(4));
                order.setStatusPayment(rs.getBoolean(5));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return order;
    }
    //count total orderdetail by orderid
    public int countTotalOrderDetail(int OrderID){
        int n = 0;
        String sql = "select count(*) from OrderDetails where OrderID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, OrderID);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                n = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    //get last index of history order
    public int getLastIndexHistoryOrder(){
        int n = 0;
        String sql = "select max(HistoryID) from OrderHistory";
        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if(rs.next()){
                n = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    //get last index orderdetails
    public int getLastIndexOrderDetails(){
        int n = 0;
        String sql = "select max(OrderDetailID) from OrderDetails";
        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if(rs.next()){
                n = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    //get total price by orderid
    public double getTotalPrice(int OrderID){
        double n = 0;
        String sql = "select TotalPrice from Orders where OrderID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, OrderID);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                n = rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    //get  sub item by orderid
    public int getSubItem(int OrderID){
        int n = 0;
        String sql = "select count(*) from OrderDetails where OrderID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, OrderID);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                n = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    PaymentDAO paymentDAO = new PaymentDAO();
    public int addOrderandOrderLine(Cart cart, int customerID){
        int n = 0;
        int orderID = 0;
        int m = 0;
        if (cart.getSize()>=1) {
            orderID = getLastIndex() + 1;
            m = addOrder(customerID);
            paymentDAO.addHistoryOrder(orderID, "UnPaid");
            //add order history
        }
        if(m > 0) {
            for (Item item : cart.getItems()) {
                addOrderDetail(orderID, item.getProduct().getProductID(), item.getQuantity());
            }
            n++;
            updateOrder(orderID, cart.getTotalPrice());
        }
        return orderID;
    }
    public Vector<OrderHistory> getVectorOrderHistory(int idCustomer){
        Vector<OrderHistory> list = new Vector<>();
        String sql = "select * from OrderHistory where OrderID in (select OrderID from Orders where CustomerID = ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, idCustomer);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                OrderHistory orderHistory = new OrderHistory();
                orderHistory.setHistoryID(rs.getInt(1));
                orderHistory.setOrder(getOrder(rs.getInt(2)));
                orderHistory.setOrderStatus(rs.getString(3));
                orderHistory.setUpdateDate(rs.getDate(4));
                list.add(orderHistory);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public Vector<OrderHistory> getVectorOrderHistoryAdmin(){
        Vector<OrderHistory> list = new Vector<>();
        String sql = "select * from OrderHistory ";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                OrderHistory orderHistory = new OrderHistory();
                orderHistory.setHistoryID(rs.getInt(1));
                orderHistory.setOrder(getOrder(rs.getInt(2)));
                orderHistory.setOrderStatus(rs.getString(3));
                orderHistory.setUpdateDate(rs.getDate(4));
                list.add(orderHistory);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public int deleteOrder(int OrderID){
        int n = 0;
        if(paymentDAO.checkStatusOrderHistory(OrderID)){
            deleteOrderHistory(OrderID);
            String sql = "delete from Orders where OrderID = ?";
            try {
                PreparedStatement pre = conn.prepareStatement(sql);
                pre.setInt(1, OrderID);
                n = pre.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return n;
    }
    public int deleteOrderHistory(int OrderID){
        int n = 0;
        String sql = "delete from OrderHistory where OrderID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, OrderID);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }







}
