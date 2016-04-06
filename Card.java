
public class Card {

    private int value, suit;
    
    private static String[] suits = {"hearts", "spades", "diamonds", "clubs"};
    private static String[] values = {"2", "3", "4", "5", "6", "7", "8", "9",
        "10", "Jack", "Queen", "King", "Ace"};
    
    public static String ValueInString(int Value){
        
        return values[Value];
    }
    
    public Card(int suit, int value){
        
        this.value = value;
        this.suit = suit;
        print();
    }
    
    public String print(){
        
        return suits[suit] + values[value];
    }
    
    public int getValue(){
        
        return value;
    }
    
    public int getSuit(){
        
        return suit;
    }

   
}
