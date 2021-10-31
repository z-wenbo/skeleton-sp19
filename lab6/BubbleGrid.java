public class BubbleGrid {
    int[][] grid;
    UnionFind bubbles;
    int rowlength;
    int collength;
    public BubbleGrid(int[][] g) {
        grid = g;
        collength = g.length;
        rowlength = g[0].length;
        bubbles = new UnionFind(collength * rowlength);
        for (int i = 0; i < collength; i++) {
            for (int j = 0; j < rowlength; j++) {


            }

        }
    }

    public


}
