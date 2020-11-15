import java.util.*;
public class Dealer{
  int bankAccount = (int)Math.sqrt(Integer.MAX_VALUE)/123;
  public int getAmount(){
        Scanner betAmount = new Scanner(System.in);
    String input;
    Integer amount = 0;
    bankAccount = bankAccount;
    boolean validAmount = false;
    
    while(validAmount == false)
    {
      try {
        System.out.println("How much would you like to bet? Please enter an approriate number.");
        betAmount = new Scanner(System.in);
        input = betAmount.nextLine();
        amount = Integer.parseInt(input);
        if (amount <= 0){
         System.out.println("This is not an appropriate value");
          validAmount = false;
        }
        else{
          validAmount = true;
        }
        //List<Book> books = bookService . findBooksCheaperThan(intCost);
      }
      catch (NumberFormatException e) {
        //exception = false;
        //while(exception == false){      
        System.out.println("This is not an appropriate value");
      }
      catch (InputMismatchException rf) {
        //exception = false;
        //while(exception == false){
        System.out.println("This is not an appropriate value");
      }
    }
    
    return amount;
    
  }
  public boolean getAnswer(String question){
    boolean hit = true;
    boolean validAnswer = false;
    while(validAnswer == false){
    System.out.println(question);
    Scanner hitOrNo = new Scanner(System.in);
    String answer = hitOrNo.nextLine();  // Read user input
    if (answer.equals("yes")){
    hit = true;
    validAnswer = true;
    }
    else if (answer.equals("no")){
    hit = false;
    validAnswer = true;
    }
    else {
    validAnswer = false;
    System.out.println("Please enter an appropriate answer.");
    }
    }
    return hit;
  }
}