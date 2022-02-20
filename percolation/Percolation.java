/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int n;
    private boolean[][] grid;
    private final WeightedQuickUnionUF array;
    private int openSites = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Grid must be >= 1");
        }

        this.n = n;
        this.grid = new boolean[n][n];
        this.array = new WeightedQuickUnionUF(n * n);

        for (int i = 1; i < this.n; i++) {
            // Union the first row to root 0
            this.array.union(0, i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.grid[i][j] = false;
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (checkRange(row, col)) {
            throw new IllegalArgumentException("Out of range");
        }
        if (!isOpen(row, col)) {
            this.openSites++;
            this.grid[row - 1][col - 1] = true;
        }

        int mapNum = mapGridToArr(row, col);

        for (int i = -1; i < 2; i += 2) {
            if (this.isOpen(row + i, col)) {
                int mapToNum = mapGridToArr(row + i, col);
                this.array.union(mapNum, mapToNum);
            }
            if (this.isOpen(row, col + i)) {
                int mapToNum = mapGridToArr(row, col + i);
                this.array.union(mapNum, mapToNum);
            }

        }
    }

    public boolean isOpen(int row, int col) {
        if (checkRange(row, col)) {
            return false;
        }
        return this.grid[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        // check whether the spot isOpen
        if (!isOpen(row, col)) return false;
        int mapNum = mapGridToArr(row, col);
        if (this.array.find(mapNum) == this.array.find(0)) return true;
        return false;
    }

    public int numberOfOpenSites() {
        return this.openSites;
    }

    public boolean percolates() {
        if (n == 1) {
            if (isOpen(1, 1)) return true;
            else return false;
        }
        int rootPercolates = this.array.find(0);
        for (int i = 1; i <= this.n; i++) {
            // Last row of the grid
            if (this.array.find((this.n * this.n) - i) == rootPercolates) return true;
        }
        return false;
    }

    private boolean checkRange(int row, int column) {
        row -= 1;
        column -= 1;
        if (row >= this.n || column >= this.n || row < 0 || column < 0) {
            return true;
        }
        return false;
    }

    private int mapGridToArr(int row, int column) {
        // f(x,y) = (x-1)n + (y-1)
        return ((row - 1) * this.n + (column - 1));
    }

    public static void main(String[] args) {
        Percolation test = new Percolation(3);
        System.out.print(test.percolates());
    }
}
