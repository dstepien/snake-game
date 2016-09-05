package pl.dawidstepien.game;

import com.googlecode.lanterna.terminal.Terminal;

public class Square {

  private int x;

  private int y;

  private final Terminal.Color color;

  private static final String SQUARE_CHARS = "  ";

  public Square(int x, int y, Terminal.Color color) {
    this.x = x;
    this.y = y;
    this.color = color;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public String getString() {
    return SQUARE_CHARS;
  }

  public Terminal.Color getBackgroundColor() {
    return color;
  }
}
