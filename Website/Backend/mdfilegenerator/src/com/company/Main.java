package com.company;
import java.awt.desktop.ScreenSleepEvent;
import java.io.*;
import java.util.Scanner;
import static java.sql.DriverManager.println;

public class Main {

    public static void main(String[] args) throws IOException {
        String fs ="";
        String fileContent = fileReader(fs);
        String newfileContent = SearchAndReplace(fileContent);

        System.out.println(newfileContent);
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

    public static String SearchAndReplace (String fc){
        String name = "Schweinefleisch";
        String price = "22,50";
        fc = fc.replace("%%TITLE%%", name);
        fc = fc.replace("%%PRICE%%", price);
        return fc;
    }
}
