package ua.alexkras;


import java.util.Scanner;

public class Controller {
    public Model model;
    public View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    /**
     * Await user input, and check, if it matches particular regex
     * @param regex required regular expression
     * @throws java.util.regex.PatternSyntaxException – if the regular expression's syntax is invalid
     * @return String, that matches regex.
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

        while (model.noteBookDataModel.hasNextPosition()){
            view.printCurrentPositionMessage();
            view.printCurrentPositionRegex();

            String input = inputRegexWithScanner(model.noteBookDataModel.getCurrentRegex());

            model.note.addPosition(model.noteBookDataModel.getCurrentPositionName(),input);
            model.noteBookDataModel.nextPosition();
        }

        String fullName = model.generateFullName();
        String fullAddress = model.generateFullAddress();

        model.note.addPosition(NoteStrings.positionFullName,fullName);
        model.note.addPosition(NoteStrings.positionFullAddress,fullAddress);

        model.addNote();
    }


}
