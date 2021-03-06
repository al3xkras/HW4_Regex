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
        return bundleValues.getString(NoteStrings.positionPrefix+NoteStrings.PositionNames[currentPositionIndex]);
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
    public String getPositionNameByIndex(int index){
        if (index>=0 & index<NoteStrings.PositionNames.length){
            return NoteStrings.PositionNames[index];
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
