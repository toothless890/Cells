import java.io.*;
import java.util.Arrays;

public class Run {

    public static void print(Canvas canvas, Object message) {
        String[] a = Arrays.deepToString(canvas.getAllCells()).split(",", 0);
        int i = 0;
        for (String list : a) {
            System.out.print(list);
            i = (i + 1) % canvas.width;
            if (i == 0) {
                System.out.print("\n");
            }
        }
        System.out.println("\n");
    }

    public static void update(Canvas canvas) {
        Cell[][] cells = canvas.getAllCells();
        for (int x = 0; x < canvas.width; x++) {
            for (int y = 0; y < canvas.height; y++) {

                if (cells[y][x] != null) {

                    cells[y][x].updateGroup(canvas);
                    cells[y][x].replicate(canvas);
                }
            }
        }
        canvas.updateCells();
        print(canvas, cells);
    }

    public static void main(String[] args) {
        Canvas canvas = new Canvas(9, 9);
        Integer[] testpos = { 4, 4 };
        Cell Brian = new Cell(testpos, 100, 100);
        canvas.addCell(Brian);

        print(canvas, canvas.getAllCells());

        update(canvas);
        update(canvas);
        update(canvas);
        update(canvas);

        // update(canvas);

    }
}
