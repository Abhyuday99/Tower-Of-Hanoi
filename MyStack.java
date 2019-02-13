package binarySearch;
import java.util.EmptyStackException ;

public class MyStack<E>{
	
	private Node<E> head  ;
	private int size ;
	
	MyStack(){
		this.head = null ;
		this.size = 0 ;
	}
	
	public void push(E item) {
		Node<E> temp = head ;
		head = new Node(item);
		head.setNext(temp);
		size++ ;
		return ;
	}
	public E pop() throws EmptyStackException {
		
		if(size == 0) {
			throw new EmptyStackException() ;
		}
		else {
			E val = head.getData();
			head = head.getNext() ;
			size-- ;
			return val ;
			
		}
		
	}
	public E peek() {
		if(size == 0) {
			throw new EmptyStackException() ;
		}
		else {
			return head.getData() ;
			
		}
	}
	public boolean empty() {
		if(size == 0) {
			return true ;
		}
		else {
			return false ;
		}
	}
	
	public static void main(String[] args) {
		
		
	}
	
}
