package structures;

import java.util.NoSuchElementException;

import support.structures.UnboundedQueueInterface;

/**************************************************************************************
 * NOTE: before starting to code, check support/structures/UnboundedQueueInterface.java
 * for detailed explanation of each interface method, including the parameters, return
 * values, assumptions, and requirements
 ***************************************************************************************/
public class Queue<T> implements UnboundedQueueInterface<T> {

	class Node<U> {

		public U data;

		public Node<U> next;

		public Node(U data) { this.data=data;}
		
		public Node(U data, Node<U> next) {
			this.data = data; this.next=next;
		}
	}
		
	private Node<T> front;
		
	private Node<T> rear;
		
	private int numElements;

	public Queue() {		
            // TODO 1
		front = null;
		rear = null;
		numElements = 0;
			
    }
	
	public Queue(Queue<T> other) {
            // TODO 2
			front=null;
			rear = null;
			numElements = 0;
			
			Node<T> curr = other.front;
			
			while(curr != null){
				enqueue(curr.data);
				curr = curr.next;
			}
	}
	
	//@Override
	public boolean isEmpty() {
            // TODO 3
            return (front == null);
	}

	//@Override
	public int getSize() {
            // TODO 4
            return numElements;
	}

	//@Override
	public void enqueue(T element) {
            // TODO 5
		if(front == null){
			front = new Node<T>(element);
			rear = front;
		}
		else{
			Node<T> node = new Node<T>(element);
			
			rear.next = node;
			rear = node;
		}
		numElements++;
	}

	//@Override
	public T dequeue() throws NoSuchElementException {
            // TODO 6
		T data = front.data;

		if(front.next == null){
			front = null;
			rear = null;
		}
		else
			front = front.next;
			numElements--;
			return data;
		
	}

	//@Override
	public T peek() throws NoSuchElementException {
            // TODO 7
            return front.data;
	}

	
	//@Override
	public UnboundedQueueInterface<T> reversed() {
            // TODO 8

			Queue<T> ret = new Queue<T>();
			helper(front, ret);
			return ret;

	}
	private Queue<T> helper(Node<T> n, Queue<T> ret) {
		/*if (n != null) {
			helper(n.getNext(), ret);
			ret.enqueue(n.getData());
		}
	}	*/
		
		if(isEmpty())

		return new Queue<T>();
	
		
		 T[] arr;
		 arr = new Object[];
			
		Node<T> curr = front;
			
		int i=0;
			
		while(curr != null){
			arr[i] = curr.data;
			i++;
			curr = curr.next;
		}
			
		Queue<T> queue1 = new Queue<T>();
			
		for(i=arr.length-1;i>=0;i--)
			
		queue1.enqueue(arr[i]);
			
		return queue1; 
	}	
	
}

class Node<T> {
	public T data;
	public Node<T> next;
	public Node(T data) { this.data=data;}
	public Node(T data, Node<T> next) {
		this.data = data; this.next=next;
	}
}

