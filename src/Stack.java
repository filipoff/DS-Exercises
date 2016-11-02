public class Stack<T> {
	private class Node {
		private T value = null;
		private Node next = null;

		private Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	private Node top = null;

	public void push(T element) {

		Node node = new Node(element, top);
		top = node;
	}

	public T pop() {
		if (top == null)
			return null;

		T element = top.value;
		top = top.next;

		return element;
	}

	public T peek() {
		if (top == null)
			return null;
		return top.value;
	}
}
