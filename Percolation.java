import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean grid[][];
    private WeightedQuickUnionUF unionDataStructure;
    private int num_open_sites = 0;

    private void initGrid(int n) {
        //initializes all squares to false
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }

        unionDataStructure = new WeightedQuickUnionUF(((n*n)+2));

        //top virtual site
        for(int i = 0; i < n; i++) {
            unionDataStructure.union(i, n*n);
        }

        //bottom virtual site
        for(int j = n*n-1; j > n*n-1-n; j--) {
            unionDataStructure.union(j, n*n+1);
        }
    }

    private void checkValidArguments(int row, int col) {
        if(row > grid.length) {
            throw new IllegalArgumentException();
        } else if (col > grid[0].length) {
            throw new IllegalArgumentException();
        }
    }

    private int xyToNum(int row, int col) {
        int num = (grid.length * row) + col;

        return num;
    }

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if(n <= 0) throw new IllegalArgumentException();
        grid = new boolean[n][n];
        initGrid(n);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int n = grid.length;

        checkValidArguments(row, col);

        if(grid[row-1][col-1] == false) {
            grid[row-1][col-1] = true;
            num_open_sites++;
        }

        // square to the left is open
        if(col > 1 && grid[row-1][col-2]) {
            unionDataStructure.union(xyToNum(row-1, col-1), xyToNum(row-1, col-2));
        }

        // square to the right is open
        if(col < n && grid[row-1][col]) {
            unionDataStructure.union(xyToNum(row-1, col-1), xyToNum(row-1, col));
        }

        // square above is open
        if(row > 1 && grid[row-2][col-1]) {
            unionDataStructure.union(xyToNum(row-1, col-1), xyToNum(row-2, col-1));
        }

        // square below is open
        if(row < n && grid[row][col-1]) {
            unionDataStructure.union(xyToNum(row-1, col-1), xyToNum(row, col-1));
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkValidArguments(row, col);
        return grid[row-1][col-1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int n = grid.length;

        // if the set in mind is connected to the top virtual set or the bottom virtual set, return true
        if(unionDataStructure.find(xyToNum(row-1, col-1)) == unionDataStructure.find(xyToNum(n, 0))) {
            return true;
        } else if (unionDataStructure.find(xyToNum(row-1, col-1)) == unionDataStructure.find(xyToNum(n, 1))) {
            return true;
        } else {
            return false;
        }
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return num_open_sites;
    }

    // does the system percolate?
    public boolean percolates() {
        int n = grid.length;
        if(unionDataStructure.find(xyToNum(n, 0)) == unionDataStructure.find(xyToNum(n, 1))) {
            return true;
        }
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation theMain = new Percolation(2);
        theMain.open(1,1);
        theMain.open(2,2);
        theMain.open(1,2);
        theMain.numberOfOpenSites();
        System.out.println(theMain.numberOfOpenSites());
    }
}