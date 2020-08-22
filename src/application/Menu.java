package application;

import entities.Bovine;
import entities.Bull;
import entities.Cow;
import entities.Database;
import entities.Farm;
import entities.Herd;
import entities.User;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Cássio Alberto Santos Baptistussi
 */
public class Menu {

    //Constants that represent menu's options.
    private static final int LOGOUT = 0;
    private static final int SHOW_HELP = 1;
    private static final int ADD_USER = 2;
    private static final int REMOVE_USER = 3;
    private static final int SEARCH_USER = 4;
    private static final int REMOVE_FARM = 5;
    private static final int SEARCH_FARM = 6;
    private static final int DECLARE_BIRTH = 7;
    private static final int DECLARE_PURCHASE = 8;
    private static final int DECLARE_DEATH = 9;
    private static final int DECLARE_SALE = 10;
    private static final int DECLARE_BRUCELLOSIS = 11;
    private static final int SEARCH_BOVINE = 12;
    private static final int SEARCH_BY_RACE = 13;
    private static final int SHOW_HERD = 14;
    private static final int SHOW_CATEGORIES = 15;
    private static final int SHOW_DEAD = 16;
    private static final int SHOW_SOLD = 17;
    private static final int SHOW_BREEDS = 18;

    Scanner sc = new Scanner(System.in);
    boolean userValidated;
    boolean exit;
    User user = new User();
    Bull bull = new Bull();
    Cow cow = new Cow();
    Farm farm = new Farm();
    Database db = new Database();

    public static void main(String[] args) {
        User user = new User();
        user.readUsers();
        Farm farm = new Farm();
        farm.readFarms();
        Menu menu = new Menu();
        System.out.println(menu.showHelp());
        menu.runMenu();
    }

    public void runMenu() {
        while (!userValidated) {
            printHeader();
            try {
                userValidated = user.validateUser();
                sc.nextLine();
                if (userValidated == false) {
                    System.out.println("CPF ou Senha inválidos! Tente novamente!\n");
                }
                Menu.clearScreen();
            } catch (NullPointerException e) {
                System.out.println("\nErro: " + e + ".\n");
            }
        }
        while (!exit) {
            printHeader();
            printMenu();
            int choice = getInput();
            performAction(choice);
            sc.nextLine();
            Menu.clearScreen();
        }
    }

    private void printHeader() {
        System.out.println("                                                 +-----------------------------------------------+");
        System.out.println("                                                 |          Software para Gerenciamento          |");
        System.out.println("                                                 |             de Criação de Bovinos             |");
        System.out.println("                                                 +-----------------------------------------------+");
    }

    private void printMenu() {
        System.out.println("\nEscolha uma opção:\n");
        System.out.println("1 - Exibir ajuda.");
        System.out.println("2 - Incluir usuário.");
        System.out.println("3 - Excluir usuário.");
        System.out.println("4 - Pesquisar usuários.");
        System.out.println("5 - Excluir fazenda.");
        System.out.println("6 - Pesquisar fazenda.");
        System.out.println("7 - Declarar nascimento.");
        System.out.println("8 - Declarar compra.");
        System.out.println("9 - Declarar morte.");
        System.out.println("10 - Declarar venda.");
        System.out.println("11 - Declarar vacinação contra brucelose.");
        System.out.println("12 - Pesquisar animal por número.");
        System.out.println("13 - Pesquisar animais por raça.");
        System.out.println("14 - Exibir rebanho por animais.");
        System.out.println("15 - Exibir rebanho por categorias.");
        System.out.println("16 - Listar os animais mortos.");
        System.out.println("17 - Listar os animais vendidos.");
        System.out.println("18 - Listar crias por vaca.");
        System.out.println("0 - Sair.");
    }

    private int getInput() {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > 18) {
            try {
                System.out.print("\nDigite sua opção: ");
                choice = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
        return choice;
    }

    private void performAction(int choice) {
        List<Farm> farms = db.recoverFarms();
        Farm farm = farms.get(0);
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        switch (choice) {
            case LOGOUT:
                exit = true;
                System.out.println("\nObrigado por usar este software.\n");
                break;
            case SHOW_HELP:
                System.out.println("\n----------IMPORTANTE. LEIA ANTES DE USAR O SISTEMA.----------");
                System.out.println(menu.showHelp());
                break;
            case ADD_USER:
                user.addUser();
                break;
            case REMOVE_USER:
                user.removeUser();
                break;
            case SEARCH_USER:
                System.out.println("\n----------USUÁRIOS CADASTRADOS----------");
                user.searchUsers();
                break;
            case REMOVE_FARM:
                farm.removeFarm();
                break;
            case SEARCH_FARM:
                System.out.println("\n----------FAZENDA CADASTRADA----------");
                farm.searchFarms();
                break;
            case DECLARE_BIRTH:
                System.out.print("Digite M ou F para o sexo do animal: ");
                String sexo1,
                 sexo2,
                 sexo3;
                sexo1 = "M";
                sexo2 = "F";
                sexo3 = sc.next();
                if (sexo3.equalsIgnoreCase(sexo1)) {
                    bull.declareBirth();
                } else if (sexo3.equalsIgnoreCase(sexo2)) {
                    cow.declareBirth();
                }
                break;
            case DECLARE_PURCHASE:
                System.out.print("Digite M ou F para o sexo do animal: ");
                sexo1 = "M";
                sexo2 = "F";
                sexo3 = sc.next();
                if (sexo3.equalsIgnoreCase(sexo1)) {
                    bull.declarePurchase();
                } else if (sexo3.equalsIgnoreCase(sexo2)) {
                    cow.declarePurchase();
                }
                break;
            case DECLARE_DEATH:
                System.out.print("Digite M ou F para o sexo do animal: ");
                sexo1 = "M";
                sexo2 = "F";
                sexo3 = sc.next();
                if (sexo3.equalsIgnoreCase(sexo1)) {
                    bull.declareDeath();
                } else if (sexo3.equalsIgnoreCase(sexo2)) {
                    cow.declareDeath();
                }
                break;
            case DECLARE_SALE:
                System.out.print("Digite M ou F para o sexo do animal:");
                sexo1 = "M";
                sexo2 = "F";
                sexo3 = sc.next();
                if (sexo3.equalsIgnoreCase(sexo1)) {
                    bull.declareSale();
                } else if (sexo3.equalsIgnoreCase(sexo2)) {
                    cow.declareSale();
                }
                break;
            case DECLARE_BRUCELLOSIS:
                cow.declareBrucellosis();
                break;
            case SEARCH_BOVINE:
                Bovine.searchBovine();
                break;
            case SEARCH_BY_RACE:
                Bovine.searchByRace();
                break;
            case SHOW_HERD:
                System.out.println(farm);
                System.out.println("\n----------REBANHO DA FAZENDA----------");
                Herd.showHerd();
                break;
            case SHOW_CATEGORIES:
                System.out.println(farm);
                System.out.println("\n----------REBANHO POR CATEGORIAS----------");
                Herd.showCategories();
                break;
            case SHOW_DEAD:
                System.out.println(farm);
                System.out.println("\n----------ANIMAIS MORTOS----------");
                Herd.showDead();
                break;
            case SHOW_SOLD:
                System.out.println(farm);
                System.out.println("\n----------ANIMAIS VENDIDOS----------");
                Herd.showSold();
                break;
            case SHOW_BREEDS:
                System.out.println("\n----------CRIAS E INTERVALO ENTRE PARTOS----------");
                cow.searchBreeds();
                break;
            default:
                System.out.println("Um erro desconhecido ocorreu.");
        }
    }

    // https://stackoverflow.com/questions/2979383/java-clear-the-console
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public String showHelp() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nPara começar a usar este sistema, o primeiro passo é cadastrar um usuário.\n");
        sb.append("Depois, cadastrar uma fazenda.\n");
        sb.append("Após escolher uma opção e o sistema exibir o respectivo conteúdo, digitar ENTER para continuar.\n");
        sb.append("Digitar o cpf no formato xxx.xxx.xxx-xx.\n");
        sb.append("Digitar as datas no formato dd/mm/aaaa.\n");
        sb.append("Para declarar nascimento, compra, morte ou venda, digitar m, M, f ou F para o sexo dos animais.\n");
        sb.append("Para declarar nascimento, a mãe do animal já deve estar cadastrada.\n");
        sb.append("Os animais provenientes de compra têm número da mãe igual a zero.\n");
        sb.append("Para uma melhor visualização no terminal, clicar com o botão direito do mouse na barra de título,\n");
        sb.append("em propriedades, e ajustar as configurações como tamanho de tela, tamanho da fonte, etc.\n");
        return sb.toString();
    }
}