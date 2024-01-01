package percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    Percolation percolation;
    double[] results;
    int T;

    public PercolationStats(){}
    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        if(n <= 0 || trials <= 0) throw new IllegalArgumentException();
        this.T = trials;
        results = new double[trials];
        for(int i = 0; i < trials; i++){
            percolation = new Percolation(n);
            while(!percolation.percolates()){
                int j = (int)StdRandom.uniformDouble(1, n + 1);
                int k = (int)StdRandom.uniformDouble(1, n + 1);
                percolation.open(j, k);
            }
            results[i] = (percolation.numberOfOpenSites() * 1.0)/(n*n);
        }
    }

    // sample mean of percolation threshold
    public double mean(){
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        return StdStats.stddev(results);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo(){
        return mean() - (1.96*stddev())/Math.sqrt(T);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        return mean() + (1.96*stddev())/Math.sqrt(T);
    }

    // test client (see below)
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]), T = Integer.parseInt(args[1]);
//        Stopwatch stopwatch = new Stopwatch();
        PercolationStats stats = new PercolationStats(n, T);
        System.out.println("mean\t\t\t\t\t= " + stats.mean());
        System.out.println("stddev\t\t\t\t\t= " + stats.stddev());
        System.out.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
//        System.out.println("Time elapsed\t\t\t= " + stopwatch.elapsedTime());
    }

}
