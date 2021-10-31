import org.junit.Test;

public class TestUnionFind {
    @Test
    public void testUnionFind() {
        UnionFind u = new UnionFind(100);
        u.union(1,2);
        u.union(3,4);
        u.union(5,6);
        u.union(3,2);
        u.union(3,6);
        int p = u.find(2);
        boolean q = u.connected(5,6);
    }
}
