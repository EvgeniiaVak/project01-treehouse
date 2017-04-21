public class GuessingGame {
  
  public static void main(String[] args) {
    Game game = new Game();// ask for admin settings
    game.play();//start the first game
    game.playMore();//ask to refill the jar and play more if the player wants to
  }
}
