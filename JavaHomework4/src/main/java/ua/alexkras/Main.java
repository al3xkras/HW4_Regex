package ua.alexkras;


import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle(
                "note",new Locale("ua","UA"));
    }
}
