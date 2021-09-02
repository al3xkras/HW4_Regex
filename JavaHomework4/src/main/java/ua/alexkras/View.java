package ua.alexkras;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    private final String bundleRegexName = "NoteRegex";
    private final String bundleValuesName = "NotePositionNames";
    private final String bundleConstantsName = "StringConstants";

    public ResourceBundle bundleValues = ResourceBundle.getBundle(
            bundleValuesName,
            new Locale("ua","UA"));

    public ResourceBundle bundleRegex = ResourceBundle.getBundle(
            bundleRegexName,
            new Locale("ua","UA"));

    public ResourceBundle bundleConstants = ResourceBundle.getBundle(
            bundleConstantsName,
            new Locale("ua","UA"));

    public String errorMessage;

    public NoteBookDataModel dataModel;

    public View(){
        dataModel = new NoteBookDataModel(bundleRegex,bundleValues);
        errorMessage = bundleConstants.getString(NoteStrings.errorMessage);
    }

    public void printCurrentPositionMessage(){
        String message = dataModel.getCurrentValue();
        System.out.println(message);
    }

    public void printInvalidDataFormat(){
        System.out.println(errorMessage);
    }


}
