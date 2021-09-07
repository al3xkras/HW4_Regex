package ua.alexkras;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.alexkras.exception.NoteBookLoginExistsException;

public class TestNoteBook {
    NoteBook noteBook;
    Note note1;
    Note note2;

    @Before
    public void before(){
        noteBook = new NoteBook();

        note1 = new Note();
        note2 = new Note();

    }

    @Test
    public void testAddNote1(){
        Assert.assertEquals(noteBook.getNotes().size(),0);
    }

    @Test
    public void testAddNote2() throws NoteBookLoginExistsException {
        noteBook.addNote(note1);
        noteBook.addNote(note2);

        Assert.assertEquals(noteBook.getNotes().size(),2);
    }

    @Test
    public void testGetNote1() throws NoteBookLoginExistsException {
        noteBook.addNote(note1);
        noteBook.addNote(note2);

        Assert.assertEquals(noteBook.getNoteByIndex(0),note1);
        Assert.assertEquals(noteBook.getNoteByIndex(1),note2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNote2() throws NoteBookLoginExistsException{
        noteBook.addNote(note1);
        noteBook.addNote(note2);

        noteBook.getNoteByIndex(2);
    }

    @Test(expected = NoteBookLoginExistsException.class)
    public void testAddNoteException1() throws NoteBookLoginExistsException{
        String _login = NoteStrings.positionNames[NoteStrings.INDEX_LOGIN];
        note1.addPosition(_login,"login1");
        note2.addPosition(_login,"login1");

        noteBook.addNote(note1);
        noteBook.addNote(note2);
    }

    @Test
    public void testAddNoteException2() throws NoteBookLoginExistsException{
        String _login = NoteStrings.positionNames[NoteStrings.INDEX_LOGIN];
        note1.addPosition(_login,"login1");
        note2.addPosition(_login,"login2");

        noteBook.addNote(note1);
        noteBook.addNote(note2);
    }

}
