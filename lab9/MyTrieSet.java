import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

public class MyTrieSet implements TrieSet61B{
    private Node root;

    private class Node {
        private boolean isKey;
        private HashMap<Character,Node> map;

        public Node(){
            isKey = false;
            map = new HashMap<>();
        }

        public Node(char c, boolean b){
            isKey = b;
            map = new HashMap<>();
        }
    }

    public  MyTrieSet(){
        root = new Node();
    }

    @Override
    public void clear() {
        root = new Node();
    }

    @Override
    public boolean contains(String key) {
        if (key == null || key.length() < 1) {
            return true;
        }
        Node curr = root;
        for (int i = 0, n = key.length(); i < n; i++) {
            char c = key.charAt(i);
            if (!curr.map.containsKey(c)) return false;
            curr = curr.map.get(c);
        }
        if (curr.isKey == true) {
            return true;
        } else {
            return false;
        }
    }



    @Override
    public void add(String key) {
        if (key == null || key.length() < 1) {
            return;
        }
        Node curr = root;
        for (int i = 0, n = key.length(); i < n; i++) {
            char c = key.charAt(i);
            if (!curr.map.containsKey(c)) {
                curr.map.put(c, new Node(c, false));
            }
            curr = curr.map.get(c);
        }
        curr.isKey = true;
    }

    private void colHelp(String s, List<String> x, Node n){
        if (n.isKey) x.add(s);
        for (Character c:
                n.map.keySet()) {
            colHelp(s+c, x, n.map.get(c));
        }
    }

    private Node findprefix(String key){
        Node curr = root;
        for (int i = 0, n = key.length(); i < n; i++) {
            char c = key.charAt(i);
            curr = curr.map.get(c);
        }

        return curr;
    }

    @Override
    public List<String> keysWithPrefix(String prefix) {
        List<String> xs = new LinkedList<>();
        Node pre = findprefix(prefix);
        colHelp(prefix, xs, pre);
        return xs;
    }

    @Override
    public String longestPrefixOf(String key) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        MyTrieSet t = new MyTrieSet();
        t.add("hello");
        t.add("hi");
        t.add("help");
        t.add("zebra");
    }
}
