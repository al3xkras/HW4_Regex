package ua.alexkras;


import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    private static final String bundleRegexName = "NoteRegex";
    private static final String bundleValuesName = "NotePositionNames";

    public static final Locale locale = new Locale("ua","UA");

    public static final ResourceBundle bundleValues = ResourceBundle.getBundle(
            bundleValuesName, locale);

    public static final ResourceBundle bundleRegex = ResourceBundle.getBundle(
            bundleRegexName, locale);

    public static final NoteBookDataModel noteBookDataModel = new NoteBookDataModel(bundleRegex,bundleValues);
    public static final NoteBook noteBook = new NoteBook();

    public static final Model model = new Model(noteBook,noteBookDataModel);

    public static final View view= new View(noteBookDataModel,locale);

    public static final Controller controller = new Controller(model,view);

    public static void main(String[] args) {
        controller.inputNewNote();

        model.note.printNote();

    }
}
