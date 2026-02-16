import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    //n*n grid where 1= blocked 0 = open
    private boolean [][] grid; // True means open, False means blocked
    private int N ;
    private WeightedQuickUnionUF UF;
    private int TOP_ID;
    private int BOTTOM_ID;
    private int  totalOpen;
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n){
        if (n <=0){
            throw new IllegalArgumentException("Grid size must be greater than zero!");
        }
        this.N = n;
        // create the WeightedQuickFind and set it as an attribute
        this.UF = new WeightedQuickUnionUF(n*n + 2);

        this.TOP_ID = n*n ;// designate a slot for the TOP_ID 
        this.BOTTOM_ID = n*n + 2;                      //
        this.grid = new boolean [n+1][n+1];
    }   

    // opens the site (row, col) if it is not open already
    public void open(int row, int col){
        if (row <=0 || row >this.N || col <=0 || col >this.N){
            throw new IllegalArgumentException("ROW or COL are outside the expected range!");
        }
        if (!isOpen(row,col) && isFull(row,col)){
            this.grid[row][col] = true;
            this.totalOpen ++;
        
            // connect to the virtual top ?
            int currID = getId(row,col);
            //UF.union(currID,TOP);
            // union with any other neighnors that might be open
            // Connects to top only if row is 1
            if(row ==1){
                UF.union(currID,TOP_ID);
            }
            if (row == this.N){
                UF.union(currID,BOTTOM_ID);
            }
            this.connectToNei(row-1,col,currID);
            this.connectToNei(row+1,col,currID);
            this.connectToNei(row,col-1,currID);
            this.connectToNei(row-,col+1,currID);
        }

    }
    private connectToNei(int row,itn col,int currID){
        if (row >= 1 && row <= this.N && col >= 1 && col <=this.N){
            if (isOpen(row,col){
                int neiID = this.getId(row, col);
                UF.union(currID,neiID);
            }
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
        
        int currID = getId(row,col);
        if(UF.find(currID) == UF.find(TOP_ID)){
            return true && isOpen(row,col);
        }
        return false;
    }

    // returns the number of open sites
    //
    public int numberOfOpenSites(){return this.totalOpen;}

    // does the system percolate?
    public boolean percolates(){
        return this.UF.find(BOTTOM_ID) == this.UF.find(TOP_ID);
        // go through the bottom rows
        // and use isFull on each (row,col)
        //
        // for(int i =1; i <=this.N;i++){
        //     if(isFull(this.N,i)){
        //         return true;
        //     }
        // }
        // return false;

    }
    //method for mapping row and col to id
    private int getId(int row,int col){ 
        if (row <=0 || row >this.N || col <=0 || col >this.N){
            throw new IllegalArgumentException("ROW or COL are outside the expected range!");
        }
        return this.N * (row -1) + col;
    }


    // test client (optional)
    public static void main(String[] args){
        Percolation p = new Percolation(10);
        System.out.println(p.numberOfOpenSites());
        System.out.println(p.isFull(3,5));
        System.out.println("Something to test...");
    }
}
