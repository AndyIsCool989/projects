/*
Spring 2022
Andy Wang
Ms Wolfe
Black Jack Game 
*/

public class Card //create new class called Card 
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	public static final String SUITS[] = {"HEARTS", "DIAMONDS", "CLUBS", "SPADES"};
	
	private int suit; //initalize number suit 
	private int face; //intialize number face 
	private int cardNum; //intialize cardnum 

  	
	public Card() { //basic constructor 
		cardNum=1;
		face = (cardNum-1)%13+1;
		suit = ((cardNum-1)/13);
	}

	public Card(int num) { //constructor
		cardNum = num;
		face = (cardNum-1)%13+1;
		suit = ((cardNum-1)/13);
	}



  	public int getValue() { //get value method, returns face of card 
  		return face;
  	}

	public int getFace() { //get face method, returns face of card 
		return face;
	}

	public int getSuit() { //get suit method, returns suit of card 
		return suit;
	}

  	//toString
  	public String toString() {
		  return FACES[getFace()] + "of" + SUITS[getSuit()] + "| value =" + getValue();
	  }
 }