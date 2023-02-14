import java.util.Arrays;
import java.lang.Math;

public class Cell {

    private int[] position;
    private int health;
    private int species;
    private Cell[][] group;
    private int groupHealth;
    private int replicationThreshold;

    Cell(int[] position, int health, int species) {
        this.health = health;
        this.species = species;
        this.position = position;
        this.group = new Cell[3][3];
        this.replicationThreshold = 100; // subject to change based on species
    }

    public int[] getPosition() {
        return this.position;
    }

    public Cell[][] getGroup() {
        return this.group;
    }

    public int getHealth() {
        return this.health;
    }

    public int getSpecies() {
        return this.species;
    }

    public int getReplicationThreshold() {
        return this.replicationThreshold;
    }

    public void updateGroup(Canvas canvas) {
        this.groupHealth = 0;
        int[] offsets = { -1, 0, 1 };
        for (int dx : offsets) {
            for (int dy : offsets) {
                int y = this.position[0] + dx;
                int x = this.position[1] + dy;
                int[] coords = { y, x };
                if (MatrixOperations.checkBounds(coords, canvas)) {
                    Cell newCell = canvas.getCell(coords);
                    this.group[dy + 1][dx + 1] = newCell;
                    if (newCell != null) {
                        this.groupHealth += newCell.getHealth();
                    }

                } else {
                    this.group[dy + 1][dx + 1] = null; // or some default value
                }
            }
        }
    }

    private int countDivisions(int[] workingMatrixes, Cell[][] group) {
        int divisions = 0;

        for (int m = 0; m < 4; m++) {
            for (int r = 0; r < 3; r++) {
                for (int i = 0; i < 3; i++) {
                    if (Constants.testMatrixes[m][r][i]) {
                        if (group[r][i] == null) {
                            workingMatrixes[m]++;

                            if (workingMatrixes[m] == 2) {
                                divisions += 2;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(divisions);
        return divisions;
    }

    public void replicate(Canvas canvas) {
        int[] workingMatrixes = { 0, 0, 0, 0 };
        int divisions = countDivisions(workingMatrixes, this.group);

        for (int i = 0; i < 2; i++) {
            if (workingMatrixes[i] > 1) {
                int[] apos = MatrixOperations.add2IntList(Constants.testMatrixPositions[i][0], this.position);
                if (MatrixOperations.checkBounds(apos, canvas)) {
                    Cell a = new Cell(apos, divisions, i);
                    canvas.planCell(a);
                }

                int[] bpos = MatrixOperations.add2IntList(Constants.testMatrixPositions[i][1], this.position);
                if (MatrixOperations.checkBounds(bpos, canvas)) {
                    Cell b = new Cell(bpos, divisions, i);
                    canvas.planCell(b);
                }
            }
        }

        canvas.removeCell(this.position);
    }

    public void move(Canvas canvas) {
        // Check all adjacent cells for movement direction
        int[] direction = { 0, 0 };
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx != 0 || dy != 0) {
                    int[] newPos = MatrixOperations.add2IntList(this.position, new int[] { dx, dy });
                    if (MatrixOperations.checkBounds(newPos, canvas) && canvas.getCell(newPos) == null) {
                        direction[0] -= dx;
                        direction[1] -= dy;
                    }
                }
            }
        }
        if (direction[0] != 0 || direction[1] != 0) {
            // Calculate new position
            int[] newPos = MatrixOperations.add2IntList(this.position, direction);
            if (MatrixOperations.checkBounds(newPos, canvas)) {
                // Check if another cell is already in the new position
                Cell otherCell = canvas.getCell(newPos);
                if (otherCell != null) {
                    // Merge with other cell if species matches
                    if (Math.abs(this.species - otherCell.species) < 15) {
                        this.health = (this.health + otherCell.health) / 2;
                        otherCell.health = this.health;
                        this.species = (this.species + otherCell.species) / 2;
                        otherCell.species = this.species;
                    }
                } else {
                    // Move cell to new position
                    canvas.planCell(this, newPos);
                }
            }
        }
    }

}