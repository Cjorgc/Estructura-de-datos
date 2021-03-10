package Estructuras;
public class DynamicArray <T> implements Iterable<T>{
	
	private T[] array;
	private int length;						//Elementos dentro del arreglo
	private int capacity;

	public DynamicArray() { this(16); }		//Si no especifico la capacidad del arreglo, lo creo con 16
	

	public DynamicArray(int capacity) {
		if(capacity < 0) throw new IllegalArgumentException("El tama�o del arreglo no puede ser negativo!");
		this.capacity = capacity;
		array = (T[]) new Object[capacity];
	}
	
	public int size() { return length; }
	public boolean isEmpty() {return size() == 0; }
	public T get (int index) { return array[index]; }
	public void set (int index, T data) { array[index] = data; }
	
	public void clear() {
		for(int i = 0 ; i < capacity ; i ++) {
			array[i] = null;
			length = 0;
		}
	}
	
	public void add(T element) {
		if(length + 1 > capacity) { 	//Si el arreglo se quedo sin espacio
			capacity += 30;				
			T[] newArray = (T[]) new Object[capacity];		//Resize
			for(int i = 0 ; i < length ; i ++) {
				newArray[i] = array[i];			//Copio los elementos del array viejo al nuevo (con mas espacio)
			}
			array = newArray;		//Reasigno el arreglo con mas espacio
		}
		
		array[length] = element;
		length++;
	}
	
	public void removeAt(int index) {
		if(index >= length || index < 0) { throw new IndexOutOfBoundsException("Indice no incluido en el tama�o del arreglo"); }
		T[] newArray = (T[]) new Object[capacity];
		for(int i = 0 , j = 0; i < length ; i++ ,j ++) {		//Al eliminar un elemento reubico los elementos que siguen (si existen)
			if(i == index) j--;
			else newArray[j] = array[i];
		}
		array = newArray;
		length --;
	}
	
	public boolean remove(Object element) {
		int index = indexOf(element);
		if(index == -1) return false;
		removeAt(index);
		return true;
	}
	
	public int indexOf(Object element) {
		for(int i = 0 ; i < length ; i++) {
			if(element == null) {
				if(array[i] == null) return i;
			}
			else if(element.equals(array[i]) ) return i;
		}
		return -1;
	}
	
	public boolean contains(Object element) {
		for(int i = 0 ; i < length ; i ++) {
			if(array[i].equals(element)) {
				return true;
			}
		}
		return false;
	}
	
	@Override 
	public java.util.Iterator<T> iterator(){
		return new java.util.Iterator<T>() {
			int index = 0;
			public boolean hasNext() {return index < length;}
			public T next() {return array[index + 1];}
		};
	}
	
	@Override
	public String toString() {
		if(length == 0) return "[]";
		StringBuilder sb = new StringBuilder(length).append("[");
		for(int i = 0 ; i < length - 1 ; i ++) {
			sb.append(array[i] + " , ");
		}
		return sb.append(array[length-1] + "]").toString();
	}
	
}