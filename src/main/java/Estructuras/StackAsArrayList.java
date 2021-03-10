package Estructuras;

import java.util.ArrayList;
import java.util.EmptyStackException;


public class StackAsArrayList <T>{
	private ArrayList <T> array;
	private int top;
	
	public StackAsArrayList() {
		array = new ArrayList();
	}
	
	public int size() {
		return array.size();
	}
	
	public boolean isEmpty() {
		return array.size() == 0;
	}
	
	public T peek() {
		if(isEmpty()) throw new EmptyStackException();
		return array.get(array.size() - 1);
	}
	
	public void push(T element) {
		array.add(element);
	}
	
	public T pop() {
		if(isEmpty()) throw new EmptyStackException();
		T data = array.get(array.size() - 1);
		array.remove(array.size() - 1);
		return data;
		
	}
}
