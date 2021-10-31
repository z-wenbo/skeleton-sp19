package hw2;

import org.junit.Test;

public class TestPercolation {

    @Test
    public void testPercolation() {
        Percolation test = new Percolation(4);
        test.open(0,3);
        boolean full = test.isFull(0,3);
        full = test.isOpen(0,3);
        test.open(3,3);
        test.open(1,3);
        full = test.percolates();
        test.open(2,3);
        full = test.percolates();
    }

    @Test
    public  void testPercolationStats(){
        PercolationFactory f = new PercolationFactory();
        PercolationStats p = new PercolationStats(10,20, f);
        double h = p.confidenceHigh();
        double l = p.confidenceLow();
    }
}
