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

            int i = model.noteBookDataModel.currentPositionIndex;
            if (i==NoteStrings.INDEX_GROUP) {
                Group g = inputGroup();

                model.note.addPosition(model.noteBookDataModel.getCurrentPositionName(), g.name());
                model.noteBookDataModel.nextPosition();
            } else {
                String input = inputRegexWithScanner(model.noteBookDataModel.getCurrentRegex());

                model.note.addPosition(model.noteBookDataModel.getCurrentPositionName(), input);
                model.noteBookDataModel.nextPosition();
            }
        }

        String fullName = model.generateFullName();
        String fullAddress = model.generateFullAddress();

        model.note.addPosition(NoteStrings.positionFullName,fullName);
        model.note.addPosition(NoteStrings.positionFullAddress,fullAddress);

        model.addNote();
    }

    public Group inputGroup(){
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext()){
            scanner.next();
        }
        String str = scanner.next();

        int i=0;
        for (Group g: Group.values()){
            if (str.equals(g.name())){
                return g;
            }
            i++;
        }

        view.printGroupNotFoundMessage();
        return inputGroup();
    }


}
