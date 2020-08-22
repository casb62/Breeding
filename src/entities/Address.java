package entities;

import java.util.List;
import java.util.Scanner;

public class Address {
    
    private Integer id;
    private String type;
    private String publicPlace;
    private String number;
    private String complement;
    private String mailbox;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String cep;
    private String coordinates;
    private String fone;
    private String fax;
    private String email;
    private String personId;

    public Address() {
    }

    public Address(Integer id, String type, String publicPlace, String number, String complement, String mailbox, String neighborhood, String city, String state, String country, String cep, String coordinates, String fone, String fax, String email, String personId) {
        this.id = id;
        this.type = type;
        this.publicPlace = publicPlace;
        this.number = number;
        this.complement = complement;
        this.mailbox = mailbox;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.cep = cep;
        this.coordinates = coordinates;
        this.fone = fone;
        this.fax = fax;
        this.email = email;
        this.personId = personId;
    }
    
    Scanner sc = new Scanner(System.in);

    public Integer getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     * It adds an address to the file.
     */
    public void addAddress(){
        System.out.print("Digite o cpf para proprietário pessoa física, "
        + "ou o cnpj para proprietário pessoa jurídica: ");
        String personId = sc.next();
        System.out.print("Digite 1 para endereço da fazenda ou 2 para endereço do proprietário. ");
        Integer id = sc.nextInt();
        System.out.print("Digite Avenida, Rua, Estrada, etc...: ");
        sc.nextLine();
        String type = sc.nextLine();
        System.out.print("Nome: ");
        String publicPlace = sc.nextLine();
        System.out.print("Número: ");
        String number = sc.nextLine();
        System.out.print("Complemento. Deixar em branco se não existir.: ");
        String complement = sc.nextLine();
        if(complement.equals("")){
            complement = null;
        }
        System.out.print("Caixa postal. Deixar em branco se não existir.: ");
        String mailBox = sc.nextLine();
        if(mailBox.equals("")){
            mailBox = null;
        }
        System.out.print("Bairro: ");
        String neighborhood = sc.nextLine();
        System.out.print("Cidade: ");
        String city = sc.nextLine();
        System.out.print("Estado: ");
        String state = sc.nextLine();
        System.out.print("País: ");
        String country = sc.nextLine();
        System.out.print("CEP: ");
        String cep = sc.next();
        System.out.print("Coordenadas UTM. Deixar em branco se não souber.: ");
        sc.nextLine();
        String coordinates = sc.nextLine();
        if(coordinates.equals("")){
            coordinates = null;
        }
        System.out.print("Telefone. Deixar em branco se não tiver.: ");
        String fone = sc.nextLine();
        if(fone.equals("")){
            fone = null;
        }
        System.out.print("Fax. Deixar em branco se não tiver.: ");
        String fax = sc.nextLine();
        if(fax.equals("")){
            fax = null;
        }
        System.out.print("Email. Deixar em branco se não tiver.: ");
        String email = sc.nextLine();
        if(email.equals("")){
            email = null;
        }
        Address address = new Address(id, type, publicPlace, number, complement, mailBox, neighborhood, city, state, country, cep, coordinates, fone, fax, email, personId);
        Database.conection(address);
    }//End of method addAddress.
    
    /**
     * It removes an address from the file.
     */
    public void removeAddress(){
        Database db = new Database();
        List<Address> addresses = db.recoverAddresses();
        for (Address address : addresses) {
            System.out.println("Posição: " + addresses.indexOf(address) + ", Endereço da pessoa: " + address.getPersonId() + ".");
        }
        System.out.print("\nQual a posição do endereço que deseja remover? ");
        int position = sc.nextInt();
        addresses.remove(position);
        db.recordAddresses(addresses);
        System.out.println("Operação realizada com sucesso.\n");
    }//End of method removeAddress.
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getType() + " " + this.getPublicPlace() + ", nº " + this.getNumber());
        sb.append("Complemento: " + this.getComplement() + " Caixa Postal: " + this.getMailbox());
        sb.append("Bairro: " + this.getNeighborhood() + " Cidade: " + this.getCity() + " Estado: " + this.getState() + " Pais: " + this.getCountry());
        sb.append("CEP: " + this.getCep() + " Coordenadas: " + this.getCoordinates());
        sb.append("Fone: " + this.getFone() + " Fax: " + this.getFax() + " Email: " + this.getEmail());
        return sb.toString();
    }
}