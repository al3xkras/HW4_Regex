package ua.alexkras;


import ua.alexkras.exception.NoteBookLoginExistsException;

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

    public static void main(String[] args) throws NoteBookLoginExistsException {

        final Model model = new Model(noteBook,noteBookDataModel);
        final View view= new View(noteBookDataModel,locale);
        final Controller controller = new Controller(model,view);

        String key = NoteStrings.positionNames[NoteStrings.INDEX_LOGIN];

        String login = "myLogin";
        Note note = new Note();
        note.addPosition(key,login);

        model.getNoteBook().addNote(note);
        System.out.println("(NoteBook contains note with skype login \""+login+"\")\n");

        controller.inputNewNote();

        model.getNote().printNote();
    }
}
