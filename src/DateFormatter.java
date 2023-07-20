import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public static void main(String[] args) throws ParseException {
        String dateToFormate = "23/12/1998";
        SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat format2=new SimpleDateFormat("yyyy-MM-dd");
        Date date= format1.parse(dateToFormate);
        String format = format2.format(date);
        System.out.println(format);
    }
}
