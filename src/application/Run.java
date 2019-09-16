package application;

import entities.Bull;
import entities.Cow;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Run {

    public static void main(String[] args) throws IOException, ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date("15/09/2019");
        Bull bull = new Bull('M', date, 100, true, false, false, null, null);
        System.out.println("Boi " + bull.getId() + " nascido.");

        Cow cow = new Cow('F', date, 200, true, false, false, null, null, false);
        System.out.println("Vaca " + cow.getId() + " nascida.");

    }
}
