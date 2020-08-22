package entities;

import java.util.List;
import java.util.Scanner;

public class Farm {

    private Integer id;
    private String name;
    private String stateRegistry;
    private String addressId;
    private String personId;
    
    public Farm() {
    }

    public Farm(Integer id, String name, String stateRegistry, String addressId, String personId) {
        this.id = id;
        this.name = name;
        this.stateRegistry = stateRegistry;
        this.addressId = addressId;
        this.personId = personId;
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

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     * It adds a farm to the file.
     */
    public void addFarm() {
        Integer farmId = 1;
        System.out.print("Digite o nome da fazenda: ");
        String name = sc.nextLine();
        System.out.print("Digite o número da Inscrição Estadual: ");
        String stateRegistry = sc.next();
        System.out.println("Vamos ao endereço da fazenda: ");
        Address address = new Address();
        address.addAddress();
        Database db = new Database();
        Address addressFromArq = db.recoverAddress();
        String addressId = addressFromArq.getPersonId();
        String personId = addressFromArq.getPersonId();
        if(personId.length() == 14){
            String cpf = personId;
            sc.nextLine();
            System.out.print("Digite o nome do proprietário: ");
            String owner = sc.nextLine();
            System.out.println("Agora, vamos ao endereço do proprietário: ");
            address.addAddress();
            String password = null;
            Boolean userValidated = Boolean.FALSE;
            PhysicalPerson pp = new PhysicalPerson(personId, owner, addressId, farmId, password, userValidated);
            pp.addPhysicalPerson(pp);
            Farm farm = new Farm(farmId, name, stateRegistry, addressId, cpf);
            Database.conection(farm);
            System.out.println("Operação realizada com sucesso.\n");
        }else if(personId.length() == 18){
            String cnpj = personId;
            sc.nextLine();
            System.out.print("Digite o nome da empresa proprietária: ");
            String owner = sc.nextLine();
            System.out.println("Agora, vamos ao endereço da empresa proprietária: ");
            address.addAddress();
            String password = null;
            Boolean userValidated = Boolean.FALSE;
            LegalPerson lp = new LegalPerson(personId, owner, addressId, farmId, password, userValidated);
            lp.addLegalPerson(lp);
            Farm farm = new Farm(farmId, name, stateRegistry, addressId, cnpj);
            Database.conection(farm);
            System.out.println("Operação realizada com sucesso.\n");
        }    
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
    }//End of method removeFarm.
    
    /**
     * It searchs all farms in the file and shows their data.
     */
    public void searchFarms() {
        Database db = new Database();
        List<Farm> farms = db.recoverFarms();
        for (Farm farm : farms) {
                System.out.println(farm);
                System.out.println();
        }
    }//End of method searchFarms.
    
    /**
     * It reads farms in the file and adds one if there isn't anyone there.
     */
    public void readFarms() {
        Farm farm = new Farm();
        Database db = new Database();
        List<Farm> farms = db.recoverFarms();
        if (farms.size() == 0) {
            farm.addFarm();
        }
    }//End of method readFarms.
        
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nFazenda " + this.getName() + " - Inscrição Estadual " + this.getStateRegistry() + "\n");
        Database db = new Database();
        List<Address> addresses = db.recoverAddresses();
        for(Address ad: addresses){
            if(ad.getId() == 1){
                sb.append(ad.getType() + " " + ad.getPublicPlace() + ", " + ad.getNumber() + " " + ad.getComplement() + " " +
                "Caixa Postal " + ad.getMailbox() + " " + ad.getNeighborhood() + "\n" +
                "CEP " + ad.getCep() + " - " + ad.getCity() + " - " + ad.getState() + " - " + ad.getCountry() + "\n" + 
                "Coordenadas " + ad.getCoordinates() + " - Fone " + ad.getFone() + " - Fax " + ad.getFax() + "\n" +
                "Email " + ad.getEmail());
            }
        }
        List<Person> persons = db.recoverPersons();
        for(Person p: persons){
            if(p.getId().equals(this.getPersonId()) && p.getPassword().contentEquals("null")){
                sb.append(" - Proprietário " + p.getName());
            }
        }
        return sb.toString();
    }
}