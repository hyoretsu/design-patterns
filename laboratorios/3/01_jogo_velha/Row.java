import java.util.ArrayList;
import java.util.List;

public class Row {
    List<Square> squares = new ArrayList<Square>();

    public Row(Integer columnCount) {
        for (int i = 0; i < columnCount; i++) {
            Square square = new Square(" ");

            this.squares.add(square);
        }
    }

    public Square getSquare(Integer column) {
        return this.squares.get(column);
    }

    public List<Square> getSquares() {
        return this.squares;
    }
}
