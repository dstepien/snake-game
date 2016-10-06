package pl.dawidstepien.game;

import com.googlecode.lanterna.terminal.Terminal;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

public class Berry{
    private static final Terminal.Color BERRY_COLOR = Terminal.Color.MAGENTA;
    private Board board;
    private int x = 20;
    private int y = 20;


    public Berry(Board board) {
        this.board = board;
    }

    public void draw() {
        board.drawSquare(new Square(x,y,BERRY_COLOR));
    }

    public boolean isSquare(Square square) {
        return square.getX() == x && square.getY() == y;
    }

    public void redraw(List<Square> snakeParts, List<Berry> berries) {
        calculatePosition(snakeParts, berries);
        draw();
    }

    private void calculatePosition(List<Square> snakeParts, List<Berry> berries) {
        boolean collision = true;
        while(collision){
            randomPosition();
            collision = false;
        }
    }

    private void randomPosition() {
        x = RandomUtils.nextInt(2, board.getColumns()-3);
        if (x % 2 != 0) x++;
        y = RandomUtils.nextInt(1, board.getRows() - 1);
    }
}
