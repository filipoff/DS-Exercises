public class Main {

	private static boolean recursiveIsPresent(int target, int[] array,
			int leftBoundary, int rightBoundary) {

		int medianIndex = (leftBoundary + rightBoundary) / 2;

		if (rightBoundary - leftBoundary == 0)
			return false;

		if (target == array[medianIndex])
			return true;
		else {
			if (target < array[medianIndex])
				return recursiveIsPresent(target, array, leftBoundary,
						medianIndex);
			else
				return recursiveIsPresent(target, array, medianIndex + 1,
						rightBoundary);
		}
	}

	private static boolean iterativeIsPresent(int target, int[] array,
			int leftBoundary, int rightBoundary) {

		while (true) {
			int medianIndex = (leftBoundary + rightBoundary) / 2;

			if (leftBoundary - rightBoundary == 0)
				return false;
			if (target == array[medianIndex]) {
				return true;
			} else {
				if (target < array[medianIndex])
					rightBoundary = medianIndex;
				else
					leftBoundary = medianIndex + 1;
			}
		}
	}

	public static boolean isPresent(int target, int[] array) {
		return iterativeIsPresent(target, array, 0, array.length);
	}

	public boolean checkAnagram(String first, String second) {

		if (first.length() != second.length())
			return false;

		int[] firstMap = new int[65536];
		int[] secondMap = new int[65536];

		for (int i = 0; i < first.length(); i++) {
			firstMap[first.charAt(i)]++;
			secondMap[second.charAt(i)]++;
		}

		for (int i = 0; i < first.length(); i++) {
			if (firstMap[first.charAt(i)] != secondMap[first.charAt(i)])
				return false;
		}
		return true;
	}

	public static boolean hasUniqueCharacters(String string) {
		int checker = 0;
		for (int i = 0; i < string.length(); ++i) {
			int val = string.charAt(i) - 'a';
			if ((checker | (1 << val)) == checker)
				return false;
			checker |= (1 << val);
		}
		return true;
	}

	public static int countOpenedDoors(int doorsCount) {

		boolean[] doors = new boolean[doorsCount];

		int counter = 0;

		for (int i = 0; i < doorsCount; i++) {
			for (int j = i; j < doorsCount; j += i + 1) {
				doors[j] = !doors[j];
				if (doors[j] == true)
					counter++;
				else
					counter--;
			}
		}
		return counter;
	}

	public static void main(String[] args) {

		DoublyLinkedList<Integer> l = new DoublyLinkedList<Integer>();

		for (int i = 0; i < 10; i++) {
			l.pushBack(i);
		}

		l.printContent();
		
		l.reverse();
		
		l.printContent();
		
	}
}
