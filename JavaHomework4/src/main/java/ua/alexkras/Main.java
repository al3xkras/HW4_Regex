package ua.alexkras;


import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle(
                "NoteRegex",new Locale("ua","UA"));

        String surname = bundle.getString(NoteStrings.surname);
        String name = bundle.getString(NoteStrings.name);
        String patronymic = bundle.getString(NoteStrings.patronymic);
        String nickName = bundle.getString(NoteStrings.nickName);
        String comment = bundle.getString(NoteStrings.comment);
        String group = bundle.getString(NoteStrings.group);
        String homePhoneNumber = bundle.getString(NoteStrings.homePhoneNumber);
        String personalPhoneNumber = bundle.getString(NoteStrings.personalPhoneNumber);
        String personalPhoneNumber2 = bundle.getString(NoteStrings.personalPhoneNumber2);
        String eMail = bundle.getString(NoteStrings.eMail);
        String skypeNickName = bundle.getString(NoteStrings.skypeNickName);
        String addressPostalIndex = bundle.getString(NoteStrings.addressPostalIndex);
        String addressCity = bundle.getString(NoteStrings.addressCity);
        String addressStreet = bundle.getString(NoteStrings.addressStreet);
        String addressHouseNumber = bundle.getString(NoteStrings.addressHouseNumber);
        String addressFlatNumber = bundle.getString(NoteStrings.addressFlatNumber);

        String[] regexNote = {surname,name,patronymic,nickName,comment,
                group,homePhoneNumber,personalPhoneNumber,
                personalPhoneNumber2,eMail,skypeNickName,addressPostalIndex,
                addressCity,addressStreet,addressHouseNumber,addressFlatNumber};

        String errorMessage = "Error: input does not match regex.";

        for (String regex: regexNote){
            System.out.println(regex);
            String input = RegexScanner.inputRegexWithScanner(regex,errorMessage);
        }




    }
}
