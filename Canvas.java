public class Canvas {

    private Cell[][] cells;

    private int width;
    private int height;

    Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[this.width][this.height];
    }

    public Cell getCell(Integer[] pos) {
        Cell cell = this.cells[pos[0]][pos[1]];
        return cell;
    }

    public Cell[][] getAllCells() {
        return cells;
    }

    public void removeCell(Integer[] pos) {
        this.cells[pos[0]][pos[1]] = null;
    }

    public void addCell(Cell cell) {
        Integer[] pos = cell.getPosition();
        this.cells[pos[0]][pos[1]] = cell;
    }

}