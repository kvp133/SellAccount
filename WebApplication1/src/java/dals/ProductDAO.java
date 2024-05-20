package dals;

import entities.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class ProductDAO extends DbConnect {
    //write method insert, update, delete, getAll
    public int insertProduct(Product product) {
        int n = 0;
        String sql = "insert into[dbo].[Products]\n" +
                "           ([ProductID]\n" +
                "           ,[ProductName]\n" +
                "           ,[Price]\n" +
                "           ,[ThumbnailURL]\n" +
                "           ,[Description]\n" +
                "           ,[ProductTypeID]\n" +
                "           ,[ProductFavorites]\n" +
                "           ,[Status]) " +
                "values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, product.getProductID());
            pre.setString(2, product.getProductName());
            pre.setDouble(3, product.getPrice());
            pre.setString(4, product.getThumbnailURL());
            pre.setString(5, product.getDescription());
            pre.setInt(6, product.getProductType().getProductTypeID());
            pre.setBoolean(7, product.isProductFavorite());
            pre.setBoolean(8, product.isStatus());
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public int updateProduct(Product product) {
        int n = 0;
        String sql = "update Products set ProductName = ?, Price = ?, ThumbnailURL = ?, Description = ?, ProductTypeID = ?, ProductFavorites = ?, Status = ? where ProductID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, product.getProductName());
            pre.setDouble(2, product.getPrice());
            pre.setString(3, product.getThumbnailURL());
            pre.setString(4, product.getDescription());
            pre.setInt(5, product.getProductType().getProductTypeID());
            pre.setBoolean(6, product.isProductFavorite());
            pre.setBoolean(7, product.isStatus());
            pre.setInt(8, product.getProductID());
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public int deleteProduct(int productID) {
        int n = 0;
        String sql = "delete from Products where ProductID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, productID);
            n = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    public Vector<Product> getProductByProductTypeID(int productTypeID) {
        Vector<Product> list = new Vector<>();
        String sql = "select * from Products where ProductTypeID 1=1";
        if (productTypeID != 0) {
            sql += " and ProductTypeID = ?";
        }
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, productTypeID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setThumbnailURL(rs.getString(4));
                product.setDescription(rs.getString(5));
                product.setProductType(new ProductTypeDAO().getProductTypeByID(rs.getInt(6)));
                product.setProductFavorite(rs.getBoolean(7));
                product.setStatus(rs.getBoolean(8));
                list.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Vector<Product> getAllProduct() {
        Vector<Product> list = new Vector<>();
        String sql = "select * from Products";
        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setThumbnailURL(rs.getString(4));
                product.setDescription(rs.getString(5));
                product.setProductType(new ProductTypeDAO().getProductTypeByID(rs.getInt(6)));
                product.setProductFavorite(rs.getBoolean(7));
                product.setStatus(rs.getBoolean(8));
                list.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    //search Product contain searchName and price between minPrice and maxPrice if null then get all
    public Vector<Product> searchProduct(String searchName, int minPrice, int maxPrice) {
        Vector<Product> list = new Vector<>();
        String sql = "select * from Products where 1=1 ";
        if (searchName != null && !searchName.equals("")) {
            sql += " and ProductName like '%"+searchName+"%'";
        }
        if (minPrice != 0) {
            sql += " and Price >= "+minPrice;
        }
        if (maxPrice != 0) {
            sql += " and Price <= "+maxPrice;
        }

        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setThumbnailURL(rs.getString(4));
                product.setDescription(rs.getString(5));
                product.setProductType(new ProductTypeDAO().getProductTypeByID(rs.getInt(6)));
                product.setProductFavorite(rs.getBoolean(7));
                product.setStatus(rs.getBoolean(8));
                list.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public Product getProductByID(int productID) {
        Product product = new Product();
        String sql = "select * from Products where ProductID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, productID);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                product.setProductID(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setThumbnailURL(rs.getString(4));
                product.setDescription(rs.getString(5));
                product.setProductType(new ProductTypeDAO().getProductTypeByID(rs.getInt(6)));
                product.setProductFavorite(rs.getBoolean(7));
                product.setStatus(rs.getBoolean(8));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return product;
    }
    //search product by product name if null or empty then get all
    public Vector<Product> searchProductByName(String searchName) {
        Vector<Product> list = new Vector<>();
        String sql = "select * from Products where 1=1 ";
        if (searchName != null && !searchName.equals("")) {
            sql += " and ProductName like '%"+searchName+"%'";
        }
        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setThumbnailURL(rs.getString(4));
                product.setDescription(rs.getString(5));
                product.setProductType(new ProductTypeDAO().getProductTypeByID(rs.getInt(6)));
                product.setProductFavorite(rs.getBoolean(7));
                product.setStatus(rs.getBoolean(8));
                list.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public int getLastProductID(){
        int n = 0;
        String sql = "select max(ProductID) from Products";
        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                n = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }
    //get product by product name
    public Product getProductByName(String productName) {
        Product product = new Product();
        String sql = "select * from Products where ProductName = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, productName);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                product.setProductID(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setThumbnailURL(rs.getString(4));
                product.setDescription(rs.getString(5));
                product.setProductType(new ProductTypeDAO().getProductTypeByID(rs.getInt(6)));
                product.setProductFavorite(rs.getBoolean(7));
                product.setStatus(rs.getBoolean(8));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return product;
    }
    //get product sort asc by price
    public Vector<Product> getProductSortAscByPrice() {
        Vector<Product> list = new Vector<>();
        String sql = "select * from Products order by Price asc";
        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt(1));
                product.setProductName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setThumbnailURL(rs.getString(4));
                product.setDescription(rs.getString(5));
                product.setProductType(new ProductTypeDAO().getProductTypeByID(rs.getInt(6)));
                product.setProductFavorite(rs.getBoolean(7));
                product.setStatus(rs.getBoolean(8));
                list.add(product);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }



}
