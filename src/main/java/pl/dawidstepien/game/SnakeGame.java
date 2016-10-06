package pl.dawidstepien.game;

import com.googlecode.lanterna.input.Key;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SnakeGame {

  private Berry berry;

  private List<Berry> berries = new ArrayList<>();

  private Board board;

  private Snake snake;

  private Keyboard keyboard;

  private boolean isRunning = true;

  public SnakeGame() {
    board = new Board();
    snake = new Snake(board);
    keyboard = new Keyboard(board);
    berries.add(new Berry(board));
  }

  public void start() {
    drawBorder();
    drawSnake();
    drawBerries();
  }

  private void drawBerries() {
    berries.forEach(Berry::draw);
  }

  private void drawSnake() {
    try{
      snake.draw();
      Square square = snake.getHead();
      for(Berry berry : berries){
        if(berry.isSquare(square)){
          snake.addLength();
          berry.redraw(snake.getParts(), berries);
          break;
        }
      }
    } catch (IllegalPositionException e){
      reset();
    }
  }

  private void reset(){
    snake.reset();
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
    if(key.getKind().equals(Key.Kind.ArrowDown)) {
      snake.setDirection(SnakeDirection.DOWN);
    }
    if(key.getKind().equals(Key.Kind.ArrowLeft)) {
      snake.setDirection(SnakeDirection.LEFT);
    }
    if(key.getKind().equals(Key.Kind.ArrowRight)) {
      snake.setDirection(SnakeDirection.RIGHT);
    }

    drawSnake();

  }

  private void endGame() {
    isRunning = false;
  }

  public void stop() {
    board.stop();
    System.exit(0);
  }
}
