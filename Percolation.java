import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean grid[][];

    private void initGrid(boolean[] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                grid[i][j] = false;
            }
        }
    }

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if(n <= 0) throw new IllegalArgumentException();
        grid = new boolean[n+1][n];
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if(grid[row-1][col-1] == false) {
            grid[row-1][col-1] = true;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row > grid.length || col > grid.length) {
            throw new IllegalArgumentException();
        }
        if(grid[row-1][col-1]) {
            return false;
        } else {
            return true;
        }
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return 0;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {
    }
}