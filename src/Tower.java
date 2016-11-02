import java.util.ArrayList;
import java.util.List;

public class Tower {
	private int diskCount;
	private List<Stack<Integer>> rods;
	private static final int rodCount = 3;
	private int stepCounter;
	private boolean done;

	public Tower(int diskCount) {
		this.diskCount = diskCount;
		init();
	}

	private void init() {
		this.stepCounter = 0;
		this.done = false;
		this.rods = new ArrayList<Stack<Integer>>();
		for (int i = 0; i < rodCount; i++) {
			rods.add(new Stack<Integer>());
		}
		for (int i = diskCount; i > 0; i--) {
			rods.get(0).push(i);
		}
	}

	private void moveDiskToProperRod(Stack<Integer> firstRod,
			Stack<Integer> secondRod) {
		Integer firstRodValue = firstRod.peek();
		Integer secondRodValue = secondRod.peek();
		if (firstRodValue == null) {
			firstRod.push(secondRodValue);
			secondRod.pop();
		} else if (secondRodValue == null) {
			secondRod.push(firstRodValue);
			firstRod.pop();
		} else if (firstRodValue < secondRodValue) {
			secondRod.push(firstRodValue);
			firstRod.pop();
		} else {
			firstRod.push(secondRodValue);
			secondRod.pop();
		}
		stepCounter++;
		if (rods.get(0).peek() == null && rods.get(1).peek() == null)
			done = true;
	}

	public void solve() {
		if (diskCount % 2 == 0) {
			while (true) {
				moveDiskToProperRod(rods.get(0), rods.get(1));
				if (done)
					break;
				moveDiskToProperRod(rods.get(0), rods.get(2));
				if (done)
					break;
				moveDiskToProperRod(rods.get(1), rods.get(2));
				if (done)
					break;
			}
		} else {
			while (true) {
				moveDiskToProperRod(rods.get(0), rods.get(2));
				if (done)
					break;
				moveDiskToProperRod(rods.get(0), rods.get(1));
				if (done)
					break;
				moveDiskToProperRod(rods.get(1), rods.get(2));
				if (done)
					break;
			}
		}
	}

	public int getStepCounter() {
		return stepCounter;
	}
}
