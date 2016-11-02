public class QueueUsingStacks<T> {
	Stack<T> enqueueStack;
	Stack<T> dequeueStack;

	public QueueUsingStacks() {
		enqueueStack = new Stack<T>();
		dequeueStack = new Stack<T>();
	}

	public void enqueue(T element) {
		enqueueStack.push(element);
	}

	public T dequeue() {
		if (dequeueStack.peek() == null) {
			while (enqueueStack.peek() != null) {
				dequeueStack.push(enqueueStack.pop());
			}
		}
		return dequeueStack.pop();
	}
}
