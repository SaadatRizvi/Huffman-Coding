import java.util.Arrays;

public class MinHeap {

	private int capacity;
	private int size;
	Node[] items;
	
	MinHeap(int initialCapacity){
		this.capacity = initialCapacity;
		this.size =0;
		this.items = new Node[capacity];
		
	}
	private int getLeftChildIndex(int parentIndex){ return 2*parentIndex + 1;}
	private int getRightChildIndex(int parentIndex){ return 2*parentIndex + 2;}
	private int getParentIndex(int childIndex){return (childIndex-1)/2;}
	
	private boolean hasLeftChild(int index){return getLeftChildIndex(index)< size; }
	private boolean hasRightChild(int index){return getRightChildIndex(index)< size; }
	private boolean hasParent(int index){return getParentIndex(index) >= 0;}
	
	private Node leftChild(int index) {return this.items[getLeftChildIndex(index)];} 
	private Node rightChild(int index){ return this.items[getRightChildIndex(index)];}
	private Node parent(int index){ return this.items[getParentIndex(index)];}
	
	
	private void swap(int i, int j){
		Node temp=items[i];
		items[i] = items[j];
		items[j] = temp;
		
	}
	private void ensureCapacity(){
		if(size == capacity){
			items= Arrays.copyOf(items, capacity*2);
		}
	}
	
	public int getSize(){
		return this.size;
	}
	
	public Node peek(){
		if(size == 0) throw new IllegalStateException();
		return items[0];
	}
	public Node poll(){
		if(size == 0) throw new IllegalStateException();
		Node item = items[0];
		items[0] = items[size-1];
		size--;
		HeapifyDown();
		return item;
	}
	public void add (Node item){
		ensureCapacity();
		items[size]=item;
		size++;
		heapifyUp();
	}
	private void heapifyUp() {
		int index = size-1;
		while(hasParent(index) && parent(index).frequency > items[index].frequency){
			swap(index,getParentIndex(index));
			index = getParentIndex(index);
		}
	}
	private void HeapifyDown() {
		int index =0;
		while(hasLeftChild(index)){
			int smallerIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && rightChild(index).frequency < leftChild(index).frequency){
				smallerIndex = getRightChildIndex(index);
			}
			if(items[index].frequency < items[smallerIndex].frequency){
				break;
			}
			swap(index,smallerIndex);
			index = smallerIndex;			
		}
		
	}
	
	
	
}
