class LRUCache {
    class Node{
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node left;  // Least recently used side
    private final Node right; // Most recently used side

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Dummy nodes make list updates easier.
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) {
            return -1;
        }

        remove(node);
        insertAtRight(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node != null) {
            node.value = value;
            remove(node);
            insertAtRight(node);
            return;
        }
        else {
            node = new Node(key, value);
            cache.put(key, node);
            insertAtRight(node);
        }

        if (cache.size() > capacity) {
            Node leastRecentlyUsed = left.next;
            remove(leastRecentlyUsed);
            cache.remove(leastRecentlyUsed.key);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertAtRight(Node node) {
        Node previousMostRecent = right.prev;

        previousMostRecent.next = node;
        node.prev = previousMostRecent;

        node.next = right;
        right.prev = node;
    }
}
