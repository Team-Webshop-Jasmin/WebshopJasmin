package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import static java.sql.DriverManager.println;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("mdtemplate.md");
        String fileContent = "";
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            fileContent = fileContent.concat(scan.nextLine() + "\n");
        }

        FileWriter writer = new FileWriter("newproduct.md");
        writer.write(fileContent);
        writer.close();
    }
}
