/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author KieuVietPhuoc
 */
public class Admin {

    private int adminID;
    private String username;
    private String passwordHash;
    private boolean status;

    public Admin(int adminID, String username, String passwordHash, boolean status) {
        this.adminID = adminID;
        this.username = username;
        this.passwordHash = passwordHash;
        this.status = status;
    }

    // Getter and setter methods
    public Admin() {
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
