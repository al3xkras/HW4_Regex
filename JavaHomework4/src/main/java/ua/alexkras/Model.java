package ua.alexkras;

public class Model {

    Note note;
    NoteBook noteBook;
    NoteBookDataModel noteBookDataModel;



    public Model(NoteBook noteBook, NoteBookDataModel noteBookDataModel){
        this.noteBook = noteBook;
        this.noteBookDataModel = noteBookDataModel;
    }

    public void newNote(){
        note = new Note();
    }

    public void addNote(){
        if (note!=null) {
            noteBook.addNote(note);
            note = null;
        }
    }
}
