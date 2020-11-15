public class Cards {
  private String suit;
  private String name;
  private int value;
  public Cards (String s, String n, int v)
  {
    suit = s;
    name = n;
    value = v;
  }
  
  public String getSuit()
  {
    return suit;
  }
  public String getName()
  {
    return name;
  }
  public int getValue()
  {
    return value;
  }
   public String toString(){
    return name + " of " + suit + " " + (int) value;
  }
}
  
  
    
    

