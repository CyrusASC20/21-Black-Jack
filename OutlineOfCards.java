import java.util.*;

public class OutlineOfCards {
public static void main(String[] args){
//initializing starting variables for bank account  
int pBank = (int)Math.sqrt(Integer.MAX_VALUE/890);
int bankAccount = (int)((Math.random()*pBank)+123);
//while loop that runs the program until the player runs out of money
while (bankAccount > 0){
  //the deck of cards is created
  String[] Suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
  String[] Name = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
  int[] Value = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
  int sNum = 0;
  int nNum = 0;
  int vNum = 0;
  String cardStr = "";
  ArrayList<String> deck = new ArrayList<String>();
  ArrayList<String> playerCards = new ArrayList<String>();
  ArrayList<String> computerCards = new ArrayList<String>();
  int numberOfAces = 0;
  int compNumberOfAces = 0;
  while (sNum < 4 ){
    while (nNum < 13){
      Cards newCard = new Cards(Suit[sNum], Name[nNum], Value[nNum]);
      deck.add(newCard.toString());
      nNum++;
    }
    nNum = 0;
    sNum++;
  }
  // Shuffling the deck of cards 
  Collections.shuffle(deck);    
  boolean number = true;
  int compAccount = 0;
  System.out.println("Your cards are:");
  //the player's first cards are dealt 
  int compVal = 0; 
  int val = 0; 
  int card = 3;
  int nextCardIndex = 0;

  String fCard = deck.get(nextCardIndex++);
  String suitOrigin = fCard.substring(0,3);

  String sCard = deck.get(nextCardIndex++);
  String suitOrigin2 = sCard.substring(0,3);
  
  playerCards.add(fCard);
  int length1 = fCard.length()-1;

  String firstVal = fCard.substring(length1-1);
  int fVal = Integer.parseInt(firstVal.trim());
  if (suitOrigin.equals("Ace")){
    numberOfAces++;
  }

  playerCards.add(sCard);
  int length2 = sCard.length()-1;

  String secondVal = sCard.substring(length2-1);
  int sVal = Integer.parseInt(secondVal.trim());
  if (suitOrigin2.equals("Ace")){
    numberOfAces++;
  }

  val += fVal+sVal;
  int oriVal = val;
  System.out.println(playerCards);
  if (numberOfAces>=1){
    System.out.println("Your current value is: " + val + " or " + (val-10));  
  }
  else{
    System.out.println("Your current value is: " + val);
  }

  
  System.out.println();
  //the computer's first cards are dealt
  String compHCard = deck.get(nextCardIndex++);

  computerCards.add(compHCard);
  int compLength3 = compHCard.length()-1;

  String compThirdVal = compHCard.substring(compLength3-1);
  int compHCardVal = Integer.parseInt(compThirdVal.trim());

  compVal += compHCardVal;

  System.out.println("The computer's first card is " + computerCards);
  System.out.println("The computer's current value is: " + compVal);
  
  System.out.println();
  
  System.out.println("You have $" + bankAccount + " in your bank account.");
  

  //the user inputs the amount of money they will bet
  Scanner betamount = new Scanner(System.in);
  String input;
  Integer amount = 0;
  boolean validamount = false;
  Dealer mrD = new Dealer();//creating a new function with from the Dealer.java file
  while (validamount == false){
    amount = mrD.getAmount();//the player is asked how much they would like to bet; fuction checks if input is acceptable

    if (amount > bankAccount){
      System.out.println("You do not have enough money in your account to bet the amount you stated. Please bet a smaller amount.");
      validamount = false;
    }
    else{
      validamount = true;
      bankAccount -= amount;
      System.out.println("You have taken $" + amount + " from your bank account. You have $" + bankAccount + " remaining."); 
    }
  }

  System.out.println("Your cards are: "+playerCards);
  if (numberOfAces>=1){
    System.out.println("Your current value is: " + val + " or " + (val-10));  
  }
  else{
    System.out.println("Your current value is: " + val);
  }
  System.out.println();
  

 
  
  //if player gets Blackjack, they win and a new game begins
  if (val == 21){  
    System.out.println(val); 
    System.out.println("You've yot Blackjack! You've won!!");
    bankAccount += amount*2;
    System.out.println("Your current bank account balance is $"+bankAccount);
    System.out.println("Your cards are: "+playerCards);
    if (numberOfAces>=1){
      System.out.println("Your current value is: " + val + " or " + (val-10));  
    }
    else{
      System.out.println("Your current value is: " + val);
    }
    System.out.println();
    System.out.println();
    System.out.println("|||New Game|||");
    System.out.println("|||New Game|||");
    System.out.println("|||New Game|||");
    System.out.println();
  }
  else{
    //player is asked if they would like to double down
    boolean hit = true;
    boolean dDown = true;
    dDown = mrD.getAnswer("Would you like to double down? You can double your bet, but only recieve one more card. Please answer yes or no");//player is asked whether or not they would like to double down; function cheacks if input is acceptable
    System.out.println("Your cards are: "+playerCards);
    if (numberOfAces>=1){
      System.out.println("Your current value is: " + val + " or " + (val-10));  
    }
    else{
      System.out.println("Your current value is: " + val);
    }
    System.out.println();
    if(dDown == true){
      if (amount>=bankAccount){
        System.out.println("You do not have enough money to double your bet");
        dDown = false;
        System.out.println("Your cards are: "+playerCards);
        if (numberOfAces>=1){
          System.out.println("Your current value is: " + val + " or " + (val-10));  
        }
        else{
          System.out.println("Your current value is: " + val);
        }
        System.out.println();
      }
      else{
        bankAccount -= amount;
        System.out.println("Your current bank account balance is $"+bankAccount);
        String hCard = deck.get(nextCardIndex++);
        System.out.println("You have been dealt the " + hCard);
        String suit = hCard.substring(0,3);

        
        int length3 = hCard.length()-1;

        String thirdVal = hCard.substring(length3-1);
        int hCardVal = Integer.parseInt(thirdVal.trim());
        if (suit.equals("Ace")){
          numberOfAces++;
        }
        if (val + hCardVal > 21 && numberOfAces==1){
          val-=10;
          numberOfAces--;
        }

        val += hCardVal;
        playerCards.add(hCard);
        System.out.println("total value: " + val);
        System.out.println("Your cards are: "+playerCards);
        if (numberOfAces>=1){
          System.out.println("Your current value is: " + val + " or " + (val-10));  
        }
        else{
          System.out.println("Your current value is: " + val);
        }
        System.out.println();
      }
    }
    //if the player does not want to double down, they are asked if they would like to recieve another card
    if (dDown == false){
      while ( val < 21 && hit == true){
        hit = mrD.getAnswer("Would you like a hit? please answer yes or no"); //player is asked whether or not they would like to double down; function cheacks if input is acceptable
        if (hit == false){
          System.out.println("You have chosen not to recieve another card, now you are facing off against the computer.");

        }
        else if (hit == true){
          if (hit == false){ 
            break;
          }
          else if (hit == true){
            //player recieves a new card
            String hCard = deck.get(nextCardIndex++);
            System.out.println("You have been dealt the " + hCard);

            String suit = hCard.substring(0,3);

            
            int length3 = hCard.length()-1;

            String thirdVal = hCard.substring(length3-1);
            int hCardVal = Integer.parseInt(thirdVal.trim());
            if (suit.equals("Ace")){
              numberOfAces++;
            }
            if (val + hCardVal > 21 && numberOfAces==1){
              val-=10;
              numberOfAces--;
            }
            //value of the player's hand is changed based on the card they were dealt
            val += hCardVal;
            playerCards.add(hCard);

            System.out.println("Your cards are: "+playerCards);
            if (numberOfAces>=1){
              System.out.println("Your current value is: " + val + " or " + (val-10));  
            }
            else{
              System.out.println("Your current value is: " + val);
            }
            System.out.println();
          }
        }  
      }
    }
    if (val > 21){  
      System.out.println(val); 
      System.out.println("Sorry, you busted! You lost!");
      //if the players value of their hand goes over 21 and they chose to double down, double their original bet is taken from their account
      if(dDown == true){

        System.out.println("Your current bank account balance is $"+bankAccount);
      }
      else{
        
        System.out.println("Your current bank account balance is $"+bankAccount);
      }
    }
    else{
      while (compVal < 17){
        //computer is dealth a new card
        compHCard = deck.get(nextCardIndex++);
        System.out.println("The computer has been dealt the " + compHCard);
        computerCards.add(compHCard);
        String compSuit = compHCard.substring(0,3);
        System.out.println();
        System.out.println("Computer's Cards:");
        System.out.println(computerCards);
        compLength3 = compHCard.length()-1;

        compThirdVal = compHCard.substring(compLength3-1);
        compHCardVal = Integer.parseInt(compThirdVal.trim());
        if (compSuit.equals("Ace")){
          compNumberOfAces++;
        }
        if (compVal + compHCardVal > 21 && compNumberOfAces ==1){
          compVal-=10;
          compNumberOfAces--;
        }
        //the value of the computer's hand changes based on the value of the new card
        compVal += compHCardVal;
        System.out.println("Computer value: " + compVal);
      }
      //the different possible outcomes of the game. if the player had chosen to double down, they would have recieved double the earnings and if they lost they would have lost double the losses
      if (compVal > 21){
        System.out.println("The computer has busted. You have won!");
        if(dDown == true){
          bankAccount += (amount*2)*2;
          System.out.println("Your current bank account balance is $"+bankAccount);
        }
        else{
          bankAccount += amount*2;
          System.out.println("Your current bank account balance is $"+bankAccount);
        }
      }
      else if (compVal > val && compVal <= 21){
        System.out.println("The computer has a greater value. You have lost!!");
        if(dDown == true){
          
        System.out.println("Your current bank account balance is $"+bankAccount);
        }
        else{
          
          System.out.println("Your current bank account balance is $"+bankAccount);
        }
      }
      else if (compVal < val && val <= 21){
        System.out.println("You have a greater value. You have won!");
        if(dDown == true){
          bankAccount += (amount*2)*2;
          System.out.println("Your current bank account balance is $"+bankAccount);
        }
        else{
          bankAccount += amount*2;
          System.out.println("Your current bank account balance is $"+bankAccount);
        }
      }
      else if (val == compVal ){   
        System.out.println(val); 
        System.out.println("It is a tie, which means you have won!");
        if(dDown == true){
          bankAccount += (amount*2)*2;
          System.out.println("Your current bank account balance is $"+bankAccount);
        }
        else{
          bankAccount += amount*2;
          System.out.println("Your current bank account balance is $"+bankAccount);
        }
      }
      
      
    }
    
    
    
  }
  //after the player has won or lost, a new game is created
  System.out.println();
  System.out.println("|||New Game|||");
  System.out.println("|||New Game|||");
  System.out.println("|||New Game|||");
  System.out.println();
  
}
//once the player's bank account is empty, the game is over
System.out.println();
System.out.println("|||Game Over|||");
System.out.println("|||Game Over|||");
System.out.println("|||Game Over|||");
System.out.println();
}
}







    
    
  




  





