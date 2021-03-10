package Estructuras;

import java.util.EmptyStackException;


//Estructura de datos LIFO


public class Stack <T>{
	
	private T[] array;
	private int top;
	private int capacity;
	
	public Stack(int capacity) {
		this.capacity = capacity;
		array = (T[]) new Object[capacity];
		this.top = -1;
	}
	public Stack() {
		this(10);
	}
	
	public int size() {
		return top + 1;
	}
	
	public boolean isEmpty() {
		return top < 0;
	}
	
	public T peek () {
		if(isEmpty()) throw new EmptyStackException();
		return array[top];
	}
	
	public void push(T element) {
		if(size() + 1 > capacity) {						
			capacity += 10;
			T [] newArray = (T[]) new Object[capacity];
			for(int i = 0 ; i <= top ; i ++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
		top ++;
		array[top] = element;
	}
	
	public T pop() {
		if(isEmpty()) throw new EmptyStackException();
		T data = array[top];
		top--;
		return data;
	}
}

