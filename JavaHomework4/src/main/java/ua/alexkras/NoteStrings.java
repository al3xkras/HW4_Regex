package ua.alexkras;

public interface NoteStrings {
     String positionPrefix = "position.";
     String regexPrefix = "regex.";

     String errorMessage = "string.errorMessage";
     String groupNotFoundMessage = "string.groupNotFoundMessage";
     String loginExistsMessage = "string.loginExistsMessage";

     String dateOfCreation = "dateOfCreation";
     String dateOfLastEdit = "dateOfLastEdit";

     int INDEX_SURNAME = 0;
     int INDEX_NAME = 1;
     int INDEX_ADDRESS_POSTAL = 11;
     int INDEX_ADDRESS_CITY = 12;
     int INDEX_ADDRESS_STREET = 13;
     int INDEX_ADDRESS_HOUSE_NUMBER = 14;
     int INDEX_ADDRESS_FLAT_NUMBER = 15;

     //Skype login
     int INDEX_LOGIN = 10;

     int INDEX_GROUP = 5;

     String positionFullName = "fullName";
     String positionFullAddress = "fullAddress";

     String[] positionNames = {
             "surname",
             "name",
             "patronymic",
             "nickName",
             "comment",
             "group",
             "homePhoneNumber",
             "personalPhoneNumber",
             "personalPhoneNumber2",
             "eMail",
             "skypeNickName",
             "addressPostalIndex",
             "addressCity",
             "addressStreet",
             "addressHouseNumber",
             "addressFlatNumber"
     };

}
