package Estructuras;

import java.util.Iterator;

public class DoublyLinkedList <T> implements Iterable<T>{
	
	private int size;
	private Node <T> head = null;
	private Node <T> tail = null;
	
	//Declaro una clase interna para representar los nodos de la lista
	private static class Node <T>{
		T data;
		Node <T> previous, next;
		public Node(T data, Node previous, Node next) {
			this.previous = previous;
			this.next = next;
			this.data = data;
		}
		@Override
		public String toString() {
			return data.toString();	
		}
	}
	
	
	//Limpia la lista (elimina todos los nodos)
	public void clear(){
		Node <T> traverse = head;
		while(traverse != null) {
			Node <T> next = traverse.next;
			traverse.previous = traverse.next = null;
			traverse.data = null;
			traverse = next;
		}
		head = tail = null;
		size = 0;
	}
	
	
	//Tamaño de la lista
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void add(T element) {
		addLast(element);
	}
	
	
	//Agrega un elemento al principio de la lista
	public void addFirst(T element) {
		if(isEmpty()) {
			head = tail = new Node<T>(element, null, null);
		}
		else {
			head.previous = new Node<T>(element,null,head);
			this.head = head.previous;;
		}
		
		size ++;
	}
	
	
	//Agrega un elemento al final de la lista
	public void addLast(T element) {
		if(isEmpty()) {
			head = tail = new Node<T>(element, null, null);
		}
		else {
			tail.next = new Node<T> (element, tail, null);
			this.tail = tail.next;
		}
		
		size ++;
	}
	
	//Devuelve el dato del primer nodo de la lista
	public T peekFirst() {
		if(isEmpty()) throw new RuntimeException("Lista vacia");
		return head.data;
	}
	
	//Devuelve el dato del ultimo nodo de la lista
	public T peekLast() {
		if(isEmpty()) throw new RuntimeException("Lista vacia");
		return tail.data;
	}
	
	//Elimina el primer nodo de la lista
	public T removeFirst() {
		if(isEmpty()) throw new RuntimeException("Lista vacia");
		T data = head.data;
		head = head.next;
		size --;
		if(isEmpty()) tail = null;
		else head.previous = null;
		return data;
	
	}
	
	public T removeLast() {
		if(isEmpty()) throw new RuntimeException("Lista vacia");
		T data = tail.data;
		tail = tail.previous;
		size --;
		if(isEmpty()) head = null;
		else tail.next = null;
		return data;
	}
	
	
	//Si encuentra el dato pasado por argumento en algun nodo, lo eliminay devuelve true sino false
	public boolean remove(Object obj) {
		Node<T> traverse = head;
		
		if(obj == null) {
			for(traverse = head ; traverse != null ; traverse = traverse.next) {
				if(traverse.data == null) {
					remove (traverse);
					return true;
				}
			}
		}
		else {
			for(traverse = head ; traverse != null ; traverse = traverse.next) {
				if(obj.equals(traverse.data)) {
					remove(traverse);
					return true;
				}
			}
		}
		return false;
	}
	
	//Elimina y devuelve el nodo de la lista que se le pase por argumento
	public T remove (Node<T> node) {
		if(node.previous == null) return removeFirst();
		if(node.next == null) return removeLast();
		
		node.previous.next = node.next;
		node.next.previous = node.previous;
		T data = node.data;
		size--;
		node = node.previous = node.next = null;
		
		return data;
	}
	
	//Elimina el nodo indicando el indice
	public T removeAt(int index) {
		if(index < 0 || index >= size) throw new IllegalArgumentException("Indice fuera de rango");
		
		int i;
		Node<T> traverse;
		
		if(index < size / 2) {
			for(i = 0, traverse = head ; i < index ; i++) {
				traverse = traverse.next;
			}
			
		}
		else {
			for(i = size - 1 , traverse = tail ; i > index ; i--) {
				traverse = traverse.previous;
			}
		}
		
		return remove(traverse);
		
	}

	//Devuelve el indice del nodo contenedor del dato pasado por arg
	public int indexOf(Object obj) {
		int i = 0;
		Node<T> traverse;
		
		if(obj == null) {
			for(traverse = head ; traverse != null ; traverse = traverse.next, i++) {
				if(traverse.data == null) {
					return i;
				}
			}
		}
		else {
			for(traverse = head ; traverse != null ; traverse = traverse.next , i++) {
				if(obj.equals(traverse.data)) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public boolean contains(Object obj) {
		return indexOf(obj) >= 0;
	}
	
	@Override
	public Iterator<T> iterator(){
		return new Iterator<T>(){
			private Node<T> traverse = head;
			
			public boolean hasNext() {
				return traverse.next != null;
			}
			
			public T next() {
				T data = traverse.data;
				traverse = traverse.next;
				return data;
			}
		};
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<T> traverse = head;
		while(traverse != null) {
			sb.append(traverse.data + ", ");
			traverse = traverse.next;
		}
		sb.append("]");
		return sb.toString();
	}
	
}
