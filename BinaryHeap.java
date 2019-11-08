public class BinaryHeap {

	private int[] arr;
	private int size;

	public BinaryHeap() {
		arr = new int[10];
		size = 0;
		arr[0] = Integer.MAX_VALUE;
	}
//return the position of any item's parent or children for any given item
	private int parent(int index) {
		return (index - 1) / 2;
	}

	private int leftChild(int index) {
		return (index * 2) + 1;
	}

	private int rightChild(int index) {
		return (index * 2) + 2;
	}
//remove the root
	public int remove() {
		int returnVal = arr[0];
		arr[0] = arr[--size];
		if (size != 0) {
			siftdown(0);
		}

		return returnVal;
	}
//add items to the queue
	public void add(int i) {

		if (arr.length == size) {

			growHeap();
		}
		arr[size++] = i;
		int index = size - 1;

		while (arr[index] < arr[parent(index)] && index > 0) {
			swap(index, parent(index));
			index = parent(index);
		}
	}
//expand the array
	private void growHeap() {
		int[] newheap = new int[arr.length * 2];
		System.arraycopy(this.arr, 0, newheap, 0, arr.length);
		this.arr = newheap;
	}

	private void swap(int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
//swap child and parent if the child has higher priority.
	private void siftdown(int position) {
		if (leftChild(position) >= size)
			return;
		int child = leftChild(position);
		if (rightChild(position) < size && arr[rightChild(position)] < arr[child])
			child = rightChild(position);
		if (arr[child] < arr[position]) {
			swap(child, position);
		}
		siftdown(child);
	}

}