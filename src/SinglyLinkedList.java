import java.util.Iterator;
import java.util.NoSuchElementException;


public class SinglyLinkedList<T> implements Iterable<T> {

	private class Node {
		private T value = null;
		private Node next = null;

		private Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	private class SinglyLinkedListIterator implements Iterator<T> {

		private Node current;

		private SinglyLinkedListIterator() {
			current = first;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			if (hasNext()) {
				T element = current.value;
				current = current.next;
				return element;
			}
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			// for now
			throw new UnsupportedOperationException();
		}

	}

	private Node first = null;
	private Node last = null;
	private int size = 0;

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void addFirst(T element) {
		if (isEmpty())
			first = last = new Node(element, null);
		else {
			Node newFirst = new Node(element, first);
			first = newFirst;
		}
		size++;
	}

	public void addLast(T element) {
		if (isEmpty())
			first = last = new Node(element, null);
		else {
			Node node = new Node(element, null);
			last.next = node;
			last = node;
		}
		size++;
	}

	public void addAt(int index, T element) {

		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();

		if (index == size) {
			addLast(element);
			return;
		}

		if (index == 0) {
			addFirst(element);
			return;
		}

		Node current = getNodeAt(index - 1);
		current.next = new Node(element, current.next);
		size++;

	}

	private Node getNodeAt(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node current = first;

		for (int i = 0; i < index; i++)
			current = current.next;

		return current;
	}

	public T get(int index) {

		return getNodeAt(index).value;
	}

	public T removeLast() {
		if (isEmpty())
			throw new NoSuchElementException();

		T value = last.value;
		Node current = getNodeAt(size - 2);
		current.next = null;
		last = current;
		size--;
		return value;
	}

	public T removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException();

		T value = first.value;
		Node currentFirst = first;
		first = first.next;
		currentFirst.next = null;
		size--;
		return value;

	}

	public T remove(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();

		if (index == size - 1)
			return removeLast();

		if (index == 0)
			return removeFirst();

		Node current = getNodeAt(index - 1);
		T value = current.next.value;
		current.next = current.next.next;
		size--;
		return value;
	}

	public void clear() {
		Node current = first;
		while (current.next != null) {
			Node next = current.next;
			current.next = null;
			current = next;
		}
		first = last = null;
		size = 0;
	}

	public boolean contains(T element) {
		for (Iterator<T> it = new SinglyLinkedListIterator(); it.hasNext();)
			if (it.next() == element)
				return true;

		return false;
	}

	@Override
	public Iterator<T> iterator() {
		return new SinglyLinkedListIterator();
	}

	public void reverse() {
		// recursiveReverseFrom(first);
		iterativeReverse();
	}

	private void recursiveReverseFrom(Node current) {

		if (current.next == null) {
			last = first;
			first = current;
			return;
		}

		recursiveReverseFrom(current.next);
		current.next.next = current;
		if (current == last)
			last.next = null;
	}

	private void iterativeReverse() {

		Node current = first;
		Node prev = null;
		Node next = first.next;

		while (current.next != null) {

			current.next = prev;
			prev = current;
			current = next;
			next = current.next;
		}

		last = first;
		current.next = prev;
		first = current;
	}

	public void removeDuplicates() {

		if (size == 1)
			return;

		Node inspected = first;

		while (inspected != null) {

			Node potentialDuplicate = inspected.next;
			Node previousOfPotential = inspected;

			while (potentialDuplicate != null) {

				if (inspected.value.equals(potentialDuplicate.value)) {

					previousOfPotential.next = potentialDuplicate.next;
					potentialDuplicate = potentialDuplicate.next;

					if (potentialDuplicate == null)
						last = previousOfPotential;

					size--;

				} else {

					previousOfPotential = potentialDuplicate;
					potentialDuplicate = potentialDuplicate.next;
				}
			}
			inspected = inspected.next;
		}
	}

	public T getNthLastElement(int index) {
		Node left = first;
		Node right = first;

		for (int i = 0; i < index; i++) {
			if (right.next == null)
				return null;
			right = right.next;
		}
		while (right.next != null) {
			right = right.next;
			left = left.next;
		}
		return left.value;
	}
}