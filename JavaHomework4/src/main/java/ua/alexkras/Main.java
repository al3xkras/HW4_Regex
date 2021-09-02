package ua.alexkras;


import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    private static final String bundleRegexName = "NoteRegex";
    private static final String bundleValuesName = "NoteValues";

    public static final Locale locale = new Locale("ua","UA");

    public static final ResourceBundle bundleValues = ResourceBundle.getBundle(
            bundleValuesName, locale);

    public static final ResourceBundle bundleRegex = ResourceBundle.getBundle(
            bundleRegexName, locale);

    public static final NoteBookDataModel noteBookDataModel = new NoteBookDataModel(bundleRegex,bundleValues);
    public static final NoteBook noteBook = new NoteBook();

    public static void main(String[] args) {

        final Model model = new Model(noteBook,noteBookDataModel);
        final View view= new View(noteBookDataModel,locale);
        final Controller controller = new Controller(model,view);

        controller.inputNewNote();

        model.note.printNote();
    }
}
