/*
Spring 2022
Andy Wang
Ms Wolfe
Black Jack Game 
*/

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
	public static final int NUMFACES = 13; //instantiate numfaces as 13
	public static final int NUMSUITS = 4; //instantiate numsuits as 4 
	public static final int NUMCARDS = 52; //instantiate numcards as 52 

	public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

	private int topCardIndex; //new int called topCardIndex
	private ArrayList<Card> stackOfCards; //create new arraylist called stackOfCards 

	public Deck ()
	{
		//initialize data - stackOfCards - topCardIndex
		topCardIndex = NUMCARDS-1;
		stackOfCards = new ArrayList<Card>();
		
		for(int i=1; i<=NUMCARDS; i++) { //for loop adding 52 cards into the stackOfCards arraylist
			stackOfCards.add(new BlackJackCard(i));
		}
		
		
	}

	//modifiers
   public void shuffle ()
	{
		//shuffle the deck
		//reset variables as needed
		Collections.shuffle(stackOfCards);
		topCardIndex = NUMCARDS-1;
	}

	//accessors 
	public int size () { 
		return stackOfCards.size(); //return size of stackOfCards 
	}

	public int numCardsLeft() {
		return topCardIndex+1; //return number of cards left in deck 
	}

	public Card nextCard() {
		return stackOfCards.get(topCardIndex--); //return the next card in stackOfCards 
	}

	//toString 
	public String toString() {
		return stackOfCards + "   topCardIndex = " + topCardIndex; 
	} 
}