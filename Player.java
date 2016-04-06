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

public class Player {
    
    private static String[] playern_name = {"player 1"};
    private static int bankroll = 1000;
    private int bet;
    private Card[] CardsforPlayer;
    private Card[] CardsforComputer;
    private int[] value;
    private HandCheck hndcom;
    private HandCheck hndper;
    
    public void setbet(int bet){
    
        this.bet=bet;
    }
    
    public void lost_money(){
        
        bankroll -= bet;
    }
    
    public void winnings(){
        
        bankroll += (bet * 2);
    }
    
    public int getBankroll(){
        
        return bankroll;
    }
    
    public void playhand(){
        
        Deck deck1 = new Deck();
        
        int i, changecard, bet, computerScore, playerScore;
        String PlayerOption;
        deck1.deck();
        Scanner in = new Scanner(System.in);
        
        System.out.println("Cards in deck before suffle:");
        
        for (i=0; i<deck1.getTotalCard(); i++){
            
            System.out.println("(" + deck1.getcard(i).getSuit() + "," + 
                    deck1.getcard(i).getValue() + ")");
        }
        
        deck1.shuffle();
        
        System.out.println("Cards in deck after suffle:");
        for (i=0; i<deck1.getTotalCard(); i++){
            
            System.out.println("(" + deck1.getcard(i).getSuit() + "," + 
                    deck1.getcard(i).getValue() + ")");
        }
        
        value = new int[6];
        CardsforPlayer = new Card[5];
        CardsforComputer = new Card[5];
        
        for (i=0; i<5; i++){
            
            CardsforPlayer[i] = deck1.drawCard();
            CardsforComputer[i] = deck1.drawCard();
        }
        
        System.out.println("Your cards is :");
        for (i=0; i<5; i++){
            
            System.out.println("(" + CardsforPlayer[i].getSuit() + "," + 
                    CardsforPlayer[i].getValue() + ")");
        }
        
        System.out.println("Do tou want to redraw?");
        PlayerOption = in.nextLine();
        
        if (PlayerOption.compareTo("yes")==0){
            
            for(i=0; i<5; i++){
                
                CardsforPlayer[i] = deck1.drawCard();
            }
            
            System.out.println("Your new cards is :");
            for (i=0; i<5; i++){
            
            System.out.println("(" + CardsforPlayer[i].getSuit() + "," + 
                    CardsforPlayer[i].getValue() + ")");
            }
        }
        
        else{
            
            System.out.println("Do you want to replace any card? ");
            PlayerOption = in.nextLine();
            
            if (PlayerOption.compareTo("yes")==0){
                
                System.out.println("which one do you want to change?");
                
                for (i=0; i<5; i++){
                    
                    System.out.println("enter " + i + " for " + "(" +
                            CardsforPlayer[i].getSuit() + "," + CardsforPlayer[i].getValue() + ")");
                }
                
                changecard = in.nextInt();
                CardsforPlayer[changecard] = deck1.drawCard();
                System.out.println("Your new cards is :");
                for (i=0; i<5; i++){
            
                    System.out.println("(" + CardsforPlayer[i].getSuit() + "," + 
                    CardsforPlayer[i].getValue() + ")");
                }
            }
        }
        
        System.out.println("how much many do you bet? ");
        bet = in.nextInt();
        
        if (bet<=bankroll){
            
            setbet(bet);
        }
        
        else {
            while (!(bet<=bankroll)){
                System.out.println("you dont have enough money try again! ");
                bet = in.nextInt();
            }
            
            setbet(bet);
        }
        
        System.out.println("computer's cards are:");
        for (i=0; i<5; i++){
            
            System.out.println("(" + CardsforComputer[i].getSuit() + "," + 
                    CardsforComputer[i].getValue() + ")");
        }
        hndcom = new HandCheck();
        computerScore = hndcom.check(CardsforComputer);
        
        if (computerScore < 300){
            
            for (i=0; i<5; i++){
                
                CardsforComputer[i] = deck1.drawCard();
            }
            System.out.println("computer's new cards are:");
            for (i=0; i<5; i++){
            
                System.out.println("(" + CardsforComputer[i].getSuit() + "," + 
                    CardsforComputer[i].getValue() + ")");
            }
        }
        
        computerScore = hndcom.check(CardsforComputer);
        hndper = new HandCheck();
        playerScore = hndper.check(CardsforPlayer);
        
        System.out.println("Computer score = " + computerScore);
        System.out.println("Player score = " + playerScore);
        
        if (playerScore > computerScore){
            System.out.println("you win");
            winnings();
        }
        
        else{
            System.out.println("computer win");
            lost_money();
        }
        
        System.out.println("you have " + bankroll + "$");
    }
    
    
}
