import java.io.*;
import java.util.Arrays;

public class Run {
    public static void print(Object message) {
        System.out.print(message);
    }

    public static void println(Object message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        Canvas canvas = new Canvas(3, 3);
        Integer[] testpos = { 1, 1 };
        Cell Brian = new Cell(testpos, 100, 100);
        canvas.addCell(Brian);
        Brian.replicate(canvas);
        String[] a = Arrays.deepToString(canvas.getAllCells()).split(",", 0);
        int x = 0;
        for (String list : a) {
            print(list);
            x = (x + 1) % 3;
            if (x == 0) {
                print("\n");
            }
        }
        // print();
    }
}