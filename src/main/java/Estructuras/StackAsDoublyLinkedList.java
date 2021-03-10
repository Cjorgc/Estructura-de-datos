package Estructuras;

import java.util.EmptyStackException;
import java.util.Iterator;

public class StackAsDoublyLinkedList <T>{
	/*	
	 * Stack implementado como lista doblemente enlazada
	 * 
	 * 
	 * 
	*/
	DoublyLinkedList list = new DoublyLinkedList<T>();
	
	public StackAsDoublyLinkedList() {}
	
	//Crear un stack con un primer elemento
	public StackAsDoublyLinkedList(T element) {
		list.add(element);
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	//Insertar elemento al final del stack
	public void push(T element) {
		list.addLast(element);
	}
	
	//Retirar el ultimo elemento del satck
	public T pop() {
		if(isEmpty()) throw new EmptyStackException();
		return (T)list.removeLast();
	}
	
	//Consultar ultimo elemento del stack
	public T peek() {
		if(isEmpty())throw new EmptyStackException();
		return (T)list.peekLast();
	}
	
	public Iterator iterator() {
		return list.iterator();
	}
}
