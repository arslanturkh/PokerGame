/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author H.ONUR
 */
import java.util.*;

public class HandCheck {
    
   public int check(Card hand[]){

		if(hand == null || hand.length != 5){
			System.out.println("Your hand is not 5 cards. Fix your code and try again.");
			System.exit(0);
		}

		Card[] shand = sortHand(hand);

		int rank = 0;

		if((rank = straightFlush(shand)) > 0){
			rank += 800;
		}else if((rank = fourOfAKind(shand)) > 0){
			rank += 700;
		}else if((rank = fullHouse(shand)) > 0){
			rank += 600;
		}else if((rank = flush(shand)) > 0){
			rank += 500;
		}else if((rank = straight(shand))  > 0){
			rank += 400;
		}else if((rank = threeOfAKind(shand)) > 0){
			rank += 300;
		}else if((rank = twoPair(shand)) > 0){
			rank += 200;
		}else if((rank = pair(shand)) > 0){
			rank += 100;
		}else{
			rank = highCard(shand);
		}

		return rank;

	}

	private int straightFlush(Card hand[]){
		if(flush(hand) > 0 && straight(hand) > 0){
			return hand[4].getValue();
		}else{
			return 0;
		}
	}

	private int flush(Card hand[]){
		boolean isFlush = true;
		int suit = hand[0].getSuit();
		for(int i = 0; i < hand.length; i++){
			if(hand[i].getSuit() != suit){
				isFlush = false;
			}
		}
		if(isFlush)
			return hand[4].getValue();
		else
			return 0;
	}

	private int straight(Card hand[]){
		boolean isStraight = true;
		int val = 0;
		for(int i = 0; i < hand.length - 1; i++){
			val = hand[i].getValue();
			if(val != (hand[i+1].getValue() - 1)){
				isStraight = false;
			}
		}
		if(isStraight){
			return val;
		}else
			return 0;
	}

	private int fullHouse(Card hand[]){
		int cards = threeOfAKind(hand);
		int pair = 0;
		if(cards != 0){
			for(int i = 0; i < hand.length -1; i++){
				if(hand[i].getValue() != cards){
					if(hand[i].getValue() == hand[i+1].getValue()){
						pair = hand[i].getValue();
						if(pair < cards)
							return cards;
						else
							return pair;
					}
				}
			}
		}
		return 0;
	}

	private int fourOfAKind(Card hand[]){
		for(int i = 0; i < hand.length - 3; i++){
			if(hand[i].getValue() == hand[i+1].getValue() && 
				hand[i].getValue() == hand[i+2].getValue() &&
				hand[i].getValue() == hand[i+3].getValue()){
				return hand[i].getValue();
			}
		}
		return 0;
	}

	private int threeOfAKind(Card hand[]){
		for(int i = 0; i < hand.length - 2; i++){
			if(hand[i].getValue() == hand[i+1].getValue() && hand[i].getValue() == hand[i+2].getValue()){
				return hand[i].getValue();
			}
		}
		return 0;
	}

	private int twoPair(Card hand[]){
		int numPairs = 0;
		int highestPair = 0;
		for(int i = 0; i < hand.length - 1; i++){
			if(hand[i].getValue() == hand[i+1].getValue()){
				highestPair = hand[i].getValue();
				numPairs++;
			}
		}

		if(numPairs == 2){
			return highestPair;
		}
		return 0;
	}

	private int pair(Card hand[]){
		for(int i = 0; i < hand.length -1; i++){
			if(hand[i].getValue() == hand[i+1].getValue()){
				return hand[i].getValue();
			}
		}
		return 0;
	}

	private int highCard(Card hand[]){
		int high = hand[0].getValue();
		for(int i = 1; i < hand.length; i++){
			if(high < hand[i].getValue()){
				high = hand[i].getValue();
			}
		}
		return high;
	}

	private int lowCard(Card hand[]){
		int low = hand[0].getValue();
		for(int i = 1; i < hand.length; i++){
			if(low > hand[i].getValue()){
				low = hand[i].getValue();
			}
		}
		return low;
	}

	private Card[] sortHand(Card hand[]){
		Card[] shand = Arrays.copyOf(hand, 5);
		for(int i = 0; i < shand.length; i++){
			for(int j = 0; j < shand.length; j++){
				if(shand[i].getValue() <= shand[j].getValue()){
					Card temp = shand[i];
					shand[i] = shand[j];
					shand[j] = temp;
				}
			}
		}
		return shand;
	}

    void Cnoheck(Card[] CardsforComputer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
