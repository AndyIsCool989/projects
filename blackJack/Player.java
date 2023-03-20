/*
Spring 2022
Andy Wang
Ms Wolfe
Black Jack Game 
*/

import java.util.*;

public class Player //class player  
{
   private ArrayList<Card> hand; //new arraylist from card, called hand 
   private int winCount; //count number of wins 

   public Player () { //basic constructor 
      winCount=0; 
      hand = new ArrayList<Card>(); //create new hand 
   }

   public Player (int score) { //constructor 
      winCount = score;
      hand = new ArrayList<Card>(); //create new hand 
   }

   public void addCardToHand( Card temp ) { //method adding a card to current hand 
      hand.add(temp);
   }

   public void resetHand() { //reset player's hand 
      hand.clear();
   }

   public  void setWinCount(int numwins) { //set number of wins for player 
      winCount = numwins;
   }

   public int getWinCount() { return winCount; } //return wincount of player 

   public int getHandSize() { return hand.size(); } //return handsize of player 

   public int getHandValue() { //get total hand value of player 
      int sum = 0; //sum of card values in player's hand 
      int aces = 0; 
      for(Card card : hand) { //check for aces 
         if(card.getValue()==1) { //if there is a ace in the player deck
            aces++; //aces plus 1 
            sum+=11; //add 11 to total hand value 
         } else {
            sum+=card.getValue(); //add card value to hand value 
         }
      }
      while(aces>0 && sum>21) { //if the player has more than 1 ace and goes over 21 
         sum-=10; //subtract 10 from player's hand 
         aces--; //subtract an ace 
      }
      return sum; //return the total value of player's hand 
   }

   //toString 
   public String toString() {
      return hand + "Total Value:" + getHandValue();
   }
}