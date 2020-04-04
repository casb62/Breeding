package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Herd {

    private int b0_12;
    private int b13_24;
    private int b25_36;
    private int b37_60;
    private int bmore60;
    private int c0_2;
    private int c3_8;
    private int c9_12;
    private int c13_24;
    private int c25_36;
    private int c37_60;
    private int cmore60;
    private int sumOfBulls;
    private int sumOfCows;
    private int sum;

    public Herd() {
    }

    public Herd(int b0_12, int b13_24, int b25_36, int b37_60, int bmore60, int c0_2, int c3_8, int c9_12, int c13_24, int c25_36, int c37_60, int cmore60, int sumOfBulls, int sumOfCows, int sum) {
        this.b0_12 = b0_12;
        this.b13_24 = b13_24;
        this.b25_36 = b25_36;
        this.b37_60 = b37_60;
        this.bmore60 = bmore60;
        this.c0_2 = c0_2;
        this.c3_8 = c3_8;
        this.c9_12 = c9_12;
        this.c13_24 = c13_24;
        this.c25_36 = c25_36;
        this.c37_60 = c37_60;
        this.cmore60 = cmore60;
        this.sumOfBulls = sumOfBulls;
        this.sumOfCows = sumOfCows;
        this.sum = sum;
    }

    /**
     * It receives the bovines from file, selects those on the farm, separates them by gender 
     * and age and displays the totals and the percentage of each group in relation to the total. 
     */
    public static void showCategories() {
        Herd herd = new Herd(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Database db = new Database();
        List<Bovine> bovines = db.recoverBovines();
        int age = 0;
        double bullCounter = 0;
        double cowCounter = 0;
        for (Bovine bovine : bovines) {
            if (bovine.getDeadInFarm() == false && bovine.getSold() == false) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                String finalDate = sdf.format(date);
                age = Bovine.computeAge(bovine.getId(), finalDate);
                if (bovine.getGender() == 'M') {
                    bullCounter++;
                    if (age > 0 && age <= 360) {
                        herd.b0_12++;
                    } else if (age > 360 && age <= 720) {
                        herd.b13_24++;
                    } else if (age > 720 && age <= 1080) {
                        herd.b25_36++;
                    } else if (age > 1080 && age <= 1800) {
                        herd.b37_60++;
                    } else if (age > 1800) {
                        herd.bmore60++;
                    }
                } else if (bovine.getGender() == 'F') {
                    cowCounter++;
                    if (age > 0 && age <= 89) {
                        herd.c0_2++;
                    } else if (age > 89 && age <= 240) {
                        herd.c3_8++;
                    } else if (age > 240 && age <= 360) {
                        herd.c9_12++;
                    } else if (age > 360 && age <= 720) {
                        herd.c13_24++;
                    } else if (age > 720 && age <= 1080) {
                        herd.c25_36++;
                    } else if (age > 1080 && age <= 1800) {
                        herd.c37_60++;
                    } else if (age > 1800) {
                        herd.cmore60++;
                    }
                }
            }
        }
    System.out.printf ("\nMachos de 0 a 12 meses: %d\t%.2f%s\n", herd.b0_12, (herd.b0_12 * 100) / (bullCounter + cowCounter), "%.");
    System.out.printf ("Machos de 13 a 24 meses: %d\t%.2f%s\n", herd.b13_24, (herd.b13_24 * 100) / (bullCounter + cowCounter), "%.");
    System.out.printf ("Machos de 25 a 36 meses: %d\t%.2f%s\n", herd.b25_36, (herd.b25_36 * 100) / (bullCounter + cowCounter), "%.");
    System.out.printf ("Machos de 37 a 60 meses: %d\t%.2f%s\n", herd.b37_60, (herd.b37_60 * 100) / (bullCounter + cowCounter), "%.");
    System.out.printf ("Machos acima de 60 meses: %d\t%.2f%s\n", herd.bmore60, (herd.bmore60 * 100) / (bullCounter + cowCounter), "%.");
    System.out.printf ("\nFêmeas de 0 a 2 meses: %d\t%.2f%s\n", herd.c0_2, (herd.c0_2 * 100) / (bullCounter + cowCounter), "%.");
    System.out.printf ("Fêmeas de 3 a 8 meses: %d\t%.2f%s\n", herd.c3_8, (herd.c3_8 * 100) / (bullCounter + cowCounter), "%.");
    System.out.printf ("Fêmeas de 9 a 12 meses: %d\t%.2f%s\n", herd.c9_12, (herd.c9_12 * 100) / (bullCounter + cowCounter), "%.");
    System.out.printf ("Fêmeas de 13 a 24 meses: %d\t%.2f%s\n", herd.c13_24, (herd.c13_24 * 100) / (bullCounter + cowCounter), "%.");
    System.out.printf ("Fêmeas de 25 a 36 meses: %d\t%.2f%s\n", herd.c25_36, (herd.c25_36 * 100) / (bullCounter + cowCounter), "%.");
    System.out.printf ("Fêmeas de 37 a 60 meses: %d\t%.2f%s\n", herd.c37_60, (herd.c37_60 * 100) / (bullCounter + cowCounter), "%.");
    System.out.printf ("Fêmeas acima de 60 meses: %d\t%.2f%s\n", herd.cmore60, (herd.cmore60 * 100) / (bullCounter + cowCounter), "%.");

    herd.sumOfBulls  = herd.b0_12 + herd.b13_24 + herd.b25_36 + herd.b37_60 + herd.bmore60;
    System.out.printf ("\nTotal de machos: %d\t\t%.2f%s\n", herd.sumOfBulls, (herd.sumOfBulls * 100) / (bullCounter + cowCounter), "%.");

    herd.sumOfCows  = herd.c0_2 + herd.c3_8 + herd.c9_12 + herd.c13_24 + herd.c25_36 + herd.c37_60 + herd.cmore60;
    System.out.printf ("Total de fêmeas: %d\t\t%.2f%s\n", herd.sumOfCows, (herd.sumOfCows * 100) / (bullCounter + cowCounter), "%.");

    herd.sum  = herd.sumOfBulls + herd.sumOfCows;
    System.out.printf ("Total geral: %d\t\t\t%.2f%s\n", herd.sum, (herd.sum * 100) / (bullCounter + cowCounter), "%.");
    }//End of method showCategories.
    
    /**
     * It receives the bovines from file, selects those on the farm and displays them one
     * by one.
     */
    public static void showHerd(){
        Database db = new Database();
        List<Bovine> bovines = db.recoverBovines();
        int counter = 0;
        for(Bovine bovine: bovines){
            if(bovine.getDeadInFarm() == false && bovine.getSold() == false){
                counter++;
                System.out.println(bovine);
            }
        }
        System.out.println("\nTotal: " + counter + " animais.");
    }//End of method showHerd.
    
    /**
     * It receives the bovines from file and shows the dead ones.
     */
    public static void showDead(){
        Database db = new Database();
        List<Bovine> bovines = db.recoverBovines();
        int dead = 0;
        for(Bovine bovine: bovines){
            if(bovine.getDeadInFarm() == true){
                dead ++;
                System.out.println(bovine);
            }
        }
        System.out.printf("\nTotal geral: %d\tTaxa de mortalidade total: %.2f%s\n",dead,(dead * 100.0 / bovines.size()),"%.");
    }//End of method showDeads.
    
    /**
     * It receives the bovines from file and shows the sold ones.
     */
    public static void showSold(){
        Database db = new Database();
        List<Bovine> bovines = db.recoverBovines();
        int sold = 0;
        for(Bovine bovine: bovines){
            if(bovine.getSold() == true){
                sold++;
                System.out.println(bovine);
            }
        }
        System.out.println("\nTotal: " + sold + " animais.");
    }//End of method showSold.
}