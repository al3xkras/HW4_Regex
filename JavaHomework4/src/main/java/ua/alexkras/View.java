package ua.alexkras;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    public String bundleConstantsName = "StringConstants";

    public ResourceBundle bundleConstants;

    public String errorMessage;
    public String groupNotFoundMessage;

    public NoteBookDataModel dataModel;

    public View(NoteBookDataModel dataModel, Locale locale){
        this.dataModel = dataModel;

        this.bundleConstants = ResourceBundle.getBundle(
                bundleConstantsName,
                locale);
        errorMessage = bundleConstants.getString(NoteStrings.errorMessage);
        groupNotFoundMessage  = bundleConstants.getString(NoteStrings.groupNotFoundMessage);
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

    public void printGroupNotFoundMessage(){
        System.out.println(groupNotFoundMessage);
    }

}
