import java.util.Random;
import java.util.ArrayList;

public class Deck {
    
    private ArrayList <Card> cards;
    
    void deck(){
        
        cards = new ArrayList<Card>();
        
        int list1, list2, i, j, size;
        
        Random generator = new Random();
        Card temp;
        
        for(i=0; i<4; i++){
            
            for(j=0; j<13; j++){
                
                cards.add(new Card(i,j));
            }
        }
        
        
        
    }
    
    public Card drawCard(){
        
        return cards.remove(0);
          
    }
    
    public int getTotalCard(){
        
        return cards.size();
    }
    
    public Card getcard(int x){
        
        return cards.get(x);
    }
    
    public void shuffle(){
        int i,list1,list2,size;
        Card temp;
        Random generator = new Random();
        for(i=0; i<100; i++){
            
            list1 = generator.nextInt(cards.size() - 1);
            list2 = generator.nextInt(cards.size() - 1);
            
            temp = cards.get(list2);
            
            cards.set(list2, cards.get(list1));
            cards.set(list1, temp);
        }
    }
}
