package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] arr;
    private int n;
    private int openSites = 0;
    private WeightedQuickUnionUF wquickFind;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if(n <= 0) throw new IllegalArgumentException();
        this.n = n;
        this.wquickFind = new WeightedQuickUnionUF(n * n + 2);
        for (int i = 1; i <= n; i++) {
            wquickFind.union(0, i);
        }
        for (int i = n * (n - 1) + 1; i <= n * n; i++) {
            wquickFind.union(n * n + 1, i);
        }
        arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = false;
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row <= 0 || row > n || col <= 0 || col > n) throw new IllegalArgumentException();
        if (!isOpen(row, col)) {
            arr[row - 1][col - 1] = true;
            openSites++;

            // write connection logic with neighbouring open sites
            if (row - 2 >= 0 && isOpen(row - 1, col)) {
                wquickFind.union((row - 1) * n + col, (row - 2) * n + col);
            }
            if (row < n && isOpen(row + 1, col)) {
                wquickFind.union((row - 1) * n + col, (row) * n + col);
            }
            if (col - 2 >= 0 && isOpen(row, col - 1)) {
                wquickFind.union((row - 1) * n + col, (row - 1) * n + col - 1);
            }
            if (col < n && isOpen(row, col + 1)) {
                wquickFind.union((row - 1) * n + col, (row - 1) * n + col + 1);
            }
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row <= 0 || row > n || col <= 0 || col > n) throw new IllegalArgumentException();
        return arr[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row <= 0 || row > n || col <= 0 || col > n) throw new IllegalArgumentException();
        return isOpen(row, col)  && wquickFind.find(0) == wquickFind.find((row-1)*n + col);
//        return !arr[row - 1][col - 1];
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        if(numberOfOpenSites() == 0) return false;
        return wquickFind.find(0) == wquickFind.find(n * n + 1);
    }

    // test client (optional)
    public static void main(String[] args) {

    }
}
