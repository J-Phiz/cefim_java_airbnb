package jpsave.airbnb.outils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that extends Date class to support French date formats creation and print :<ul>
 *  <li>dayNum/monthNum/yearNum</li>
 *  <li>dayNum, monthNum, yearNum</li>
 * </ul>
 *
 * @Author Jean-Philippe SAVE
 */
public class MaDate extends Date {
    private static final String STRING_MADATE_FORMAT = "dd/MM/yyyy";
    private static final SimpleDateFormat MADATE_FORMAT = new SimpleDateFormat(STRING_MADATE_FORMAT);
    private static final Pattern PATTERN_MADATE = Pattern.compile("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{2,4}$");

    /**
     * Internal method that check that the strMaDate format given is supported.
     * And if supported, it converts it to a string accepted by Date.
     *
     * @param strMaDate the given string Date to check
     * @return the accepted string format for Date
     * @throws InputMismatchException if strMaDate format is not supported
     */
    private static String dateStringCheckAndConvert(String strMaDate) {
        Matcher matchMaDate = PATTERN_MADATE.matcher(strMaDate);

        if (matchMaDate.find()) {
            String[] strDate = strMaDate.split("/");
            return ("" + strDate[1] + "/" + strDate[0] + "/" + strDate[2]);
        }
        throw new InputMismatchException("Erreur de saisie de date");
    }

    /**
     * Class Constructor
     *
     * @param stringDate accepted format is : dayNum/monthNum/yearNum
     */
    public MaDate(String stringDate) {
        super(dateStringCheckAndConvert(stringDate));
    }

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
        return MADATE_FORMAT.format(this);
    }
}
