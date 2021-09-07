package ua.alexkras;

import java.util.ResourceBundle;

public class NoteBookDataModel {
    private int currentPositionIndex = 0;
    public int getCurrentPositionIndex(){return currentPositionIndex;}

    private final ResourceBundle bundleRegex,bundleValues;

    public NoteBookDataModel(ResourceBundle bundleRegex, ResourceBundle bundleValues){
        this.bundleRegex = bundleRegex;
        this.bundleValues = bundleValues;
    }

    public String getCurrentValue(){
        return bundleValues.getString(NoteStrings.positionPrefix+NoteStrings.positionNames[currentPositionIndex]);
    }

    public String getValueByIndex(int index){
        return bundleValues.getString(NoteStrings.positionPrefix+NoteStrings.positionNames[index]);
    }

    public String getCurrentRegex(){
        return bundleRegex.getString(NoteStrings.regexPrefix+NoteStrings.positionNames[currentPositionIndex]);
    }

    public String getRegexByIndex(int index){
        return bundleRegex.getString(NoteStrings.regexPrefix+NoteStrings.positionNames[index]);
    }

    public String getCurrentPositionName(){
        if (hasNextPosition()){
            return NoteStrings.positionNames[currentPositionIndex];
        }
        return null;
    }
    public String getPositionNameByIndex(int index){
        if (index>=0 & index<NoteStrings.positionNames.length){
            return NoteStrings.positionNames[index];
        }
        return null;
    }

    public void nextPosition(){
        if (currentPositionIndex<NoteStrings.positionNames.length){
            currentPositionIndex++;
        }
    }

    public boolean hasNextPosition(){
        if (currentPositionIndex<NoteStrings.positionNames.length){
            return true;
        }
        return false;
    }

}
