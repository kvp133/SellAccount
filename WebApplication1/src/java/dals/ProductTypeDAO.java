package dals;

import entities.ProductType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class ProductTypeDAO extends DbConnect{
    //write method insert, update, delete, getAll
    public int insertProductType(ProductType productType){
        int n = 0;
        String sql = "insert into [dbo].[ProductTypes]\n" +
                "           ([ProductTypeID]\n" +
                "           ,[TypeName]\n" +
                "           ,[Status]) values(?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, productType.getProductTypeID());
            pre.setString(2, productType.getTypeName());
            pre.setBoolean(3, productType.isStatus());
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public int updateProductType(ProductType productType){
        int n = 0;
        String sql = "update ProductTypes set TypeName = ?, Status = ? where ProductTypeID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, productType.getTypeName());
            pre.setBoolean(2, productType.isStatus());
            pre.setInt(3, productType.getProductTypeID());
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public int deleteProductType(int productTypeID){
        int n = 0;
        String sql = "delete from ProductTypes where ProductTypeID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, productTypeID);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public Vector<ProductType> getAllProductType(){
        Vector<ProductType> list = new Vector<ProductType>();
        String sql = "select * from ProductTypes";
        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                ProductType productType = new ProductType();
                productType.setProductTypeID(rs.getInt(1));
                productType.setTypeName(rs.getString(2));
                productType.setStatus(rs.getBoolean(3));
                list.add(productType);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ProductType getProductTypeByID(int productTypeID){
        ProductType productType = new ProductType();
        String sql = "select * from ProductTypes where ProductTypeID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, productTypeID);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                productType.setProductTypeID(rs.getInt(1));
                productType.setTypeName(rs.getString(2));
                productType.setStatus(rs.getBoolean(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return productType;
    }
    public ProductType getProductTypeByName(String productTypeName){
        ProductType productType = new ProductType();
        String sql = "select * from ProductTypes where TypeName = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, productTypeName);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                productType.setProductTypeID(rs.getInt(1));
                productType.setTypeName(rs.getString(2));
                productType.setStatus(rs.getBoolean(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return productType;
    }

//    public static void main(String[] args) {
//        ProductTypeDAO abc = new ProductTypeDAO();
//        for(ProductType c: abc.getAllProductType()){
//            System.out.println(c.getTypeName());
//        }
//        
//    }

}
