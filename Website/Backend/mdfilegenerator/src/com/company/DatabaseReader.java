package com.company;

import javax.swing.plaf.nimbus.State;
import javax.xml.crypto.Data;
import java.net.ConnectException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseReader {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "my-secret-pw");
        int aop = getAmountOfProducts(con);
        System.out.println(aop);


        DatabaseReader dbreader = new DatabaseReader();
        dbreader.createConnection();

        getAmountOfProducts(con);
        getProductNames(con, aop);
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

        ResultSet rs1 = stmt.executeQuery("SELECT  COUNT(*)FROM products.Products p ");
        int ammountofproducts = 0;

        while(rs1.next()){
            ammountofproducts = rs1.getInt(1);
        }
        return ammountofproducts;
    }

    public static String getProductNames(Connection con, int ammountofproducts) throws SQLException {
        Statement stmt = con.createStatement();
        String[] productnames = new String[ammountofproducts];
        int i = 0;

       ResultSet rs = stmt.executeQuery("SELECT * FROM products.Products p");

        while (rs.next()){
            productnames[i] = rs.getString("name");
            i += 1;
        }

        String newproductname = productnames[productnames.length-1];

        return newproductname;
    }

    public static String getProductDesription(){
        String newproductdescription="";
        return newproductdescription;
    }
}
