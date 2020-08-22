package entities;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import view.ScreenLogin;
import view.ScreenLogin.Login;

public class User extends PhysicalPerson{

    public User() {
    }

    public User(String id, String name, String addressId, Integer farmId, String password, Boolean userValidated) {
        super(id, name, addressId, farmId, password, userValidated);
    }

    Scanner sc = new Scanner(System.in);

    /**
     * It adds an user to the file.
     */
    public void addUser() {
            System.out.print("Usuário, digite o seu cpf no formato (xxx.xxx.xxx-xx): ");
            String cpf = sc.next();
            sc.nextLine();
            System.out.print("Digite seu nome sem acentuação: ");
            String name = sc.nextLine();
            String addressId = cpf;
            Integer farmId = 1;
            System.out.print("Digite sua senha: ");
            String password = sc.next();
            sc.nextLine();
            Boolean userValidated = Boolean.FALSE;
            User user = new User(cpf, name, addressId, farmId,  password,userValidated);
            Database.conection(user);
            System.out.println("Operação realizada com sucesso.\n");
    }//End of method addUser.

    /**
     * It removes an user from the file.
     */
    public void removeUser() {
        Database db = new Database();
        List<Person> users = db.recoverPersons();
        for (Person user : users) {
            System.out.println("Posição: " + users.indexOf(user) + ", nome: " + user.getName() + ", cpf: " + user.getId() + ".");
        }
        System.out.print("\nQual a posição do usuário que deseja remover? ");
        int position = sc.nextInt();
        users.remove(position);
        db.recordPersons(users);
        System.out.println("Operação realizada com sucesso.\n");
    }//End of method removeUser.

    /**
     * It reads users in the file and adds one if there isn't anyone there.
     */
    public void readUsers() {
        User user = new User();
        Database db = new Database();
        List<Person> users = db.recoverPersons();
        if (users.size() == 0) {
            user.addUser();
        }
    }//End of method readUsers.

    /**
     * It searchs all users in the file and shows their data.
     */
    public void searchUsers() {
        System.out.println();
        Database db = new Database();
        List<Person> users = db.recoverPersons();
        for (Person user : users) {
            if(user.getId().length() == 14 && !user.getPassword().contentEquals("null")){
                User usuario = new User(user.getId(), user.getName(), user.getAddressId(), user.getFarmId(), user.getPassword(), user.getUserValidated());
                System.out.println(usuario);
            }
        }
    }//End of method searchUsers.

    /**
     * It validates the user, welcomes him, and alert him for foot and mouth
     * vaccination in May and November.
     *
     * @return
     */
    public boolean validateUser() {
        ScreenLogin.Login sll = new ScreenLogin().new Login();
        sc.nextLine();
        String typedCpf = sll.getCpf();
        String typedPassword = sll.getPassword();
        Database db = new Database();
        List<Person> users = db.recoverPersons();
        Boolean userValidated = Boolean.FALSE;
        for (Person user : users) {
                if (user.getId().equalsIgnoreCase(typedCpf) && user.getPassword().equalsIgnoreCase(typedPassword)) {
                    user = new User(user.getId(), user.getName(), user.getAddressId(),user.getFarmId(), user.getPassword(),  user.getUserValidated());
                    userValidated = !user.getUserValidated();
                    Calendar c = Calendar.getInstance();
                    int hora = c.get(Calendar.HOUR_OF_DAY);
                    int dia = c.get(Calendar.DAY_OF_MONTH);
                    int mes = c.get(Calendar.MONTH) + 1;
                    int ano = c.get(Calendar.YEAR);
                    if (hora >= 6 && hora < 12) {
                        System.out.println("\nBom dia " + user.getName() + ", seja bem vindo! Hoje é dia " + dia + "/" + mes + "/" + ano + ". Tecle ENTER" + ".\n");
                    } else if (hora >= 12 && hora < 18) {
                        System.out.println("\nBoa tarde " + user.getName() + ", seja bem vindo! Hoje é dia " + dia + "/" + mes + "/" + ano + ". Tecle ENTER" + ".\n");
                    } else {
                        System.out.println("\nBoa noite " + user.getName() + ", seja bem vindo! Hoje é dia " + dia + "/" + mes + "/" + ano + ". Tecle ENTER" + ".\n");
                    }
                    if (mes == 5 || mes == 11) {
                        System.out.println("Não esquecer a vacina contra febre aftosa este mês!\n");
                    }
                } 
            }
        return userValidated;
    }//End of method validatedUser.

    @Override
    public String toString() {
        return "Usuário: " + this.getName()+ " cpf: " + this.getId() + ".";
    }
}