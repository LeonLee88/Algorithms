public class MyHashMap<K,V>{
	public static class Node<K, V>{
		final K key;
		V value;
		Node<K, V> next;
		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
		public K getKey() {
			return key;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value;
		}
	}
	public static final int DEFAULT_CAPACITY = 16;
	public static final float DEFAULT_LOAD_FACOTR = 0.75f;
	private Node<K,V>[] array;
	private int size;
	private float loadFactor;

	public MyHashMap(){
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACOTR);
	}
	public MyHashMap(int cap, int loadFactor) {
		if (cap <= 0) {
			throw new IllegalArgumentException("cap can not be <= 0");
		}
		this.array = (Node<K, V>)(new Node[cap]);
		this.size = 0;
		this.loadFactor = loadFactor;
	}
	public int size(){
		return size == 0;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public void clear(){
		Arrays.fill(this.array, null);
		size = 0;
	}
	private int hash(K key) {
		if (key == null) {
			return 0;
		}
		return key.hashCode() & 0X7FFFFFFF;
	}
	private int getIndex(K key) {
		return hash(key) % array.length;
	}
	private boolean equalsValue(V v1, V v2) {
		if (v1 == null && v2 == null) {
			return true;
		}
		if (v1 == null || v2 == null) {
			return false;
		}
		return v1.equals(v2);
	}
	public boolean containsValue(V value) {
		if (isEmpty()) {
			return false;
		}
		synchronized(this){
			for (Node<K,V> node : array) {
				while (node != null) {
					if (equalsValue(node.value, value)) {
						return true;
					}
					node = node.next;
				}
			}
			return false;
		}
	}
	private boolean equalsKey(K k1, K k2) {
		if (k1 == null && k2 == null) {
			return true;
		}
		if (k1 == null || k2 == null) {
			return false;
		}
		return k1.equals(k2);
	}
	public boolean containsKey(K key) {
		int index = getIndex(key);
		synchronized(this){
			Node<K,V> node = array[index];
			while(node != null) {
				if (equalsKey(node.key, key)) {
					return true;
				}
				node = node.next;
			}
			return false;
		}
	}
	public V get(K key) {
		int index = getIndex(key);
		synchronized(this) {
			Node<K, V> node = array[index];
			while(node != null) {
				if (equalsKey(node.key, key)) {
					return node.value;
				}
				node = node.next;
			}
			return null;	
		}
	}
	public V put(K key, V value) {
		int index = getIndex(key);
		synchronized(this) {
			Node<K, V> head = array[index];
			Node<K, V> node = head;
			while (node != null) {
				if (equalsKey(node.key. key)) {
					V result = node.result;
					node.value = value;
					return result;
				}
				node = node.next;
			}
			Node<K,V> newNode = new Node(key, value);
			newNode.next = head;
			array[index] = newNode;
			size++;
			if (needRehashing()) {
				rehashing();
			}
			return null;
		}
		
	}
	private boolean needRehashing() {
		float ratio = (size + 0.0f) / array.length;
		return ratio >= loadFactor;
	}
	private boolean rehashing() {
		//
	}
	public V remove(K key) {
		//
	}
}
