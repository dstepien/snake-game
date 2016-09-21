package pl.dawidstepien.game;

import com.googlecode.lanterna.input.Key;

public class SnakeGame {

  private Board board;

  private Snake snake;

  private Keyboard keyboard;

  private boolean isRunning = true;

  public SnakeGame() {
    board = new Board();
    snake = new Snake(board);
    keyboard = new Keyboard(board);
  }

  public void start() {
    drawBorder();
    drawSnake();
//    drawBerry();
  }

  private void drawSnake() {
    snake.draw();
  }

  private void drawBorder() {
    Border border = new Border(board);
    border.draw();
  }

  public boolean isRunning() {
    return isRunning;
  }

  public void run() {
    Key key = board.getCurrentKey();

    if(key.getKind().equals(Key.Kind.Escape)) {
      endGame();
    }

    if(key.getKind().equals(Key.Kind.ArrowUp)) {
      snake.setDirection(SnakeDirection.UP);
    }

    snake.draw();
  }

  private void endGame() {
    isRunning = false;
  }

  public void stop() {
    board.stop();
    System.exit(0);
  }
}
