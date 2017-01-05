package data_structures;

// implement array with Array

public class ArrayQueue {
	int size;
	int head;
	int tail;
	int capacity;
	Integer[] array;

	public ArrayQueue(int capacity) {
		this.array = new Integer[capacity];
		size = 0;
		head = 0;
		tail = 0;
	}

	public boolean offer(Integer num) {
		if (size == array.length) {
			return false;
		}
		array[tail] = num;
		tail = (tail + 1) % array.length;
		size++;
		return true;
	}

	public Integer peek() {
		if (size == 0) {
			return null;
		}
		return array[head];
	}

	public Integer poll() {
		if (size == 0) {
			return null;
		}
		Integer num = array[head];
		head = (head + 1) % array.length;
		size--;
		return num;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}
}
