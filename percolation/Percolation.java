/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Percolation {

    private final int n;
    private boolean[][] grid;
    private MyQuickUnionUF array;
    private int openSites = 0;

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
        this.openSites += 1;
        this.grid[row - 1][col - 1] = true;
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
        int mapNum = mapGridToArr(row, col);
        return this.array.id[mapNum] == -1;
    }

    public int numberOfOpenSites() {
        return this.openSites;
    }

    public boolean percolates() {
        for (int i = 1; i <= this.n; i++) {
            if (this.array.connected((this.n * this.n) - i, 0)) return true;
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
        // Percolation test = new Percolation(Integer.parseInt(args[0]));
        Percolation test = new Percolation(4);
        test.open(4, 1);
        test.open(3, 1);
        test.open(2, 1);
        test.open(1, 1);
        test.open(2, 2);
        test.open(3, 2);
        for (int i = 0; i < test.array.id.length; i++) {
            System.out.print(test.array.id[i]);
            System.out.print('\n');
        }
        System.out.print(test.percolates());
    }
}
