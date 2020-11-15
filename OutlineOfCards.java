import java.util.*;

public class OutlineOfCards {
public static void main(String[] args){
int abc = (int)Math.sqrt(Integer.MAX_VALUE/890);
int def = (int)Math.sqrt(Integer.MAX_VALUE/123);
int bankAccount = (int)((Math.random()*abc)+123);
while (bankAccount > 0){
  String[] Suit = {"Clubs", "Diamonds", "Hearts", "Spades"};
  String[] Name = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
  int[] Value = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
  int a = 0;
  int b = 0;
  int c = 0;
  String d = "";
  ArrayList<String> deck = new ArrayList<String>();
  ArrayList<String> playerCards = new ArrayList<String>();
  ArrayList<String> computerCards = new ArrayList<String>();
  int numberOfAces = 0;
  int compNumberOfAces = 0;
  while (a < 4 ){
    while (b < 13){
      Cards newCard = new Cards(Suit[a], Name[b], Value[b]);
      deck.add(newCard.toString());
      b++;
    }
    b = 0;
    a++;
  }
// converting array to a List
//List<String> list = Arrays.asList(stringArray);
// Shuffling list elements
  Collections.shuffle(deck);    
  boolean number = true;
  int compAccount = 0;
  System.out.println("Your cards are:");
  //System.out.println();
  int compVal = 0; 
  int val = 0; 
  int card = 3;
  int zero = 0;
  int one = 1;
  int two = 2;
  int three = 3;
  int four = 4;
  //int ran = (int)(Math.random()*deck.size());
  String q = deck.get(zero++);
  String suitOrigin = q.substring(0,3);
  //int ran2 = (int)(Math.random()*deck.size());
  String f = deck.get(one++);
  String suitOrigin2 = f.substring(0,3);
  //System.out.println(q);
  playerCards.add(q);
  int length1 = q.length()-1;
//System.out.println(e.substring(length1));
  String firstval = q.substring(length1-1);
  int g = Integer.parseInt(firstval.trim());
  if (suitOrigin.equals("Ace")){
    numberOfAces++;
  }
  //System.out.println(g);
  //System.out.println(f);
  playerCards.add(f);
  int length2 = f.length()-1;
  //System.out.println(f.substring(length2-1));
  String secondval = f.substring(length2-1);
  int h = Integer.parseInt(secondval.trim());
  if (suitOrigin2.equals("Ace")){
    numberOfAces++;
  }
  //System.out.println(g+h);
  val += g+h;
  int orival = val;
  System.out.println(playerCards);
  if (numberOfAces>=1){
  System.out.println("Your current value is: " + val + " or " + (val-10));  
  }
  else{
  System.out.println("Your current value is: " + val);
  }
  //System.out.println(e.getName());
  
  System.out.println();
  
  String compi = deck.get(two++);
  //System.out.println(compi);
  computerCards.add(compi);
  int complength3 = compi.length()-1;
  //System.out.println(i.substring(length3));
  String compthirdval = compi.substring(complength3-1);
  int compj = Integer.parseInt(compthirdval.trim());
  //System.out.println(compthirdval);
  compVal += compj;
  //System.out.println(compj);
  System.out.println("The computer's first card is " + computerCards);
  System.out.println("The computer's current value is: " + compVal);
  
  System.out.println();
  
  System.out.println("You have $" + bankAccount + " in your bank account.");
  

  
  Scanner betAmount = new Scanner(System.in);
  String input;
  Integer amount = 0;
  bankAccount = bankAccount;
  boolean validAmount = false;
  Dealer mrD = new Dealer();
  while (validAmount == false){
    amount = mrD.getAmount();
    //System.out.println(amount);
    if (amount > bankAccount){
      System.out.println("You do not have enough money in your account to bet the amount you stated. Please bet a smaller amount.");
      validAmount = false;
    }
    else{
      validAmount = true;
      bankAccount -= amount;
      System.out.println("You have taken $" + amount + " from your bank account. You have $" + bankAccount + " remaining."); 
    }
  }
  //System.out.println("You have $" + bankAccount + " in your bank account.");
  System.out.println("Your cards are: "+playerCards);
  if (numberOfAces>=1){
  System.out.println("Your current value is: " + val + " or " + (val-10));  
  }
  else{
  System.out.println("Your current value is: " + val);
  }
  System.out.println();
  
  //System.out.println("Would you like a hit? please answer yes or no");
  //Scanner hitOrNo = new Scanner(System.in);
  //String answer = hitOrNo.nextLine();  // Read user input
 
  
  
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
    
    boolean hit = true;
    boolean dew = true;
    dew = mrD.getAnswer("Would you like to double down? You can double your bet, but only recieve one more card. Please answer yes or no");
      System.out.println("Your cards are: "+playerCards);
      if (numberOfAces>=1){
        System.out.println("Your current value is: " + val + " or " + (val-10));  
      }
      else{
        System.out.println("Your current value is: " + val);
      }
      System.out.println();
      if(dew == true){
        if (amount*2>=bankAccount){
          System.out.println("You do not have enough money to double your bet");
          dew = false;
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
          amount *= 2;
          String i = deck.get(three++);
          System.out.println(i);
          String suit = i.substring(0,3);
          System.out.println(suit);
          
          int length3 = i.length()-1;
          //System.out.println(i.substring(length3));
          String thirdval = i.substring(length3-1);
          int j = Integer.parseInt(thirdval.trim());
          if (suit.equals("Ace")){
            numberOfAces++;
          }
          if (val + j > 21 && numberOfAces==1){
            val-=10;
            numberOfAces--;
          }
          System.out.println(j);
          val += j;
          playerCards.add(i);
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
      if (dew == false){
        while ( val < 21 && hit == true){
          hit = mrD.getAnswer("Would you like a hit? please answer yes or no");
          if (hit == false){
            System.out.println("You have chosen not to recieve another card, now you are facing off against the computer."); 
            //System.out.println(orival);
          }
          else if (hit == true){
            if (hit == false){ 
          break;
            }
            else if (hit == true){
              //System.out.println(answer);
              String i = deck.get(three++);
              //System.out.println(i);
              String suit = i.substring(0,3);
              //System.out.println(suit);
              
              int length3 = i.length()-1;
              //System.out.println(i.substring(length3));
              String thirdval = i.substring(length3-1);
              int j = Integer.parseInt(thirdval.trim());
              if (suit.equals("Ace")){
                numberOfAces++;
              }
              if (val + j > 21 && numberOfAces==1){
            val-=10;
            numberOfAces--;
              }
              //System.out.println(j);
              val += j;
              playerCards.add(i);
              //System.out.println("total value: " + val);
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
        if(dew == true){
        bankAccount = bankAccount-amount;
        System.out.println("Your current bank account balance is $"+bankAccount);
        }
        else{
        bankAccount = bankAccount;
        System.out.println("Your current bank account balance is $"+bankAccount);
        }
      }
      else{
        while (compVal < 17){
          //System.out.println(compi);
        compi = deck.get(four++);
        computerCards.add(compi);
        String compSuit = compi.substring(0,3);
        System.out.println();
        System.out.println("Computer's Cards:");
        System.out.println(computerCards);
        complength3 = compi.length()-1;
        //System.out.println(i.substring(length3));
        compthirdval = compi.substring(complength3-1);
        compj = Integer.parseInt(compthirdval.trim());
        if (compSuit.equals("Ace")){
          compNumberOfAces++;
        }
        if (compVal + compj > 21 && compNumberOfAces ==1){
          compVal-=10;
          compNumberOfAces--;
        }
        //System.out.println(compthirdval);
        compVal += compj;
        System.out.println("Computer value: " + compVal);
        }
      if (compVal > 21){
        System.out.println("The computer has busted. You have won!");
        if(dew == true){
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
        if(dew == true){
        bankAccount = bankAccount-amount;
        System.out.println("Your current bank account balance is $"+bankAccount);
        }
        else{
        bankAccount = bankAccount;
        System.out.println("Your current bank account balance is $"+bankAccount);
      }
      }
      else if (compVal < val && val <= 21){
        System.out.println("You have a greater value. You have won!");
        if(dew == true){
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
        if(dew == true){
        bankAccount += (amount*2)*2;
        System.out.println("Your current bank account balance is $"+bankAccount);
        }
        else{
        bankAccount += amount*2;
        System.out.println("Your current bank account balance is $"+bankAccount);
      }
    }
      
    System.out.println();
    System.out.println("|||New Game|||");
    System.out.println("|||New Game|||");
    System.out.println("|||New Game|||");
    System.out.println();
  }
  
  
  
}

System.out.println();
System.out.println("|||Game Over|||");
System.out.println("|||Game Over|||");
System.out.println("|||Game Over|||");
System.out.println();

}
}
}







    
    
  




  





