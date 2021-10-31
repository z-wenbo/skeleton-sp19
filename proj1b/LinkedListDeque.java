public class LinkedListDeque<Item> implements Deque<Item>{
    private class LinkNode{
        public Item item;
        public LinkNode next;
        public LinkNode last;

        public LinkNode(){
            item = null;
            next = this;
            last = this;
        }

        public LinkNode(Item i, LinkNode n, LinkNode l){
            item = i;
            next = n;
            last = l;
        }
    }

    private LinkNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new LinkNode();
        size = 0;
    }

    @Override
    public void addFirst(Item item){
        LinkNode p = sentinel.next;
        sentinel.next = new LinkNode(item, sentinel.next, sentinel);
        p.last = sentinel.next;
        size = size + 1;
    }
    @Override
    public void addLast(Item item){
        LinkNode p = sentinel.last;
        sentinel.last = new LinkNode(item, sentinel, sentinel.last);
        p.next = sentinel.last;
        size = size + 1;
    }

    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        LinkNode p = sentinel.next;
        while (p != sentinel){
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
        System.out.print("\n");
    }
    @Override
    public Item removeFirst(){
        LinkNode p = sentinel.next;
        sentinel.next = p.next;
        sentinel.next.last = sentinel;
        size = size - 1;
        return p.item;
    }
    @Override
    public Item removeLast(){
        LinkNode p = sentinel.last;
        sentinel.last = p.last;
        sentinel.last.next = sentinel;
        size = size - 1;
        return p.item;
    }
    @Override
    public Item get(int index){
        if (index >= size || index < 0){
            return null;
        }
        int j = 0;
        LinkNode p = sentinel.next;
        while(j<index){
            p = p.next;
            j = j + 1;
        }
        return p.item;
    }

    private Item get(LinkNode p, int i) {
        if (i == 0) {
            return p.item;
        }
        return get(p.next,i-1);
    }

    public Item getRecursive(int index){
        if (index >= size || index < 0){
            return null;
        } else {
            return get(sentinel.next,index);
        }
    }

    public LinkedListDeque(LinkedListDeque other){
        sentinel = new LinkNode();
        size = 0;
        for(int i = 0; i < other.size(); i += 1){
            addLast((Item) other.get(i));
        }
    }

}