package pl.dawidstepien.game;

import com.googlecode.lanterna.terminal.Terminal;

public class Snake {

  private static final Terminal.Color BORDER_COLOR = Terminal.Color.YELLOW;

  private Board board;

  private int berriesConsumed;

  private int x;

  private int y;

  private SnakeDirection direction = SnakeDirection.NULL;

  public Snake(Board board) {
    this.board = board;
    setCenterPosition(board);
  }

  private void setCenterPosition(Board board) {
    x = (board.getColumns()/2) - 1;
    y = (board.getRows()/2) - 1;
  }

  public void draw() {
    if(!direction.equals(SnakeDirection.NULL)) {
      calculatePosition();
    }
    drawSnakePart(x, y);
  }

  private void calculatePosition() {

  }

  private void drawSnakePart(int x, int y) {
    board.drawSquare(new Square(x, y, BORDER_COLOR));
  }

  public void setDirection(SnakeDirection direction) {
    this.direction = direction;
  }
}
