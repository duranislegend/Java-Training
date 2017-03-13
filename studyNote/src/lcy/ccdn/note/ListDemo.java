package lcy.ccdn.note;

import java.util.Arrays;

class ArrayList {
	private Object[] arr;
	private int next;

	ArrayList(int index) {
		// System.out.println(next);
		arr = new Object[index];
	}

	ArrayList() {
		this(16);
	}

	public void add(Object o) {
		if (next == arr.length) {
			arr = Arrays.copyOf(arr, arr.length * 2);
		}
		arr[next++] = o;
	}

	public Object get(int index) {
		if (index > next) {
			return -1;
		}
		return arr[index];
	}

	public int size() {
		return next;
	}

}

class LinkedList {
	private class Node {
		Object o;

		Node(Object o) {
			this.o = o;
		}

		Node next;
	}

	Node first;

	public void add(Object o) {
		if (first == null) {
			first = new Node(o);
		} else {
			Node last = first;
			while (last.next != null) {
				last = last.next;
			}
			last.next = new Node(o);
		}
	}

	public Object get(int index) {
		Node last = first;
		int count = 0;
		while (last.next != null && count < index) {
			last = last.next;
			count++;
		}
		if (count >= index) {
			return last.o;
		} else
			return -1;

	}
	public int size(){
		Node last = first;
		int count = 0;
		while(last != null){
			last = last.next;
			count++;
		}
		return count;
	}
}

public class ListDemo {
	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList();
		// arrayList.add("String");
		// System.out.println(arrayList.get(35));
		// System.out.println(arrayList.arr.length);
		LinkedList linkedList = new LinkedList();
		linkedList.add("String");
		linkedList.add(Integer.valueOf(1));
		System.out.println(linkedList.get(1));
		System.out.println(linkedList.size());
	}
}
