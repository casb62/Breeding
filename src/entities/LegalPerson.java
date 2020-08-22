package entities;

import java.util.List;
import java.util.Scanner;

public class LegalPerson extends Person{

    public LegalPerson() {
    }

    public LegalPerson(String id, String name, String addressId, Integer farmId, String password, Boolean userValidated) {
        super(id, name, addressId, farmId, password, userValidated);
    }

    Scanner sc = new Scanner(System.in);

    /**
     * It adds a legalPerson to the file. 
     */
    public void addLegalPerson(LegalPerson lp){
        Database.conection(lp);
    }//End of method addLegalPerson.
    
    /**
     * It removes a legalPerson from the file.
     */
    public void removeLegalPerson() {
        Database db = new Database();
        List<Person> legalPersons = db.recoverPersons();
        for (Person lp : legalPersons) {
            System.out.println("Posição: " + legalPersons.indexOf(lp) + ", nome: " + lp.getName() + ", cnpj: " + lp.getId() + ".");
        }
        System.out.print("\nQual a posição da empresa proprietária que deseja remover? ");
        int position = sc.nextInt();
        legalPersons.remove(position);
        db.recordPersons(legalPersons);
        System.out.println("Operação realizada com sucesso.\n");
    }//End of method removeLegalPerson.
    
    @Override
    public String toString(){
        Database db = new Database();
        List<Address> addresses = db.recoverAddresses();
        Address address = null;
        for(Address ad: addresses){
            if(ad.getPersonId() == this.getId() && this.getPassword().equals("null")){
                address = new Address(ad.getId(), ad.getType(), ad.getPublicPlace(), ad.getNumber(), ad.getComplement(), ad.getMailbox(), ad.getNeighborhood(), ad.getCity(), ad.getState(), ad.getCountry(), ad.getCep(), ad.getCoordinates(), ad.getFone(), ad.getFax(), ad.getEmail(), ad.getPersonId());
            }
        }
    return "CNPJ " + this.getId() + " Nome " + this.getName() + address.toString();   
    }
}
