package jpsave.airbnb.outils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that extends Date class to support French date formats creation and print :<ul>
 *  <li>dd/MM/yyyy</li>
 *  <li>dd/MM/yy</li>
 *  <li>dd, MM, yyyy</li>
 * </ul>
 *
 * @Author Jean-Philippe SAVE
 */
public class MaDate extends Date {

    private static final String STRINGSHORTDATEFORMAT = "dd/MM/yy";
    private static final String STRINGLONGDATEFORMAT = "dd/MM/yyyy";
    private static final SimpleDateFormat longDateFormat = new SimpleDateFormat(STRINGLONGDATEFORMAT);
    private static final SimpleDateFormat shortDateFormat = new SimpleDateFormat(STRINGSHORTDATEFORMAT);
    private static final Pattern patternShortDate = Pattern.compile("^[0-9]{2}/[0-9]{2}/[0-9]{2}$");
    private static final Pattern patternLongDate = Pattern.compile("^[0-9]{2}/[0-9]{2}/[0-9]{4}$");

    /**
     * Internal method that check that the stringDate format given is supported.
     * And if supported, it converts it to a long.
     *
     * @param stringDate
     * @return the stringDate converted a long
     * @throws Exception if stringDate format is not supported
     */
    private static long dateStringCheckAndConvert(String stringDate) throws Exception {
        Matcher matchShortDate = patternShortDate.matcher(stringDate);
        Matcher matchLongDate = patternLongDate.matcher(stringDate);

        if(matchShortDate.find()) {
            return shortDateFormat.parse(stringDate).getTime();
        }
        if(matchLongDate.find()) {
            return longDateFormat.parse(stringDate).getTime();
        }
        throw new Exception("Erreur de saisie de date");
    }

    /**
     * Class Constructor
     *
     * @param stringDate accepted formats are : dd/MM/yy or dd/MM/yyyy
     * @throws Exception check input format
     */
    public MaDate(String stringDate) throws Exception {
        super(dateStringCheckAndConvert(stringDate));
    }
//    public MaDate(String stringDate) {
//            super(stringDate);
//    }

    /**
     * Class Constructor
     *
     * @param day the wanted day (1-31)
     * @param month the wanted month (1-12)
     * @param year the wanted year (yyyy)
     */
    public MaDate(int day, int month, int year) {
        super(year-1900, month+1, day);
    }

    /**
     * Print the date to the dd/MM/yyyy format.
     *
     * @return String "dd/MM/yyyy"
     */
    @Override
    public String toString() {
        return longDateFormat.format(this);
    }
}
