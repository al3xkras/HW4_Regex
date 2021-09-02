package ua.alexkras;


import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    private static final String bundleRegexName = "NoteRegex";
    private static final String bundleValuesName = "NotePositionNames";

    public static final Locale locale = new Locale("ua","UA");

    public static ResourceBundle bundleValues = ResourceBundle.getBundle(
            bundleValuesName,
            locale);

    public static ResourceBundle bundleRegex = ResourceBundle.getBundle(
            bundleRegexName,
            locale);

    public static NoteBookDataModel noteBookDataModel = new NoteBookDataModel(bundleRegex,bundleValues);
    public static NoteBook noteBook = new NoteBook();

    public static Model model = new Model(noteBook,noteBookDataModel);

    public static View view= new View(noteBookDataModel,locale);

    public static Controller controller = new Controller(model,view);

    public static void main(String[] args) {
        controller.inputNewNote();
    }
}
