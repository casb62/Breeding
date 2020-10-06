package entities;

import java.util.Random;

public class Test {
    
    public static int counter = 0;
    public static Random gerador = new Random();
    
    public static void main(String[] args){
        
            
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                for(int i = 0; i <= 9; i++){
                   
                    System.out.println(ch + "-" + i);
                    //System.out.println(i);
                    counter++;
                    
                }
                
        }
        
        System.out.println(counter);
        System.out.println(gerador.nextInt(10));//de 0 a 9
    }
}
