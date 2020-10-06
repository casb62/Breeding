package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Cow extends Bovine {

    public Cow() {
    }

    public Cow(Integer idOfMother, Character gender, String race, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfPurchase, String dateOfBrucellosis, String dateOfDeath, String dateOfSale, String causeOfDeath) {
        super(idOfMother, gender, race, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfPurchase, dateOfBrucellosis, dateOfDeath, dateOfSale, causeOfDeath);
    }

    public Cow(Integer id, Integer idOfMother, Character gender, String race, Boolean bornInFarm, Boolean brucellosis, Boolean deadInFarm, Boolean sold, String dateOfBirth, String dateOfPurchase, String dateOfBrucellosis, String dateOfDeath, String dateOfSale, String causeOfDeath) {
        super(id, idOfMother, gender, race, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfPurchase, dateOfBrucellosis, dateOfDeath, dateOfSale, causeOfDeath);
    }

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Receives a female born in the farm.
     */
    @Override
    public void declareBirth() {
        System.out.print("Digite o número da mãe desta fêmea: ");
        int idOfMother = sc.nextInt();
        char gender = 'F';
        System.out.print("Digite a raça desta fêmea: ");
        String race = sc.nextLine();
        boolean bornInFarm = true;
        boolean brucellosis = false;
        boolean deadInFarm = false;
        boolean sold = false;
        System.out.print("Digite a data de nascimento desta fêmea(dd/MM/yyyy): ");
        String dateOfBirth = sc.next();
        String dateOfPurchase = null;
        String dateOfBrucellosis = null;
        String dateOfDeath = null;
        String dateOfSale = null;
        String causeOfDeath = null;
        Cow cow = new Cow(idOfMother, gender, race, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfPurchase, dateOfBrucellosis, dateOfDeath, dateOfSale, causeOfDeath);
        Database.conection(cow);
        System.out.println("Operação realizada com sucesso.\n");
    }//End of method declareBirth.

    /**
     * Receives a female bought to the farm.
     */
    @Override
    public void declarePurchase() {
        int idOfMother = 0;
        char gender = 'F';
        System.out.print("Digite a raça deste fêmea: ");
        String race = sc.nextLine();
        boolean bornInFarm = false;
        boolean brucellosis = false;
        boolean deadInFarm = false;
        boolean sold = false;
        System.out.print("Digite a data de nascimento desta fêmea(dd/MM/yyyy): ");
        String dateOfBirth = sc.next();
        System.out.print("Digite a data de compra desta fêmea(dd/MM/yyyy): ");
        String dateOfPurchase = sc.next();
        String dateOfBrucellosis = null;
        String dateOfDeath = null;
        String dateOfSale = null;
        String causeOfDeath = null;
        Cow cow = new Cow(idOfMother, gender, race, bornInFarm, brucellosis, deadInFarm, sold, dateOfBirth, dateOfPurchase, dateOfBrucellosis, dateOfDeath, dateOfSale, causeOfDeath);
        Database.conection(cow);
        System.out.println("Operação realizada com sucesso.");
    }//End of method declarePurchase.

    /**
     * Sets deadInFarm to true and keeps this bovine in file.
     */
    @Override
    public void declareDeath() {
        Database db = new Database();
        List<Bovine> bovines = db.recoverBovines();
        for (Bovine bovine : bovines) {
            if(bovine.getGender() == 'F' && bovine.getDeadInFarm() == Boolean.FALSE && bovine.getSold() == Boolean.FALSE){
            System.out.println(bovine);
            }
        }
        System.out.println();
        System.out.print("Qual o número da fêmea que deseja declarar a morte? ");
        int id = sc.nextInt();
        for (Bovine bovine : bovines) {
            if (bovine.getId() == id) {
                bovine.setDeadInFarm(Boolean.TRUE);
                System.out.print("Digite a data de óbito (dd/MM/yyyy): ");
                String dateOfDeath = sc.next();
                bovine.setDateOfDeath(dateOfDeath);
                System.out.print("Digite a causa da morte: ");
                String causeOfDeath = sc.nextLine();
                bovine.setCauseOfDeath(causeOfDeath);
            }
        }
        db.recordBovines(bovines);
        System.out.println("Operação realizada com sucesso.");
    }//End of method declareDeath.

    /**
     * Sets sold to true and keeps this bovine in file.
     */
    @Override
    public void declareSale() {
        Database db = new Database();
        List<Bovine> bovines = db.recoverBovines();
        for (Bovine bovine : bovines) {
            if(bovine.getGender() == 'F' && bovine.getDeadInFarm() == Boolean.FALSE && bovine.getSold() == Boolean.FALSE){
            System.out.println(bovine);
            }
        }
        System.out.println();
        System.out.print("Qual o número da fêmea que deseja declarar a venda? ");
        int id = sc.nextInt();
        for (Bovine bovine : bovines) {
            if (bovine.getId() == id) {
                bovine.setSold(Boolean.TRUE);
                System.out.print("Digite a data de venda da fêmea(dd/MM/yyyy): ");
                String dateOfSale = sc.next();
                bovine.setDateOfSale(dateOfSale);
            }
        }
        db.recordBovines(bovines);
        System.out.println("Operação realizada com sucesso.");
    }//End of method declareSale.

    /**
     * Sets brucellosis to true.
     */
    public void declareBrucellosis() {
        Database db = new Database();
        List<Bovine> bovines = db.recoverBovines();
        System.out.println("As seguintes fêmeas não receberam vacina contra brucelose: ");
        List<Bovine> cows = new ArrayList<>();
        for(Bovine bovine: bovines){
            if(bovine.getGender() == 'F' && bovine.getDeadInFarm() == Boolean.FALSE && bovine.getSold() == Boolean.FALSE){
                cows.add(bovine);
            }
        }
        int counter = 0;
        boolean jump = false;
        for(Bovine bovine: cows){
            if(bovine.getBrucellosis() == true){
                counter++;
                if(counter == cows.size()){
                jump = true;    
                }
            }else if(bovine.getBrucellosis() == false){
                System.out.println("Fêmea nº " + bovine.getId() + ".");
            }
        }
        if(jump){
           System.out.println("Todas as fêmeas receberam vacina contra brucelose!\n"); 
        }else if (jump == false){
        System.out.print("\nQual o número da fêmea que deseja declarar como vacinada? ");
        int id = sc.nextInt();
        System.out.print("Em que data ela foi vacinada? ");
        String dateOfBrucellosis = sc.next();
        for(Bovine bovine: cows){
            if(bovine.getId() == id){
                bovine.setBrucellosis(Boolean.TRUE);
                bovine.setDateOfBrucellosis(dateOfBrucellosis);
            }
        }
        db.recordBovines(bovines);
        System.out.println("Operação realizada com sucesso.");
        }
    }//End of method declareBrucellosis.
    
    /**
     * It finds the breeds of each cow and calculate the intervals between them.
     */
    public void searchBreeds(){
        Database db = new Database();
        List<Bovine> bovines = db.recoverBovines();
        System.out.print("\nDigite o número da fêmea da qual deseja pesquisar as crias: ");
        int cn = sc.nextInt();
        String date1 = null;
        String date2 = null;
        String date3 = null;
        for(Bovine bovine: bovines){
            if(bovine.getId() == cn){
                date3 = bovine.getDateOfBirth();//DN da mãe
            }
            if(bovine.getIdOfMother() == cn){
                System.out.println(bovine);
                date2 = bovine.getDateOfBirth();//DN da primeira cria no primeiro passo, da segunda no segundo passo, etc
                try{
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date fb = sdf.parse(date2);
                    long firstBreed = fb.getTime();
                    Date dnm = sdf.parse(date3);
                    long dnMother = dnm.getTime();
                    long ageMother = ((firstBreed - dnMother) / (1000 * 60 * 60 * 24));
                    int ageMotherInt = (int) ageMother;
                    System.out.println("Idade da mãe no parto: " + ageMotherInt + " dias.");
                }catch(ParseException e){
                    e.printStackTrace();
                }
                if(date1 != null){
                    try{
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date fd = sdf.parse(date2);
                    long finalDate = fd.getTime();
                    Date id = sdf.parse(date1);
                    long initialDate = id.getTime();
                    long age = ((finalDate - initialDate) / (1000 * 60 * 60 * 24));
                    int ageInt = (int) age;
                    System.out.println("Intervalo entre partos(IEP): " + ageInt + " dias.");
                    }catch(ParseException e){
                        e.printStackTrace();
                    }
                }
            date1 = date2;//date1 recebe a DN da primeira cria no primeiro passo, da segunda no segundo passo, etc
            }
        }
        if(date1 == null){
            System.out.println("\nEsta fêmea não tem crias.");
        }
    }//End of method searchBreeds.

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nFêmea nº ");
        sb.append(getId());
        sb.append(" da raça ");
        sb.append(getRace());
        sb.append(", mãe nº ");
        sb.append(getIdOfMother());
        sb.append(", nascida no dia ");
        sb.append(getDateOfBirth());
        if (getBornInFarm() == true) {
            sb.append(", na propriedade");
        } else {
            sb.append(", comprada no dia ");
            sb.append(getDateOfPurchase());
        }
        if (getBrucellosis() == true) {
            sb.append(", vacinada contra brucelose no dia ");
            sb.append(getDateOfBrucellosis());
        } else {
            sb.append(", não recebeu vacina contra brucelose");
        }
        if (getSold() == true) {
            sb.append(", vendida no dia ");
            sb.append(getDateOfSale());
            sb.append(", com ");
            sb.append(computeAge(getId(), getDateOfSale()));
            sb.append(" dias de idade.");
        }
        if (getDeadInFarm() == true) {
            sb.append(", morta no dia ");
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