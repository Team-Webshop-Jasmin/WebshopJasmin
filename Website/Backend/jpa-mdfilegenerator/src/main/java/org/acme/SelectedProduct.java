package org.acme;
import java.io.IOException;

public class SelectedProduct {
    public static int selectedproduct;

    static {
        try {
            selectedproduct = Main.selectProductToAdd();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}