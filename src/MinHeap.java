import java.util.Arrays;
import java.util.stream.Collectors;

import javax.swing.text.StyleContext.SmallAttributeSet;


@SuppressWarnings("unused")
public class MinHeap {

	private int capacity = 10;
	private int size = 0;

	int[] items = new int[capacity];

	// Get Index:
	private int getLeftChildIndex(int parentIndex) { return 2*parentIndex + 1; }
	private int getRightChildIndex(int parentIndex) { return 2*parentIndex + 2; }
	private int getParentIndex(int childIndex) { return (childIndex - 1)/2; }

	// Get Value:
	private int leftChildValue(int parentIndex) { return items[getLeftChildIndex(parentIndex)]; }
	private int rightChildValue(int parentIndex) { return items[getRightChildIndex(parentIndex)]; }
	private int parentValue(int childIndex) { return items[getParentIndex(childIndex)]; }

	// Get Booleans:
	private boolean hasLeftChild(int parentIndex) { return getLeftChildIndex(parentIndex) < size; }
	private boolean hasRightChild(int parentIndex) { return getRightChildIndex(parentIndex) < size; }
	private boolean hasParent(int childIndex) { return getParentIndex(childIndex) >= 0; }

	private void swap(int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}

	private void ensureCapacity() {
		if(size == capacity) {
			items = Arrays.copyOf(items, capacity*2);
			capacity = capacity*2;
		}
	}

	public int peek() {
		if (size == 0) throw new IllegalStateException();
		return items[0];
	}

	public int poll() {
		if (size == 0) throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}

	public void add(int item) {
		ensureCapacity();
		items[size] = item;
		size++;
		heapifyUp();
	}

	private void heapifyDown() {
		int index = 0;
		int smallerValueIndex = 0;
		while(hasLeftChild(index)) {
			
			if(items[getLeftChildIndex(index)] > items[getRightChildIndex(index)]) {
				smallerValueIndex = getRightChildIndex(index);
			} else {
				smallerValueIndex = getLeftChildIndex(index);
			}
			
			if(items[index] < items[smallerValueIndex]) {
				break;
			} else {
				swap(index, smallerValueIndex);
			}
			index = smallerValueIndex;
		}
	}

	private void heapifyUp() {
		int index = size - 1;
		while(hasParent(index) && parentValue(index) > items[index]) {
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}
	}
	
	public static void main(String[] args) {
		MinHeap mh = new MinHeap();
		mh.add(5);
		System.out.println(Arrays.stream(mh.items).boxed().collect(Collectors.toList()));
		mh.add(3);
		System.out.println(Arrays.stream(mh.items).boxed().collect(Collectors.toList()));
		mh.add(9);
		System.out.println(Arrays.stream(mh.items).boxed().collect(Collectors.toList()));
		mh.add(6);
		System.out.println(Arrays.stream(mh.items).boxed().collect(Collectors.toList()));
		mh.add(11);
		System.out.println(Arrays.stream(mh.items).boxed().collect(Collectors.toList()));
		mh.add(8);
		System.out.println(Arrays.stream(mh.items).boxed().collect(Collectors.toList()));
		mh.add(1);
		System.out.println(Arrays.stream(mh.items).boxed().collect(Collectors.toList()));
		mh.add(2);
		System.out.println(Arrays.stream(mh.items).boxed().collect(Collectors.toList()));
		
		System.out.println("Polled: " + mh.poll());
		System.out.println(Arrays.stream(mh.items).boxed().collect(Collectors.toList()));
		
		System.out.println("Polled: " + mh.poll());
		System.out.println(Arrays.stream(mh.items).boxed().collect(Collectors.toList()));

		System.out.println("Polled: " + mh.poll());
		System.out.println(Arrays.stream(mh.items).boxed().collect(Collectors.toList()));

		System.out.println("Polled: " + mh.poll());
		System.out.println(Arrays.stream(mh.items).boxed().collect(Collectors.toList()));

		System.out.println("Polled: " + mh.poll());
		System.out.println(Arrays.stream(mh.items).boxed().collect(Collectors.toList()));

		System.out.println("Polled: " + mh.poll());
		System.out.println(Arrays.stream(mh.items).boxed().collect(Collectors.toList()));

		System.out.println("Polled: " + mh.poll());
		System.out.println(Arrays.stream(mh.items).boxed().collect(Collectors.toList()));

		System.out.println("Polled: " + mh.poll());
		System.out.println(Arrays.stream(mh.items).boxed().collect(Collectors.toList()));

	}

}
