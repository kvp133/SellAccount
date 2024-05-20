package dals;


import entities.Admin;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @KieuVietPhuoc
 */



public class AdminDAO extends DbConnect{
    //write insert, update, delete, select methods here
    public int addAdmin(Admin item){
        int n = 0;
        //write code here
        String sql = "INSERT INTO Admin VALUES(?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, item.getAdminID());
            pre.setString(2, item.getUsername());
            pre.setString(3, item.getPasswordHash());
            pre.setBoolean(4, item.isStatus());
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error addAdmin: " + e);
        }
        return n;
    }
    public int updateAdmin(Admin item){
        int n = 0;
        //write code here
        String sql = "UPDATE Admin SET username = ?, passwordHash = ?, status = ? WHERE adminID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, item.getUsername());
            pre.setString(2, item.getPasswordHash());
            pre.setBoolean(3, item.isStatus());
            pre.setInt(4, item.getAdminID());
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updateAdmin: " + e);
        }
        return n;
    }
    public int deleteAdmin(int adminID){
        int n = 0;
        //write code here
        String sql = "DELETE FROM Admin WHERE adminID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, adminID);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleteAdmin: " + e);
        }
        return n;
    }
    public boolean checkAdmin(String username, String password){
        boolean check = false;
        //write code here
        String sql = "SELECT * FROM Admin WHERE username = ? AND passwordHash = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            if(pre.executeQuery().next()){
                check = true;
            }
        } catch (SQLException e) {
            System.out.println("Error checkAdmin: " + e);
        }
        return check;
    }
}
