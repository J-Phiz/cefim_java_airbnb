package jpsave.airbnb.outils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe statique pour la gestion commune d'outils
 *
 * @Author Jean-Philippe SAVE
 */
public class Utile {
    private static final String STRINGSHORTDATEFORMAT = "dd/MM/yy";
    private static final String STRINGLONGDATEFORMAT = "dd/MM/yyyy";
    private static final SimpleDateFormat longDateFormat = new SimpleDateFormat(STRINGLONGDATEFORMAT);
    private static final SimpleDateFormat shortDateFormat = new SimpleDateFormat(STRINGSHORTDATEFORMAT);
    private static final Pattern patternShortDate = Pattern.compile("^[0-9]{2}/[0-9]{2}/[0-9]{2}$");
    private static final Pattern patternLongDate = Pattern.compile("^[0-9]{2}/[0-9]{2}/[0-9]{4}$");

    /**
     *
     *
     * @param stringDate
     * @return
     * @throws Exception
     */
    public static Date creerDate(String stringDate) throws Exception {
        Matcher matchShortDate = patternShortDate.matcher(stringDate);
        Matcher matchLongDate = patternLongDate.matcher(stringDate);

        if(matchShortDate.find()) {
            return shortDateFormat.parse(stringDate);
        }
        if(matchLongDate.find()) {
            return longDateFormat.parse(stringDate);
        }
        return null;
    }

    public static Date creerDate(int day, int month, int year) throws Exception {
        if(day < 1 || day > 31)
            return null;
        if(month < 1 || month > 12)
            return null;

        return longDateFormat.parse(String.format("%02d/%02d/%04d", day, month, year));
    }

    public static String afficheDate(Date date) {
        return longDateFormat.format(date);
    }
}
