package application;

import entities.Bovine;
import entities.Bull;
import entities.Cow;
import entities.Database;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Run {

    public static void main(String[] args) throws ParseException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        
        Bull bull = new Bull(100,'M',false,false,false,false,"22/09/2019",null,null,null);
        Cow cow = new Cow(200,'F',false,false,false,false,"22/09/2019",null,null,null);
        System.out.println("Boi " + bull.getId() + " nascido.");
        System.out.println("Vaca " + cow.getId() + " nascida.");
        Database db = new Database();
        List<Bovine> bovines = db.recover();
        bovines.add(bull);
        bovines.add(cow);
        db.record(bovines);
    }
}
