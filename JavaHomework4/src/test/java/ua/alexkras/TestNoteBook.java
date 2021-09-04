package ua.alexkras;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void testAddNote2(){
        noteBook.addNote(note1);
        noteBook.addNote(note2);

        Assert.assertEquals(noteBook.getNotes().size(),2);
    }

    @Test
    public void testGetNote1(){
        noteBook.addNote(note1);
        noteBook.addNote(note2);

        Assert.assertEquals(noteBook.getNoteByIndex(0),note1);
        Assert.assertEquals(noteBook.getNoteByIndex(1),note2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNote2(){
        noteBook.addNote(note1);
        noteBook.addNote(note2);

        noteBook.getNoteByIndex(2);
    }

}
