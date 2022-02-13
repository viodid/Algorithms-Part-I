/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Percolation {

    private final int n;
    private boolean[][] grid;
    private MyQuickUnionUF array;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Grid must be >= 1");
        }

        this.n = n;
        this.grid = new boolean[n][n];
        this.array = new MyQuickUnionUF(n * n);

        for (int i = 0; i < this.n; i++) {
            this.array.id[i] = -1;
        }

        for (int i = n * n - 1; i >= n * n - n; i--) {
            this.array.id[i] = n * n;
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
        this.grid[row - 1][col - 1] = true;
        // row -= 1;
        // col -= 1;
        for (int i = -1; i < 2; i += 2) {
            if (this.isOpen(row + i, col) && !this.checkRange(row + i, col)) {
                this.array.union(row + i, col);
            }
            if (this.isOpen(row, col + i) && !this.checkRange(row, col + i)) {
                this.array.union(row, col + i);
            }
        }
    }

    public boolean isOpen(int row, int col) {
        // if (checkRange(row, col)) {
        //     throw new IllegalArgumentException("Out of range");
        // }
        return this.grid[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        if (checkRange(row, col)) {
            throw new IllegalArgumentException("Out of range");
        }
        // Boilerplate
        MyQuickUnionUF arr = new MyQuickUnionUF(this.n * this.n);
        for (int i = 0; i < this.n; i++) {
            arr.id[i] = -1;
        }

        int mapNum = mapGridToArr(row, col);
        return arr.connected(-1, mapNum);
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

    private int mapGridToArr(int row, int column) {
        // f(x,y) = (x-1)n + (y-1)
        return ((row - 1) * this.n + (column - 1));
    }

    public static void main(String[] args) {
        Percolation test = new Percolation(Integer.parseInt(args[0]));
        // for (int i = 0; i < test.grid.length; i++) {
        //     System.out.print(test.grid[i]);
        // }

        test.open(2, 2);
        test.open(3, 2);
        for (int i = 0; i < test.grid.length; i++) {
            System.out.print(test.array.id[i]);
            System.out.print('\n');
        }
    }
}
