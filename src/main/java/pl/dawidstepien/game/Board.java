package pl.dawidstepien.game;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

public class Board {

  private static final int BOARD_COLUMNS = 70;

  private static final int BOARD_ROWS = 30;

  private static final String TITLE = "SnakeGame";

  private Screen screen;

  public Board() {
    SwingTerminal terminal = TerminalFacade.createSwingTerminal(BOARD_COLUMNS, BOARD_ROWS);
    screen = new Screen(terminal);
    screen.startScreen();
    terminal.setCursorVisible(false);
    terminal.getJFrame().setResizable(false);
    terminal.getJFrame().setTitle(TITLE);
  }

  public void stop() {
    screen.stopScreen();
  }

  public void drawSquare(Square square) {
    screen.putString(square.getX(), square.getY(), square.getString(), square.getBackgroundColor(), square.getBackgroundColor());
    screen.refresh();
  }

  public int getColumns() {
    return BOARD_COLUMNS;
  }

  public int getRows() {
    return BOARD_ROWS;
  }
}
