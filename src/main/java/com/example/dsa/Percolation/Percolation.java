import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    //n*n grid where 1= blocked 0 = open
    private boolean [][] grid; // True means open, False means blocked
    private int N ;
    private WeightedQuickUnionUF UF;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        if (n <=0){
            throw new IllegalArgumentException("Grid size must be greater than zero!")
        }
        this.N = n;
        // create the WeightedQuickFind and set it as an attribute
        UF = new WeightedQuickUnionUF(n*n);
        grid = new boolean [n][n];
    }   

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        if (row <=0 || row >this.N || col <=0 || col >this.N){
            throw new IllegalArgumentException("ROW or COL are outside the expected range!")
        }
        if (!isOpen(row,col)){
            this.grid[row][col] = true;
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        if (row <=0 || row >this.N || col <=0 || col >this.N){
            throw new IllegalArgumentException("ROW or COL are outside the expected range!")
        }
        return this.grid[row][col];}

    // is the site (row, col) full?
    public boolean isFull(int row, int col){ 
        if (row <=0 || row >this.N || col <=0 || col >this.N){
            throw new IllegalArgumentException("ROW or COL are outside the expected range!")
        }
    }

    // returns the number of open sites
    //
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
    public boolean percolates(){
        // start from some (i,j) in the top and use
        // use find to check that the elements
        // at the top have the same root 
        //
        //scan the top 
        for (int j = 0; i <N;i++){
            if(this.grid[0][j])
        }
        
        use UnionFind()
    }
    //method for mapping row and col to id
    private int getId(int row,int col){ 
        if (row <=0 || row >this.N || col <=0 || col >this.N){
            throw new IllegalArgumentException("ROW or COL are outside the expected range!")
        }
        return this.N * (row -1) + col;}


    // test client (optional)
    public static void main(String[] args)
}
