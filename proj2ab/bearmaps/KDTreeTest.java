package bearmaps;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class KDTreeTest {
    private static Random r = new Random(198);

    @Test
    public void testCorrectness() {
        List<Point> points = randomPoints(100000);

        NaivePointSet nps = new NaivePointSet(points);
        KDTree kd = new KDTree(points);

        List<Point> goals = randomPoints(10000);

        for (Point goal : goals) {
            Point expected = nps.nearest(goal.getX(), goal.getY());
            Point actual = kd.nearest(goal.getX(), goal.getY());
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testEfficiency() {
        List<Point> randomPoints = randomPoints(100000);

        KDTree kd = new KDTree(randomPoints);
        NaivePointSet nps = new NaivePointSet(randomPoints);

        List<Point> queryPoints = randomPoints(10000);

        long start = System.currentTimeMillis();
        for (Point p : queryPoints) {
            nps.nearest(p.getX(), p.getY());
        }
        long end = System.currentTimeMillis();
        System.out.println("NaivePointSet: " + (end - start) / 1000.0 + " seconds");

        start = System.currentTimeMillis();
        for (Point p : queryPoints) {
            kd.nearest(p.getX(), p.getY());
        }
        end = System.currentTimeMillis();
        System.out.println("KDTree: " + (end - start) / 1000.0 + " seconds");
    }

    private Point randomPoint() {
        return new Point(r.nextDouble(), r.nextDouble());
    }

    private List<Point> randomPoints(int N) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i += 1) {
            points.add(randomPoint());
        }
        return points;
    }
    @Test
    public void TestKDTree(){
        Point p1 = new Point(2, 3); // constructs a Point with x = 1.1, y = 2.2
        Point p2 = new Point(4, 2);
        Point p3 = new Point(4, 5);
        Point p4 = new Point(3, 3);
        Point p5 = new Point(1, 5);
        Point p6 = new Point(4, 4);

        KDTree t = new KDTree(List.of(p1, p2, p3, p4, p5, p6));

        t.nearest(1,1);


    }
}
