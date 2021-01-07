package jpsave.airbnb.outils;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    private static final String STRINGMADATEFORMAT = "dd/MM/yyyy";
    private static final SimpleDateFormat maDateFormat = new SimpleDateFormat(STRINGMADATEFORMAT);
    private static final Pattern patternMaDate = Pattern.compile("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{2,4}$");

    /**
     * Internal method that check that the strMaDate format given is supported.
     * And if supported, it converts it to a string accepted by Date.
     *
     * @param strMaDate the given string Date to check
     * @return the accepted string format for Date
     * @throws Exception if strMaDate format is not supported
     */
    private static String dateStringCheckAndConvert(String strMaDate) throws Exception {
        Matcher matchMaDate = patternMaDate.matcher(strMaDate);

        if (matchMaDate.find()) {
            String[] strDate = strMaDate.split("/");
            return ("" + strDate[1] + "/" + strDate[0] + "/" + strDate[2]);
        }
        throw new Exception("Erreur de saisie de date");
    }

    /**
     * Class Constructor
     *
     * @param stringDate accepted format is : dayNum/monthNum/yearNum
     * @throws Exception check input format
     */
    public MaDate(String stringDate) throws Exception {
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
        return maDateFormat.format(this);
    }
}
