package entities;

import static entities.Bovine.computeAge;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Bull extends Bovine {

    public Bull() {
    }

    public Bull(Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfPurchase, String dateOfBrucellosis, String dateOfDeath, String dateOfSale) {
        super(idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfPurchase, dateOfBrucellosis, dateOfDeath, dateOfSale);
    }

    public Bull(Integer id, Integer idOfMother, Character gender, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfPurchase, String dateOfBrucellosis, String dateOfDeath, String dateOfSale) {
        super(id, idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfPurchase, dateOfBrucellosis, dateOfDeath, dateOfSale);
    }
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Receives a male born in the farm.
     */
    @Override
    public void declareBirth() {
        System.out.print("Digite o número da mãe deste macho: ");
        int idOfMother = sc.nextInt();
        char gender = 'M';
        boolean bornInFarm = true;
        boolean brucellosis = false;
        boolean deadInFarm = false;
        boolean sold = false;
        System.out.print("Digite a data de nascimento deste macho(dd/MM/yyyy): ");
        String dateOfBirth = sc.next();
        String dateOfPurchase = null;
        String dateOfBrucellosis = null;
        String dateOfDeath = null;
        String dateOfSale = null;
        Bull bull = new Bull(idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfPurchase, dateOfBrucellosis, dateOfDeath, dateOfSale);
        Database db = new Database();
        List<Bovine> bovines = db.recover();
        bovines.add(bull);
        db.record(bovines);
    }//End of method declareBirth.

    /**
     * Receives a male bought to the farm.
     */
    @Override
    public void declarePurchase() {
        int idOfMother = 0;
        char gender = 'M';
        boolean bornInFarm = false;
        boolean brucellosis = false;
        boolean deadInFarm = false;
        boolean sold = false;
        System.out.print("Digite a data de nascimento deste macho(dd/MM/yyyy): ");
        String dateOfBirth = sc.next();
        System.out.print("Digite a data de compra deste macho(dd/MM/yyyy): ");
        String dateOfPurchase = sc.next();
        String dateOfBrucellosis = null;
        String dateOfDeath = null;
        String dateOfSale = null;
        Bull bull = new Bull(idOfMother, gender, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfPurchase, dateOfBrucellosis, dateOfDeath, dateOfSale);
        Database db = new Database();
        List<Bovine> bovines = db.recover();
        bovines.add(bull);
        db.record(bovines);
    }//End of method declarePurchase.

    /**
     * Sets deadInFarm to true and keeps this bovine in file.
     */
    @Override
    public void declareDeath() {
        Database db = new Database();
        List<Bovine> bovines = db.recover();
        for (Bovine bovine : bovines) {
            System.out.println(bovine);
        }
        System.out.println();
        System.out.print("Qual o número do macho que deseja declarar a morte? ");
        int id = sc.nextInt();
        for (Bovine bovine : bovines) {
            if (bovine.getId() == id) {
                bovine.setDeadInFarm(Boolean.TRUE);
                System.out.print("Digite a data de óbito do macho(dd/MM/yyyy): ");
                String dateOfDeath = sc.next();
                bovine.setDateOfDeath(dateOfDeath);
                System.out.println("Declarada a morte do macho nº " + bovine.getId() + " em " + bovine.getDateOfDeath() + ".");
                System.out.println();
            }
        }
        db.record(bovines);
    }//End of method declareDeath.

    /**
     * Sets sold to true and keeps this bovine in file.
     */
    @Override
    public void declareSale() {
        Database db = new Database();
        List<Bovine> bovines = db.recover();
        for (Bovine bovine : bovines) {
            System.out.println(bovine);
        }
        System.out.println();
        System.out.print("Qual o número do macho que deseja declarar a venda? ");
        int id = sc.nextInt();
        for (Bovine bovine : bovines) {
            if (bovine.getId() == id) {
                bovine.setSold(Boolean.TRUE);
                System.out.print("Digite a data de venda do macho(dd/MM/yyyy): ");
                String dateOfSale = sc.next();
                bovine.setDateOfSale(dateOfSale);
                System.out.println("Declarada a venda do macho nº " + bovine.getId() + " em " + bovine.getDateOfSale() + ".");
                System.out.println();
            }
        }
        db.record(bovines);
    }//End of method declareSale.

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Macho nº ");
        sb.append(getId());
        sb.append(", mãe nº ");
        sb.append(getIdOfMother());
        sb.append(", nascido no dia ");
        sb.append(getDateOfBirth());
        if (getBornInFarm() == true) {
            sb.append(", na propriedade");
        } else {
            sb.append(", comprado no dia ");
            sb.append(getDateOfPurchase());
        }
        if (getBrucellosis() == true) {
            sb.append(", vacinado contra brucelose no dia ");
            sb.append(getDateOfBrucellosis());
        } else {
            sb.append(", não recebeu vacina contra brucelose");
        }
        if (getSold() == true) {
            sb.append(", vendido no dia ");
            sb.append(getDateOfSale());
            sb.append(", com ");
            sb.append(computeAge(getId(), getDateOfSale()));
            sb.append(" dias de idade.");
        }
        if (getDeadInFarm() == true) {
            sb.append(", morto no dia ");
            sb.append(getDateOfDeath());
            sb.append(", com ");
            sb.append(computeAge(getId(), getDateOfDeath()));
            sb.append(" dias de idade.");
        }
        if (getSold() == false && getDeadInFarm() == false) {
            Date date = new Date();
            String finalDate = sdf.format(date);
            sb.append(", está com ");
            sb.append(computeAge(getId(), finalDate));
            sb.append(" dias de idade.");
        }
        return sb.toString();
    }//End of method toString.
}
