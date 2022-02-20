/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final int trials;
    private final int n;
    private final double[] percTrials;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Grid and trials must be > 0");
        }
        this.n = n;
        this.trials = trials;
        this.percTrials = new double[trials];

        for (int i = 0; i < trials; i++) {
            double percThreshold = percolationProcess();
            percTrials[i] = percThreshold;
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(percTrials) / (n * n);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(percTrials) / (n * n);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return (mean() - 1.96 * stddev() / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return (mean() + 1.96 * stddev() / Math.sqrt(trials));
    }

    private double percolationProcess() {
        Percolation perc = new Percolation(n);
        while (!perc.percolates()) {
            int row = StdRandom.uniform(n);
            int col = StdRandom.uniform(n);
            perc.open(row + 1, col + 1);
        }
        return perc.numberOfOpenSites();
    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats test = new PercolationStats(Integer.parseInt(args[0]),
                                                     Integer.parseInt(args[1]));
        StdOut.printf("mean                      = %7.5f\n"
                              + "stddev                    = %7.5f\n"
                              + "95%% confidence interval   = [%7.5f, %7.5f]\n",
                      test.mean(),
                      test.stddev(),
                      test.confidenceLo(),
                      test.confidenceHi());
    }
}
