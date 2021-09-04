package ua.alexkras;

import java.util.ArrayList;
import java.util.Arrays;

public class NoteBook {

    private final ArrayList<Note> notes;
    public ArrayList<Note> getNotes(){return notes;}

    public NoteBook(Note[] notes){
        this.notes = new ArrayList<>();
        this.notes.addAll(Arrays.asList(notes));
    }

    public NoteBook(ArrayList<Note> noteArray){
        this.notes = noteArray;
    }

    public NoteBook(){
        this.notes = new ArrayList<>();
    }

    public void addNote(Note note){
        notes.add(note);
    }

    public Note getNoteByIndex(int index){
        return notes.get(index);
    }
}
