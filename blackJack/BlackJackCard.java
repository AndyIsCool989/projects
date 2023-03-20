/*
Spring 2022
Andy Wang
Ms Wolfe
Black Jack Game 
*/

public class BlackJackCard extends Card
{
	public BlackJackCard() { //basic constructor
		super();
	}

	public BlackJackCard(int num) { //constructor 
		super(num);
	}

  	public int getValue()
  	{
  		//enables you to build the value for the game into the card
  		//this makes writing the whole program a little easier
		if(getFace()>10) {
			return 10;
		} else {
			return getFace();
		}
			
		

		
  	}
  	
 }