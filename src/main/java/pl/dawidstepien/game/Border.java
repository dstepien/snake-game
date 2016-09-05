package pl.dawidstepien.game;

import com.googlecode.lanterna.terminal.Terminal;

public class Border {

  private static final Terminal.Color BORDER_COLOR = Terminal.Color.BLUE;

  private final Board board;

  public Border(Board board) {
    this.board = board;
  }

  public void draw() {
    drawCorners();
    drawTop();
    drawLeft();
    drawRight();
    drawBottom();
  }
  private void drawCorners() {
    drawBorderSquare(0, 0);
    drawBorderSquare(board.getColumns() - 2, 0);
    drawBorderSquare(0, board.getRows() - 1);
    drawBorderSquare(board.getColumns() - 2, board.getRows() - 1);
  }

  private void drawTop() {
    for(int i = 2; i < board.getColumns() - 2; i += 2) {
      drawBorderSquare(i, 0);
    }
  }

  private void drawLeft() {
    for(int i = 1; i < board.getRows() - 1; i++) {
      drawBorderSquare(0, i);
    }
  }

  private void drawRight() {
    for(int i = 1; i < board.getRows() - 1; i++) {
      drawBorderSquare(board.getColumns() - 2, i);
    }
  }

  private void drawBottom() {
    for(int i = 2; i < board.getColumns() - 2; i += 2) {
      drawBorderSquare(i, board.getRows() - 1);
    }
  }

  private void drawBorderSquare(int x, int y) {
    board.drawSquare(new Square(x, y, BORDER_COLOR));
  }
}
