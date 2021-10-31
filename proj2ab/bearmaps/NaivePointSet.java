package bearmaps;

import java.util.List;
import java.lang.Math;

public class NaivePointSet implements PointSet{

    List<Point> pointSet;

    public NaivePointSet(List<Point> points){
        pointSet = points;
    }

    @Override
    public Point nearest(double x, double y) {
        double minDist = Double.MAX_VALUE;
        Point n = null;
        for ( Point p:
             pointSet) {
            double dist = Math.sqrt(Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2));
            if (dist < minDist) {
                minDist = dist;
                n = p;
            }

        }
        return n;
    }

    public static void main(String[] args) {
        Point p1 = new Point(1.1, 2.2); // constructs a Point with x = 1.1, y = 2.2
        Point p2 = new Point(3.3, 4.4);
        Point p3 = new Point(-2.9, 4.2);

        NaivePointSet nn = new NaivePointSet(List.of(p1, p2, p3));
        Point ret = nn.nearest(3.0, 4.0); // returns p2
        ret.getX(); // evaluates to 3.3
        ret.getY(); // evaluates to 4.4
    }


}
