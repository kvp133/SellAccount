package dals;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import entities.Customer;


public class CustomerDAO extends DbConnect {
    //write method insert, update, delete, select
    public int insertCustomer(Customer customer) {
        int n = 0;
        String sql = "insert into Customers(username, password, firstName, lastName, email, avturl, currentBalance, status) values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, customer.getUsername());
            pre.setString(2, customer.getPassword());
            pre.setString(3, customer.getFirstName());
            pre.setString(4, customer.getLastName());
            pre.setString(5, customer.getEmail());
            pre.setString(6, customer.getAvturl());
            pre.setDouble(7, customer.getCurrentBalance());
            pre.setBoolean(8, customer.isStatus());
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    //last index id
    public int getLastIndex(){
        int n = 0;
        String sql = "select max(customerID) from Customers";
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
    //insert customer
    public int insertCustomer(String firstName, String lastName, String email, String username, String password) {
        int n = 0;
        String sql = "insert into Customers(CustomerID,username, password, firstName, lastName, email, urlavt, currentBalance, status) values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, getLastIndex()+1);
            pre.setString(2, username);
            pre.setString(3, password);
            pre.setString(4, firstName);
            pre.setString(5, lastName);
            pre.setString(6, email);
            pre.setString(7, "./assets/img/avatar/avt1.png");
            pre.setDouble(8, 0);
            pre.setBoolean(9, true);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    public Customer getCustomerByID(int customerID){
        Customer customer = null;
        String sql = "select * from Customers where customerID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, customerID);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getBoolean(9));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return customer;
    }

    public int updateCustomer(Customer customer) {
        int n = 0;
        String sql = "update Customers set username = ?, password = ?, firstName = ?, lastName = ?, email = ?, avturl = ?, currentBalance = ?, status = ? where customerID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, customer.getUsername());
            pre.setString(2, customer.getPassword());
            pre.setString(3, customer.getFirstName());
            pre.setString(4, customer.getLastName());
            pre.setString(5, customer.getEmail());
            pre.setString(6, customer.getAvturl());
            pre.setDouble(7, customer.getCurrentBalance());
            pre.setBoolean(8, customer.isStatus());
            pre.setInt(9, customer.getCustomerID());
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public int deleteCustomer(int customerID) {
        int n = 0;
        String sql = "delete from Customers where customerID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, customerID);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public Vector<Customer> getAllCumstomer() {
        Vector<Customer> customers = new Vector<Customer>();
        String sql = "select * from Customers";
        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                Customer customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getBoolean(9));
                customers.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return customers;
    }
    //write get customer using email and password
    public Customer getCustomerByEmail(String email,String password){
        Customer customer = null;
        String sql = "select * from Customers where email = ? and password = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getBoolean(9));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return customer;
    }
    //write get customer using username and password
    public Customer getCustomerByUsername(String username,String password){
        Customer customer = null;
        String sql = "select * from Customers where username = ? and password = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getBoolean(9));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return customer;
    }

    //write check valid email
    public boolean checkEmail(String email){
        boolean check = false;
        String sql = "select * from Customers where email = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, email);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                check = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return check;
    }
    //write check valid username
    public boolean checkUsername(String username){
        boolean check = false;
        String sql = "select * from Customers where username = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, username);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                check = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return check;
    }
    //update current balance
    public int updateCurrentBalance(int customerID, double amount){
        int n = 0;
        String sql = "update Customers set currentBalance = ? where customerID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setDouble(1, amount);
            pre.setInt(2, customerID);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    //update information of customer
    public int updateInformation(int customerID, String firstName, String lastName, String email){
        int n = 0;
        String sql = "update Customers set firstName = ?, lastName = ?, email = ? where customerID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, firstName);
            pre.setString(2, lastName);
            pre.setString(3, email);
            pre.setInt(4, customerID);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    //check valid password
    public boolean checkPassword(int customerID, String password){
        boolean check = false;
        String sql = "select * from Customers where customerID = ? and password = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, customerID);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                check = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return check;
    }
    //update password
    public int updatePassword(int customerID, String password){
        int n = 0;
        String sql = "update Customers set password = ? where customerID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, password);
            pre.setInt(2, customerID);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    //edit customer
    public int editCustomer(Customer customer) {
        int n = 0;
        String sql = "update Customers set Username = ?, Password = ?, FirstName = ?, LastName = ?, Email = ?, Urlavt = ?, CurrentBalance = ?, Status = ? where CustomerID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, customer.getUsername());
            pre.setString(2, customer.getPassword());
            pre.setString(3, customer.getFirstName());
            pre.setString(4, customer.getLastName());
            pre.setString(5, customer.getEmail());
            pre.setString(6, "./assets/img/avatar/avatar-1.png");
            pre.setDouble(7, customer.getCurrentBalance());
            pre.setBoolean(8, true);
            pre.setInt(9, customer.getCustomerID());
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    //search customer by id or name if id null  return all customer
    public Vector<Customer> searchCustomer(String id) {
        Vector<Customer> customers = new Vector<>();
        String sql = "SELECT * FROM Customers WHERE 1=1";
        if (id != null && !id.isEmpty()) {
            sql += " AND CustomerID = ?";
        }
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            if (id != null && !id.isEmpty()) {
                pre.setString(1, id);
            }
            try (ResultSet rs = pre.executeQuery()) {
                while (rs.next()) {
                    Customer customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getBoolean(9));
                    customers.add(customer);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return customers;
    }


}