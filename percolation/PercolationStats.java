/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class PercolationStats {
    private int trials;
    private int n;
    private double[] percTrials = new double[trials];

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Grid and trials must be > 0");
        }
        this.n = n;
        this.trials = trials;

        for (int i = 0; i < trials; i++) {
            double percThreshold = percolationProcess();
            percTrials[i] = percThreshold;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return 1.0;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return 1.0;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return 1.0;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return 1.0;
    }

    private double percolationProcess() {
        Percolation perc = new Percolation(n);
        while (!perc.percolates()) {
            int row = StdRandom.uniform(n);
            int col = StdRandom.uniform(n);
            perc.open(row + 1, col + 1);
        }
        return (double) perc.numberOfOpenSites();
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats test = new PercolationStats(4, 20);
        System.out.print(Arrays.toString(test.getPercTrials()));
    }

    public double[] getPercTrials() {
        return percTrials;
    }

    public void setPercTrials(double[] percTrials) {
        this.percTrials = percTrials;
    }
}
