import java.util.Arrays;

public class Cell {

    private Integer[] position;
    private int health;
    private int species;
    private Cell[][] group;
    private int groupHealth;

    Cell(Integer[] position, int health, int species) {
        this.health = health;
        this.species = species;
        this.position = position;
        this.group = new Cell[3][3];
    }

    public Integer[] getPosition() {
        return position;
    }

    public void updateGroup(Canvas canvas) { // Canvas is a matrix of Cells
        for (Integer x = -1; x <= 1; x++) {
            for (Integer y = -1; y <= 1; y++) {
                Integer[] position = { this.position[0] + x, this.position[0] + y };
                this.group[x + 1][y + 1] = canvas.getCell(position);
            }
        }
    }

    public void replicate(Canvas canvas) {
        Integer[] workingMatrixes = { 0, 0, 0, 0 };
        int divisions = 0;
        for (int m = 0; m < 4; m++) {
            for (int r = 0; r < 3; r++) {
                for (int i = 0; i < 3; i++) { // this is super overcomplicated, try to use Constants.testMatrixPositions
                                              // or something
                    if (Constants.testMatrixes[m][r][i] == 1) {
                        if (this.group[r][i] == null) {
                            workingMatrixes[m] += 1;
                            if (workingMatrixes[m] == 2) {
                                divisions += 2;
                            }

                        }
                    }
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            if (workingMatrixes[i] > 1) {
                Integer[] bpos = MatrixOperations.add2IntList(Constants.testMatrixPositions[i][0], this.position);
                Cell a = new Cell(bpos, divisions, i);
                canvas.addCell(a);
                Integer[] apos = MatrixOperations.add2IntList(Constants.testMatrixPositions[i][1], this.position);
                Cell b = new Cell(apos, divisions, i);
                canvas.addCell(b);
            }
        }

        canvas.removeCell(this.position);
    }
}