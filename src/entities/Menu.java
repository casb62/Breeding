package entities;

import java.util.Scanner;

public class Menu {
    
    //Constants that represent menu's options.
    private static final int SHOW_HELP = 1;
    private static final int ADD_USER = 2;
    private static final int REMOVE_USER = 3;
    private static final int SEARCH_USER = 4;
    private static final int DECLARE_BIRTH = 5;
    private static final int DECLARE_PURCHASE = 6;
    private static final int DECLARE_DEATH = 7;
    private static final int DECLARE_SALE = 8;
    private static final int DECLARE_BRUCELLOSIS = 9;
    private static final int SEARCH_BOVINE = 10;
    private static final int SHOW_HERD = 11;
    private static final int SHOW_CATEGORIES = 12;
    private static final int SHOW_DEAD = 13;
    private static final int SHOW_SOLD = 14;
    private static final int LOGOUT = 15;
    
    public static void showMenu(){
        User user = new User();
        Bull bull = new Bull();
        Cow cow = new Cow();
        Menu menu = new Menu();
        System.out.println(menu);
        int option = 0;
        Scanner sc = new Scanner(System.in);
        do{
            option = sc.nextInt();
            switch(option){
                case SHOW_HELP:
                    System.out.println(menu.showHelp());
                    break;
                case ADD_USER:
                    user.addUser();
                    break;
                case REMOVE_USER:
                    user.removeUser();
                    break;
                case SEARCH_USER:
                    user.searchUsers();
                    break;
                case DECLARE_BIRTH:
                    System.out.print("Digite M ou F para o sexo do animal: ");
                    String sexo1, sexo2, sexo3;
                    sexo1 = "M";
                    sexo2 = "F";
                    sexo3 = sc.next();
                    if(sexo3.equalsIgnoreCase(sexo1)){
                        bull.declareBirth();
                    }else if(sexo3.equalsIgnoreCase(sexo2)){
                        cow.declareBirth();
                    }
                    break;
                case DECLARE_PURCHASE:
                    System.out.print("Digite M ou F para o sexo do animal: ");
                    sexo1 = "M";
                    sexo2 = "F";
                    sexo3 = sc.next();
                    if(sexo3.equalsIgnoreCase(sexo1)){
                        bull.declarePurchase();
                    }else if(sexo3.equalsIgnoreCase(sexo2)){
                        cow.declarePurchase();
                    }
                    break;
                case DECLARE_DEATH:
                    System.out.print("Digite M ou F para o sexo do animal: ");
                    sexo1 = "M";
                    sexo2 = "F";
                    sexo3 = sc.next();
                    if(sexo3.equalsIgnoreCase(sexo1)){
                        bull.declareDeath();
                    }else if(sexo3.equalsIgnoreCase(sexo2)){
                        cow.declareDeath();
                    }
                    break;
                case DECLARE_SALE:
                    System.out.print("Digite M ou F para o sexo do animal:");
                    sexo1 = "M";
                    sexo2 = "F";
                    sexo3 = sc.next();
                    if(sexo3.equalsIgnoreCase(sexo1)){
                        bull.declareSale();
                    }else if(sexo3.equalsIgnoreCase(sexo2)){
                        cow.declareSale();
                    }
                    break;
                case DECLARE_BRUCELLOSIS:
                    cow.declareBrucellosis();
                    break;
                case SEARCH_BOVINE:
                    Bovine.searchBovine();
                    break;
                case SHOW_HERD:
                    Herd.showHerd();
                    break;
                case SHOW_CATEGORIES:
                    Herd.showCategories();
                    break;
                case SHOW_DEAD:
                    Herd.showDead();
                    break;
                case SHOW_SOLD:
                    Herd.showSold();
                    break;
                case LOGOUT:
                    System.out.println("Saindo...\n");
                    break;
                default:
                    System.err.println("Você não digitou uma opção válida! Tente novamente.\n");
            }//End of switch.
            
        }while(option != 15);
    }//End of method showMenu.
    
    public String showHelp(){
        StringBuilder sb = new StringBuilder();
        sb.append("Para uma melhor visualização no terminal, clicar com o botão direito do mouse \n");
        sb.append("na barra de título, em propriedades, layout, e configurar o tamanho do buffer \n");
        sb.append("de tela com largura 205 e altura 290.\n");
        sb.append("Para utilizar este sistema, o primeiro passo é cadastrar um usuário.\n");
        sb.append("Digitar o cpf no formato xxx.xxx.xxx-xx.\n");
        sb.append("Para declarar nascimento, compra, morte ou venda, digitar m, M, f ou F para o sexo dos animais.\n");
        sb.append("Digitar as datas no formato dd/mm/aaaa.\n");
        sb.append("Para declarar nascimento, a mãe do animal já deve estar cadastrada.\n");
        sb.append("Os animais provenientes de compra têm número da mãe igual a zero.\n");
        return sb.toString();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tMENU\n\n");
        sb.append("1 - Exibir ajuda.\n");
        sb.append("2 - Incluir usuário.\n");
        sb.append("3 - Excluir usuário.\n");
        sb.append("4 - Pesquisar usuários.\n");
        sb.append("5 - Declarar nascimento.\n");
        sb.append("6 - Declarar compra.\n");
        sb.append("7 - Declarar morte.\n");
        sb.append("8 - Declarar venda.\n");
        sb.append("9 - Declarar brucelose.\n");
        sb.append("10 - Pesquisar animal.\n");
        sb.append("11 - Exibir rebanho por animais.\n");
        sb.append("12 - Exibir rebanho por categorias.\n");
        sb.append("13 - Listar os animais mortos.\n");
        sb.append("14 - Listar os animais vendidos.\n");
        sb.append("15 - Sair.\n\n");
        sb.append("Escolha uma opção: ");
        return sb.toString();
    }
}
