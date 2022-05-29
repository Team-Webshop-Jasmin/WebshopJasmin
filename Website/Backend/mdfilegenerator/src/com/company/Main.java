package com.company;
import java.awt.desktop.ScreenSleepEvent;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static java.sql.DriverManager.getConnection;
import static java.sql.DriverManager.println;
import com.company.DatabaseReader;

import javax.xml.crypto.Data;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        String fs ="";
        String fileContent = fileReader(fs);
        String newfileContent = SearchAndReplace(fileContent);

        fileWriter(newfileContent);
    }

    public static String fileReader(String fc) throws FileNotFoundException {
        File file = new File("mdtemplate.md");
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            fc = fc.concat(scan.nextLine() + "\n");
        }

        return fc;
    }
    public static Writer fileWriter(String fileContent) throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\willi\\Desktop\\Schule\\SYP\\Project Repo\\Website\\jasminsweets_ws\\content\\products\\newproduct.md");

        writer.write(fileContent);
        writer.close();
        return writer;
    }

    public static String SearchAndReplace (String fc) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "my-secret-pw");

        int ammountofproducts = DatabaseReader.getAmountOfProducts(con);
        String name = DatabaseReader.getProductNames(con, ammountofproducts);
        String price = DatabaseReader.getProductPrice(con,ammountofproducts);
        System.out.println(name);
        System.out.println(price);


        String description ="Eine Mischung an Baklava von bester Qualität. Sie haben die Möglichkeit die verschiedenen Spezialitäten vorort zu probieren und sich selbst zu überzeugen. Lassen Sie sich von einer Mischung an feinsten Baklavasorten überraschen.";
        fc = fc.replace("%%TITLE%%", name);
        fc = fc.replace("%%PRICE%%", price);
        fc = fc.replace("%%DESCRIPTION%%", description);
        return fc;
    }
}
