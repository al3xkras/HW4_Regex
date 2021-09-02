package ua.alexkras;

import java.util.ResourceBundle;

public class NoteBookDataModel {
    int currentPositionIndex = 7;

    ResourceBundle bundleRegex,bundleValues;

    public NoteBookDataModel(ResourceBundle bundleRegex, ResourceBundle bundleValues){
        this.bundleRegex = bundleRegex;
        this.bundleValues = bundleValues;
    }

    public String getPositionValueByIndex(int index){
        return bundleValues.getString(NoteStrings.positionPrefix+NoteStrings.PositionNames[index]);
    }
    public String getCurrentValue(){
        return bundleValues.getString(NoteStrings.positionPrefix+NoteStrings.PositionNames[currentPositionIndex]);
    }

    public String getPositionRegexByIndex(int index){
        return bundleRegex.getString(NoteStrings.regexPrefix+NoteStrings.PositionNames[index]);
    }
    public String getCurrentRegex(){
        return bundleRegex.getString(NoteStrings.regexPrefix+NoteStrings.PositionNames[currentPositionIndex]);
    }

    public String getCurrentPositionName(){
        if (hasNextPosition()){
            return NoteStrings.PositionNames[currentPositionIndex];
        }
        return null;
    }

    public void nextPosition(){
        if (currentPositionIndex<NoteStrings.PositionNames.length){
            currentPositionIndex++;
        }
    }

    public boolean hasNextPosition(){
        if (currentPositionIndex<NoteStrings.PositionNames.length){
            return true;
        }
        return false;
    }

}
