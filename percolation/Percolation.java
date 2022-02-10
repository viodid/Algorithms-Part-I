/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.QuickUnionUF;

public class Percolation {

    private final int n;
    private int[] grid;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Grid must be >= 1");
        }

        this.n = n;
        this.grid = new int[this.n * this.n];

        for (int i = 0; i < n * n; i++) {
            // -1 as 'null' type
            this.grid[i] = -1;
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (checkRange(row, col)) {
            throw new IllegalArgumentException("Out of range");
        }


    }

    public boolean isOpen(int row, int col) {
        if (checkRange(row, col)) {
            throw new IllegalArgumentException("Out of range");
        }
        return true;
    }

    public boolean isFull(int row, int col) {
        if (checkRange(row, col)) {
            throw new IllegalArgumentException("Out of range");
        }
        return true;
    }

    public int numberOfOpenSites() {
        return 0;
    }

    public boolean percolates() {
        return true;
    }

    private boolean checkRange(int row, int column) {
        if (row > this.n || column > this.n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Percolation test = new Percolation(Integer.parseInt(args[0]));
        // test.isFull(4, 5);
        for (int i = 0; i < test.grid.length; i++) {
            System.out.print(test.grid[i]);
        }
        // System.out.print(test.grid);

        QuickUnionUF test2 = new QuickUnionUF(test.grid.length);
        test2.union(1, 2);
        for (int i = 0; i < test.grid.length; i++) {
            System.out.print(test2.id[i]);
        }
    }
}
