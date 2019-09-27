package application;

import entities.Bovine;
import entities.Database;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        List<Bovine> bovines = new ArrayList<>();
        Database db = new Database();
        bovines = db.recover();
        //System.out.print("Digite o nº de um animal: ");
        //int id = sc.nextInt();
        for (Bovine bovine : bovines) {
            //if (bovine.getId() == id) {
                System.out.println(bovine);

            }
            System.out.println();

        }
    }
//}
