public class Canvas {

    private Cell[][] cells;
    private Cell[][] plannedCells;
    int width;
    int height;

    Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[this.height][this.width];
        this.plannedCells = new Cell[this.height][this.width];
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

    public void planCell(Cell cell) {
        Integer[] pos = cell.getPosition();
        this.plannedCells[pos[0]][pos[1]] = cell;
    }

    public void addCell(Cell cell) { // should only be used for cell creation, for new cells via replication, and
                                     // movement, use planCell
        Integer[] pos = cell.getPosition();
        this.cells[pos[0]][pos[1]] = cell;
    }

    public void updateCells() {
        this.cells = this.plannedCells;
        this.plannedCells = new Cell[this.height][this.width];
    }

}