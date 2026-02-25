import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationStats {
    //some useful private fields to easily track statistics;
    private Percolation perc;
    private int T;
    private double [] xBars;
    private double SQRT_T ; 
    private int [] openIDSlots;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        this.T = trials;
        this.SQRT_T = Math.sqrt(T);
        xBars = new double [this.T];
        double fracOpen;
        this.openIDSlots = new int [n*n];
        for(int j = 0; j <n*n; j++){
            openIDSlots[j] = j+1;  
        }
        // the fraction of sites that are opened
        for (int i = 0; i < this.T;i++){
            this.perc = new Percolation(n);
            //shuffle the ids array
            StdRandom.shuffle(openIDSlots);
            for(int k = 0; k< n*n; k++){
                int row = getRowFromID(openIDSlots[k],n);
                int col = getColFromID(openIDSlots[k], n);
                this.perc.open(row,col);

                if (this.perc.percolates()){
                    break;
                }
            }
            //while (!this.perc.percolates()){
            //    //get a random x and y
            //    x = StdRandom.uniformInt(1,n+1);
            //    y = StdRandom.uniformInt(1,n+1);
            //    this.perc.open(x,y);
            //}
            fracOpen = (double) perc.numberOfOpenSites()/ (n*n);
            xBars[i] = fracOpen;
        }
    }

    // sample mean of percolation threshold
    public double mean(){return StdStats.mean(xBars);}

    // sample standard deviation of percolation threshold
    public double stddev(){return StdStats.stddev(xBars);}

    // low endpoint of 95% confidence interval
    public double confidenceLo(){return this.mean() - 1.96 * this.stddev()/this.SQRT_T;}

    // high endpoint of 95% confidence interval
    public double confidenceHi(){return this.mean() + 1.96 *this.stddev()/this.SQRT_T;}
    
    //private methods to get row and columns easily
    private int getRowFromID(int id, int n){
        return (id-1) /n  + 1;
    }
    private int getColFromID(int id, int n){
        return (id -1) % n + 1;
    }
   // test client (see below)
   public static void main(String[] args){
        PercolationStats ps = new PercolationStats(100,100);
        System.out.println("Mean: " +ps.mean());
        System.out.println("STDDEV: " +ps.stddev());
        System.out.println("Confidence Lo: " +ps.confidenceLo());
        System.out.println("Confidence High: " +ps.confidenceHi());
        System.out.println("End of first test");
   }
   

}
