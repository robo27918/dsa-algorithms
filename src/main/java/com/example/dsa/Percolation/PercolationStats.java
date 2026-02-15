import java.security.PermissionCollection;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationStats {
    private Percolation perc;
    private double xBar =0.0;
    private double stdDev=0.0;
    private double T =0.0;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials){
        this.T = trials;
        this.perc = new Percolation(n);

        int x,y;
        double fracOpen;
        // the fraction of sites that are opened
        for (int i = 0; i < trails;i++){
            while (!this.perc.percolates()){
                //get a random x and y
                x = StdRandom.uniformInt(1,n+1);
                y = StdRandom.uniformInt(1,n+1);
                this.perc.open(x,y);
            }
            fracOpen = (float) perc.numberOfOpenSites()/ n;
           this.xBar += fracOpen;
        }
        System.out.println("xBAR" + this.xBar);
    }

    // sample mean of percolation threshold
    public double mean(){return 2.0;}

    // sample standard deviation of percolation threshold
    public double stddev(){return 2.0;}

    // low endpoint of 95% confidence interval
    public double confidenceLo(){return 2.0;}

    // high endpoint of 95% confidence interval
    public double confidenceHi(){return 0.0;}

   // test client (see below)
   public static void main(String[] args){
        PercolationStats ps = new PercolationStats(100);

   }

}
