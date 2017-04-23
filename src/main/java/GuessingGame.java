public class GuessingGame {
  private Prompter prompter;
  private Jar jar;
  private int guessInt = 0;
  private int numberOfTries = 0;
  private boolean wantToPlayMore = false;
  
  public static void main(String[] args) {
    GuessingGame game = new GuessingGame();// ask for admin settings
    game.play();//start the first game
    game.playMore();//ask to refill the jar and play more if the player wants to
  }
  
  GuessingGame () {
    //construct the game
    prompter = new Prompter();
    jar = prompter.promptForJar();
  }
  
  public void play() {
    boolean isWon = false;
    
    while (!isWon) {
      //1. ask the player for an answer
      askPlayerForAGuess();
      
      //2. check if the player is right
      if (guessInt == jar.getActualNumberOfItems()) {
        isWon = true;
        prompter.winCongrats(numberOfTries);
      } else
      if (guessInt < jar.getActualNumberOfItems()) {
        prompter.guessIsTooLow();
      } else
      if (guessInt > jar.getActualNumberOfItems()) {
        prompter.guessIsTooHigh();
      }
    }//--------end while not won loop
    
  }
  
  public void playMore() {
    do { 
      String yesNoAnswer = prompter.promptToRefillTheJar().toLowerCase();
        if (yesNoAnswer.equals("no")) {
          wantToPlayMore = false;
        } else if (yesNoAnswer.equals("yes")) {
          wantToPlayMore = true;
          jar.fill();
          numberOfTries = 0;
          play();
        } else {
          prompter.incorrectInput();
          playMore();
        }
    } while (wantToPlayMore);
  }
  
  private void askPlayerForAGuess() {
    String guessString = "";
    boolean isValid = false;
    
    //ask the player for a valid answer
    
    while (!isValid) {
      //check if the input is an integer
      try {
        guessString = prompter.promptForAGuess(jar);
        guessInt = Integer.valueOf(guessString);
        
        //if it's a number check if the input is not more than the max number of items
        if (guessInt <= jar.getMaxNumberOfItems()) {
          isValid = true;
          numberOfTries++;
        } else {
          prompter.warnMoreThanMaxItems();
        }
      } catch (NumberFormatException nfe) {
        prompter.incorrectInput();
      }
    }//-----end while didn't get a valid answer loop
    
  }
}