package ua.alexkras;

import java.util.ArrayList;

public class Note {

    public final ArrayList<String> keys = new ArrayList<>();
    private final ArrayList<String> values = new ArrayList<>();

    public void addPosition(String key, String value){
        int indexOf = keys.indexOf(key);
        if (indexOf!=-1){
            values.add(indexOf,value);
        } else {
            keys.add(key);
            values.add(value);
        }
    }

    public String getPosition(String key){
        return values.get(keys.indexOf(key));
    }
}
