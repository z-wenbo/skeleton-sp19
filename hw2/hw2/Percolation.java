package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int[][] grid;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF ufWithoutBottom;
    private int size;
    private int open_sites;
    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N){
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = 0;
            }
        }
        uf = new WeightedQuickUnionUF(N*N + 2);
        ufWithoutBottom = new WeightedQuickUnionUF(N*N + 1);
        size = N;
        open_sites = 0;
    }

    private int coordinatesConverter(int r, int c) {
        return r*size + c+ 1;
    }

    private final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void unionAround(int r, int c) {
        for (int[] dir : directions) {
            int x = r + dir[0];
            int y = c + dir[1];
            if(x >= 0 && x < size && y >= 0 && y < size && grid[x][y] == 1) {
                uf.union(coordinatesConverter(r,c), coordinatesConverter(x,y));
                ufWithoutBottom.union(coordinatesConverter(r,c), coordinatesConverter(x,y));
            } else if (x == -1) {
                uf.union(0,coordinatesConverter(r,c));
                ufWithoutBottom.union(0,coordinatesConverter(r,c));
            } else if (x == size) {
                uf.union(size*size+1, coordinatesConverter(r,c));
            }
        }
    }

    public void open(int row, int col)  {
        validate(row);
        validate(col);
        if (!isOpen(row, col)) {
            grid[row][col] = 1;
            unionAround(row, col);
        }
        open_sites++;
    }// open the site (row, col) if it is not open already


    public void validate(int m) {
        if (m<0 || m >= size) {
            throw new java.lang.IndexOutOfBoundsException();
        }
    }

    public boolean isOpen(int row, int col)  {
        return grid[row][col] == 1;
    }// is the site (row, col) open?

    public boolean isFull(int row, int col)  {
        return ufWithoutBottom.connected(coordinatesConverter(row,col),0);
    }// is the site (row, col) full?
    public int numberOfOpenSites()  {
        return open_sites;
    }         // number of open sites
    public boolean percolates() {
        return uf.connected(0,size*size +1);
    }             // does the system percolate?
    public static <AType> AType set3 (AType[] A, AType x) {
        for (int i = 0; i < A.length; i += 1) A[i] = x;
        return A[0];
    }
    public static void main(String[] args) {
        String[] x = new String[30];
        set3(x,"curse you");
    }  // use for unit testing (not required, but keep this here for the autograder)
}

