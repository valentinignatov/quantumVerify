package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatChanger {
	public String changeDateFormat(String inputDate) {
        // Define the original format
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        // Define the new format
        SimpleDateFormat newFormat = new SimpleDateFormat("MM-dd-yyyy");
        
        try {
            // Parse the input date
            Date date = originalFormat.parse(inputDate);
            // Return the date in the new format
            return newFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
