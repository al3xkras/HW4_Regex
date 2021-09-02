package ua.alexkras;

import java.util.ArrayList;

public class Note {

    public final ArrayList<String> keys = new ArrayList<>();
    private final ArrayList<String> values = new ArrayList<>();

    private static final String BRACKET_LEFT = "[";
    private static final String BRACKET_RIGHT = "]";
    private static final String COLON = " : ";

    /**
     * Add value (position) to a Note, and associate it with key.
     * @param key Key, that will be associated with value. If Note already contains the key,
     *            previous value associated with it will be overwritten.
     * @param value String, that will be associated with key.
     */
    public void addPosition(String key, String value){
        int indexOf = keys.indexOf(key);
        if (indexOf!=-1){
            values.add(indexOf,value);
        } else {
            keys.add(key);
            values.add(value);
        }
    }

    /**
     * Get position value of a Note by its key.
     * @param key - String, that identifies particular value
     * @throws IndexOutOfBoundsException – if there is no value matching key
     * @return String (value), that matches key
     */
    public String getPositionByKey(String key){
        return values.get(keys.indexOf(key));
    }

    public boolean containsPosition(String position){
        return values.contains(position);
    }

    public void printNote(){
        for (int i=0; i<keys.size();i++){
            System.out.println(BRACKET_LEFT+keys.get(i)+COLON+values.get(i)+BRACKET_RIGHT);
        }
    }
}
