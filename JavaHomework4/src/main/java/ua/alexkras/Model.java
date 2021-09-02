package ua.alexkras;

import java.util.ResourceBundle;

public class Model {

    Note note;
    NoteBook noteBook;
    NoteBookDataModel noteBookDataModel;


    private static final String COMMA = ", ";
    private static final String BRACKET_LEFT = "(";
    private static final String BRACKET_RIGHT = ") ";

    public Model(NoteBook noteBook, NoteBookDataModel noteBookDataModel){
        this.noteBook = noteBook;
        this.noteBookDataModel = noteBookDataModel;
    }

    public String generateFullName(){

        String _name = NoteStrings.PositionNames[NoteStrings.INDEX_NAME];
        String _surname = NoteStrings.PositionNames[NoteStrings.INDEX_SURNAME];

        String name = note.getPositionByKey(_name);
        String surname = note.getPositionByKey(_surname);

        return surname + " " + name.charAt(0) + ".";
    }

    public String generateFullAddress(){

        String _postal = NoteStrings.PositionNames[NoteStrings.INDEX_ADDRESS_POSTAL];
        String _city = NoteStrings.PositionNames[NoteStrings.INDEX_ADDRESS_CITY];
        String _street = NoteStrings.PositionNames[NoteStrings.INDEX_ADDRESS_STREET];
        String _house_number = NoteStrings.PositionNames[NoteStrings.INDEX_ADDRESS_HOUSE_NUMBER];
        String _flat_number = NoteStrings.PositionNames[NoteStrings.INDEX_ADDRESS_FLAT_NUMBER];


        String postal = note.getPositionByKey(_postal);
        String city = note.getPositionByKey(_city);
        String street = note.getPositionByKey(_street);
        String house_number = note.getPositionByKey(_house_number);
        String flat_number = note.getPositionByKey(_flat_number);

        StringBuilder address = new StringBuilder();
        address.append(BRACKET_LEFT);
        address.append(postal);
        address.append(BRACKET_RIGHT);
        address.append(city);
        address.append(COMMA);
        address.append(street);
        address.append(COMMA);
        address.append(house_number);
        address.append(COMMA);
        address.append(flat_number);

        return address.toString();
    }

    public void newNote(){
        note = new Note();
    }

    public void addNote(){
        if (note!=null) {
            noteBook.addNote(note);
        }
    }
}
