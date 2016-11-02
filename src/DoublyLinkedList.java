public class DoublyLinkedList<T> {

	private class Node {
		private T value = null;
		private Node next = null;
		private Node prev = null;

		private Node(T value, Node prev, Node next) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
	}

	private Node first = null;
	private Node last = null;
	private int size = 0;

	public int getSize() {
		return size;
	}

	private boolean isEmpty() {
		return size == 0;
	}

	public void pushBack(T element) {
		if (isEmpty()) {
			first = last = new Node(element, null, null);
			size++;
			return;
		}
		Node node = new Node(element, last, null);
		last.next = node;
		last = node;
		size++;
	}

	public void pushFront(T element) {
		if (isEmpty()) {
			first = last = new Node(element, null, null);
			size++;
			return;
		}
		Node node = new Node(element, null, first);
		first.prev = node;
		first = node;
		size++;
	}

	public T popBack() {
		if (isEmpty())
			return null;
		if (first == last) {
			T element = first.value;
			first = last = null;
			size--;
			return element;
		}

		T element = last.value;
		last = last.prev;
		last.next.prev = null;
		last.next = null;
		size--;
		return element;
	}

	public T popFront() {
		if (isEmpty())
			return null;
		if (first == last) {
			T element = first.value;
			first = last = null;
			size--;
			return element;
		}

		T element = first.value;
		first = first.next;
		first.prev.next = null;
		first.prev = null;
		size--;
		return element;
	}

	public void printContent() {
		Node n = first;
		while (n != null) {
			System.out.print(n.value + (n.next == null ? "\n" : ", "));
			n = n.next;
		}
		System.out.println("Size: " + size);
	}

	private T peekFront() {
		if (isEmpty())
			return null;
		return first.value;
	}

	private T peekBack() {
		if (isEmpty())
			return null;
		return last.value;
	}

	private Node getNodeAt(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		if (index == 0)
			return first;

		if (index == size - 1)
			return last;

		Node node = null;

		if (index < size / 2) {
			node = first;
			int counter = 0;
			while (counter++ < index)
				node = node.next;

		} else {
			int counter = size - 1;
			node = last;
			while (counter-- > index)
				node = node.prev;

		}

		return node;
	}

	public T getAt(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		if (index == 0)
			return peekFront();

		if (index == size - 1)
			return peekBack();

		return getNodeAt(index).value;

	}

	public void removeAt(int index) {

		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		if (index == 0) {
			popFront();
			return;
		}

		if (index == size - 1) {
			popBack();
			return;
		}

		Node node = getNodeAt(index);

		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.next = null;
		node.prev = null;
		size--;
	}

	public void reverse() {
		Node current = last;
		first = last;
		while (current != null) {
			Node node = current.next;
			
			current.next = current.prev;
			current.prev = node;
			current = current.next;
		}
		
		last = current;

	}
}
