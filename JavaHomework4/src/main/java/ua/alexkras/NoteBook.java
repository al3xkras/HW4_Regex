package ua.alexkras;

import ua.alexkras.exception.NoteBookLoginExistsException;

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

    public void addNote(Note note) throws NoteBookLoginExistsException {
        String _login = NoteStrings.positionNames[NoteStrings.INDEX_LOGIN];

        String login = note.getPositionByKey(_login);

        if (login!=null && this.containsNoteWithLogin(login)){
            throw new NoteBookLoginExistsException();
        }

        notes.add(note);
    }

    protected void forceAddNote(Note note){
        notes.add(note);
    }

    public Note getNoteByIndex(int index){
        return notes.get(index);
    }

    public boolean containsNoteWithLogin(String login){
        String _login = NoteStrings.positionNames[NoteStrings.INDEX_LOGIN];
        for (Note note: notes){
            if (note.containsPosition(_login) &&
                    note.getPositionByKey(_login).equals(login)){
                return true;
            }
        }
        return false;
    }
}
