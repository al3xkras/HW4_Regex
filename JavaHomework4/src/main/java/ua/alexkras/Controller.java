package ua.alexkras;


import ua.alexkras.exception.NoteBookLoginExistsException;

import java.util.Scanner;

public class Controller {
    private final Model model;
    public Model getModel(){return model;}

    private final View view;
    public View getView(){return view;}

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    /**
     * Await user input, and check, if it matches particular regex
     * @param regex required regular expression
     * @throws java.util.regex.PatternSyntaxException – if the regular expression's syntax is invalid
     * @return Input string, that matches regex.
     */
    public String inputRegexWithScanner(String regex){
        String output;
        Scanner scanner = new Scanner(System.in);
        while (!(scanner.hasNext() && (output = scanner.next()).matches(regex))){
            view.printInvalidDataFormat();
        }
        return output;
    }

    public void inputNewNote(){
        model.newNote();

        while (model.getNoteBookDataModel().hasNextPosition()){
            view.printCurrentPositionMessage();
            view.printCurrentPositionRegex();

            int i = model.getNoteBookDataModel().getCurrentPositionIndex();
            if (i==NoteStrings.INDEX_GROUP) {
                Group g = inputGroup();

                model.getNote().addPosition(model.getNoteBookDataModel().getCurrentPositionName(), g.name());
            } else {
                String input = inputRegexWithScanner(model.getNoteBookDataModel().getCurrentRegex());

                model.getNote().addPosition(model.getNoteBookDataModel().getCurrentPositionName(), input);
            }

            model.getNoteBookDataModel().nextPosition();
        }

        String fullName = model.generateFullName();
        String fullAddress = model.generateFullAddress();

        model.getNote().addPosition(NoteStrings.positionFullName,fullName);
        model.getNote().addPosition(NoteStrings.positionFullAddress,fullAddress);


        try {
            model.addNote();
        } catch (NoteBookLoginExistsException e){
            String key = NoteStrings.positionNames[NoteStrings.INDEX_LOGIN];

            String invalidLogin = model.getNote().getPositionByKey(key);
            String newLogin = invalidLogin;


            while (model.getNoteBook().containsNoteWithLogin(newLogin)) {
                view.printLoginExistsMessage();
                view.print(model.getNoteBookDataModel().getValueByIndex(NoteStrings.INDEX_LOGIN));

                newLogin = inputRegexWithScanner(
                        model.getNoteBookDataModel().getRegexByIndex(NoteStrings.INDEX_LOGIN));
            }

            model.getNote().addPosition(key,newLogin);

            model.getNoteBook().forceAddNote(model.getNote());
        }
    }

    public Group inputGroup(){
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext()){
            scanner.next();
        }
        String str = scanner.next();

        for (Group g: Group.values()){
            if (str.equals(g.name())){
                return g;
            }
        }

        view.printGroupNotFoundMessage();
        return inputGroup();
    }


}
