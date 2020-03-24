package entities;

import java.util.List;
import java.util.Scanner;

public class Farm {

    private Integer id;
    private String name;
    private String stateRegistry;
    private String owner;
    private String cpfOwner;
    private String county;
    private String state;
    
    public Farm() {
    }

    public Farm(Integer id, String name, String stateRegistry, String owner, String cpfOwner, String county, String state) {
        this.id = id;
        this.name = name;
        this.stateRegistry = stateRegistry;
        this.owner = owner;
        this.cpfOwner = cpfOwner;
        this.county = county;
        this.state = state;
    }
    
    Scanner sc = new Scanner(System.in);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStateRegistry() {
        return stateRegistry;
    }

    public void setStateRegistry(String stateRegistry) {
        this.stateRegistry = stateRegistry;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCpfOwner() {
        return cpfOwner;
    }

    public void setCpfOwner(String cpfOwner) {
        this.cpfOwner = cpfOwner;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    /**
     * It adds a farm to the file.
     */
    public void addFarm() {
        System.out.print("\nDigite um número para esta fazenda(Ex: 1): ");
        Integer id = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o nome da fazenda: ");
        String name = sc.nextLine();
        System.out.print("Digite o número da Inscrição Estadual: ");
        String stateRegistry = sc.next();
        sc.nextLine();
        System.out.print("Digite o nome do proprietário: ");
        String owner = sc.nextLine();
        System.out.print("Digite o CPF do proprietário: ");
        String cpfOwner = sc.next();
        sc.nextLine();
        System.out.print("Digite o nome do município: ");
        String county = sc.nextLine();
        System.out.print("Digite o nome do Estado: ");
        String state = sc.nextLine();
        Farm farm = new Farm(id, name, stateRegistry, owner, cpfOwner, county, state);
        Database db = new Database();
        List<Farm> farms = db.recoverFarms();
        farms.add(farm);
        db.recordFarms(farms);
        System.out.println("Operação realizada com sucesso.\n");
    }//End of method addFarm.

    /**
     * It removes a farm from the file.
     */
    public void removeFarm() {
        Database db = new Database();
        List<Farm> farms = db.recoverFarms();
        for (Farm farm : farms) {
            System.out.println("Posição: " + farms.indexOf(farm) + ", Nome: " + farm.getName() + ", Inscrição Estadual: " + farm.getStateRegistry() + ".");
        }
        System.out.print("\nQual a posição da fazenda que deseja remover? ");
        int position = sc.nextInt();
        farms.remove(position);
        db.recordFarms(farms);
        System.out.println("Operação realizada com sucesso.\n");
    }//End of method removeUser.
        
    @Override
    public String toString(){
        return "\nFazenda: " + getName() + " - Inscrição Estadual: " + getStateRegistry() + "\n" + 
        "Proprietário: " + getOwner() + " - CPF: " + getCpfOwner() + "\n" +
        "Município: " + getCounty() + " - UF " + getState() + "\n";
    }
}