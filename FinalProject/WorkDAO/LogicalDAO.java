package FinalProject.WorkDAO;

// проверка на логику

import FinalProject.WorkDAO.Setting;

import java.util.regex.Matcher;

public class LogicalDAO {
    static public boolean isName(String str) {
        Matcher m = Setting.PATNAMEGOOD_1.matcher(str);
        return (m.matches() && (str.length()>0 && str.length()<=Setting.LENGHTNAME_HOTTEL_USER));
    }

    static public boolean isNotice(String str) {
        Matcher m = Setting.PATNAMEGOOD_2.matcher(str);
        return m.matches();
    }
    static public boolean isEdrpou(String str) {
        Matcher m = Setting.PATNAMEGOOD_Num.matcher(str);
        return m.matches();
    }



}
