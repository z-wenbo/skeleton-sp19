package bearmaps;

import java.util.Comparator;
import java.util.List;


public class KDTree implements PointSet{
    private BST root;

    public KDTree(List<Point> p){
        root = null;
        for (Point ps:
             p) {
            put(ps);
        }
    }

    private class BST{
        protected Point p;
        protected Comparator<Point> comparator;
        protected BST left, right;
        protected char axis;
        public BST(Point point, char c) {
            p = point;
            if (c == 'x') {
                comparator = (Point a, Point b) -> Double.compare(a.getX(), b.getX());
            }
            if (c == 'y') {
                comparator = (Point a, Point b) -> Double.compare(a.getY(), b.getY());
            }
            axis = c;
        }

        public Point bestPossiblePointOnTheBadSide(Point goal){
            if (axis == 'x') return new Point(this.p.getX(), goal.getY());
            return new Point(goal.getX(), this.p.getY());
        }
    }



    /* Associates the specified value with the specified key in this map. */
    private void put(Point point){
        root = put(root, point, 'y');
    }

    private BST put(BST n, Point point, char axis) {
        if (n == null) {
            return new BST(point,switchAxis(axis));
        }
        if (n.comparator.compare(point,n.p ) < 0) {
            n.left = put(n.left, point, switchAxis(axis));
        }
        if (n.comparator.compare(point,n.p) >= 0) {
            n.right = put(n.right, point, switchAxis(axis));
        }
        return n;
    }
    private char switchAxis(char axis) {
        if (axis == 'x') return 'y';
        return 'x';
    }

    @Override
    public Point nearest(double x, double y) {
        Point goal = new Point(x, y);
        return nearest(root, goal, root).p;
    }

    private BST nearest(BST n, Point goal, BST best){
        if (n == null) return best;
        if (Point.distance(n.p, goal) < Point.distance(best.p, goal)) best = n;

        BST goodSide;
        BST badSide;
        if (n.comparator.compare(goal, n.p) < 0) {
            goodSide = n.left;
            badSide = n.right;
        } else {
            badSide = n.left;
            goodSide = n.right;
        }

        best = nearest(goodSide,goal,best);

        Point bestPossiblePointOnTheBadSide = n.bestPossiblePointOnTheBadSide(goal);
        if (Point.distance(bestPossiblePointOnTheBadSide,goal) < Point.distance(best.p,goal)) {
            best = nearest(badSide,goal,best);
        }
        return best;

    }



}
