class MergeSort {

	/**
	 * Takes a ArrayList, it's starting index and the index of the last element
	 * and sorts it by recursively splitting it (it doesn't actually create two
	 * different arrays when splitting it just determines where each array
	 * starts and ends) and then merging them together in the correct order
	 *
	 * @param list
	 *            the MyArrayList object that the sorting will be performed on
	 * @param start
	 *            an integer that specifies the index of the first element in
	 *            the MyArrayList object
	 * @param finish
	 *            an integer that specifies the index of the last element in the
	 *            MyArraylist object
	 */
	void mergeSort(ArrayList<Integer> list, int start, int finish) {
		// if the index of the first element and the index of the last element
		// are the same
		// or if the list is empty then return
		if (start == finish || list.size() == 0) {
			return;
		}
		// find the midpoint of the list in order to split the list into two
		// parts
		int mid = (start + finish) / 2;
		// call mergeSort on the left sublist
		mergeSort(list, start, mid, c);
		// call mergeSort on the right sublist
		mergeSort(list, mid + 1, finish, c);
		// merge the left and right sublists
		merge(list, start, mid, mid + 1, finish, c);
	}

	/**
	 * Takes an ArrayList that's conceptually split into two lists, the starting
	 * index and the index of the last element of the first Array and the
	 * starting index and the index of the last element of the second Array and
	 * merge them together into one array that is sorted in ascending order
	 *
	 * @param list
	 *            the MyArrayList object that the merging will be performed on
	 * @param leftFirst
	 *            an integer that specifies the index of the first element in
	 *            the first MyArrayList object
	 * @param leftLast
	 *            an integer that specifies the index of the last element in the
	 *            first MyArraylist object
	 * @param rightFirst
	 *            an integer that specifies the index of the first element in
	 *            the second MyArrayList object
	 * @param righttLast
	 *            an integer that specifies the index of the last element in the
	 *            second MyArraylist object
	 * @param c
	 *            a comparator that determines which data field of the Record
	 *            objects should be taken in consideration when sorting
	 */
	void merge(ArrayList<Integer> list, int leftFirst, int leftLast, int rightFirst, int rightLast) {
		// create a temporary array to store the elements in ascending order
		ArrayList<Integer> temp = new ArrayList<Integer>();
		// Create two variables to keep track of the index we're at in the left
		// and right sublists
		int indexLeft = leftFirst;
		int indexRight = rightFirst;
		// While we're not at the end of the left or right sublist keep on going
		while (indexLeft <= leftLast && indexRight <= rightLast) {
			// find the smallest element between the two sublists and add it to
			// the temporary list
			// so that it contains the elements in ascending order
      if (list.get(indexLeft) < list.get(indexRight)) {
        temp.add(list.get(indexLeft));
				indexLeft++;
      } else {
        temp.add(list.get(indexRight));
				indexRight++;
      }
		}
		// Check if there is anything left in the left sublist and add it to the
		// temporary list
		while (indexLeft <= leftLast) {
			temp.add(list.get(indexLeft));
			indexLeft++;
		}
		// Check if there is anything right in the left sublist and add it to
		// the temporary list
		while (indexRight <= rightLast) {
			temp.add(list.get(indexRight));
			indexRight++;
		}
		// Copy the contents of the temporary list to the actual list so that it
		// contains all elements in a sorted order
		int i = 0;
		int j = leftFirst;
		while (i < temp.size()) {
			list.set(j, temp.get(i++));
			j++;
		}

	}
}
