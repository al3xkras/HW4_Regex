package ua.alexkras;

import java.util.ResourceBundle;

public class NoteBookDataModel {
    int currentPositionIndex = 0;

    ResourceBundle bundle;

    public NoteBookDataModel(ResourceBundle bundle){
        this.bundle = bundle;
    }

    public String getPositionValueByIndex(int index){
        return bundle.getString(NoteStrings.positionPrefix+NoteStrings.PositionNames[index]);
    }
    public String getCurrentValue(){
        return bundle.getString(NoteStrings.positionPrefix+NoteStrings.PositionNames[currentPositionIndex]);
    }

    public String getPositionRegexByIndex(int index){
        return bundle.getString(NoteStrings.regexPrefix+NoteStrings.PositionNames[index]);
    }
    public String getCurrentRegex(){
        return bundle.getString(NoteStrings.regexPrefix+NoteStrings.PositionNames[currentPositionIndex]);
    }

    public boolean nextPosition(){
        if (currentPositionIndex<NoteStrings.PositionNames.length){
            currentPositionIndex++;
        } else {
            return false;
        }
        return true;
    }

}
