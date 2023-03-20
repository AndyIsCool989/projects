/*
Spring 2022
Andy Wang
Ms Wolfe
Black Jack Game 
*/


/*
Black Jack
play game 
	bet money, check if enough money
	player add 2 cards, dealer add 2 cards, last dealer card show value
	player add card - hit?
		add acrd
		get handvalue
	dealer add cards until 17 or higher 

	settle the bet, who wins 

	natural 21 (win)
	tie (dealer wins)
		except 2 natural black jack (no winner)
	

*/

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack
{
	private Dealer dealer; //create new dealer 
	private Player player; //create new player 
	private Money money; //create new money 

	public BlackJack() { //create new blackjack with dealer, player, and 1000 money 
		dealer = new Dealer();
		player = new Player();
		money = new Money(1000);
	}

	public void playGame() { //void playGame method 

		Scanner keyboard = new Scanner(System.in); //set up keyboard to take input from player 
		System.out.println("\ntype yes if you want to play"); 

		String choice = keyboard.nextLine(); //choice is the player's next keyboard input 

		while(choice.equals("yes") && money.getMoney()>0) { //if player types "yes" and their money is above 0, then continue 

			out.print("\n================================================="); //add line to make game more clear and clean 
			player.resetHand(); //reset player hand 
			dealer.resetHand(); //reset dealer hand 

			do { //create do while loop to check and take their money 
				out.print("\nPlace your bet"); //asks to place bet 
				out.println();
				out.println("Remaining funds: " + money.getMoney()); 
			} while (!money.betMoney(keyboard.nextInt()));

			System.out.println("\ngame initiated "); 

			dealer.shuffle(); //shuffles cards 

			//add two cards to player's and dealer's hand
			player.addCardToHand(dealer.deal());
			dealer.addCardToHand(dealer.deal());
			System.out.println("dealer's card is : " + dealer.getHandValue()); //prints only one of dealer's card 
			player.addCardToHand(dealer.deal());
			dealer.addCardToHand(dealer.deal());


			if (player.getHandValue()==21) { //check if player has a natural blackjack (get 21 without hitting)
				out.println("you win! Natrual blackjack!"); 
				money.winMoney(2.5); //add money 
				break;
			}


			out.println("type h if you want to hit, current hand value is: " + player.getHandValue()); //player must type h if they want to hit (add card)

			String choiceHit = keyboard.next(); //choiceHit is the player's next keyboard input 
			out.println("\nCurrent keyboard input: " + choiceHit);
			while (choiceHit.equals("h") && player.getHandValue()<21) { //if the player's keyboard input is h and their handvalue is under 21
				out.println("\nYou hit! Adding card...");
				player.addCardToHand(dealer.deal()); //add card to player's hand 
				System.out.println("current hand value: " + player.getHandValue()); //print out current hand value after hitting 
				if (player.getHandValue()>21) { //if you go over 21, you lose 
					out.println("you went over, should have stopped hitting");
					break;
				}
				choiceHit = ""; //reset choiceHit variable 
				out.println("hit again? type h to hit or type anything else to skip");
				choiceHit = keyboard.next(); //get ready to take in next keyboard input 
			}
			
		

			while(dealer.hit() && player.getHandValue()<=21) { //dealer must hit until 17 
				dealer.addCardToHand(dealer.deal()); //dealer hits, adds card to hand 
				System.out.println("dealer hits, his new hand value is: " + dealer.getHandValue()); //prints out dealer's current hand value 
			}

			if (dealer.getHandValue()>21) { //if dealer goes over, you win 
				out.println("you win! dealer went over!");
				money.winMoney(2); //add money 
				
			}

			else if (player.getHandValue()==21 && dealer.getHandValue()==21) { //if you and dealer both get 21 
				out.print("its a tie! "); 
				money.tieMoney(); //return your bet money 
			}
				

			else if (player.getHandValue() > dealer.getHandValue() && player.getHandValue() <= 21) { //if your hand value is larger than dealer's and is less than or equal to 21 
				out.println("you win!"); //you win 
				out.println("dealer's hand was: " + dealer.getHandValue()); //print dealer's hand 
				out.println("player's hand was: " + player.getHandValue()); //print your hand 
				money.winMoney(2); //add money  
				
			}
			else if (player.getHandValue() < dealer.getHandValue() && dealer.getHandValue()<=21) { //if you hand value was less than dealer's and dealer's was less than 21 
				out.println("you lose!"); //you lose
				out.println("dealer value: " + dealer.getHandValue()); //print out dealer's hand value 
				out.println("player value: " + player.getHandValue()); //print out your hand value 

			}
		}
	}
	
	public static void main(String[] args) {
		BlackJack game = new BlackJack(); //create new blackjack 
		game.playGame(); //call playGame 
		
	}
}