/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author H.ONUR
 */
import java.util.Scanner;

public class DeckTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String playerOption;
        Player player1 = new Player();
        Scanner in = new Scanner(System.in);
        
        
        do {
            
            player1.playhand();
            System.out.println("do you want to continue");
            playerOption = in.nextLine();
            
            if (player1.getBankroll() == 0){
                
                playerOption = "no";
                System.out.println("you dont have money to play!");
            }
        } while(playerOption.compareTo("yes") == 0);
    }
}
