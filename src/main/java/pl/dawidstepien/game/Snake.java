package pl.dawidstepien.game;

import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class Snake {

  private static final Terminal.Color SNAKE_COLOR = Terminal.Color.YELLOW;
  private static final Terminal.Color TRANSPARENT_COLOR = Terminal.Color.DEFAULT;

  private Board board;

  private int length = 1;

  private int x;

  private int y;

  private SnakeDirection direction = SnakeDirection.NULL;

  private List<Square> parts = new ArrayList<>();

  public Snake(Board board) {
    this.board = board;
    setCenterPosition();
  }

  private void setCenterPosition() {
    x = (board.getColumns()/2) - 1;
    y = (board.getRows()/2) - 1;
  }

  public void draw() throws IllegalPositionException {
    removeSnakePart();
    if(!direction.equals(SnakeDirection.NULL)) {
      calculatePosition();
    }
    checkIfPositionIsValid();
    drawSnakePart(x, y);
  }

  private void checkIfPositionIsValid() throws IllegalPositionException {
    if(x < 2 || x > (board.getColumns() - 4) || y < 1 || y > (board.getRows() - 2)){
      throw new IllegalPositionException();
    }
  }

  private void calculatePosition() {
    if(direction.equals(SnakeDirection.DOWN)){
      y += 1;
    }
    if(direction.equals(SnakeDirection.UP)){
      y -= 1;
    }
    if(direction.equals(SnakeDirection.LEFT)){
      x -= 2;
    }
    if(direction.equals(SnakeDirection.RIGHT)){
      x += 2;
    }
  }

  private void drawSnakePart(int x, int y) {
    Square square = new Square(x, y, SNAKE_COLOR);
    if(parts.isEmpty() || square.equals(parts.get(parts.size() - 1)) == false){
      board.drawSquare(square);
      parts.add(square);
      System.out.println("x: " + square.getX() + " y: " + square.getY());
      System.out.println("parts size: " + parts.size());
    }
  }
  private void removeSnakePart() {
    if(parts.size() > length){
      Square square = parts.get(parts.size() - length - 1);
      board.drawSquare(new Square(square.getX(), square.getY(), TRANSPARENT_COLOR));
      System.out.println("square x: " + square.getX() + " y: " + square.getY());
    }
  }

  public void setDirection(SnakeDirection direction) {
    this.direction = direction;
  }

  public void reset() {
    direction = SnakeDirection.NULL;
    setCenterPosition();
    for(Square square : parts) {
      board.drawSquare(new Square(square.getX(), square.getY(), TRANSPARENT_COLOR));
    }
    parts.clear();
    length = 1;
  }

  public Square getHead() {
    return parts.get(parts.size() - 1);
  }

  public void addLength(){
    length++;
  }

  public List<Square> getParts() {
    return parts;
  }
}
