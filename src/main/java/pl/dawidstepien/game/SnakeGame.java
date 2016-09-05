package pl.dawidstepien.game;

public class SnakeGame {

  private Board board;

  private boolean isRunning = true;

  public SnakeGame() {
    board = new Board();
  }

  public void start() {
    Border border = new Border(board);
    border.draw();
  }

  public boolean isRunning() {
    return isRunning;
  }

  public void run() {
//    board.runKeyAction();
  }

  public void stop() {
    board.stop();
    System.exit(0);
  }
}
