import java.util.Scanner;

public class Prompter {
  
  public Jar promptForJar () {
    Scanner scanner = new Scanner (System.in);
    //1. ask for which items
    System.out.println("=============++++ Administrator Mode ++++=============");
    System.out.printf("%nWhat items should be in the jar?%n (e.g. cookies, almonds) - ");
    String typeOfItems = scanner.nextLine();
    //2. ask for max number of the items
    System.out.printf("%nWhat is the maximum number of %s can be in the jar?%n (enter an integer) ", typeOfItems);
    int maxNumberOfItems = scanner.nextInt();
    System.out.printf("=============++++ ------------------ ++++=============%n%n%n");
    
    //3. construct the jar
    return new Jar(typeOfItems, maxNumberOfItems);
  }
  
  public String promptForAGuess (Jar jar) {
    Scanner scanner = new Scanner (System.in);
    boolean isValid = false;
    
    System.out.printf("%n%nHow many %s are in the jar?%n(pick a number between 1 and %d): ",
                      jar.getItemName(),
                      jar.getMaxNumberOfItems()
                     );
    return scanner.nextLine();
  }
  
  public void guessIsTooLow() {
    System.out.println("Your guess is too low");
  }
  public void guessIsTooHigh() {
    System.out.println("Your guess is too high");
  }
  
  public void winCongrats (int numberOfGuesses) {
    System.out.println("Congratulations! You won!!!");
    if (numberOfGuesses == 1) {
      System.out.printf ("You got it in %d attempt.%n%n", numberOfGuesses);
    } else {
      System.out.printf ("You got it in %d attempts.%n%n", numberOfGuesses);
    }
  }
  
  public String promptToRefillTheJar() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Do you want to refill the jar? (yes/no)  ");
    return scanner.nextLine();
  }
              
  public void incorrectInput() {
    System.out.println ("%nIncorrect input!");
  }
  
  public void warnMoreThanMaxItems() {
    System.out.printf("%nYour guess must be less than maximum fill amount!");
  }
}