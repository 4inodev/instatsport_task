package kg.chinodev.instatsport.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Util {
    public static String millisToTime(long timeStamp) {
        Date date = new Date(timeStamp);
        DateFormat formatter = new SimpleDateFormat("mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.format(date);
    }
    public static String timeStampToDate(String timeStamp) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss", Locale.getDefault());
        Date date = null;
        try {
            date = format.parse(timeStamp);
            DateFormat returnFormat = new SimpleDateFormat("dd.MM.yyyy' at 'HH:mm", Locale.getDefault());
            return returnFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return timeStamp;
        }
    }
}
