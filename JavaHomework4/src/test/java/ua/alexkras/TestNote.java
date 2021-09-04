package ua.alexkras;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestNote {
    Note note1, note2;

    @Before
    public void before(){
        note1 = new Note();
        note2 = new Note();
    }

    @Test
    public void testAddPosition(){
        note1.addPosition("n","1");
        note2.addPosition("n","2");
        note2.addPosition("m","3");

        Assert.assertEquals(note1.keys.size(),1);
        Assert.assertEquals(note1.values.size(),1);

        Assert.assertEquals(note2.keys.size(),2);
        Assert.assertEquals(note2.values.size(),2);
    }

    @Test(expected =  IndexOutOfBoundsException.class)
    public void testGetPositionByKey1(){
        note1.addPosition("n","1");
        note2.addPosition("n","2");
        note2.addPosition("m","3");

        note1.getPositionByKey("o");
    }

    @Test
    public void testGetPositionByKey2(){
        note1.addPosition("n","1");
        note2.addPosition("n","2");
        note2.addPosition("m","3");

        Assert.assertEquals(note1.getPositionByKey("n"),"1");
        Assert.assertEquals(note2.getPositionByKey("n"),"2");
        Assert.assertEquals(note2.getPositionByKey("m"),"3");
    }

    @Test
    public void testGetPositionByKey3(){
        note1.addPosition("n","1");
        note1.addPosition("n","2");
        note1.addPosition("m","3");

        Assert.assertEquals(note1.getPositionByKey("n"),"2");
        Assert.assertEquals(note1.getPositionByKey("m"),"3");
    }

    @Test
    public void testContainsPosition(){
        note1.addPosition("n","1");
        note1.addPosition("m","3");

        Assert.assertTrue(note1.containsPosition("n"));
        Assert.assertTrue(note1.containsPosition("m"));
        Assert.assertFalse(note1.containsPosition("o"));
    }


}
