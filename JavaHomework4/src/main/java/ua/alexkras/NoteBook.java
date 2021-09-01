package ua.alexkras;

import java.util.ArrayList;
import java.util.Arrays;

public class NoteBook {

    ArrayList<Note> notes;

    public NoteBook(Note[] notes){
        this.notes = new ArrayList<>();
        this.notes.addAll(Arrays.asList(notes));
    }

    public NoteBook(ArrayList<Note> noteArray){
        this.notes = noteArray;
    }


}
