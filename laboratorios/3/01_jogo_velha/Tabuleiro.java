import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    Integer columnCount;
    List<Row> rows = new ArrayList<Row>();

    public Tabuleiro(Integer columnCount, Integer rowCount) {
        this.columnCount = columnCount;

        for (int i = 0; i < rowCount; i++) {
            Row row = new Row(columnCount);

            this.rows.add(row);
        }
    }

    public Boolean verificaGanhador() {
        Row firstRow = this.rows.get(0);
        Row secondRow = this.rows.get(1);
        Row thirdRow = this.rows.get(2);

        if ((firstRow.getSquare(0) == firstRow.getSquare(1))
                && (firstRow.getSquare(0) == firstRow.getSquare(2))) {
            return true;
        } else if ((secondRow.getSquare(0) == secondRow.getSquare(1))
                && (secondRow.getSquare(0) == secondRow.getSquare(2))) {
            return true;
        } else {
            return false;
        }
    }

    public void display() {
        String tabuleiroFormatado = "";

        for (Integer i = 0; i < 3; i++) {
            Row row = this.rows.get(i);
            List<Square> squares = row.getSquares();

            Integer j = 0;
            for (Square square : squares) {
                tabuleiroFormatado += square.getInfo();

                if (j == squares.size() - 1 && i < this.columnCount - 1) {
                    tabuleiroFormatado += "\n";
                } else {
                    tabuleiroFormatado += " | ";
                }

                j += 1;
            }
        }

        System.out.print(tabuleiroFormatado);
    }
}
