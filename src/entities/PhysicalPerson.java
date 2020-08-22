package entities;

import java.util.List;
import java.util.Scanner;

public class PhysicalPerson  extends Person{

    public PhysicalPerson() {
    }

    public PhysicalPerson(String id, String name, String addressId, Integer farmId, String password, Boolean userValidated) {
        super(id, name, addressId, farmId, password, userValidated);
    }

    Scanner sc = new Scanner(System.in);

    /**
     * It adds a physicalPerson to the file. 
     */
    public void addPhysicalPerson(PhysicalPerson pp){
        Database.conection(pp);
    }//End of method addPhysicalPerson.
    
    /**
     * It removes a physicalPerson from the file.
     */
    public void removePhysicalPerson() {
        Database db = new Database();
        List<Person> physicalPersons = db.recoverPersons();
        for (Person pp : physicalPersons) {
            System.out.println("Posição: " + physicalPersons.indexOf(pp) + ", nome: " + pp.getName() + ", cpf: " + pp.getId() + ".");
        }
        System.out.print("\nQual a posição do proprietário que deseja remover? ");
        int position = sc.nextInt();
        physicalPersons.remove(position);
        db.recordPersons(physicalPersons);
        System.out.println("Operação realizada com sucesso.\n");
    }//End of method removePhysicalPerson.
    
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
    return "CPF " + this.getId() + " Nome " + this.getName() + address.toString();   
    }
}