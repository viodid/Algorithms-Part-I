/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Percolation {

    private final int n;
    private boolean[][] grid;
    private MyQuickUnionUF[] array;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Grid must be >= 1");
        }

        this.n = n;
        this.grid = new boolean[n][n];
        this.array = new MyQuickUnionUF[n * n];

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
        if (row >= this.n || column >= this.n) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Percolation test = new Percolation(Integer.parseInt(args[0]));
        // test.isFull(4, 5);
        // for (int i = 0; i < test.grid.length; i++) {
        //     System.out.print(test.grid[i]);
        // }
        System.out.print(test.grid.length);

        // MyQuickUnionUF test2 = new MyQuickUnionUF(test.grid.length);
        test.array.union(4, 2);
        for (int i = 0; i < test.grid.length; i++) {
            System.out.print(test.array[i]);
            System.out.print('\n');
        }
    }
}
