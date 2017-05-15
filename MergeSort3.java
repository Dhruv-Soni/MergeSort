package merge;

public class MergeSort3 {
	private int[] a;
	private long nVisits;

	public MergeSort3(int[] a) {
		this.a = a;
	}

	// Multiple lines if a is bigger than 20 elements.
	public String toString() {
		return "MergeSort3:\n" + arrayToString(a);
	}

	// This might be useful for debugging.
	private static String arrayToString(int[] arr) {
		String s = "{ ";
		if (arr.length <= 20) {
			for (int i : arr)
				s += i + ",";
			s = s.substring(0, s.length() - 1); // delete last char (a comma)
												// from s
			s += " }";
			return s;
		}

		else {
			for (int i : arr)
				s += "\n  " + i;
			s += "\n}";
			return s;
		}
	}

	// Complete this. It's ok to copy code you wrote in lab.
	private boolean isSorted(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (!(arr[i - 1] <= arr[i])) {
				return false;
			}

		}
		return true;

	}

	public void sort() {
		nVisits = sortRecurse(a);
	}

	// Returns the number of visits.
	private long sortRecurse(int[] sortMe) {
		// Already sorted if length is 0 or 1.
		if (sortMe.length <= 1)
			return 1; // 1 visit

		long nVisits = 0;

		// Copy values into 3 pieces.
		int pieceLength = sortMe.length / 3;
		if (pieceLength == 0)
			pieceLength = 1;
		int[] piece1 = new int[pieceLength];
		System.arraycopy(sortMe, 0, piece1, 0, pieceLength);

		int[] piece2 = new int[pieceLength];
		System.arraycopy(sortMe, pieceLength, piece2, 0, pieceLength);

		int lastPieceLength = sortMe.length - 2 * pieceLength;
		int[] piece3 = new int[lastPieceLength];
		System.arraycopy(sortMe, pieceLength * 2, piece3, 0, lastPieceLength);

		nVisits += 2 * sortMe.length;

		// Sort the 3 pieces.
		nVisits += sortRecurse(piece1);
		assert isSorted(piece1) : "Not sorted";
		nVisits += sortRecurse(piece2);
		assert isSorted(piece2) : "Not sorted";
		nVisits += sortRecurse(piece3);
		assert isSorted(piece3) : "Not sorted";

		// Merge.
		// add code here.
		ThreeArrayMerger mm = new ThreeArrayMerger(piece1, piece2, piece3, sortMe);
		mm.merge();
		nVisits += mm.getNVisits();
		assert isSorted(sortMe);
		return nVisits;
	}

	public long getNVisits() {
		return nVisits;
	}

	public static void main(String[] args) {
		System.out.println("STARTING");

		// Test your algorithm on the tiny, already sorted, backward, and
		// length=10
		// arrays provided by TestCaseMaker. When you are confident, comment out
		// the code or delete it.
		// Uncomment this code when you are confident your algorithm works.
		int[] lengths = { 10_000, 50_000, 100_000, 250_000 };
		for (int length : lengths) {
			int[] sortMe = TestCaseMaker.buildRandom(length, 1_000_000_000);
			MergeSort3 sorter = new MergeSort3(sortMe);
			sorter.sort();
			long nVisits = sorter.getNVisits();
			double nLogN = length * Math.log10(length);
			double k = nVisits / nLogN;
			System.out.println("Sorted " + length + " after " + nVisits + "visits ... k = " + k);
		}

		/*
		 * int[] c = new int[14];
		 * 
		 * for(int i = 0; i<c.length; i++) { c[i] = i; }
		 * 
		 * MergeSort3 a = new MergeSort3(c); a.sortRecurse(c);
		 * 
		 * System.out.println("DONE"); }
		 */

		// MergeSort3 a = new MergeSort3(TestCaseMaker.getTiny());
		// a.sort();
		// System.out.println(a.toString());
		// System.out.println(a.nVisits);

	}
}
