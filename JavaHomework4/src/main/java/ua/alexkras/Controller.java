package ua.alexkras;


import java.util.Scanner;

public class Controller {
    public Model model;
    public View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

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

            model.noteBookDataModel.nextPosition();

            model.note.addPosition(model.noteBookDataModel.getCurrentPositionName(),input);

        }

        model.addNote();
    }


}
