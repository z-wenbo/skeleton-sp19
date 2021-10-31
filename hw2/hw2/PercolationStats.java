package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] x;
    private int times;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        x = new double[T];
        times = T;
        for (int i = 0; i < T; i++) {
            Percolation experiment = pf.make(N);
            int r = 0;
            int c = 0;
            while (!experiment.percolates()) {
                while (experiment.isOpen(r,c)){
                    r = StdRandom.uniform(0, N);
                    c = StdRandom.uniform(0, N);
                }
                experiment.open(r,c);
            }
            x[i] = (double) experiment.numberOfOpenSites() / (double) N*N;
        }
    }  // perform T independent experiments on an N-by-N grid
    public double mean() {
        return StdStats.mean(x);
    }   // sample mean of percolation threshold
    public double stddev() {
        return StdStats.stddev(x);
    }    // sample standard deviation of percolation threshold
    public double confidenceLow() {
        return this.mean()- 1.96 * this.stddev() / Math.sqrt(times);
    }     // low endpoint of 95% confidence interval
    public double confidenceHigh() {
        return this.mean()+ 1.96 * this.stddev() / Math.sqrt(times);
    }     // high endpoint of 95% confidence interval

}
