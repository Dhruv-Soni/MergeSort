package merge;

import java.util.*;

public class ThreeArrayMerger {
	private int[] array1;
	private int[] array2;
	private int[] array3;
	private int[] dest; // "dest" means destination

	//
	// Constructor. Don't change this.
	//
	public ThreeArrayMerger(int[] array1, int[] array2, int[] array3, int[] dest) {
		if (array1.length + array2.length + array3.length != dest.length)
			throw new IllegalArgumentException("Invalid array lengths");

		this.array1 = array1;
		this.array2 = array2;
		this.array3 = array3;
		this.dest = dest;
	}

	//
	// Merge array1 with array2, into a temporary array. Then merge that
	// temporary array
	// with array 3, into dest.
	//
	public void merge() {
		int[] temp = new int[array1.length + array2.length];
		merge2(array1, array2, temp);
		merge2(array3, temp, dest);
	}

	//
	// You saw how to do this in lecture on April 6. When this method returns,
	// the values in a1 and a2 should be in merged[], in ascending order. Assume
	// merged[] has been created and is the right length, and a1 & a2 are
	// sorted.
	//
//	public static void merge2(int[] a1, int[] a2, int[] merged) {
//		// Index Position in first array - starting with first element
//		int iFirst = 0;
//
//		// Index Position in second array - starting with first element
//		int iSecond = 0;
//
//		// Index Position in merged array - starting with first position
//		int iMerged = 0;
//
//		// Compare elements at iFirst and iSecond,
//		// and move smaller element at iMerged
//		while (iFirst != a1.length || iSecond != a2.length) {
//			// while(true)
//			if (iFirst == a1.length && iSecond != a2.length)
//				merged[iMerged++] = a2[iSecond++];
//			else if (iSecond == a2.length && iFirst != a1.length)
//				merged[iMerged++] = a1[iFirst++];
//			else if (a1[iFirst] < (a2[iSecond]) && (iFirst != a1.length) && (iSecond != a2.length))
//				merged[iMerged++] = a1[iFirst++];
//			else
//				merged[iMerged++] = a2[iSecond++];
//
//		}
//
//	}

	 private static void merge2(int[] a1, int[] a2, int[] merged)
	 {
	 int j=0,k=0; //index of a1, a2 and merged respectively
	 for(int i = 0; i < merged.length; i++ ) //checks if a1 and
	 {
	 boolean takeFromLeft= (( (k==a2.length) && (j!=a1.length)) || (a1[j]<a2[k])); // the complier problem with raj**
	 if(takeFromLeft)
	 {
	 merged[i]=a1[j++];
	
	 }
	 else
	 {
	 merged[i]=a2[k++];
	
	 }
	 }
	 }

	int getNVisits() {
		// Merging array1 with array 2 requires 1 read and 1 write for each
		// member of each array.
		int nVisits = 2 * (array1.length + array2.length);

		// Merging the temporary array with array 3 requires 1 read and 1 write
		// for each member of each array.
		// The length of the temporary array is array1.length + array2.length.
		nVisits += 2 * (array1.length + array2.length + array3.length);
		return nVisits;
	}

	public static void main(String[] args) {
		// Test the merge2() method. Think about what the output should
		// look like. Comment out this code after you're confident that merge2()
		// is ok.
		// int[] a1 = { 1, 3, 5};
		// int[] a2 = { 3, 4, 6};
		// int[] partiallyMerged = new int[6];
		// merge2(a1, a2, partiallyMerged);
		// for (int i : partiallyMerged)
		// System.out.println(i);

		// Un-comment this code after you're confident that merge2() is ok. Use
		// this code to test the merge() method.

		int[] b1 = { 1, 5, 7 };
		int[] b2 = { 2, 5, 6 };
		int[] b3 = { 3, 4, 9 };
		int[] merged = new int[9];
		ThreeArrayMerger merger = new ThreeArrayMerger(b1, b2, b3, merged);
		merger.merge();
		for (int i : merged)
			System.out.println(i);
		//

	}
}
