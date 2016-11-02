public class Queue<T> {

	private class Node {
		private T value = null;
		private Node next = null;

		private Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	private Node first = null;
	private Node last = null;

	public void enqueue(T element) {
		Node node = new Node(element, null);
		if (last == null && first == null) {
			first = last = node;
		} else {
			last.next = node;
			last = node;
		}
	}

	public T dequeue() {
		if (first == null) {
			return null;
		}
		if (first == last) {
			T value = first.value;
			first = last = null;
			return value;
		}
		T value = first.value;
		first = first.next;
		return value;
	}

	public boolean isEmpty() {
		return first == null;
	}
}
