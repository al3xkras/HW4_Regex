package ua.alexkras;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Note {

    public final ArrayList<String> keys = new ArrayList<>();
    public final ArrayList<String> values = new ArrayList<>();

    private final Date dateOfCreation;
    public Date getDateOfCreation(){return dateOfCreation;}

    private Date dateOfLastEdit;
    public Date getDateOfLastEdit(){return dateOfLastEdit;}

    private static final String BRACKET_LEFT = "[";
    private static final String BRACKET_RIGHT = "]";
    private static final String COLON = " : ";


    public Note(){
        dateOfCreation = new Date();
        dateOfLastEdit = new Date();
    }
    /**
     * Add value (position) to a Note, and associate it with key.
     * @param key Key, that will be associated with value. If Note already contains the key,
     *            previous value associated with it will be overwritten.
     * @param value String, that will be associated with key.
     */
    public void addPosition(String key, String value){
        int indexOf = keys.indexOf(key);
        if (indexOf!=-1){
            values.remove(indexOf);
            values.add(indexOf,value);
        } else {
            keys.add(key);
            values.add(value);
        }
        dateOfLastEdit = new Date();
    }

    /**
     * Get position value of a Note by its key.
     * @param key - String, that identifies particular value
     * @return String, that matches key; null – if Note does not contain specified key
     */
    public String getPositionByKey(String key){
        if (!this.containsPosition(key)){
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    public boolean containsPosition(String position){
        return keys.contains(position);
    }

    public void printNote(){
        for (int i=0; i<keys.size();i++){
            System.out.println(BRACKET_LEFT+keys.get(i)+COLON+values.get(i)+BRACKET_RIGHT);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(NoteStrings.dateOfCreation+COLON+
                dateFormat.format(dateOfCreation));
        System.out.println(NoteStrings.dateOfLastEdit+COLON+
                dateFormat.format(dateOfLastEdit));
    }
}
