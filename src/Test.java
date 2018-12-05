import java.util.Scanner;

/**
 * Test harness for LRU page replacement algorithm
 *
 * Usage:
 *	java [-Ddebug] Test <reference string size> <number of page frames>
 */

public class Test
{
	public static int page_frames;

	public static void main(String[] args) {
		int page_size;

		Scanner scanner = new Scanner(System.in);

		System.out.print("Size of Page Reference String: ");
		page_size = scanner.nextInt();
		System.out.print("Number of page frames: ");
		page_frames = scanner.nextInt();

		PageGenerator ref = new PageGenerator(page_size); //Integer(args[0])

		int[] referenceString = ref.getReferenceString();

		/** Use the LRU algorithm */
		LRU lru = new LRU(page_frames); //Integer(args[1])

		// output a message when inserting a page
		for (int i = 0; i < referenceString.length; i++) {
			//System.out.println("inserting " + referenceString[i]);
			lru.insert(referenceString[i]);
		}

		lru.algorithm();

		// report the total number of page faults
		System.out.println("LRU faults = " + lru.getPageFaultCount());
		System.out.println("LRU Page Replacements = " + lru.getPageSwaps());
	}
}