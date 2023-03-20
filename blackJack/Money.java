/*
Spring 2022
Andy Wang
Ms Wolfe
Black Jack Game 
*/


public class Money { //create money class 
    int money; //int called money
    int bet; //int called bet 

    Money(int money) { //constructor 
        this.money = money;
    }

    public int getMoney() { //returns money 
        return money;
    }

    public boolean betMoney(int bet) { //modifier for betting money 
        this.bet = bet;
        if (bet<=money) { //your bet must be less than or equal to your total money 
            money = money - bet; //substract bet from your money 
            System.out.println("Bet Placed - Remaining Funds: " + money);
            return true; //return true if bet was successfully placed 
        } else {
            System.out.println("Insufficient Funds - Remaining Funds: " + money);
            return false; //return false if not enough money 
        }
    }

    public void winMoney(double profit) { 
        money += profit * bet; //if win, multiply the amount you bet by 2 and add it to total money 
    }

    public void tieMoney() { //when you and dealer tie 
        money+=bet; //return money 
    }
}
