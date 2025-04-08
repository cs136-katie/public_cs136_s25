/*
 * Date class 
 */
import java.util.Arrays; 

public class Date{
    public final int month; 
    public final int day;
    public final int year;

    /**
     * @param date the string representation of this date 
     * in the form MM/DD/YYYY
     */
    public Date(String date) {
        String[] fields = date.split("/");
        this.month = Integer.parseInt(fields[0]);
        this.day   = Integer.parseInt(fields[1]);
        this.year  = Integer.parseInt(fields[2]);
    }

    /**
     * Returns a string representation of this date.
     *
     * @return the string representation in the format MM/DD/YYYY
     */
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    public static void main(String[] args){
        Date today = new Date("04/01/2024"); 
        System.out.println(today);
    }
}

