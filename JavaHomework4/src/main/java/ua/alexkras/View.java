package ua.alexkras;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    public String bundleConstantsName = "StringConstants";

    public ResourceBundle bundleConstants;

    public String errorMessage;

    public NoteBookDataModel dataModel;

    public View(NoteBookDataModel dataModel, Locale locale){
        this.dataModel = dataModel;

        this.bundleConstants = ResourceBundle.getBundle(
                bundleConstantsName,
                locale);
        errorMessage = bundleConstants.getString(NoteStrings.errorMessage);
    }

    public void printCurrentPositionMessage(){
        String message = dataModel.getCurrentValue();
        System.out.println(message);
    }

    public void printCurrentPositionRegex(){
        String message = dataModel.getCurrentRegex();
        System.out.println(message);
    }

    public void printInvalidDataFormat(){
        System.out.println(errorMessage);
    }


}
