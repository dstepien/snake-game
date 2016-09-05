package pl.dawidstepien.game;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    SnakeGame game = new SnakeGame();
    game.start();
    while(game.isRunning()) {
      game.run();
      Thread.sleep(1000);
    }
    game.stop();
  }
}
