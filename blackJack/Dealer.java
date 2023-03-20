/*
Spring 2022
Andy Wang
Ms Wolfe
Black Jack Game 
*/

public class Dealer extends Player
{
	private Deck stackOfCards; 	//define a deck of cards

	public Dealer() {
		stackOfCards = new Deck(); //make new deck called stackOfCards
	}

	public void  shuffle()
	{
		stackOfCards.shuffle(); //shuffle the deck
	}

	public Card deal(){ //deal method 
	   return stackOfCards.nextCard();
	}
	
	public int numCardsLeftInDeck() //check how many cards left in deck 
	{
		return stackOfCards.numCardsLeft();
	}

	public boolean hit() //hit method 
	{
	   if (getHandValue()<17) { //if dealer's hand is less than 17, then return true  
		   return true;
	   }
	   return false;
    }
}








