import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    //n*n grid where 1= blocked 0 = open
    private boolean [][] grid; // True means open, False means blocked
    private int N ;
    private WeightedQuickUnionUF UF;
    private int TOP_ID;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        if (n <=0){
            throw new IllegalArgumentException("Grid size must be greater than zero!");
        }
        this.N = n;
        // create the WeightedQuickFind and set it as an attribute
        UF = new WeightedQuickUnionUF(n*n + 2);
        TOP_ID = n*n + 1;// designate a slot for the TOP_ID 
        grid = new boolean [n+1][n+1];
    }   

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        if (row <=0 || row >this.N || col <=0 || col >this.N){
            throw new IllegalArgumentException("ROW or COL are outside the expected range!");
        }
        if (!isOpen(row,col)){
            this.grid[row][col] = true;
        }
        // connect to the virtual top ?
        int currID = getId(row,col);
        //UF.union(currID,TOP);
        // union with any other neighnors that might be open
        // Connects to top only if row is 1
        if(row ==1){
            UF.union(currID,TOP_ID);
        }

        if(row > 1 && isOpen(row-1,col)){
            UF.union(currID, getId(row-1,col));
        }
        //checks bottom
        if(row < N && isOpen(row+1,col)){
            UF.union(currID, getId(row+1,col));
        }
        //checks left
        if(col > 1 && isOpen(row,col-1)){
            UF.union(currID, getId(row,col-1));
        }
        //checks right
        if(col < N && isOpen(row,col+1)){
            UF.union(currID, getId(row,col+1));
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        if (row <=0 || row >this.N || col <=0 || col >this.N){
            throw new IllegalArgumentException("ROW or COL are outside the expected range!");
        }
        return this.grid[row][col];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col){ 
        if (row <=0 || row >this.N || col <=0 || col >this.N){
            throw new IllegalArgumentException("ROW or COL are outside the expected range!");
        }
        //TODO: implement
        int currID = getID(row,col);
        if(UF.find(currID) == UF.find(TOP_ID)){
            return true;
        }
        return false;
    }

    // returns the number of open sites
    //
    public int numberOfOpenSites(){
            int count = 0;
            // brute force: loop through the grid and see what is open
            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid.length; j++) {
                   if(isOpen(i,j)){count++;} 
                }   
            }
            return count;
    }

    // does the system percolate?
    public boolean percolates(){
        // go through the bottom rows
        // and use isFull on each (row,col)
        for
    }
    //method for mapping row and col to id
    private int getId(int row,int col){ 
        if (row <=0 || row >this.N || col <=0 || col >this.N){
            throw new IllegalArgumentException("ROW or COL are outside the expected range!")
        }
        return this.N * (row -1) + col;
    }


    // test client (optional)
    public static void main(String[] args)
}
