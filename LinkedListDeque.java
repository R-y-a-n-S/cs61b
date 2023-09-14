public class LinkedListDeque<T> {
    private DLL baseLL;
    public LinkedListDeque() {
        baseLL = new DLL();
    }
    public void addFirst(T item) {
        baseLL.addFirst(item);
    }

    public void addLast(T item) {
        baseLL.addLast(item);
    }

    public boolean isEmpty() {
        return baseLL.size == 0;
    }

    public int size() {
        return baseLL.size;
    }

    public void printDeque() {
        Node temp = baseLL.front;
        for (int i = 0; i < baseLL.size; i ++) {
            if (temp.next.item != null) {
                System.out.print(temp.next.item);
                if (temp.next == baseLL.last) break;
                System.out.print(" ");

            }
            temp = temp.next;
        }


    }

    public T removeFirst() {
        return baseLL.removeFirst();
    }

    public T removeLast() {
        return baseLL.removeLast();
    }

    public T get(int index) {
        if (index >= baseLL.size || index < 0) return null;
        Node temp = baseLL.front;
        for ( int i = 0; i <= index; i ++) {
            temp = temp.next;
            if (i == index) return (T) temp.item;
        }
        return null;

    }

    public T getRecursive(int index) {
        if (index < 0 || index >= baseLL.size) {
            return null; // Index out of bounds
        }
        return (T) getRecursive2(index, baseLL.front.next);
    }

    private T getRecursive2(int index, Node<T> current) {
        if (index == 0) {
            return current.item;
        }
        return (T) getRecursive2(index - 1, current.next);
    }

    public class Node<T> {
        public T item;
        public Node next;
        public Node prev;


        public Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    public class DLL {
        public Node front;
        public Node last;
        public int size;
        public DLL() {
            front = new Node<>(null, null, null);
            last = new Node<>(null, null, front);
            front.next = last;
            size = 0;
        }
        public void addFirst(T data) {
            Node newNode = new Node<>(data,front.next,front);
            front.next.prev = newNode;
            front.next = newNode;
            size ++;
        }

        public void addLast(T data) {
            Node newNode = new Node<>(data,last,last.prev);
            last.prev.next = newNode;
            last.prev = newNode;
            size ++;
        }

        public T removeFirst() {
            if (size == 0) return null;
            T item = (T) front.next.item;
            Node temp = front.next.next;
            temp.prev = front;
            front.next.next = null;
            front.next.prev = null;
            front.next = temp;
            size --;
            return item;
        }

        public T removeLast() {
            if (size == 0) return null;
            T item = (T) last.prev.item;
            Node temp = last.prev.prev;
            temp.next = last;
            last.prev.prev = null;
            last.prev.next = null;
            last.prev = temp;
            size --;
            return item;
        }
    }

}
















