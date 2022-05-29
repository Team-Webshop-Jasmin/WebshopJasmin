package com.company;

import javax.swing.plaf.nimbus.State;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseReader {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "my-secret-pw");
    }

    public static void createConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "my-secret-pw");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseReader.class.getName()).log(Level.SEVERE,null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int getAmountOfProducts(Connection con) throws SQLException {
        Statement stmt = con.createStatement();

        ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*)FROM products.Products p ");
        int ammountofproducts = 0;

        while(rs1.next()){
            ammountofproducts = rs1.getInt(1);
        }
        return ammountofproducts;
    }

    public static String[] getProductNames(Connection con, int ammountofproducts) throws SQLException {
        Statement stmt = con.createStatement();
        String[] productnames = new String[ammountofproducts];
        String newproductname ="";
        int i = 0;

       ResultSet rs = stmt.executeQuery("SELECT * FROM products.Products p");

        while (rs.next()){
            productnames[i] = rs.getString("name");
            i += 1;
        }

        return productnames;
    }

    public static String getNameOfNewProduct(Connection con, int ammountofproducts) throws SQLException {
        Statement stmt = con.createStatement();
        String[] productnames = new String[ammountofproducts];
        String newproductname ="";
        int i = 0;

        ResultSet rs = stmt.executeQuery("SELECT * FROM products.Products p");

        while (rs.next()){
            productnames[i] = rs.getString("name");
            i += 1;
        }

        newproductname  = productnames[SelectedProduct.selectedproduct];

        return newproductname;
    }

    public static String getPriceOfNewProduct(Connection con, int ammountofproducts) throws SQLException {
        Statement stmt = con.createStatement();
        String[] productprices = new String[ammountofproducts];
        String newproductprice ="";
        int i = 0;

        ResultSet rs = stmt.executeQuery("SELECT * FROM products.Products p");

        while (rs.next()){
            productprices[i] = rs.getString("price");
            i += 1;
        }

        newproductprice = productprices[SelectedProduct.selectedproduct];

        return newproductprice;
    }

    public static String getDescriptionOfNewProduct(Connection con, int ammountofproducts) throws SQLException {
        Statement stmt = con.createStatement();
        String[] productdescriptions = new String[ammountofproducts];
        String newproductdescription ="";
        int i = 0;

        ResultSet rs = stmt.executeQuery("SELECT * FROM products.Products p");

        while (rs.next()){
            productdescriptions[i] = rs.getString("description");
            i += 1;
        }

        newproductdescription = productdescriptions[SelectedProduct.selectedproduct];

        return newproductdescription;
    }
}
