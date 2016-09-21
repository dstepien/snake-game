package pl.dawidstepien.game;

import com.googlecode.lanterna.terminal.Terminal;

import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Square square = (Square) o;
    return x == square.x &&
            y == square.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
