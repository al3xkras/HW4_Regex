package ua.alexkras.exception;

public class NoteKeyException extends Exception {
    private final String MESSAGE = "Note object does not contain key \"%s\"";
    public String key;

    public NoteKeyException(String key){
        this.key=key;
    }

    @Override
    public void printStackTrace(){
        super.printStackTrace();
        System.out.printf(MESSAGE,this.key);
    }
}
