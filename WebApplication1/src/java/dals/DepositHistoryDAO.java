package dals;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepositHistoryDAO extends DbConnect{
    public int getLastDepositHistoryID(){
        int n = 0;
        String sql = "select top 1 HistoryID from DepositHistory order by HistoryID desc";
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
    public int addDepositHistory(int customerID, double amount){
        int n = 0;
        String sql = "insert into DepositHistory values(?,?, ?, GETDATE(),?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, getLastDepositHistoryID()+1);
            pre.setInt(2, customerID);
            pre.setDouble(3, amount);
            pre.setBoolean(4, true);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    //method get total profit
    public double getTotalProfit(){
        double total = 0;
        String sql = "select sum(Amount) from DepositHistory where Status = 1";
        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            if(rs.next()){
                total = rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return total;
    }
    //method get total profit by month
    public double getTotalProfitByMonth(int month){
        double total = 0;
        String sql = "select sum(Amount) from DepositHistory where Status = 1 and MONTH(Date) = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, month);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                total = rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return total;
    }
    //method get total profit by year
    public double getTotalProfitByYear(int year){
        double total = 0;
        String sql = "select sum(Amount) from DepositHistory where Status = 1 and YEAR(Date) = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, year);
            ResultSet rs = pre.executeQuery();
            if(rs.next()){
                total = rs.getDouble(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return total;
    }

}
