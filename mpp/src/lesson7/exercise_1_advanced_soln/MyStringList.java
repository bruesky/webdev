package lesson7.exercise_1_advanced_soln;

import java.util.*;

//Final solution in labsolns folder
//No need to implement Iterable manually if instead
//you extend AbstractList
public class MyStringList implements StringList, Iterable<String> {
	
	String[] strArray;
	int size;
	public String[] strArray() {
		return strArray;
	}
	public void setSize(int x) {
		size = x;
	}
	
	
	//other fields and methods
	final int INITIAL_LENGTH = 16;
	
	/* constructor */
	public MyStringList() {
		strArray = new String[INITIAL_LENGTH];
		size = 0;
	}
	//copies element at pos1 to pos2
	public boolean copy(int pos1, int pos2) {
		if(pos1 < 0 || pos1 >= size) return false;
		if(pos2 < 0 || pos2 >= size) return false;
		strArray[pos2] = strArray[pos1];
		return true;
	}
	//overwrites the value at pos with new value val
	public void overwrite(String val, int pos) {
		if(pos < 0 || pos >= size) return;
		strArray[pos] = val;
	}
	public void resize() {
		//System.out.println("resizing");
		int len = strArray.length;
		int newlen = 2 * len;
		String[] temp = new String[newlen];
		System.arraycopy(strArray, 0, temp, 0, len);
		strArray = temp;
	}

	

	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < size - 1; ++i) {
			sb.append(strArray[i] + ", ");
		}
		if(size > 0)
		   sb.append(strArray[size - 1] + "]");
		return sb.toString();
	}

	public int size() {
		return size;
	}

	public Iterator<String> iterator() {
		return new MyIterator();
	}

	class MyIterator implements Iterator<String> {

		private int position;

		MyIterator() {
			position = 0;
		}

		public boolean hasNext() {
			return (position < size);
		}

		public String next() throws IndexOutOfBoundsException {
			if (!hasNext())
				throw new IndexOutOfBoundsException();
			return strArray[position++];
		}

		@SuppressWarnings("unused")
		public void reset() {
			position = 0;
		}

		/** optional -- not necessary to implement */
		public void remove() {
			// not implemented

		}
		
	}
}
