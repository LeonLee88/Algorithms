class MidStack<K>{
    public static class Node<K>{
        public K key;
        public Node<K> pre;
        public Node<K> next;
        public Node(K value){
            this.key = value;
        }
    }
    public int size;
    public Node<K> head;
    public Node<K> tail;
    public Node<K> mid;
    public MidStack(){
        head = tail = mid = null;
    }
    public K pop() {
        if (tail == null) {
            return null;
        }
        Node<K> result = tail;
        tail.pre.next = null;
        tail = tail.pre;
        if (size % 2 == 1) {
            mid = mid.pre;
        }
        size--;
        return result.key;
    }
    public void push(K key) {
        Node<K> newNode = new Node(key);
        if (tail == null) {
            head = tail = mid = newNode;
        }else{
            tail.next = newNode;
            newNode.pre = tail;
            tail = newNode;
            if (size % 2 == 0) {
                mid = mid.next;
            }
        }
        size++;
    }
    public K peek() {
        if (tail == null) {
            return null;
        }
        return tail.key;
    }
    public K peekMid() {
        if (mid == null) {
            return null;
        }
        return mid.key;
    }
    public K popMid() {
        if (mid == null) {
            return null;
        }
        if(mid == tail){
            K result = mid.key;
            head = tail = mid = null;
            return result;
        }
        if (mid == head) {
            K result = mid.key;
            head = tail;
            mid = tail;
            return result;
        }
        mid.pre.next = mid.next;
        mid.next.pre = mid.pre;
        Node<K> temp = mid;
        if (size % 2 == 1) {
            mid = mid.pre;
        }else{
            mid = mid.next;
        }
        temp.pre = null;
        temp.next = null;
        size--;
        return temp.key;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<K> cur = head;
        while(cur != null) {
            sb.append(cur.key).append(",");
            cur = cur.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}