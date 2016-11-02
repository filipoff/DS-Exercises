public class Tree<T extends Comparable<T>> {

	private class Node<U extends Comparable<U>> implements Comparable<Node<U>> {
		private U value = null;
		private Node<U> left = null;
		private Node<U> right = null;

		private Node(U value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;

		}

		@Override
		public int compareTo(Node<U> o) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	Node root = null;

	public boolean remove(T element) {
		return false;
	}
}
