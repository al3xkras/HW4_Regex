package ua.alexkras;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.alexkras.exception.NoteBookLoginExistsException;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestModel {

    Model model;

    NoteBook noteBook;

    static final String bundleRegexName = "NoteRegex";
    static final String bundleValuesName = "NoteValues";

    static final Locale locale = new Locale("ua","UA");


    static ResourceBundle bundleRegex;
    static ResourceBundle bundleValues;

    NoteBookDataModel noteBookDataModel;

    @BeforeClass
    public static void beforeClass(){
        bundleValues = ResourceBundle.getBundle(
                bundleValuesName, locale);

        bundleRegex = ResourceBundle.getBundle(
                bundleRegexName, locale);
    }


    @Before
    public void before(){
        noteBook = new NoteBook();
        noteBookDataModel = new NoteBookDataModel(bundleRegex,bundleValues);

        model = new Model(noteBook,noteBookDataModel);
    }

    @Test
    public void testAddNote() throws NoteBookLoginExistsException {
        Assert.assertEquals(0,model.getNoteBook().getNotes().size());
        model.newNote();
        Assert.assertNotNull(model.getNote());
        model.addNote();
        Assert.assertEquals(1,model.getNoteBook().getNotes().size());
    }

    @Test
    public void testGenerateFullName(){
        String _name = NoteStrings.positionNames[NoteStrings.INDEX_NAME];
        String _surname = NoteStrings.positionNames[NoteStrings.INDEX_SURNAME];

        model.getNote().addPosition(_name,"Name");
        model.getNote().addPosition(_surname,"Surname");

        Assert.assertEquals(model.generateFullName(),"Surname N.");
    }

    @Test
    public void testGenerateFullAddress(){
        String _postal = NoteStrings.positionNames[NoteStrings.INDEX_ADDRESS_POSTAL];
        String _city = NoteStrings.positionNames[NoteStrings.INDEX_ADDRESS_CITY];
        String _street = NoteStrings.positionNames[NoteStrings.INDEX_ADDRESS_STREET];
        String _house_number = NoteStrings.positionNames[NoteStrings.INDEX_ADDRESS_HOUSE_NUMBER];
        String _flat_number = NoteStrings.positionNames[NoteStrings.INDEX_ADDRESS_FLAT_NUMBER];

        model.getNote().addPosition(_postal,"33853");
        model.getNote().addPosition(_city,"Kyiv");
        model.getNote().addPosition(_street,"Khreschatyk");
        model.getNote().addPosition(_house_number,"35");
        model.getNote().addPosition(_flat_number,"10");


        Assert.assertEquals(model.generateFullAddress(),
                "(33853) Kyiv, Khreschatyk, 35, 10");
    }



}
