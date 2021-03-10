package Estructuras;


/*
 * Estructura de datos de tipo FIFO
 * 
 */

public class Queue <T>{
	
	private T[] array;
	private final int first = 0;
	private int top;
	private int capacity;
	
	public Queue(int capacity) {
		array = (T[]) new Object[capacity];
		this.top = -1;
		this.capacity = capacity;
	}
	
	public Queue() {
		this(10);
	}
	
	/*
	 * Devuelve el tamano de la cola
	 */
	public int size() {
		return top + 1;
	}
	
	/*
	 * Devuelve si la cola esta vacia o no
	 */
	
	public boolean isEmpty() {
		return size() == 0;
	}
	/*
	 * Devuelve el primer elemento de la cola
	 */
	public T peek () {
		if(isEmpty()) throw new RuntimeException("Queue vacio");
		return array[first];
	}
	
	/*
	 * Devuelve y elimina el primer elemento de la cola
	 */

	public T poll() {
		if(isEmpty()) throw new RuntimeException("Queue vacio");
		T data = array[first];
		if(top == first) {
			array[first] = null;
			top--;
		}
		for(int i = 1 ; i <= top ; i ++) {
			array[i - 1] = array[i];
			array[top] = null;
			top--;
		}
		return data;
	}
	
	/* 
	 *Inserta un elemento al final de la cola
	 *En caso de que la capacidad de la cola no sea suficiente
	 *incrementa el tamano de la cola en 10
	 */
	
	public void offer(T element) {
		if(size() + 1 > capacity) {
			capacity += 10;
			T[] newArray = (T[]) new Object[capacity];
			for(int i = 0 ; i <= top ; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
		top++;
		array[top] = element;
	}
	
	
	
}
