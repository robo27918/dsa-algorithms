import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    //n*n grid where 1= blocked 0 = open
    private int [][] grid; 
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        for(int i =0; i < n;i++){
            for (int j = 0; j < n;j++){
                this.grid[i][j] = 1;
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){}

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){return this.grid[row][col] ==0;}

    // is the site (row, col) full? where full = blocked
    public boolean isFull(int row, int col){return this.grid[row][col];}

    // returns the number of open sites
    public int numberOfOpenSites(){
            int count = 0;
            // brute force: loop through the grid and see what is open
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                   if(isOpen(i,j)){count++;} 
                }   
            }
            return count;
    }

    // does the system percolate?
    public boolean percolates()

    // test client (optional)
    public static void main(String[] args)
}
