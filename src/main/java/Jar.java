import java.util.Random;

public class Jar {
  private String itemName;
  private int maxNumberOfItems;
  private int actualNumberOfItems;
  
  public Jar (String itemName, int maxNumberOfItems) {
    this.itemName = itemName;
    this.maxNumberOfItems = maxNumberOfItems;
    this.fill();
  }
  
  public String getItemName () {
    return itemName;
  }
  public int getMaxNumberOfItems () {
    return maxNumberOfItems;
  }
  public int getActualNumberOfItems () {
    return actualNumberOfItems;
  }
  
  public void fill () {
    Random random = new Random();
    actualNumberOfItems = random.nextInt(maxNumberOfItems) + 1;
  }
}