package ua.alexkras;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    private final String bundleConstantsName = "StringConstants";

    private final ResourceBundle bundleConstants;

    private final String errorMessage;
    private final String groupNotFoundMessage;

    private final NoteBookDataModel dataModel;

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
