package ua.alexkras;


import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    private static final String bundleRegexName = "NoteRegex";
    private static final String bundleValuesName = "NoteValues";

    private static final Locale locale = new Locale("ua","UA");

    private static final ResourceBundle bundleValues = ResourceBundle.getBundle(
            bundleValuesName, locale);

    private static final ResourceBundle bundleRegex = ResourceBundle.getBundle(
            bundleRegexName, locale);

    private static final NoteBookDataModel noteBookDataModel = new NoteBookDataModel(bundleRegex,bundleValues);
    private static final NoteBook noteBook = new NoteBook();

    public static void main(String[] args) {

        final Model model = new Model(noteBook,noteBookDataModel);
        final View view= new View(noteBookDataModel,locale);
        final Controller controller = new Controller(model,view);

        controller.inputNewNote();

        model.getNote().printNote();
    }
}
