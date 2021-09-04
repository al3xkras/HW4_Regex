package ua.alexkras;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestNoteBookDataModel {

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
        noteBookDataModel = new NoteBookDataModel(bundleRegex,bundleValues);
    }

    @Test
    public void testGetCurrentValue(){
        String expectedCurrentValue1 = bundleValues.getString(NoteStrings.positionPrefix+NoteStrings.PositionNames[0]);
        String expectedCurrentValue2 = bundleValues.getString(NoteStrings.positionPrefix+NoteStrings.PositionNames[1]);

        Assert.assertEquals(noteBookDataModel.getCurrentValue(),expectedCurrentValue1);
        noteBookDataModel.nextPosition();
        Assert.assertEquals(noteBookDataModel.getCurrentValue(),expectedCurrentValue2);
        Assert.assertEquals(noteBookDataModel.getCurrentValue(),expectedCurrentValue2);
    }

    @Test
    public void testGetCurrentRegex(){
        String expectedCurrentRegex1 = bundleRegex.getString(NoteStrings.regexPrefix+NoteStrings.PositionNames[0]);
        String expectedCurrentRegex2 = bundleRegex.getString(NoteStrings.regexPrefix+NoteStrings.PositionNames[1]);

        Assert.assertEquals(noteBookDataModel.getCurrentRegex(),expectedCurrentRegex1);
        noteBookDataModel.nextPosition();
        Assert.assertEquals(noteBookDataModel.getCurrentRegex(),expectedCurrentRegex2);
        Assert.assertEquals(noteBookDataModel.getCurrentRegex(),expectedCurrentRegex2);
    }

    @Test
    public void testGetCurrentPositionName(){
        String expectedCurrentName1 = NoteStrings.PositionNames[0];
        String expectedCurrentName2 = NoteStrings.PositionNames[1];

        Assert.assertEquals(noteBookDataModel.getCurrentPositionName(),expectedCurrentName1);
        noteBookDataModel.nextPosition();
        Assert.assertEquals(noteBookDataModel.getCurrentPositionName(),expectedCurrentName2);
        Assert.assertEquals(noteBookDataModel.getCurrentPositionName(),expectedCurrentName2);
    }

    @Test
    public void testGetPositionNameByIndex(){
        String expectedCurrentName1 = NoteStrings.PositionNames[0];
        String expectedCurrentName2 = NoteStrings.PositionNames[3];

        Assert.assertEquals(noteBookDataModel.getPositionNameByIndex(0),expectedCurrentName1);
        noteBookDataModel.nextPosition();
        Assert.assertEquals(noteBookDataModel.getPositionNameByIndex(0),expectedCurrentName1);
        Assert.assertEquals(noteBookDataModel.getPositionNameByIndex(3),expectedCurrentName2);
    }

    @Test
    public void testHasNextPosition(){
        int loops = NoteStrings.PositionNames.length;

        for (int i=0; i<loops; i++){
            Assert.assertTrue(noteBookDataModel.hasNextPosition());
            noteBookDataModel.nextPosition();
        }
        Assert.assertFalse(noteBookDataModel.hasNextPosition());
    }


}
