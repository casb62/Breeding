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
        
        
        Database sb = new Database();
        List<Bovine> bovines = sb.recover();
        for(Bovine bovine: bovines){
            System.out.println(bovine);
        }
        System.out.println();
    }
}
