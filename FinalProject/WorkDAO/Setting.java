package FinalProject.WorkDAO;

//файл настроек

import java.util.regex.Pattern;

public class Setting {
    final static String NAME_OF_FILEHOTEL = "d:\\work\\java\\data\\datahotel.txt";
    final static String NAME_OF_FILEROOM = "d:\\work\\java\\data\\dataroom.txt";
    final static String NAME_OF_FILEUSERS = "d:\\work\\java\\data\\datausers.txt";
    final static String NAME_OF_FILE_HOTELROOMS = "d:\\work\\java\\data\\datahotelrooms.txt";
    final static String NAME_OF_FILE_RESERVATION = "d:\\work\\java\\data\\datareservation.txt";
    final static int LENGHTNAME_HOTTEL_USER =100;
    final static Pattern PATNAMEGOOD_1 = Pattern.compile("^[A-Za-zА-Яа-я]+[A-Za-zА-Яа-яёЁ0-9-:.'\",()_\\s]*$");
    final static Pattern PATNAMEGOOD_2 = Pattern.compile("^[A-Za-zА-Яа-яёЁ0-9-:.'\",()_\\s]*$");
    final static Pattern PATNAMEGOOD_Num = Pattern.compile("^[0-9]*$");
    final static int SIZEDISPLAYOUTPUTDATA = 15;

}
